package elevator;

import java.util.ArrayList;

public class Simulator {
    public static void simulate(double probability, int floors, int elevators, int simLength) {
        
        ArrayList<Elevator> elevatorList = new ArrayList<Elevator>();
        BooleanSource prob = new BooleanSource(probability);
        
        final Elevator.ElevatorState IDLE = Elevator.ElevatorState.IDLE;
        final Elevator.ElevatorState TO_SOURCE = Elevator.ElevatorState.TO_SOURCE;
        final Elevator.ElevatorState TO_DESTINATION = Elevator.ElevatorState.TO_DESTINATION;

        try {
            int requestSum = 0;
            int totalWaitTime = 0;
            double averageWaitTime;

            // Initialize the elevators
            for (int i = 0; i < elevators; i++) {
                elevatorList.add(new Elevator());
            }

            RequestQueue queue = new RequestQueue();
            
            // Main simulation loop
            for (int i = 1; i <= simLength; i++) {
                
                // Check for new request arrival
                if (prob.requestArrived()) {
                    Request newRequest = new Request(floors);
                    newRequest.setTimeEntered(i);
                    queue.enqueue(newRequest);
                }

                // Check each elevator
                for (Elevator e : elevatorList) {
                    
                    // If elevator is idle and there are requests in the queue, assign a new request
                    if (e.getElevatorState() == IDLE && !queue.isEmpty()) {
                        Request temp = queue.dequeue();
                        e.setRequest(temp);

                        // Set elevator state based on its current position relative to the request's source floor
                        if (e.getCurrentFloor() == e.getRequest().getSourceFloor()) {
                            e.setElevatorState(TO_DESTINATION);
                        } else {
                            e.setElevatorState(TO_SOURCE);
                        }
                    }

                    // Move the elevator
                    if (e.getElevatorState() == TO_SOURCE) {
                        if (e.getCurrentFloor() < e.getRequest().getSourceFloor()) {
                            e.setCurrentFloor(e.getCurrentFloor() + 1);
                        } else if (e.getCurrentFloor() > e.getRequest().getSourceFloor()) {
                            e.setCurrentFloor(e.getCurrentFloor() - 1);
                        }
                        
                        // If elevator arrives at the source floor
                        if (e.getCurrentFloor() == e.getRequest().getSourceFloor()) {
                            e.setElevatorState(TO_DESTINATION);
                        }
                    } else if (e.getElevatorState() == TO_DESTINATION) {
                        if (e.getCurrentFloor() < e.getRequest().getDestinationFloor()) {
                            e.setCurrentFloor(e.getCurrentFloor() + 1);
                        } else if (e.getCurrentFloor() > e.getRequest().getDestinationFloor()) {
                            e.setCurrentFloor(e.getCurrentFloor() - 1);
                        }

                        // If elevator arrives at the destination floor
                        if (e.getCurrentFloor() == e.getRequest().getDestinationFloor()) {
                            // Request is now complete, so update statistics
                            totalWaitTime += i - e.getRequest().getTimeEntered();
                            requestSum++;
                            e.setElevatorState(IDLE);
                        }
                    }
                }
            }

            // Output final statistics
            averageWaitTime = (double) totalWaitTime / (double) requestSum;
            System.out.println("\nTotal wait time: " + totalWaitTime);
            System.out.println("Total Requests: " + requestSum);
            System.out.print("Average wait time: ");
            System.out.printf("%.2f", averageWaitTime);

        } catch (EmptyQueueException e) {
            System.out.print(e.getMessage());
        }
    }
}