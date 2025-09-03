package elevator;

/**
 * The Elevator class contains information about the elevator and the request it takes.
 */
public class Elevator {

    private int currentFloor;
    private ElevatorState elevatorState;
    private Request request;
    
    /**
     * An enum to represent the possible states of an elevator.
     */
    public enum ElevatorState {
        IDLE,
        TO_SOURCE,
        TO_DESTINATION
    }

    /**
     * Constructor for the Elevator class.
     */
    public Elevator(){
        this.request = null;
        this.elevatorState = ElevatorState.IDLE;
        this.currentFloor = 1;
    }

    /**
     * Gets the current floor of the elevator.
     */
    public int getCurrentFloor(){
        return currentFloor;
    }

    /**
     * Sets the current floor of the elevator.
     */
    public void setCurrentFloor(int currentFloor){
        this.currentFloor = currentFloor;
    }

    /**
     * Gets the state of the elevator.
     */
    public ElevatorState getElevatorState(){
        return elevatorState;
    }

    /**
     * Sets the state of the elevator.
     */
    public void setElevatorState(ElevatorState elevatorState){
        this.elevatorState = elevatorState;
    }

    /**
     * Gets the request the elevator is handling.
     */
    public Request getRequest(){
        return request;
    }

    /**
     * Sets the request the elevator is handling.
     */
    public void setRequest(Request request){
        this.request = request;
    }
}