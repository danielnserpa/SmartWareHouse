package com.ncirl.servers;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.google.protobuf.Empty;
import com.ncirl.common.Storage;
import com.ncirl.storage.StorageServiceGrpc;
import com.ncirl.storage.UnaryStorageStatusResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class StorageServer {

    private Server server;

    int port = 50079;

    public void start() throws IOException {

        server = ServerBuilder.forPort(port)
                .addService(new StorageServiceImpl())
                .build()
                .start();
        System.out.println("Storage Server started, listening on port " + port);

        registerToConsul();

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

    private void registerToConsul() {
        System.out.println("Registering server to Consul...");

        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/com/ncirl/storage-service.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));
        String serviceName = props.getProperty("consul.service.name");
        int servicePort = Integer.parseInt(props.getProperty("consul.service.port"));
        String healthCheckInterval = props.getProperty("consul.service.healthCheckInterval");

        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        ConsulClient consulClient = new ConsulClient(consulHost, consulPort);

        NewService newService = new NewService();
        newService.setName(serviceName);
        newService.setPort(servicePort);
        newService.setAddress(hostAddress);

        consulClient.agentServiceRegister(newService);

        System.out.println("Server registered to Consul successfully. Host: " + hostAddress);
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
