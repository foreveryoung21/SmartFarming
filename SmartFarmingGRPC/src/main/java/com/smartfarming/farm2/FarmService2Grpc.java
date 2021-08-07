package com.smartfarming.farm2;

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
    comments = "Source: service2.proto")
public final class FarmService2Grpc {

  private FarmService2Grpc() {}

  public static final String SERVICE_NAME = "farm.FarmService2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartfarming.farm2.CountRequest,
      com.smartfarming.farm2.CountResponse> getAnimalCountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "animalCount",
      requestType = com.smartfarming.farm2.CountRequest.class,
      responseType = com.smartfarming.farm2.CountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartfarming.farm2.CountRequest,
      com.smartfarming.farm2.CountResponse> getAnimalCountMethod() {
    io.grpc.MethodDescriptor<com.smartfarming.farm2.CountRequest, com.smartfarming.farm2.CountResponse> getAnimalCountMethod;
    if ((getAnimalCountMethod = FarmService2Grpc.getAnimalCountMethod) == null) {
      synchronized (FarmService2Grpc.class) {
        if ((getAnimalCountMethod = FarmService2Grpc.getAnimalCountMethod) == null) {
          FarmService2Grpc.getAnimalCountMethod = getAnimalCountMethod = 
              io.grpc.MethodDescriptor.<com.smartfarming.farm2.CountRequest, com.smartfarming.farm2.CountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "farm.FarmService2", "animalCount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm2.CountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm2.CountResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FarmService2MethodDescriptorSupplier("animalCount"))
                  .build();
          }
        }
     }
     return getAnimalCountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartfarming.farm2.AnimalRequest,
      com.smartfarming.farm2.AnimalResponse> getPriceIncreaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "priceIncrease",
      requestType = com.smartfarming.farm2.AnimalRequest.class,
      responseType = com.smartfarming.farm2.AnimalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartfarming.farm2.AnimalRequest,
      com.smartfarming.farm2.AnimalResponse> getPriceIncreaseMethod() {
    io.grpc.MethodDescriptor<com.smartfarming.farm2.AnimalRequest, com.smartfarming.farm2.AnimalResponse> getPriceIncreaseMethod;
    if ((getPriceIncreaseMethod = FarmService2Grpc.getPriceIncreaseMethod) == null) {
      synchronized (FarmService2Grpc.class) {
        if ((getPriceIncreaseMethod = FarmService2Grpc.getPriceIncreaseMethod) == null) {
          FarmService2Grpc.getPriceIncreaseMethod = getPriceIncreaseMethod = 
              io.grpc.MethodDescriptor.<com.smartfarming.farm2.AnimalRequest, com.smartfarming.farm2.AnimalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "farm.FarmService2", "priceIncrease"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm2.AnimalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm2.AnimalResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FarmService2MethodDescriptorSupplier("priceIncrease"))
                  .build();
          }
        }
     }
     return getPriceIncreaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartfarming.farm2.WeightRequest,
      com.smartfarming.farm2.WeightResponse> getMaxWeightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "maxWeight",
      requestType = com.smartfarming.farm2.WeightRequest.class,
      responseType = com.smartfarming.farm2.WeightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartfarming.farm2.WeightRequest,
      com.smartfarming.farm2.WeightResponse> getMaxWeightMethod() {
    io.grpc.MethodDescriptor<com.smartfarming.farm2.WeightRequest, com.smartfarming.farm2.WeightResponse> getMaxWeightMethod;
    if ((getMaxWeightMethod = FarmService2Grpc.getMaxWeightMethod) == null) {
      synchronized (FarmService2Grpc.class) {
        if ((getMaxWeightMethod = FarmService2Grpc.getMaxWeightMethod) == null) {
          FarmService2Grpc.getMaxWeightMethod = getMaxWeightMethod = 
              io.grpc.MethodDescriptor.<com.smartfarming.farm2.WeightRequest, com.smartfarming.farm2.WeightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "farm.FarmService2", "maxWeight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm2.WeightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm2.WeightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FarmService2MethodDescriptorSupplier("maxWeight"))
                  .build();
          }
        }
     }
     return getMaxWeightMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartfarming.farm2.AreaRequest,
      com.smartfarming.farm2.AreaResponse> getAreaLandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "areaLand",
      requestType = com.smartfarming.farm2.AreaRequest.class,
      responseType = com.smartfarming.farm2.AreaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartfarming.farm2.AreaRequest,
      com.smartfarming.farm2.AreaResponse> getAreaLandMethod() {
    io.grpc.MethodDescriptor<com.smartfarming.farm2.AreaRequest, com.smartfarming.farm2.AreaResponse> getAreaLandMethod;
    if ((getAreaLandMethod = FarmService2Grpc.getAreaLandMethod) == null) {
      synchronized (FarmService2Grpc.class) {
        if ((getAreaLandMethod = FarmService2Grpc.getAreaLandMethod) == null) {
          FarmService2Grpc.getAreaLandMethod = getAreaLandMethod = 
              io.grpc.MethodDescriptor.<com.smartfarming.farm2.AreaRequest, com.smartfarming.farm2.AreaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "farm.FarmService2", "areaLand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm2.AreaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartfarming.farm2.AreaResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FarmService2MethodDescriptorSupplier("areaLand"))
                  .build();
          }
        }
     }
     return getAreaLandMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FarmService2Stub newStub(io.grpc.Channel channel) {
    return new FarmService2Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FarmService2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FarmService2BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FarmService2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FarmService2FutureStub(channel);
  }

  /**
   */
  public static abstract class FarmService2ImplBase implements io.grpc.BindableService {

    /**
     */
    public void animalCount(com.smartfarming.farm2.CountRequest request,
        io.grpc.stub.StreamObserver<com.smartfarming.farm2.CountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAnimalCountMethod(), responseObserver);
    }

    /**
     */
    public void priceIncrease(com.smartfarming.farm2.AnimalRequest request,
        io.grpc.stub.StreamObserver<com.smartfarming.farm2.AnimalResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPriceIncreaseMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartfarming.farm2.WeightRequest> maxWeight(
        io.grpc.stub.StreamObserver<com.smartfarming.farm2.WeightResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getMaxWeightMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartfarming.farm2.AreaRequest> areaLand(
        io.grpc.stub.StreamObserver<com.smartfarming.farm2.AreaResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAreaLandMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAnimalCountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartfarming.farm2.CountRequest,
                com.smartfarming.farm2.CountResponse>(
                  this, METHODID_ANIMAL_COUNT)))
          .addMethod(
            getPriceIncreaseMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.smartfarming.farm2.AnimalRequest,
                com.smartfarming.farm2.AnimalResponse>(
                  this, METHODID_PRICE_INCREASE)))
          .addMethod(
            getMaxWeightMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.smartfarming.farm2.WeightRequest,
                com.smartfarming.farm2.WeightResponse>(
                  this, METHODID_MAX_WEIGHT)))
          .addMethod(
            getAreaLandMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.smartfarming.farm2.AreaRequest,
                com.smartfarming.farm2.AreaResponse>(
                  this, METHODID_AREA_LAND)))
          .build();
    }
  }

  /**
   */
  public static final class FarmService2Stub extends io.grpc.stub.AbstractStub<FarmService2Stub> {
    private FarmService2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private FarmService2Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmService2Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FarmService2Stub(channel, callOptions);
    }

    /**
     */
    public void animalCount(com.smartfarming.farm2.CountRequest request,
        io.grpc.stub.StreamObserver<com.smartfarming.farm2.CountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnimalCountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void priceIncrease(com.smartfarming.farm2.AnimalRequest request,
        io.grpc.stub.StreamObserver<com.smartfarming.farm2.AnimalResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getPriceIncreaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartfarming.farm2.WeightRequest> maxWeight(
        io.grpc.stub.StreamObserver<com.smartfarming.farm2.WeightResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getMaxWeightMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartfarming.farm2.AreaRequest> areaLand(
        io.grpc.stub.StreamObserver<com.smartfarming.farm2.AreaResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAreaLandMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FarmService2BlockingStub extends io.grpc.stub.AbstractStub<FarmService2BlockingStub> {
    private FarmService2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FarmService2BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmService2BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FarmService2BlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartfarming.farm2.CountResponse animalCount(com.smartfarming.farm2.CountRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnimalCountMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.smartfarming.farm2.AnimalResponse> priceIncrease(
        com.smartfarming.farm2.AnimalRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getPriceIncreaseMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FarmService2FutureStub extends io.grpc.stub.AbstractStub<FarmService2FutureStub> {
    private FarmService2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FarmService2FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmService2FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FarmService2FutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartfarming.farm2.CountResponse> animalCount(
        com.smartfarming.farm2.CountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnimalCountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANIMAL_COUNT = 0;
  private static final int METHODID_PRICE_INCREASE = 1;
  private static final int METHODID_MAX_WEIGHT = 2;
  private static final int METHODID_AREA_LAND = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FarmService2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FarmService2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ANIMAL_COUNT:
          serviceImpl.animalCount((com.smartfarming.farm2.CountRequest) request,
              (io.grpc.stub.StreamObserver<com.smartfarming.farm2.CountResponse>) responseObserver);
          break;
        case METHODID_PRICE_INCREASE:
          serviceImpl.priceIncrease((com.smartfarming.farm2.AnimalRequest) request,
              (io.grpc.stub.StreamObserver<com.smartfarming.farm2.AnimalResponse>) responseObserver);
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
        case METHODID_MAX_WEIGHT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.maxWeight(
              (io.grpc.stub.StreamObserver<com.smartfarming.farm2.WeightResponse>) responseObserver);
        case METHODID_AREA_LAND:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.areaLand(
              (io.grpc.stub.StreamObserver<com.smartfarming.farm2.AreaResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FarmService2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FarmService2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartfarming.farm2.FarmServiceImpl2.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FarmService2");
    }
  }

  private static final class FarmService2FileDescriptorSupplier
      extends FarmService2BaseDescriptorSupplier {
    FarmService2FileDescriptorSupplier() {}
  }

  private static final class FarmService2MethodDescriptorSupplier
      extends FarmService2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FarmService2MethodDescriptorSupplier(String methodName) {
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
      synchronized (FarmService2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FarmService2FileDescriptorSupplier())
              .addMethod(getAnimalCountMethod())
              .addMethod(getPriceIncreaseMethod())
              .addMethod(getMaxWeightMethod())
              .addMethod(getAreaLandMethod())
              .build();
        }
      }
    }
    return result;
  }
}
