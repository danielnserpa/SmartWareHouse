package com.ncirl.servers;

import com.google.protobuf.Empty;
import com.ncirl.common.Robot;
import com.ncirl.robot.RobotServiceGrpc;
import com.ncirl.robot.UnaryRobotStatusResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RobotServer {

    private Server server;
    int port = 50055;

    public void start() throws IOException {

        server = ServerBuilder.forPort(port)
                .addService(new RobotServiceImpl())
                .build()
                .start();
        System.out.println("Robot Server started, listening on port " + port);

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

    public static void main(String[] args) throws IOException, InterruptedException {
        RobotServer server = new RobotServer();
        server.start();
        server.blockUntilShutdown();
    }

     class RobotServiceImpl extends RobotServiceGrpc.RobotServiceImplBase {

        // Finish off implementing the server
         Robot robot;

         public RobotServiceImpl() {
             robot = new Robot("R2D3", "Idle", 20);
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

//         @Override
//         public void streamCurrentRobotStatus (Empty request, StreamObserver<UnaryRobotStatusResponse> responseObserver){
//             Runnable streamingTask = () -> {
//                 try {
//                     while (!Thread.currentThread().isInterrupted()){
//                         String message = "The RobotServer is Streaming RobotStatuses";
//                         Random r = new Random();
//                         int statusLow = 1;
//                                 int statusHigh = 4;
//                         int statusResult = r.nextInt(statusHigh-statusLow) + statusLow;
//                         String robotStatus;
//
//                         if (statusResult == 1) {
//                             robotStatus = "Idle";
//                         } else if (statusResult == 2) {
//                             robotStatus = "Busy";
//                         } else {
//                             robotStatus = "Charging";
//                         }
//
//                         int batteryLevelLow = 1;
//                         int batteryLevelHigh = 4;
//                         int batteryLevel = r.nextInt(batteryLevelHigh-batteryLevelLow) + batteryLevelLow;
//
//
//                         UnaryRobotStatusResponse response = UnaryRobotStatusResponse.newBuilder()
//                                 .setRobotName(message)
//                                 .setRobotStatus(robotStatus)
//                                 .setRobotBatteryLevel(batteryLevel)
//                                 .build();
//                         responseObserver.onNext(response);
//                         Thread.sleep(5000);
//                     }
//                 }
//             }
//         }

    }

}
