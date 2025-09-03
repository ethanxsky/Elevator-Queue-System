package elevator;

/**
 * The Request class contains information about the request being made.
 */
public class Request {
    int sourceFloor;
    int destinationFloor;
    int timeEntered;

    /**
     * Constructor for the Request class.
     * @param numFloors
        * The number of floors in the building.
     */
    public Request(int numFloors){
        this.sourceFloor = (int) (Math.random() * numFloors) + 1;
        this.destinationFloor = (int) (Math.random() * numFloors) + 1;
    }

    /**
     * Gets the source floor of the request.
     * @return
        * The source floor of the request.
     */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * Sets the source floor of the request.
     * @param sourceFloor
        * The source floor of the request.
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    /**
     * Gets the destination floor of the request.
     * @return
        * The destination floor of the request.
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * Sets the destination floor of the request.
     * @param destinationFloor
        * The destination floor of the request.
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    /**
     * Gets the time the request was entered.
     * @return
        * The time the request was entered.
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * Sets the time the request was entered.
     * @param timeEntered
        * The time the request was entered.
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }

    /**
     * To String method to give information on the request.
     * @return
        * The description of the request.
     */
    public String toString(){
        return "Source: " + sourceFloor + " Destination: " + destinationFloor + " Time: " + timeEntered;
    }
}
