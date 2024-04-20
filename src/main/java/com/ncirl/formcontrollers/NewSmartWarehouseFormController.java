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
import javafx.scene.control.Label;

public class NewSmartWarehouseFormController {


    public Label robotStatusOutputLabel;
    private RobotServiceGrpc.RobotServiceBlockingStub robotServiceBlockingStub; // IM USING THIS AS  THE CLIENT
    private ManagedChannel robotServiceManagedChannel;

    public Label storageStatusOutputLabel;
    private StorageServiceGrpc.StorageServiceBlockingStub storageServiceBlockingStub;
    private ManagedChannel storageServiceManagedChannel;

    public Label thermostatStatusOutputLabel;
    private ThermostatServiceGrpc.ThermostatServiceBlockingStub thermostatServiceBlockingStub;
    private ManagedChannel thermostatServiceManagedChannel;

    public void initialize() {
        System.out.println("Robot form is initialising...");
        robotServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50054)
                .usePlaintext()
                .build();
        robotServiceBlockingStub = RobotServiceGrpc.newBlockingStub(robotServiceManagedChannel);
        System.out.println("Robot gRPC Channel created...");


        // Update the Robot status
        updateRobotStatus();

        System.out.println("Storage form is initialising...");
        storageServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50057)
                .usePlaintext()
                .build();
        storageServiceBlockingStub = StorageServiceGrpc.newBlockingStub(storageServiceManagedChannel);
        System.out.println("Storage gRPC Channel created...");


        // Update the Storage status
        updateStorageStatus();

        System.out.println("Thermostat form is initialising...");
        thermostatServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50060)
                .usePlaintext()
                .build();
        thermostatServiceBlockingStub = ThermostatServiceGrpc.newBlockingStub(thermostatServiceManagedChannel);
        System.out.println("Thermostat gRPC Channel created...");


        // Update the Thermostat status
        updateThermostatStatus();
    }

    private void updateRobotStatus () {
        System.out.println("Updating Robot status...");

        // This is making the gRPC call
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

    private void updateStorageStatus () {
        System.out.println("Updating Storage status...");

        // This is making the gRPC call
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

    private void updateThermostatStatus () {
        System.out.println("Updating Thermostat status...");

        // This is making the gRPC call
        UnaryThermostatStatusResponse response = thermostatServiceBlockingStub.getCurrentThermostatStatus(Empty.getDefaultInstance());
        UnaryThermostatStatusResponse response2 = thermostatServiceBlockingStub.getCurrentThermostatStatus(Empty.getDefaultInstance());

        String unaryThermostatResponseString = new StringBuilder()
                .append("Temperature: ")
                .append(response.getTemp())
                .append("°C")
                .append("\n")
                .toString();

        thermostatStatusOutputLabel.setText(unaryThermostatResponseString);

    }

}
