package com.ncirl.robot;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: RobotService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RobotServiceGrpc {

  private RobotServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.ncirl.robot.RobotService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.ncirl.robot.UnaryRobotStatusResponse> getGetCurrentRobotStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentRobotStatus",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.ncirl.robot.UnaryRobotStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.ncirl.robot.UnaryRobotStatusResponse> getGetCurrentRobotStatusMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.ncirl.robot.UnaryRobotStatusResponse> getGetCurrentRobotStatusMethod;
    if ((getGetCurrentRobotStatusMethod = RobotServiceGrpc.getGetCurrentRobotStatusMethod) == null) {
      synchronized (RobotServiceGrpc.class) {
        if ((getGetCurrentRobotStatusMethod = RobotServiceGrpc.getGetCurrentRobotStatusMethod) == null) {
          RobotServiceGrpc.getGetCurrentRobotStatusMethod = getGetCurrentRobotStatusMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.ncirl.robot.UnaryRobotStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCurrentRobotStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.robot.UnaryRobotStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RobotServiceMethodDescriptorSupplier("getCurrentRobotStatus"))
              .build();
        }
      }
    }
    return getGetCurrentRobotStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ncirl.robot.StreamRobotStatusRequest,
      com.ncirl.robot.StreamRobotStatusResponse> getStreamRobotStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamRobotStatus",
      requestType = com.ncirl.robot.StreamRobotStatusRequest.class,
      responseType = com.ncirl.robot.StreamRobotStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.ncirl.robot.StreamRobotStatusRequest,
      com.ncirl.robot.StreamRobotStatusResponse> getStreamRobotStatusMethod() {
    io.grpc.MethodDescriptor<com.ncirl.robot.StreamRobotStatusRequest, com.ncirl.robot.StreamRobotStatusResponse> getStreamRobotStatusMethod;
    if ((getStreamRobotStatusMethod = RobotServiceGrpc.getStreamRobotStatusMethod) == null) {
      synchronized (RobotServiceGrpc.class) {
        if ((getStreamRobotStatusMethod = RobotServiceGrpc.getStreamRobotStatusMethod) == null) {
          RobotServiceGrpc.getStreamRobotStatusMethod = getStreamRobotStatusMethod =
              io.grpc.MethodDescriptor.<com.ncirl.robot.StreamRobotStatusRequest, com.ncirl.robot.StreamRobotStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamRobotStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.robot.StreamRobotStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.robot.StreamRobotStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RobotServiceMethodDescriptorSupplier("streamRobotStatus"))
              .build();
        }
      }
    }
    return getStreamRobotStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RobotServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RobotServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RobotServiceStub>() {
        @java.lang.Override
        public RobotServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RobotServiceStub(channel, callOptions);
        }
      };
    return RobotServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RobotServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RobotServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RobotServiceBlockingStub>() {
        @java.lang.Override
        public RobotServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RobotServiceBlockingStub(channel, callOptions);
        }
      };
    return RobotServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RobotServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RobotServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RobotServiceFutureStub>() {
        @java.lang.Override
        public RobotServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RobotServiceFutureStub(channel, callOptions);
        }
      };
    return RobotServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getCurrentRobotStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.ncirl.robot.UnaryRobotStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentRobotStatusMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.ncirl.robot.StreamRobotStatusRequest> streamRobotStatus(
        io.grpc.stub.StreamObserver<com.ncirl.robot.StreamRobotStatusResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamRobotStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RobotService.
   */
  public static abstract class RobotServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RobotServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RobotService.
   */
  public static final class RobotServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RobotServiceStub> {
    private RobotServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RobotServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RobotServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCurrentRobotStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.ncirl.robot.UnaryRobotStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentRobotStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.ncirl.robot.StreamRobotStatusRequest> streamRobotStatus(
        io.grpc.stub.StreamObserver<com.ncirl.robot.StreamRobotStatusResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getStreamRobotStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RobotService.
   */
  public static final class RobotServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RobotServiceBlockingStub> {
    private RobotServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RobotServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RobotServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ncirl.robot.UnaryRobotStatusResponse getCurrentRobotStatus(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentRobotStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RobotService.
   */
  public static final class RobotServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RobotServiceFutureStub> {
    private RobotServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RobotServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RobotServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ncirl.robot.UnaryRobotStatusResponse> getCurrentRobotStatus(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentRobotStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_ROBOT_STATUS = 0;
  private static final int METHODID_STREAM_ROBOT_STATUS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT_ROBOT_STATUS:
          serviceImpl.getCurrentRobotStatus((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.ncirl.robot.UnaryRobotStatusResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_ROBOT_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamRobotStatus(
              (io.grpc.stub.StreamObserver<com.ncirl.robot.StreamRobotStatusResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetCurrentRobotStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.ncirl.robot.UnaryRobotStatusResponse>(
                service, METHODID_GET_CURRENT_ROBOT_STATUS)))
        .addMethod(
          getStreamRobotStatusMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.ncirl.robot.StreamRobotStatusRequest,
              com.ncirl.robot.StreamRobotStatusResponse>(
                service, METHODID_STREAM_ROBOT_STATUS)))
        .build();
  }

  private static abstract class RobotServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RobotServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ncirl.robot.RobotServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RobotService");
    }
  }

  private static final class RobotServiceFileDescriptorSupplier
      extends RobotServiceBaseDescriptorSupplier {
    RobotServiceFileDescriptorSupplier() {}
  }

  private static final class RobotServiceMethodDescriptorSupplier
      extends RobotServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RobotServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RobotServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RobotServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentRobotStatusMethod())
              .addMethod(getStreamRobotStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
