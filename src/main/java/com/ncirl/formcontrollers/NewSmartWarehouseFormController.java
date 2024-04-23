package com.ncirl.formcontrollers;

import com.google.protobuf.Empty;
import com.ncirl.robot.RobotServiceGrpc;
import com.ncirl.robot.StreamRobotStatusRequest;
import com.ncirl.robot.StreamRobotStatusResponse;
import com.ncirl.robot.UnaryRobotStatusResponse;
import com.ncirl.storage.StorageServiceGrpc;
import com.ncirl.storage.UnaryStorageStatusResponse;
import com.ncirl.thermostat.ThermostatServiceGrpc;
import com.ncirl.thermostat.UnaryThermostatStatusResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NewSmartWarehouseFormController {

    public Label robotStreamingInfoLabel;
    private final ManagedChannel channel;
    private final RobotServiceGrpc.RobotServiceStub stub;

    public NewSmartWarehouseFormController(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = RobotServiceGrpc.newStub(channel);

    }

    public Label robotStatusOutputLabel;
    private RobotServiceGrpc.RobotServiceBlockingStub robotServiceBlockingStub;
    private ManagedChannel robotServiceManagedChannel;

    public Label storageStatusOutputLabel;
    private StorageServiceGrpc.StorageServiceBlockingStub storageServiceBlockingStub;
    private ManagedChannel storageServiceManagedChannel;

    public Label thermostatStatusOutputLabel;
    private ThermostatServiceGrpc.ThermostatServiceBlockingStub thermostatServiceBlockingStub;
    private ManagedChannel thermostatServiceManagedChannel;

    public void initialize() {
        System.out.println("Robot form is initializing...");
        robotServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50074)
                .usePlaintext()
                .build();
        robotServiceBlockingStub = RobotServiceGrpc.newBlockingStub(robotServiceManagedChannel);
        System.out.println("Robot gRPC Channel created...");

        System.out.println("Storage form is initializing...");
        storageServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50079)
                .usePlaintext()
                .build();
        storageServiceBlockingStub = StorageServiceGrpc.newBlockingStub(storageServiceManagedChannel);
        System.out.println("Storage gRPC Channel created...");

        System.out.println("Thermostat form is initializing...");
        thermostatServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50070)
                .usePlaintext()
                .build();
        thermostatServiceBlockingStub = ThermostatServiceGrpc.newBlockingStub(thermostatServiceManagedChannel);
        System.out.println("Thermostat gRPC Channel created...");
    }
    @FXML
    private void showRobotStatus() {
        // This is making the gRPC call for Robot status
        UnaryRobotStatusResponse response = robotServiceBlockingStub.getCurrentRobotStatus(Empty.getDefaultInstance());

        String unaryRobotResponseString = new StringBuilder()
                .append("Robot name: ")
                .append(response.getRobotName())
                .append("\n")
                .append("Robot status: ")
                .append(response.getRobotStatus())
                .append("\n")
                .append("Robot battery level: ")
                .append(response.getRobotBatteryLevel())
                .toString();

        robotStatusOutputLabel.setText(unaryRobotResponseString);
    }

    @FXML
    private void showAllStorageStatus() {
        // This is making the gRPC calls for all four storage statuses
        UnaryStorageStatusResponse response1 = storageServiceBlockingStub.getCurrentStorageStatus(Empty.getDefaultInstance());
        UnaryStorageStatusResponse response2 = storageServiceBlockingStub.getCurrentStorageStatus(Empty.getDefaultInstance());
        UnaryStorageStatusResponse response3 = storageServiceBlockingStub.getCurrentStorageStatus(Empty.getDefaultInstance());
        UnaryStorageStatusResponse response4 = storageServiceBlockingStub.getCurrentStorageStatus(Empty.getDefaultInstance());

        String unaryStorageResponseString = new StringBuilder()
                .append("Storage 1 - ID: ")
                .append(response1.getStorageId())
                .append(", Status: ")
                .append(response1.getStorageStatus())
                .append("\n")
                .append("Storage 2 - ID: ")
                .append(response2.getStorageId())
                .append(", Status: ")
                .append(response2.getStorageStatus())
                .append("\n")
                .append("Storage 3 - ID: ")
                .append(response3.getStorageId())
                .append(", Status: ")
                .append(response3.getStorageStatus())
                .append("\n")
                .append("Storage 4 - ID: ")
                .append(response4.getStorageId())
                .append(", Status: ")
                .append(response4.getStorageStatus())
                .toString();

        storageStatusOutputLabel.setText(unaryStorageResponseString);
    }

    @FXML
    private void showAllTemperatures() {
        // This is making the gRPC calls for all temperatures
        UnaryThermostatStatusResponse response1 = thermostatServiceBlockingStub.getCurrentThermostatStatus(Empty.getDefaultInstance());
        UnaryThermostatStatusResponse response2 = thermostatServiceBlockingStub.getCurrentThermostatStatus(Empty.getDefaultInstance());

        String unaryThermostatResponseString = "Temperature 1: " + response1.getTemp() + "°C\n" +
                "Temperature 2: " + response2.getTemp() + "°C";

        thermostatStatusOutputLabel.setText(unaryThermostatResponseString);
    }

    public void streamRobotStatus (String robotName){
        StreamObserver<StreamRobotStatusRequest> requestObserver = stub.streamRobotStatus(new StreamObserver<>(){

            @Override
            public void onNext(StreamRobotStatusResponse response) {
                System.out.println("Server response: " + response.getMessage());
                Platform.runLater(() -> {
                    robotStreamingInfoLabel.setText(response.getMessage());
                });
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



    public static void main(String[] args) throws InterruptedException {
        String host = "localhost";
        int port = 50074;
        String robotName = "TOBOR";

        NewSmartWarehouseFormController robot = new NewSmartWarehouseFormController(host, port);

        // Start streaming client information
        Thread streamThread = new Thread(() -> robot.streamRobotStatus(robotName));
        streamThread.start();

        // Wait for user input to stop streaming
        System.out.println("Press 'Q' to stop streaming robot information");
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
