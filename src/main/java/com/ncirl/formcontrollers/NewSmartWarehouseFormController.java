package com.ncirl.formcontrollers;

import com.google.protobuf.Empty;
import com.ncirl.robot.RobotServiceGrpc;
import com.ncirl.robot.UnaryRobotStatusResponse;
import com.ncirl.storage.StorageServiceGrpc;
import com.ncirl.storage.UnaryStorageStatusResponse;
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

    public void initialize() {
        System.out.println("Robot form is initialising...");
        robotServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50054)
                .usePlaintext()
                .build();
        robotServiceBlockingStub = RobotServiceGrpc.newBlockingStub(robotServiceManagedChannel);
        System.out.println("Robot gRPC Channel created...");


        // Update the robot status
        updateRobotStatus();

        System.out.println("Storage form is initialising...");
        storageServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50056)
                .usePlaintext()
                .build();
        storageServiceBlockingStub = StorageServiceGrpc.newBlockingStub(storageServiceManagedChannel);
        System.out.println("Storage gRPC Channel created...");


        // Update the robot status
        updateStorageStatus();
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
}
