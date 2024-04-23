// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RobotService.proto

package com.ncirl.robot;

public final class RobotServiceProto {
  private RobotServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_robot_UnaryRobotStatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_robot_UnaryRobotStatusResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_robot_StreamRobotStatusRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_robot_StreamRobotStatusRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_robot_StreamRobotStatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_robot_StreamRobotStatusResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_robot_BidirectionalRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_robot_BidirectionalRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_robot_BidirectionalResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_robot_BidirectionalResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022RobotService.proto\022\017com.ncirl.robot\032\033g" +
      "oogle/protobuf/empty.proto\"]\n\030UnaryRobot" +
      "StatusResponse\022\021\n\trobotName\030\001 \001(\t\022\023\n\013rob" +
      "otStatus\030\002 \001(\t\022\031\n\021robotBatteryLevel\030\003 \001(" +
      "\005\"?\n\030StreamRobotStatusRequest\022\021\n\trobotNa" +
      "me\030\001 \001(\t\022\020\n\010dateTime\030\002 \001(\t\",\n\031StreamRobo" +
      "tStatusResponse\022\017\n\007message\030\001 \001(\t\"\'\n\024Bidi" +
      "rectionalRequest\022\017\n\007message\030\001 \001(\t\"(\n\025Bid" +
      "irectionalResponse\022\017\n\007message\030\001 \001(\t2\302\002\n\014" +
      "RobotService\022Z\n\025getCurrentRobotStatus\022\026." +
      "google.protobuf.Empty\032).com.ncirl.robot." +
      "UnaryRobotStatusResponse\022l\n\021streamRobotS" +
      "tatus\022).com.ncirl.robot.StreamRobotStatu" +
      "sRequest\032*.com.ncirl.robot.StreamRobotSt" +
      "atusResponse(\001\022h\n\023bidirectionalStream\022%." +
      "com.ncirl.robot.BidirectionalRequest\032&.c" +
      "om.ncirl.robot.BidirectionalResponse(\0010\001" +
      "B&\n\017com.ncirl.robotB\021RobotServiceProtoP\001" +
      "b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        }, assigner);
    internal_static_com_ncirl_robot_UnaryRobotStatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ncirl_robot_UnaryRobotStatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_robot_UnaryRobotStatusResponse_descriptor,
        new java.lang.String[] { "RobotName", "RobotStatus", "RobotBatteryLevel", });
    internal_static_com_ncirl_robot_StreamRobotStatusRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_ncirl_robot_StreamRobotStatusRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_robot_StreamRobotStatusRequest_descriptor,
        new java.lang.String[] { "RobotName", "DateTime", });
    internal_static_com_ncirl_robot_StreamRobotStatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_ncirl_robot_StreamRobotStatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_robot_StreamRobotStatusResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_com_ncirl_robot_BidirectionalRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_ncirl_robot_BidirectionalRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_robot_BidirectionalRequest_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_com_ncirl_robot_BidirectionalResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_ncirl_robot_BidirectionalResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_robot_BidirectionalResponse_descriptor,
        new java.lang.String[] { "Message", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
