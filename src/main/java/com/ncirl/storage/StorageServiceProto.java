// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: StorageService.proto

package com.ncirl.storage;

public final class StorageServiceProto {
  private StorageServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_storage_UnaryStorageStatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_storage_UnaryStorageStatusResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_storage_StorageStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_storage_StorageStatus_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024StorageService.proto\022\021com.ncirl.storag" +
      "e\032\033google/protobuf/empty.proto\"Y\n\032UnaryS" +
      "torageStatusResponse\022;\n\021storageStatusLis" +
      "t\030\001 \003(\0132 .com.ncirl.storage.StorageStatu" +
      "s\"9\n\rStorageStatus\022\021\n\tstorageId\030\001 \001(\005\022\025\n" +
      "\rstorageStatus\030\002 \001(\t2r\n\016StorageService\022`" +
      "\n\027getCurrentStorageStatus\022\026.google.proto" +
      "buf.Empty\032-.com.ncirl.storage.UnaryStora" +
      "geStatusResponseB*\n\021com.ncirl.storageB\023S" +
      "torageServiceProtoP\001b\006proto3"
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
    internal_static_com_ncirl_storage_UnaryStorageStatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ncirl_storage_UnaryStorageStatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_storage_UnaryStorageStatusResponse_descriptor,
        new java.lang.String[] { "StorageStatusList", });
    internal_static_com_ncirl_storage_StorageStatus_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_ncirl_storage_StorageStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_storage_StorageStatus_descriptor,
        new java.lang.String[] { "StorageId", "StorageStatus", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
