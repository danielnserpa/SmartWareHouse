// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ThermostatService.proto

package com.ncirl.thermostat;

public final class ThermostatServiceProto {
  private ThermostatServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_thermostat_UnaryThermostatStatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_thermostat_UnaryThermostatStatusResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027ThermostatService.proto\022\024com.ncirl.the" +
      "rmostat\032\033google/protobuf/empty.proto\"-\n\035" +
      "UnaryThermostatStatusResponse\022\014\n\004temp\030\001 " +
      "\001(\0052~\n\021ThermostatService\022i\n\032getCurrentTh" +
      "ermostatStatus\022\026.google.protobuf.Empty\0323" +
      ".com.ncirl.thermostat.UnaryThermostatSta" +
      "tusResponseB0\n\024com.ncirl.thermostatB\026The" +
      "rmostatServiceProtoP\001b\006proto3"
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
    internal_static_com_ncirl_thermostat_UnaryThermostatStatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ncirl_thermostat_UnaryThermostatStatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_thermostat_UnaryThermostatStatusResponse_descriptor,
        new java.lang.String[] { "Temp", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
