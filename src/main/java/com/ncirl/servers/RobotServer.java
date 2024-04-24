package com.ncirl.servers;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.google.protobuf.Empty;
import com.ncirl.common.Robot;
import com.ncirl.robot.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileInputStream;
import java.io.IOException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RobotServer {

    private Server server;
    int port = 50099;

    public void start() throws IOException {

        server = ServerBuilder.forPort(port)
                .addService(new RobotServiceImpl())
                .build()
                .start();
        System.out.println("Robot Server started, listening on port " + port);

        registerToConsul();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server");
            try {
                RobotServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        // Load Consul configuration from consul.properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/com/ncirl/robot-service.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Extract Consul configuration properties
        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));
        String serviceName = props.getProperty("consul.service.name");
        int servicePort = Integer.parseInt(props.getProperty("consul.service.port"));


        // Get host address
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        // Create a Consul client
        ConsulClient consulClient = new ConsulClient(consulHost, consulPort);

        // Define service details
        NewService newService = new NewService();
        newService.setName(serviceName);
        newService.setPort(servicePort);
        newService.setAddress(hostAddress); // Set host address

        // Register service with Consul
        consulClient.agentServiceRegister(newService);

        // Print registration success message
        System.out.println("Server registered to Consul successfully. Host: " + hostAddress
        + "\n");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        RobotServer server = new RobotServer();

        server.start();
        server.blockUntilShutdown();


    }

    static class RobotServiceImpl extends RobotServiceGrpc.RobotServiceImplBase {

        // Declare robot instance
        Robot robot;
        private boolean isFirstButtonClick = true;

        // Constructor to initialize the robot with name "TOBOR", status "Idle", and battery level 100
        public RobotServiceImpl() {
            this.robot = new Robot("TOBOR", "Idle", 100);
        }

        @Override
        public void getCurrentRobotStatus(Empty request, StreamObserver<UnaryRobotStatusResponse> responseObserver) {
            // Get the current status and battery level
            String currentStatus = robot.getStatus();
            int batteryLevel = robot.getBatteryLevel();

            // Build the response with the current status and battery level
            UnaryRobotStatusResponse response = UnaryRobotStatusResponse.newBuilder()
                    .setRobotName(robot.getName())
                    .setRobotStatus(currentStatus)
                    .setRobotBatteryLevel(batteryLevel)
                    .build();

            // Send the response to the client
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void setRobotStatus(RobotStatus request, StreamObserver<Empty> responseObserver) {
            // Set the new status of the robot
            String newStatus = request.getRobotStatus();

            // Update the robot status only after the first button click
            if (!isFirstButtonClick) {
                // If changing from Busy to Idle, decrease battery level by 10
                if (newStatus.equals("Busy")) {
                    int newBatteryLevel = robot.getBatteryLevel() - 10;
                    robot.setBatteryLevel(Math.max(newBatteryLevel, 0)); // Ensure battery level doesn't go below 0
                }

                // If battery level drops from 20 to 10, change status to "Charging"
                if (robot.getBatteryLevel() == 10 && !newStatus.equals("Charging")) {
                    newStatus = "Charging";
                }

                // If battery level is 0, reset it to 100
                if (robot.getBatteryLevel() == 0) {
                    robot.setBatteryLevel(100);
                    newStatus = "Idle"; // Set status to Idle after charging
                }

                robot.setStatus(newStatus);
            } else {
                isFirstButtonClick = false; // Update the flag after the first button click
            }

            // Send an empty response to the client
            responseObserver.onNext(Empty.getDefaultInstance());
            responseObserver.onCompleted();
        }

        public StreamObserver<StreamRobotStatusRequest> streamRobotStatus(StreamObserver<StreamRobotStatusResponse> responseObserver) {
            return new StreamObserver<StreamRobotStatusRequest>() {

                @Override
                public void onNext(StreamRobotStatusRequest streamRobotRequest) {
                    System.out.println("Received Robot information:");
                    System.out.println("Active Robot name: " + streamRobotRequest.getRobotName());
                    System.out.println("Date and Time: " + streamRobotRequest.getDateTime());
                    System.out.println("\n");
                }
                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in robot information streaming: " + t.getMessage());
                }

                public void onCompleted() {
                    System.out.println("Robot information streaming completed");
                    StreamRobotStatusResponse response = StreamRobotStatusResponse.newBuilder()
                            .setMessage("Robot information streaming completed")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }

                public StreamObserver<BidirectionalRequest> bidirectionalStream(StreamObserver<BidirectionalResponse> responseObserver) {
                return new StreamObserver<>() {
                private int requestCount = 0;

                @Override
                public void onNext(BidirectionalRequest request) {
                    System.out.println("Received message from client: " + request.getMessage());
                    requestCount++;

                    // Send the initial response after the first request
                    if (requestCount == 1) {
                        BidirectionalResponse initialResponse = BidirectionalResponse.newBuilder()
                                .setMessage("Hello! My name is TOBOR")
                                .build();
                        responseObserver.onNext(initialResponse);
                        System.out.println("Sent response: " + initialResponse.getMessage());
                    }

                    // Send the final response after the second request
                    if (requestCount == 2) {
                        BidirectionalResponse finalResponse = BidirectionalResponse.newBuilder()
                                .setMessage("Thank you! BEEP BEEP! \uD83E\uDD16"
                                + "\n")
                                .build();
                        responseObserver.onNext(finalResponse);
                        System.out.println("Sent response: " + finalResponse.getMessage());
                    }
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error from client: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Robot bidirectional stream completed."
                    + "\n");
                    responseObserver.onCompleted(); // Complete the response stream
                }
            };
        }
    }
}










