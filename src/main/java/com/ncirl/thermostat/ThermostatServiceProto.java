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
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_thermostat_StreamThermoStatusRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_thermostat_StreamThermoStatusRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_thermostat_StreamThermoStatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_thermostat_StreamThermoStatusResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027ThermostatService.proto\022\024com.ncirl.the" +
      "rmostat\032\033google/protobuf/empty.proto\"J\n\035" +
      "UnaryThermostatStatusResponse\022\014\n\004temp\030\001 " +
      "\001(\005\022\033\n\023heaterStatusMessage\030\002 \001(\t\"/\n\031Stre" +
      "amThermoStatusRequest\022\022\n\nstreamTemp\030\003 \001(" +
      "\005\"-\n\032StreamThermoStatusResponse\022\017\n\007messa" +
      "ge\030\004 \001(\t2\371\001\n\021ThermostatService\022i\n\032getCur" +
      "rentThermostatStatus\022\026.google.protobuf.E" +
      "mpty\0323.com.ncirl.thermostat.UnaryThermos" +
      "tatStatusResponse\022y\n\022streamThermoStatus\022" +
      "/.com.ncirl.thermostat.StreamThermoStatu" +
      "sRequest\0320.com.ncirl.thermostat.StreamTh" +
      "ermoStatusResponse0\001B0\n\024com.ncirl.thermo" +
      "statB\026ThermostatServiceProtoP\001b\006proto3"
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
        new java.lang.String[] { "Temp", "HeaterStatusMessage", });
    internal_static_com_ncirl_thermostat_StreamThermoStatusRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_ncirl_thermostat_StreamThermoStatusRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_thermostat_StreamThermoStatusRequest_descriptor,
        new java.lang.String[] { "StreamTemp", });
    internal_static_com_ncirl_thermostat_StreamThermoStatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_ncirl_thermostat_StreamThermoStatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_thermostat_StreamThermoStatusResponse_descriptor,
        new java.lang.String[] { "Message", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
