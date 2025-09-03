package elevator;

/**
 * Custom exception to indicate an empty queue.
 */
public class EmptyQueueException extends Exception {
    
    public EmptyQueueException() {
        super("The queue is empty.");
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}