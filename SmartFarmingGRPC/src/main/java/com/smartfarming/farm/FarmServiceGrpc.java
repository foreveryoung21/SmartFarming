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
public final class FarmServiceGrpc {

  private FarmServiceGrpc() {}

  public static final String SERVICE_NAME = "farm.FarmService";

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
    if ((getCalculateMethod = FarmServiceGrpc.getCalculateMethod) == null) {
      synchronized (FarmServiceGrpc.class) {
        if ((getCalculateMethod = FarmServiceGrpc.getCalculateMethod) == null) {
          FarmServiceGrpc.getCalculateMethod = getCalculateMethod = 
              io.grpc.MethodDescriptor.<com.smartfarming.farm.Request, com.smartfarming.farm.CalculateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "farm.FarmService", "calculate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.CalculateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FarmServiceMethodDescriptorSupplier("calculate"))
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
    if ((getLevelMethod = FarmServiceGrpc.getLevelMethod) == null) {
      synchronized (FarmServiceGrpc.class) {
        if ((getLevelMethod = FarmServiceGrpc.getLevelMethod) == null) {
          FarmServiceGrpc.getLevelMethod = getLevelMethod = 
              io.grpc.MethodDescriptor.<com.smartfarming.farm.WaterRequest, com.smartfarming.farm.WaterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "farm.FarmService", "level"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.WaterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.WaterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FarmServiceMethodDescriptorSupplier("level"))
                  .build();
          }
        }
     }
     return getLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartfarming.farm.PriceRequest,
      com.smartfarming.farm.PriceResponse> getTotalPriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "totalPrice",
      requestType = com.smartfarming.farm.PriceRequest.class,
      responseType = com.smartfarming.farm.PriceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartfarming.farm.PriceRequest,
      com.smartfarming.farm.PriceResponse> getTotalPriceMethod() {
    io.grpc.MethodDescriptor<com.smartfarming.farm.PriceRequest, com.smartfarming.farm.PriceResponse> getTotalPriceMethod;
    if ((getTotalPriceMethod = FarmServiceGrpc.getTotalPriceMethod) == null) {
      synchronized (FarmServiceGrpc.class) {
        if ((getTotalPriceMethod = FarmServiceGrpc.getTotalPriceMethod) == null) {
          FarmServiceGrpc.getTotalPriceMethod = getTotalPriceMethod = 
              io.grpc.MethodDescriptor.<com.smartfarming.farm.PriceRequest, com.smartfarming.farm.PriceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "farm.FarmService", "totalPrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.PriceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.PriceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FarmServiceMethodDescriptorSupplier("totalPrice"))
                  .build();
          }
        }
     }
     return getTotalPriceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartfarming.farm.SwitchRequest,
      com.smartfarming.farm.SwitchResponse> getIrrigationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "irrigation",
      requestType = com.smartfarming.farm.SwitchRequest.class,
      responseType = com.smartfarming.farm.SwitchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartfarming.farm.SwitchRequest,
      com.smartfarming.farm.SwitchResponse> getIrrigationMethod() {
    io.grpc.MethodDescriptor<com.smartfarming.farm.SwitchRequest, com.smartfarming.farm.SwitchResponse> getIrrigationMethod;
    if ((getIrrigationMethod = FarmServiceGrpc.getIrrigationMethod) == null) {
      synchronized (FarmServiceGrpc.class) {
        if ((getIrrigationMethod = FarmServiceGrpc.getIrrigationMethod) == null) {
          FarmServiceGrpc.getIrrigationMethod = getIrrigationMethod = 
              io.grpc.MethodDescriptor.<com.smartfarming.farm.SwitchRequest, com.smartfarming.farm.SwitchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "farm.FarmService", "irrigation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.SwitchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm.SwitchResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FarmServiceMethodDescriptorSupplier("irrigation"))
                  .build();
          }
        }
     }
     return getIrrigationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FarmServiceStub newStub(io.grpc.Channel channel) {
    return new FarmServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FarmServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FarmServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FarmServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FarmServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FarmServiceImplBase implements io.grpc.BindableService {

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

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartfarming.farm.PriceRequest> totalPrice(
        io.grpc.stub.StreamObserver<com.smartfarming.farm.PriceResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTotalPriceMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartfarming.farm.SwitchRequest> irrigation(
        io.grpc.stub.StreamObserver<com.smartfarming.farm.SwitchResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getIrrigationMethod(), responseObserver);
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
          .addMethod(
            getTotalPriceMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.smartfarming.farm.PriceRequest,
                com.smartfarming.farm.PriceResponse>(
                  this, METHODID_TOTAL_PRICE)))
          .addMethod(
            getIrrigationMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.smartfarming.farm.SwitchRequest,
                com.smartfarming.farm.SwitchResponse>(
                  this, METHODID_IRRIGATION)))
          .build();
    }
  }

  /**
   */
  public static final class FarmServiceStub extends io.grpc.stub.AbstractStub<FarmServiceStub> {
    private FarmServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FarmServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FarmServiceStub(channel, callOptions);
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

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartfarming.farm.PriceRequest> totalPrice(
        io.grpc.stub.StreamObserver<com.smartfarming.farm.PriceResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getTotalPriceMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartfarming.farm.SwitchRequest> irrigation(
        io.grpc.stub.StreamObserver<com.smartfarming.farm.SwitchResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getIrrigationMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FarmServiceBlockingStub extends io.grpc.stub.AbstractStub<FarmServiceBlockingStub> {
    private FarmServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FarmServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FarmServiceBlockingStub(channel, callOptions);
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
  public static final class FarmServiceFutureStub extends io.grpc.stub.AbstractStub<FarmServiceFutureStub> {
    private FarmServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FarmServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FarmServiceFutureStub(channel, callOptions);
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
  private static final int METHODID_TOTAL_PRICE = 2;
  private static final int METHODID_IRRIGATION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FarmServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FarmServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_TOTAL_PRICE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.totalPrice(
              (io.grpc.stub.StreamObserver<com.smartfarming.farm.PriceResponse>) responseObserver);
        case METHODID_IRRIGATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.irrigation(
              (io.grpc.stub.StreamObserver<com.smartfarming.farm.SwitchResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FarmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FarmServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartfarming.farm.FarmServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FarmService");
    }
  }

  private static final class FarmServiceFileDescriptorSupplier
      extends FarmServiceBaseDescriptorSupplier {
    FarmServiceFileDescriptorSupplier() {}
  }

  private static final class FarmServiceMethodDescriptorSupplier
      extends FarmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FarmServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FarmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FarmServiceFileDescriptorSupplier())
              .addMethod(getCalculateMethod())
              .addMethod(getLevelMethod())
              .addMethod(getTotalPriceMethod())
              .addMethod(getIrrigationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
