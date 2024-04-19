package com.ncirl.storage;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: StorageService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StorageServiceGrpc {

  private StorageServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.ncirl.storage.StorageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.ncirl.storage.UnaryStorageStatusResponse> getGetCurrentStorageStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentStorageStatus",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.ncirl.storage.UnaryStorageStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.ncirl.storage.UnaryStorageStatusResponse> getGetCurrentStorageStatusMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.ncirl.storage.UnaryStorageStatusResponse> getGetCurrentStorageStatusMethod;
    if ((getGetCurrentStorageStatusMethod = StorageServiceGrpc.getGetCurrentStorageStatusMethod) == null) {
      synchronized (StorageServiceGrpc.class) {
        if ((getGetCurrentStorageStatusMethod = StorageServiceGrpc.getGetCurrentStorageStatusMethod) == null) {
          StorageServiceGrpc.getGetCurrentStorageStatusMethod = getGetCurrentStorageStatusMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.ncirl.storage.UnaryStorageStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCurrentStorageStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.storage.UnaryStorageStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StorageServiceMethodDescriptorSupplier("getCurrentStorageStatus"))
              .build();
        }
      }
    }
    return getGetCurrentStorageStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StorageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StorageServiceStub>() {
        @java.lang.Override
        public StorageServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StorageServiceStub(channel, callOptions);
        }
      };
    return StorageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StorageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StorageServiceBlockingStub>() {
        @java.lang.Override
        public StorageServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StorageServiceBlockingStub(channel, callOptions);
        }
      };
    return StorageServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StorageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StorageServiceFutureStub>() {
        @java.lang.Override
        public StorageServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StorageServiceFutureStub(channel, callOptions);
        }
      };
    return StorageServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getCurrentStorageStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.ncirl.storage.UnaryStorageStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentStorageStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StorageService.
   */
  public static abstract class StorageServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StorageServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StorageService.
   */
  public static final class StorageServiceStub
      extends io.grpc.stub.AbstractAsyncStub<StorageServiceStub> {
    private StorageServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCurrentStorageStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.ncirl.storage.UnaryStorageStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentStorageStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StorageService.
   */
  public static final class StorageServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StorageServiceBlockingStub> {
    private StorageServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ncirl.storage.UnaryStorageStatusResponse getCurrentStorageStatus(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentStorageStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StorageService.
   */
  public static final class StorageServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<StorageServiceFutureStub> {
    private StorageServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ncirl.storage.UnaryStorageStatusResponse> getCurrentStorageStatus(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentStorageStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_STORAGE_STATUS = 0;

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
        case METHODID_GET_CURRENT_STORAGE_STATUS:
          serviceImpl.getCurrentStorageStatus((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.ncirl.storage.UnaryStorageStatusResponse>) responseObserver);
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
          getGetCurrentStorageStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.ncirl.storage.UnaryStorageStatusResponse>(
                service, METHODID_GET_CURRENT_STORAGE_STATUS)))
        .build();
  }

  private static abstract class StorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StorageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ncirl.storage.StorageServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StorageService");
    }
  }

  private static final class StorageServiceFileDescriptorSupplier
      extends StorageServiceBaseDescriptorSupplier {
    StorageServiceFileDescriptorSupplier() {}
  }

  private static final class StorageServiceMethodDescriptorSupplier
      extends StorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StorageServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StorageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StorageServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentStorageStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
