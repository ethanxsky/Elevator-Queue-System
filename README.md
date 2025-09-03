# Elevator Queue System

## Overview

This project is a discrete-event simulator for a multi-elevator system. It models passenger requests, elevator movement, and a queuing system to analyze key performance metrics such as total wait time and average wait time under varying conditions. The simulation is built using a modular, object-oriented approach in Java to ensure scalability and maintainability.

## Key Features

Scalable Simulation: The program can be configured to run for thousands of time units with a large number of floors and elevators.  
Performance Analysis: It calculates total wait time, total completed requests, and average wait time to analyze system efficiency.  
Modular Design: The project is composed of separate, independent classes for core components like Elevator, Request, and RequestQueue, making the code easy to understand and extend.  
Queuing System: It uses a queue-based system to handle incoming passenger requests, simulating real-world traffic.

## Assumptions and Limitations

This simulation is a simplified model and does not account for many factors of a real-world elevator system. Key limitations include:  
- Single Request Per Trip: Elevators are assumed to handle only one request at a time (one passenger from a source floor to a destination floor) before becoming idle.  
- Idealized Movement: The model does not account for passenger load/unload times or door open/close times.  
- First-Come, First-Served Logic: The scheduling system assigns requests based on the order in which they arrive, without considering an elevator's proximity or direction of travel.

## How to Run the Simulation

The simulation is configured through command-line inputs. To run it, you will need a Java Development Kit (JDK) and Apache Maven installed.

### Compile and run using Maven:

```bash
mvn clean compile exec:java

```

Note: The specific command to run may vary depending on your project structure.

## Configuration Options

When you run the program, you will be prompted to enter the following values:  
- Probability of arrival for Requests: A number between 0.0 and 1.0 that determines the likelihood of a new request arriving at each time unit.  
- Number of floors: The number of floors in the building.  
- Number of elevators: The number of elevators available to service requests.  
- Length of the simulator: The total duration of the simulation in time units.

## Sample Output

The program will output the performance metrics based on your inputs.

```text
Please enter the probability of arrival for Requests: 1.0
Please enter the number of floors: 10
Please enter the number of elevators: 2
Please enter the length of the simulator (int time units):  100

Total wait time: 986  
Total Requests: 26  
Average wait time: 37.92
```
