package com.ncirl.servers;

import com.google.protobuf.Empty;
import com.ncirl.common.Thermostat;
import com.ncirl.thermostat.ThermostatServiceGrpc;
import com.ncirl.thermostat.UnaryThermostatStatusResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
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
