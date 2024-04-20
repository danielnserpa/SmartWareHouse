package com.ncirl.formcontrollers;

import com.google.protobuf.Empty;
import com.ncirl.robot.RobotServiceGrpc;
import com.ncirl.robot.UnaryRobotStatusResponse;
import com.ncirl.storage.StorageServiceGrpc;
import com.ncirl.storage.UnaryStorageStatusResponse;
import com.ncirl.thermostat.ThermostatServiceGrpc;
import com.ncirl.thermostat.UnaryThermostatStatusResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NewSmartWarehouseFormController {

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
        robotServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50054)
                .usePlaintext()
                .build();
        robotServiceBlockingStub = RobotServiceGrpc.newBlockingStub(robotServiceManagedChannel);
        System.out.println("Robot gRPC Channel created...");

        System.out.println("Storage form is initializing...");
        storageServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50059)
                .usePlaintext()
                .build();
        storageServiceBlockingStub = StorageServiceGrpc.newBlockingStub(storageServiceManagedChannel);
        System.out.println("Storage gRPC Channel created...");

        System.out.println("Thermostat form is initializing...");
        thermostatServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50060)
                .usePlaintext()
                .build();
        thermostatServiceBlockingStub = ThermostatServiceGrpc.newBlockingStub(thermostatServiceManagedChannel);
        System.out.println("Thermostat gRPC Channel created...");
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
}
