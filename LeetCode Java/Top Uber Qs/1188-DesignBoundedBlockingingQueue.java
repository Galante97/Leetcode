/*
 * 1188. Design Bounded Blocking Queue
 * Implement a thread-safe bounded blocking queue that has the following
 * methods:
 * 
 * BoundedBlockingQueue(int capacity) The constructor initializes the queue with
 * a maximum capacity.
 * void enqueue(int element) Adds an element to the front of the queue. If the
 * queue is full, the calling thread is blocked until the queue is no longer
 * full.
 * int dequeue() Returns the element at the rear of the queue and removes it. If
 * the queue is empty, the calling thread is blocked until the queue is no
 * longer empty.
 * int size() Returns the number of elements currently in the queue.
 * Your implementation will be tested using multiple threads at the same time.
 * Each thread will either be a producer thread that only makes calls to the
 * enqueue method or a consumer thread that only makes calls to the dequeue
 * method. The size method will be called after every test case.
 * 
 * Please do not use built-in implementations of bounded blocking queue as this
 * will not be accepted in an interview.
 */

class BoundedBlockingQueue {
    int capacity;
    Queue<Integer> q;

    public BoundedBlockingQueue(int capacity) {
        this.q = new LinkedList<Integer>();
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (q) {
            while (q.size() >= capacity) {
                q.wait();
            }
            q.add(element);
            q.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        int poll = 0;
        synchronized (q) {
            while (q.size() == 0) {
                q.wait();
            }
            poll = q.poll();
            q.notifyAll();
        }
        return poll;
    }

    public int size() {
        return this.q.size();
    }
}