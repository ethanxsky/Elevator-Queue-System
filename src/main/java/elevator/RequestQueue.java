package elevator;

import java.util.LinkedList;

/**
 * The RequestQueue class represents a queue of Requests derived from linked list.
 */
public class RequestQueue {


    private LinkedList<Request> queue;

    /**
     * Constructor for the RequestQueue class.
     */
    public RequestQueue() {
        queue = new LinkedList<>();
    }

    /**
     *Enqueues a request into the queue.
     * @param request
        * The request being enqueued.
     */
    public void enqueue(Request request) {

        queue.addLast(request);
    }

    /**
     * Dequeues a request from the queue.
     * @return
        * The request being dequeued.
     * @throws EmptyQueueException
        * Indicates an empty queue.
     */
    public Request dequeue() throws EmptyQueueException {

        if (queue.isEmpty()){
            throw new EmptyQueueException();
        }
        return queue.removeFirst();
    }

    /**
     * Returns the size of the queue.
     * @return
        * How many requests are in the queue.
     */
    public int size() {
        return queue.size();
    }

    /**
     * Indicates whether the queue is empty.
     * @return
        * True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }


}