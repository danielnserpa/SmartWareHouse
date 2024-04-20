package com.ncirl.thermostat;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: ThermostatService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ThermostatServiceGrpc {

  private ThermostatServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.ncirl.thermostat.ThermostatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.ncirl.thermostat.UnaryThermostatStatusResponse> getGetCurrentThermostatStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentThermostatStatus",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.ncirl.thermostat.UnaryThermostatStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.ncirl.thermostat.UnaryThermostatStatusResponse> getGetCurrentThermostatStatusMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.ncirl.thermostat.UnaryThermostatStatusResponse> getGetCurrentThermostatStatusMethod;
    if ((getGetCurrentThermostatStatusMethod = ThermostatServiceGrpc.getGetCurrentThermostatStatusMethod) == null) {
      synchronized (ThermostatServiceGrpc.class) {
        if ((getGetCurrentThermostatStatusMethod = ThermostatServiceGrpc.getGetCurrentThermostatStatusMethod) == null) {
          ThermostatServiceGrpc.getGetCurrentThermostatStatusMethod = getGetCurrentThermostatStatusMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.ncirl.thermostat.UnaryThermostatStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCurrentThermostatStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.thermostat.UnaryThermostatStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ThermostatServiceMethodDescriptorSupplier("getCurrentThermostatStatus"))
              .build();
        }
      }
    }
    return getGetCurrentThermostatStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ThermostatServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceStub>() {
        @java.lang.Override
        public ThermostatServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatServiceStub(channel, callOptions);
        }
      };
    return ThermostatServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ThermostatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceBlockingStub>() {
        @java.lang.Override
        public ThermostatServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatServiceBlockingStub(channel, callOptions);
        }
      };
    return ThermostatServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ThermostatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatServiceFutureStub>() {
        @java.lang.Override
        public ThermostatServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatServiceFutureStub(channel, callOptions);
        }
      };
    return ThermostatServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getCurrentThermostatStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.ncirl.thermostat.UnaryThermostatStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentThermostatStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ThermostatService.
   */
  public static abstract class ThermostatServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ThermostatServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ThermostatService.
   */
  public static final class ThermostatServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ThermostatServiceStub> {
    private ThermostatServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCurrentThermostatStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.ncirl.thermostat.UnaryThermostatStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentThermostatStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ThermostatService.
   */
  public static final class ThermostatServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ThermostatServiceBlockingStub> {
    private ThermostatServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ncirl.thermostat.UnaryThermostatStatusResponse getCurrentThermostatStatus(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentThermostatStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ThermostatService.
   */
  public static final class ThermostatServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ThermostatServiceFutureStub> {
    private ThermostatServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ncirl.thermostat.UnaryThermostatStatusResponse> getCurrentThermostatStatus(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentThermostatStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_THERMOSTAT_STATUS = 0;

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
        case METHODID_GET_CURRENT_THERMOSTAT_STATUS:
          serviceImpl.getCurrentThermostatStatus((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.ncirl.thermostat.UnaryThermostatStatusResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetCurrentThermostatStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.ncirl.thermostat.UnaryThermostatStatusResponse>(
                service, METHODID_GET_CURRENT_THERMOSTAT_STATUS)))
        .build();
  }

  private static abstract class ThermostatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ThermostatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ncirl.thermostat.ThermostatServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ThermostatService");
    }
  }

  private static final class ThermostatServiceFileDescriptorSupplier
      extends ThermostatServiceBaseDescriptorSupplier {
    ThermostatServiceFileDescriptorSupplier() {}
  }

  private static final class ThermostatServiceMethodDescriptorSupplier
      extends ThermostatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ThermostatServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ThermostatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ThermostatServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentThermostatStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
