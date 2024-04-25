package com.ncirl.servers;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.google.protobuf.Empty;
import com.ncirl.storage.StorageServiceGrpc;
import com.ncirl.storage.StorageStatus;
import com.ncirl.storage.UnaryStorageStatusResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StorageServer {

    private Server server;

    public void start() throws IOException {
        int port = 50089;
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

    public static class StorageServiceImpl extends StorageServiceGrpc.StorageServiceImplBase {

        private final List<StorageStatus> storageStatusList;
        private final Random random;

        public StorageServiceImpl() {

            storageStatusList = new ArrayList<>();
            random = new Random();

            for (int i = 1; i <= 4; i++) {
                storageStatusList.add(generateRandomStorageStatus(i));
            }
        }

        @Override
        public void getCurrentStorageStatus(Empty request, StreamObserver<UnaryStorageStatusResponse> responseObserver) {
            System.out.println("Server side getCurrentStorageStatus method invoked...");

            // Update storage status before sending the response
            updateStorageStatus();

            UnaryStorageStatusResponse.Builder responseBuilder = UnaryStorageStatusResponse.newBuilder();

            for (StorageStatus status : storageStatusList) {
                responseBuilder.addStorageStatusList(status);
            }

            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();

        }

        private void updateStorageStatus() {

            storageStatusList.replaceAll(storageStatus -> {
                // Randomly choose whether the storage status should be Full or Empty
                // Update the status of the current storage unit in the storageStatusList
                return storageStatus.toBuilder().setStorageStatus(random.nextBoolean() ? "Full" : "Empty").build();
            });
        }

        private static StorageStatus generateRandomStorageStatus(int storageId) {
            boolean isBusy = new Random().nextBoolean();
            String status = isBusy ? "Busy" : "Empty";
            return StorageStatus.newBuilder()
                    .setStorageId(storageId)
                    .setStorageStatus(status)
                    .build();
        }
    }
}