package com.ncirl.servers;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.google.protobuf.Empty;
import com.ncirl.common.Thermostat;
import com.ncirl.thermostat.ThermostatServiceGrpc;
import com.ncirl.thermostat.UnaryThermostatStatusResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
public class ThermostatServer {

    private Server server;
    int port = 50060;

    public void start() throws IOException {

        server = ServerBuilder.forPort(port)
                .addService(new ThermostatServiceImpl())
                .build()
                .start();
        System.out.println("Thermostat Server started, listening on port " + port);

        registerToConsul();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server");
            try {
                ThermostatServer.this.stop();
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

        // Load Consul configuration from consul.properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/com/ncirl/thermostat-service.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Extract Consul configuration properties
        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));
        String serviceName = props.getProperty("consul.service.name");
        int servicePort = Integer.parseInt(props.getProperty("consul.service.port"));
        String healthCheckInterval = props.getProperty("consul.service.healthCheckInterval");

        // Get host address
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        // Create a Consul client
        ConsulClient consulClient = new ConsulClient(consulHost, consulPort);

        // Define service details
        NewService newService = new NewService();
        newService.setName(serviceName);
        newService.setPort(servicePort);
        newService.setAddress(hostAddress); // Set host address

        // Register service with Consul
        consulClient.agentServiceRegister(newService);

        // Print registration success message
        System.out.println("Server registered to Consul successfully. Host: " + hostAddress);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ThermostatServer server = new ThermostatServer();
        server.start();
        server.blockUntilShutdown();
    }

    class ThermostatServiceImpl extends ThermostatServiceGrpc.ThermostatServiceImplBase {

        Thermostat thermostat, thermostat2;

        public ThermostatServiceImpl() {
            thermostat = new Thermostat(17);
            thermostat2 = new Thermostat(25);
        }


        @Override
        public void getCurrentThermostatStatus (Empty request, StreamObserver<UnaryThermostatStatusResponse> responseObserver) {
            System.out.println("Server side getThermostatStatus method invoked...");

            UnaryThermostatStatusResponse response = UnaryThermostatStatusResponse.newBuilder()
                    .setTemp(thermostat.getTemp())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }

    }
}
