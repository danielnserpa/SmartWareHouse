package com.ncirl.servers;

import com.google.protobuf.Empty;
import com.ncirl.common.Storage;
import com.ncirl.storage.StorageServiceGrpc;
import com.ncirl.storage.UnaryStorageStatusResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class StorageServer {

    private Server server;

    int port = 50056;

    public void start() throws IOException {

        server = ServerBuilder.forPort(port)
                .addService(new StorageServiceImpl())
                .build()
                .start();
        System.out.println("Storage Server started, listening on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server");
            try {
                StorageServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        StorageServer server = new StorageServer();
        server.start();
        server.blockUntilShutdown();
    }

    class StorageServiceImpl extends StorageServiceGrpc.StorageServiceImplBase {

        Storage storage, storage2, storage3, storage4;

        public StorageServiceImpl() {
            storage = new Storage(1, "Full");
            storage2 = new Storage(2, "Empty");
            storage3 = new Storage(3, "Empty");
            storage4 = new Storage(4, "Full");
        }

        @Override
        public void getCurrentStorageStatus (Empty request, StreamObserver<UnaryStorageStatusResponse> responseObserver) {
            System.out.println("Server side getStorageStatus method invoked...");

            UnaryStorageStatusResponse response = UnaryStorageStatusResponse.newBuilder()
                    .setStorageId(storage.getId())
                    .setStorageStatus(storage.getStatus())

                    .setStorageId(storage2.getId())
                    .setStorageStatus(storage2.getStatus())

                    .setStorageId(storage3.getId())
                    .setStorageStatus(storage3.getStatus())

                    .setStorageId(storage4.getId())
                    .setStorageStatus(storage4.getStatus())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }



    }
}
