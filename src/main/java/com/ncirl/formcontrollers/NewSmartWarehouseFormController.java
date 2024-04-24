package com.ncirl.formcontrollers;

import com.ncirl.robot.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class NewSmartWarehouseFormController {


    public Label robotStreamingInfoLabel;
    private final ManagedChannel channel;
    private final RobotServiceGrpc.RobotServiceStub stub;
//    private final RobotServiceGrpc.RobotServiceStub bidirectionalStub;

    public NewSmartWarehouseFormController(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = RobotServiceGrpc.newStub(channel);
//  this.bidirectionalStub = RobotServiceGrpc.newStub(channel);
    }

    public Label streamInfoLabel;
    public Label robotStatusOutputLabel;

    private RobotServiceGrpc.RobotServiceBlockingStub robotServiceBlockingStub;
    private ManagedChannel robotServiceManagedChannel;




    public void initialize() {
        System.out.println("Robot form is initializing...");
        robotServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50054)
                .usePlaintext()
                .build();
        robotServiceBlockingStub = RobotServiceGrpc.newBlockingStub(robotServiceManagedChannel);
        System.out.println("Robot gRPC Channel created...");
    }



    public void streamRobotStatus (String robotName){
        StreamObserver<StreamRobotStatusRequest> requestObserver = stub.streamRobotStatus(new StreamObserver<>(){

            @Override
            public void onNext(StreamRobotStatusResponse response) {
                System.out.println("Server response: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in streaming robot information: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Streaming robot information completed");
            }
        });

        try {
            while (true) {
                String dateTime = LocalDateTime.now().toString();
                StreamRobotStatusRequest streamRobotRequest = StreamRobotStatusRequest.newBuilder()
                        .setRobotName(robotName)
                        .setDateTime(dateTime)
                        .build();
                requestObserver.onNext(streamRobotRequest);
                Thread.sleep(5000); // Send information every 5 seconds
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        requestObserver.onCompleted();

    }
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

    }
//    public void bidirectionalStreaming() {
//        // Create a CountDownLatch to synchronize the sending of the second request
//        CountDownLatch latch = new CountDownLatch(1);
//
//        StreamObserver<BidirectionalRequest> requestObserver = bidirectionalStub.bidirectionalStream(new StreamObserver<>() {
//            @Override
//            public void onNext(BidirectionalResponse response) {
//                System.out.println("Server response: " + response.getMessage());
//                // Decrement the latch count to allow sending the second request
//                latch.countDown();
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.err.println("Error from server: " + t.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("Robot bidirectional stream completed.");
//            }
//        });
//
//        try {
//            // Send the initial message only once
//            String message = "Hello, Robot! What's your name?";
//            BidirectionalRequest initialRequest = BidirectionalRequest.newBuilder()
//                    .setMessage(message)
//                    .build();
//            System.out.println("Sending message to server: " + message);
//            requestObserver.onNext(initialRequest);
//
//            // Wait until the latch countdown completes (i.e., until the first response is received)
//            latch.await();
//
//            // Send the final message
//            String finalMessage = "Robot registered. Have a great shift!";
//            BidirectionalRequest finalRequest = BidirectionalRequest.newBuilder()
//                    .setMessage(finalMessage)
//                    .build();
//            System.out.println("Sending message to server: " + finalMessage);
//            requestObserver.onNext(finalRequest);
//
//        } catch (Exception e) {
//            System.err.println("Error while sending messages: " + e.getMessage());
//        }
//
//        // Don't send any more messages, just end the bidirectional stream
//        requestObserver.onCompleted();
//    }
//
//    public void shutdown() throws InterruptedException {
//        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//    }

    public static void main(String[] args) throws InterruptedException {
        String host = "localhost";
        int port = 50099;
        String robotName = "TOBOR";

        NewSmartWarehouseFormController robot = new NewSmartWarehouseFormController(host, port);

//        CountDownLatch bidirectionalLatch = new CountDownLatch(1);

//        // Start bidirectional streaming
//        Thread bidirectionalStreamThread = new Thread(() -> {
//            robot.bidirectionalStreaming();
//            // Signal that bidirectional streaming has completed
//            bidirectionalLatch.countDown();
//        });
//
//        bidirectionalStreamThread.start();
//
//        bidirectionalLatch.await();

        // Start streaming client information
        Thread streamThread = new Thread(() -> robot.streamRobotStatus(robotName));
        streamThread.start();


        // Wait for user input to stop streaming
        System.out.println("\n" + "Press 'Q' to stop streaming robot information");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                streamThread.interrupt();
                break;
            }
        }
        // Shutdown client
        robot.shutdown();
    }
}

