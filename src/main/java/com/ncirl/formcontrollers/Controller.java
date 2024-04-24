package com.ncirl.formcontrollers;

import com.ncirl.storage.StorageStatus;
import com.ncirl.storage.UnaryStorageStatusResponse;
import com.google.protobuf.Empty;
import com.ncirl.robot.RobotServiceGrpc;
import com.ncirl.robot.UnaryRobotStatusResponse;
import com.ncirl.storage.StorageServiceGrpc;

import com.ncirl.thermostat.ThermostatServiceGrpc;
import com.ncirl.thermostat.UnaryThermostatStatusResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Random; // Import Random class

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.concurrent.TimeUnit;

public class Controller {

    @FXML
    private Label robotStatusLabel;
    @FXML
    private Label storageStatusLabel;
    @FXML
    private Label temperatureLabel;

    private final ManagedChannel robotServiceManagedChannel;
    private final ManagedChannel storageServiceManagedChannel;
    private final ManagedChannel thermostatServiceManagedChannel;

    private final RobotServiceGrpc.RobotServiceBlockingStub robotServiceBlockingStub;
    private final StorageServiceGrpc.StorageServiceBlockingStub storageServiceBlockingStub;
    private final ThermostatServiceGrpc.ThermostatServiceBlockingStub thermostatServiceBlockingStub;

    private final Random random; // Declare Random object

    public Controller() {
        // Initialize gRPC channels and stubs
        this.robotServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50074)
                .usePlaintext()
                .build();
        this.robotServiceBlockingStub = RobotServiceGrpc.newBlockingStub(robotServiceManagedChannel);

        this.storageServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50089)
                .usePlaintext()
                .build();
        this.storageServiceBlockingStub = StorageServiceGrpc.newBlockingStub(storageServiceManagedChannel);

        this.thermostatServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50070)
                .usePlaintext()
                .build();
        this.thermostatServiceBlockingStub = ThermostatServiceGrpc.newBlockingStub(thermostatServiceManagedChannel);

        this.random = new Random(); // Initialize Random object
    }

    @FXML
    void showRobotStatusButtonClick() {
        System.out.println("ShowRobotStatusButtonClick clicked");
        // Call the method to show robot status
        showRobotStatus();
    }

    @FXML
    void showStorageStatusButtonClick() {
        System.out.println("ShowStorageStatusButtonClick clicked");
        // Call the method to show storage status
        updateStorageStatus(); // Update storage status before showing it
        showStorageStatus();
    }

    @FXML
    void showTemperatureButtonClick() {
        System.out.println("ShowTemperatureButtonClick clicked");
        // Call the method to show temperature
        showTemperature();
    }

    private void showRobotStatus() {
        // This is making the gRPC call for Robot status
        UnaryRobotStatusResponse response = robotServiceBlockingStub.getCurrentRobotStatus(Empty.getDefaultInstance());
        String unaryRobotResponseString = "Robot name: " +
                response.getRobotName() +
                "\n" +
                "Robot status: " +
                response.getRobotStatus() +
                "\n" +
                "Robot battery level: " +
                response.getRobotBatteryLevel();
        robotStatusLabel.setText(unaryRobotResponseString);
    }

    private void showStorageStatus() {
        // This is making the gRPC call for Storage status
        UnaryStorageStatusResponse response = storageServiceBlockingStub.getCurrentStorageStatus(Empty.getDefaultInstance());
        StringBuilder storageStatusBuilder = new StringBuilder();
        for (StorageStatus status : response.getStorageStatusListList()) {
            storageStatusBuilder.append("Storage ID: ")
                    .append(status.getStorageId())
                    .append(", Status: ")
                    .append(status.getStorageStatus())
                    .append("\n");
        }
        // Update the storage status label with the retrieved information
        storageStatusLabel.setText(storageStatusBuilder.toString());
    }

    private void updateStorageStatus() {
        // Update the storage status randomly
        // This method should update the storage status
        // Implement your logic here to update the status randomly or based on specific criteria

        // In this example, we'll randomly update the status of each storage unit
        UnaryStorageStatusResponse response = storageServiceBlockingStub.getCurrentStorageStatus(Empty.getDefaultInstance());
        for (StorageStatus status : response.getStorageStatusListList()) {
            // Randomly choose whether the storage status should be Full or Empty
            String newStatus = random.nextBoolean() ? "Full" : "Empty";
            // Update the status of the current storage unit
            status = status.toBuilder().setStorageStatus(newStatus).build();
        }
    }


    private void showTemperature() {
        // This is making the gRPC call for Thermostat status
        UnaryThermostatStatusResponse response = thermostatServiceBlockingStub.getCurrentThermostatStatus(Empty.getDefaultInstance());

        int temperature = response.getTemp();
        String heatingMessage = "";

        if (temperature < 18) {
            heatingMessage = "Sending request to turn on the heater";
        } else if (temperature > 25) {
            heatingMessage = "Sending request to turn off the heater";
        }

        // Update the temperature label with the temperature and heating message
        temperatureLabel.setText("Temperature: " + temperature + "°C" + (heatingMessage.isEmpty() ? "" : "\n" + heatingMessage));
    }

    public void shutdown() throws InterruptedException {
        robotServiceManagedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        storageServiceManagedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        thermostatServiceManagedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
