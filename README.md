# Distributed Systems Project - Smart Warehouse

## Overview

This project simulates a **distributed system environment** for a **Smart Warehouse**, integrating independent components such as **Robot**, **Thermostat**, and **Storage System**. Each component interacts with the others in real-time, offering dynamic status streaming and on-demand control through efficient client-server communication.

The goal of this project is to provide a functional system where each component can independently report its status, and respond to user commands, simulating real-time operations of a smart warehouse. The project emphasizes **real-time data processing**, **client-server communication**, and an **intuitive user interface**.

## Key Features

- **Real-time Status Streaming**: Get live updates from the Robot, Thermostat, and Storage systems.
- **On-Demand Control**: Ability to change the Robot’s status, adjust the Thermostat temperature, and check or modify the storage status.
- **Distributed Architecture**: Services run on separate servers with efficient communication over gRPC.
- **User Interface**: A **JavaFX** front-end application that displays system status and allows interaction with the components.
- **Service Discovery with Consul**: All services (Robot, Thermostat, Storage) register themselves with **Consul** for easy discovery and load balancing.

## Technologies Used

- **Docker**: Containerization of services for isolated environments.
- **Maven**: Dependency management and project build automation.
- **JavaFX**: User interface design.
- **gRPC**: High-performance, open-source RPC framework for client-server communication.
- **Consul**: Service discovery tool for managing service instances.
- **Java**: Programming language used for service development.

## Project Structure

- **Robot Server**: Manages robot status, battery levels, and responses to client requests for robot state and streaming.
- **Thermostat Server**: Provides temperature control, with real-time updates about the thermostat's status.
- **Storage Server**: Handles storage capacity status, allowing updates and status retrieval.
- **Client (JavaFX Application)**: Provides a GUI to interact with the backend services.
- **Service Discovery**: Each service registers itself with **Consul**, allowing for easy discovery by other services in the distributed system.

## How to Run the Project

### Prerequisites

1. **Docker** should be installed to run services in containers.
2. **Maven** should be installed to build the project and manage dependencies.
3. Ensure **Consul** is running for service discovery.

### Steps to Run the Project

1. **Build the Project**: Open a terminal in the project directory and run:
   ```bash
   mvn clean install

2. **Start Each Server**:
- Navigate to the corresponding directory for each service and run the following commands:
  - **Robot Service**:
    ```
    mvn exec:java -Dexec.mainClass=com.ncirl.servers.RobotServer
    ```
  - **Thermostat Service**:
    ```
    mvn exec:java -Dexec.mainClass=com.ncirl.servers.ThermostatServer
    ```
  - **Storage Service**:
    ```
    mvn exec:java -Dexec.mainClass=com.ncirl.servers.StorageServer
    ```

3. **Start the Launcher**:
- In the project directory, run:
  ```
  mvn exec:java -Dexec.mainClass=com.ncirl.NewSmartWareHouseApp
  ```
This launches the JavaFX GUI where you can interact with the system.

4. **Start Streaming Controller**:
- Ensure all services are running, then navigate to `StreamingController.java` and execute the method to start real-time status streaming.

### Troubleshooting

- Ensure **Docker** containers for the backend services are running and reachable.
- If services don’t register with **Consul**, check your **consul.properties** configuration for correctness.
- Check the console logs for errors and verify network connectivity if issues arise.

## Conclusion

This project demonstrates the power of **distributed systems** in creating dynamic, interactive applications. By using **Docker** for containerization, **gRPC** for communication, and **JavaFX** for the user interface, it provides a functional and scalable architecture ideal for simulating smart warehouse systems.

Enjoy interacting with your **Smart Warehouse**!



src > main > java > formcontrollers > servers
start each Server > start Launcher > start StreamingController



