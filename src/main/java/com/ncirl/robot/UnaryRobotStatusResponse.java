// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RobotService.proto

package com.ncirl.robot;

/**
 * Protobuf type {@code com.ncirl.robot.UnaryRobotStatusResponse}
 */
public  final class UnaryRobotStatusResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ncirl.robot.UnaryRobotStatusResponse)
    UnaryRobotStatusResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UnaryRobotStatusResponse.newBuilder() to construct.
  private UnaryRobotStatusResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UnaryRobotStatusResponse() {
    robotName_ = "";
    robotStatus_ = "";
    robotBatteryLevel_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UnaryRobotStatusResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            robotName_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            robotStatus_ = s;
            break;
          }
          case 24: {

            robotBatteryLevel_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ncirl.robot.RobotServiceProto.internal_static_com_ncirl_robot_UnaryRobotStatusResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ncirl.robot.RobotServiceProto.internal_static_com_ncirl_robot_UnaryRobotStatusResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ncirl.robot.UnaryRobotStatusResponse.class, com.ncirl.robot.UnaryRobotStatusResponse.Builder.class);
  }

  public static final int ROBOTNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object robotName_;
  /**
   * <pre>
   * Dados que serao passados para o cliente, apos o request. Sao as informacoes do robot.
   * </pre>
   *
   * <code>string robotName = 1;</code>
   */
  public java.lang.String getRobotName() {
    java.lang.Object ref = robotName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      robotName_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Dados que serao passados para o cliente, apos o request. Sao as informacoes do robot.
   * </pre>
   *
   * <code>string robotName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getRobotNameBytes() {
    java.lang.Object ref = robotName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      robotName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ROBOTSTATUS_FIELD_NUMBER = 2;
  private volatile java.lang.Object robotStatus_;
  /**
   * <code>string robotStatus = 2;</code>
   */
  public java.lang.String getRobotStatus() {
    java.lang.Object ref = robotStatus_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      robotStatus_ = s;
      return s;
    }
  }
  /**
   * <code>string robotStatus = 2;</code>
   */
  public com.google.protobuf.ByteString
      getRobotStatusBytes() {
    java.lang.Object ref = robotStatus_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      robotStatus_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ROBOTBATTERYLEVEL_FIELD_NUMBER = 3;
  private int robotBatteryLevel_;
  /**
   * <code>int32 robotBatteryLevel = 3;</code>
   */
  public int getRobotBatteryLevel() {
    return robotBatteryLevel_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getRobotNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, robotName_);
    }
    if (!getRobotStatusBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, robotStatus_);
    }
    if (robotBatteryLevel_ != 0) {
      output.writeInt32(3, robotBatteryLevel_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getRobotNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, robotName_);
    }
    if (!getRobotStatusBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, robotStatus_);
    }
    if (robotBatteryLevel_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, robotBatteryLevel_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ncirl.robot.UnaryRobotStatusResponse)) {
      return super.equals(obj);
    }
    com.ncirl.robot.UnaryRobotStatusResponse other = (com.ncirl.robot.UnaryRobotStatusResponse) obj;

    boolean result = true;
    result = result && getRobotName()
        .equals(other.getRobotName());
    result = result && getRobotStatus()
        .equals(other.getRobotStatus());
    result = result && (getRobotBatteryLevel()
        == other.getRobotBatteryLevel());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ROBOTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getRobotName().hashCode();
    hash = (37 * hash) + ROBOTSTATUS_FIELD_NUMBER;
    hash = (53 * hash) + getRobotStatus().hashCode();
    hash = (37 * hash) + ROBOTBATTERYLEVEL_FIELD_NUMBER;
    hash = (53 * hash) + getRobotBatteryLevel();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ncirl.robot.UnaryRobotStatusResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ncirl.robot.UnaryRobotStatusResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.ncirl.robot.UnaryRobotStatusResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.ncirl.robot.UnaryRobotStatusResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ncirl.robot.UnaryRobotStatusResponse)
      com.ncirl.robot.UnaryRobotStatusResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ncirl.robot.RobotServiceProto.internal_static_com_ncirl_robot_UnaryRobotStatusResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ncirl.robot.RobotServiceProto.internal_static_com_ncirl_robot_UnaryRobotStatusResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ncirl.robot.UnaryRobotStatusResponse.class, com.ncirl.robot.UnaryRobotStatusResponse.Builder.class);
    }

    // Construct using com.ncirl.robot.UnaryRobotStatusResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      robotName_ = "";

      robotStatus_ = "";

      robotBatteryLevel_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ncirl.robot.RobotServiceProto.internal_static_com_ncirl_robot_UnaryRobotStatusResponse_descriptor;
    }

    @java.lang.Override
    public com.ncirl.robot.UnaryRobotStatusResponse getDefaultInstanceForType() {
      return com.ncirl.robot.UnaryRobotStatusResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.ncirl.robot.UnaryRobotStatusResponse build() {
      com.ncirl.robot.UnaryRobotStatusResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ncirl.robot.UnaryRobotStatusResponse buildPartial() {
      com.ncirl.robot.UnaryRobotStatusResponse result = new com.ncirl.robot.UnaryRobotStatusResponse(this);
      result.robotName_ = robotName_;
      result.robotStatus_ = robotStatus_;
      result.robotBatteryLevel_ = robotBatteryLevel_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ncirl.robot.UnaryRobotStatusResponse) {
        return mergeFrom((com.ncirl.robot.UnaryRobotStatusResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ncirl.robot.UnaryRobotStatusResponse other) {
      if (other == com.ncirl.robot.UnaryRobotStatusResponse.getDefaultInstance()) return this;
      if (!other.getRobotName().isEmpty()) {
        robotName_ = other.robotName_;
        onChanged();
      }
      if (!other.getRobotStatus().isEmpty()) {
        robotStatus_ = other.robotStatus_;
        onChanged();
      }
      if (other.getRobotBatteryLevel() != 0) {
        setRobotBatteryLevel(other.getRobotBatteryLevel());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.ncirl.robot.UnaryRobotStatusResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ncirl.robot.UnaryRobotStatusResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object robotName_ = "";
    /**
     * <pre>
     * Dados que serao passados para o cliente, apos o request. Sao as informacoes do robot.
     * </pre>
     *
     * <code>string robotName = 1;</code>
     */
    public java.lang.String getRobotName() {
      java.lang.Object ref = robotName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        robotName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Dados que serao passados para o cliente, apos o request. Sao as informacoes do robot.
     * </pre>
     *
     * <code>string robotName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getRobotNameBytes() {
      java.lang.Object ref = robotName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        robotName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Dados que serao passados para o cliente, apos o request. Sao as informacoes do robot.
     * </pre>
     *
     * <code>string robotName = 1;</code>
     */
    public Builder setRobotName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      robotName_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Dados que serao passados para o cliente, apos o request. Sao as informacoes do robot.
     * </pre>
     *
     * <code>string robotName = 1;</code>
     */
    public Builder clearRobotName() {
      
      robotName_ = getDefaultInstance().getRobotName();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Dados que serao passados para o cliente, apos o request. Sao as informacoes do robot.
     * </pre>
     *
     * <code>string robotName = 1;</code>
     */
    public Builder setRobotNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      robotName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object robotStatus_ = "";
    /**
     * <code>string robotStatus = 2;</code>
     */
    public java.lang.String getRobotStatus() {
      java.lang.Object ref = robotStatus_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        robotStatus_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string robotStatus = 2;</code>
     */
    public com.google.protobuf.ByteString
        getRobotStatusBytes() {
      java.lang.Object ref = robotStatus_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        robotStatus_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string robotStatus = 2;</code>
     */
    public Builder setRobotStatus(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      robotStatus_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string robotStatus = 2;</code>
     */
    public Builder clearRobotStatus() {
      
      robotStatus_ = getDefaultInstance().getRobotStatus();
      onChanged();
      return this;
    }
    /**
     * <code>string robotStatus = 2;</code>
     */
    public Builder setRobotStatusBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      robotStatus_ = value;
      onChanged();
      return this;
    }

    private int robotBatteryLevel_ ;
    /**
     * <code>int32 robotBatteryLevel = 3;</code>
     */
    public int getRobotBatteryLevel() {
      return robotBatteryLevel_;
    }
    /**
     * <code>int32 robotBatteryLevel = 3;</code>
     */
    public Builder setRobotBatteryLevel(int value) {
      
      robotBatteryLevel_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 robotBatteryLevel = 3;</code>
     */
    public Builder clearRobotBatteryLevel() {
      
      robotBatteryLevel_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.ncirl.robot.UnaryRobotStatusResponse)
  }

  // @@protoc_insertion_point(class_scope:com.ncirl.robot.UnaryRobotStatusResponse)
  private static final com.ncirl.robot.UnaryRobotStatusResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ncirl.robot.UnaryRobotStatusResponse();
  }

  public static com.ncirl.robot.UnaryRobotStatusResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UnaryRobotStatusResponse>
      PARSER = new com.google.protobuf.AbstractParser<UnaryRobotStatusResponse>() {
    @java.lang.Override
    public UnaryRobotStatusResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UnaryRobotStatusResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UnaryRobotStatusResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UnaryRobotStatusResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ncirl.robot.UnaryRobotStatusResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

