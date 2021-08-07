package com.smartfarming.farm;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service.proto")
public final class FarmGrpc {

  private FarmGrpc() {}

  public static final String SERVICE_NAME = "farm.Farm";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartfarming.farm.Request,
      com.smartfarming.farm.CalculateResponse> getCalculateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "calculate",
      requestType = com.smartfarming.farm.Request.class,
      responseType = com.smartfarming.farm.CalculateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartfarming.farm.Request,
      com.smartfarming.farm.CalculateResponse> getCalculateMethod() {
    io.grpc.MethodDescriptor<com.smartfarming.farm.Request, com.smartfarming.farm.CalculateResponse> getCalculateMethod;
    if ((getCalculateMethod = FarmGrpc.getCalculateMethod) == null) {
      synchronized (FarmGrpc.class) {
        if ((getCalculateMethod = FarmGrpc.getCalculateMethod) == null) {
          FarmGrpc.getCalculateMethod = getCalculateMethod = 
              io.grpc.MethodDescriptor.<com.smartfarming.farm.Request, com.smartfarming.farm.CalculateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "farm.Farm", "calculate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.CalculateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FarmMethodDescriptorSupplier("calculate"))
                  .build();
          }
        }
     }
     return getCalculateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartfarming.farm.WaterRequest,
      com.smartfarming.farm.WaterResponse> getLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "level",
      requestType = com.smartfarming.farm.WaterRequest.class,
      responseType = com.smartfarming.farm.WaterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartfarming.farm.WaterRequest,
      com.smartfarming.farm.WaterResponse> getLevelMethod() {
    io.grpc.MethodDescriptor<com.smartfarming.farm.WaterRequest, com.smartfarming.farm.WaterResponse> getLevelMethod;
    if ((getLevelMethod = FarmGrpc.getLevelMethod) == null) {
      synchronized (FarmGrpc.class) {
        if ((getLevelMethod = FarmGrpc.getLevelMethod) == null) {
          FarmGrpc.getLevelMethod = getLevelMethod = 
              io.grpc.MethodDescriptor.<com.smartfarming.farm.WaterRequest, com.smartfarming.farm.WaterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "farm.Farm", "level"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.WaterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.WaterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FarmMethodDescriptorSupplier("level"))
                  .build();
          }
        }
     }
     return getLevelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FarmStub newStub(io.grpc.Channel channel) {
    return new FarmStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FarmBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FarmBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FarmFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FarmFutureStub(channel);
  }

  /**
   */
  public static abstract class FarmImplBase implements io.grpc.BindableService {

    /**
     */
    public void calculate(com.smartfarming.farm.Request request,
        io.grpc.stub.StreamObserver<com.smartfarming.farm.CalculateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateMethod(), responseObserver);
    }

    /**
     */
    public void level(com.smartfarming.farm.WaterRequest request,
        io.grpc.stub.StreamObserver<com.smartfarming.farm.WaterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLevelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartfarming.farm.Request,
                com.smartfarming.farm.CalculateResponse>(
                  this, METHODID_CALCULATE)))
          .addMethod(
            getLevelMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.smartfarming.farm.WaterRequest,
                com.smartfarming.farm.WaterResponse>(
                  this, METHODID_LEVEL)))
          .build();
    }
  }

  /**
   */
  public static final class FarmStub extends io.grpc.stub.AbstractStub<FarmStub> {
    private FarmStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FarmStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FarmStub(channel, callOptions);
    }

    /**
     */
    public void calculate(com.smartfarming.farm.Request request,
        io.grpc.stub.StreamObserver<com.smartfarming.farm.CalculateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void level(com.smartfarming.farm.WaterRequest request,
        io.grpc.stub.StreamObserver<com.smartfarming.farm.WaterResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLevelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FarmBlockingStub extends io.grpc.stub.AbstractStub<FarmBlockingStub> {
    private FarmBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FarmBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FarmBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartfarming.farm.CalculateResponse calculate(com.smartfarming.farm.Request request) {
      return blockingUnaryCall(
          getChannel(), getCalculateMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.smartfarming.farm.WaterResponse> level(
        com.smartfarming.farm.WaterRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getLevelMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FarmFutureStub extends io.grpc.stub.AbstractStub<FarmFutureStub> {
    private FarmFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FarmFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FarmFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartfarming.farm.CalculateResponse> calculate(
        com.smartfarming.farm.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE = 0;
  private static final int METHODID_LEVEL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FarmImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FarmImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE:
          serviceImpl.calculate((com.smartfarming.farm.Request) request,
              (io.grpc.stub.StreamObserver<com.smartfarming.farm.CalculateResponse>) responseObserver);
          break;
        case METHODID_LEVEL:
          serviceImpl.level((com.smartfarming.farm.WaterRequest) request,
              (io.grpc.stub.StreamObserver<com.smartfarming.farm.WaterResponse>) responseObserver);
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

  private static abstract class FarmBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FarmBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartfarming.farm.FarmServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Farm");
    }
  }

  private static final class FarmFileDescriptorSupplier
      extends FarmBaseDescriptorSupplier {
    FarmFileDescriptorSupplier() {}
  }

  private static final class FarmMethodDescriptorSupplier
      extends FarmBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FarmMethodDescriptorSupplier(String methodName) {
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
      synchronized (FarmGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FarmFileDescriptorSupplier())
              .addMethod(getCalculateMethod())
              .addMethod(getLevelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
