package com.ncirl.servers;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.google.protobuf.Empty;
import com.ncirl.common.Robot;
import com.ncirl.robot.RobotServiceGrpc;
import com.ncirl.robot.StreamRobotStatusRequest;
import com.ncirl.robot.StreamRobotStatusResponse;
import com.ncirl.robot.UnaryRobotStatusResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileInputStream;
import java.io.IOException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RobotServer {

    private Server server;
    int port = 50074;

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
        String healthCheckInterval = props.getProperty("consul.service.healthCheckInterval");

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
        System.out.println("Server registered to Consul successfully. Host: " + hostAddress);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        RobotServer server = new RobotServer();
        server.start();
        server.blockUntilShutdown();
    }

     class RobotServiceImpl extends RobotServiceGrpc.RobotServiceImplBase {

        // Finish off implementing the server
         Robot robot;

         public RobotServiceImpl() {
             robot = new Robot("TOBOR", "Idle", 100);
         }

         @Override
         public void getCurrentRobotStatus (Empty request, StreamObserver<UnaryRobotStatusResponse> responseObserver) {
             System.out.println("Server side getRobotStatus method invoked...");
             UnaryRobotStatusResponse response = UnaryRobotStatusResponse.newBuilder()
                     .setRobotName(robot.getName())
                     .setRobotStatus(robot.getStatus())
                     .setRobotBatteryLevel(robot.getBatteryLevel())
                     .build();

             responseObserver.onNext(response);
             responseObserver.onCompleted();
         }

         public StreamObserver<StreamRobotStatusRequest> streamRobotStatus(StreamObserver<StreamRobotStatusResponse> responseObserver) {
             return new StreamObserver<StreamRobotStatusRequest>() {

                 @Override
                 public void onNext(StreamRobotStatusRequest streamRobotRequest) {
                     System.out.println("Received Robot information:");
                     System.out.println("Active Robot name: " + streamRobotRequest.getRobotName());
                     System.out.println("Date and Time: " + streamRobotRequest.getDateTime());
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
     }
}


