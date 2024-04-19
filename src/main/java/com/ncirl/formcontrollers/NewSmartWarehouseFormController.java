package com.ncirl.formcontrollers;

import com.google.protobuf.Empty;
import com.ncirl.robot.RobotServiceGrpc;
import com.ncirl.robot.UnaryRobotStatusResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.scene.control.Label;

public class NewSmartWarehouseFormController {


    public Label robotStatusOutputLabel;

    private RobotServiceGrpc.RobotServiceBlockingStub robotServiceBlockingStub; // IM USING THIS AS  THE CLIENT
    private ManagedChannel robotServiceManagedChannel;

    public void initialize() {
        System.out.println("Form is initialising...");
        robotServiceManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50055)
                .usePlaintext()
                .build();
        robotServiceBlockingStub = RobotServiceGrpc.newBlockingStub(robotServiceManagedChannel);
        System.out.println("Grpc Channel created...");


        // Update the robot status
        updateRobotStatus();
    }

    private void updateRobotStatus () {
        System.out.println("Updating robot status...");

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
}
