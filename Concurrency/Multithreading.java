package Concurrency;

/**
 * 📘 TOPIC 5: MULTITHREADING
 * Executing multiple tasks simultaneously to improve CPU utilization.
 * Covers Lifecycle, Synchronization, and Thread Safety.
 */
public class Multithreading {

    // =========================================================================
    // SECTION 1: CREATING THREADS (Thread vs Runnable)
    // =========================================================================

    // Q: Difference between extending Thread and implementing Runnable?
    // A: 1. Inheriting: Not flexible (Java only allows one class inheritance).
    // A: 2. Implementing: Recommended for flexibility and decoupling task from runner.
    
    // Method 1: Extending Thread
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread (Extends) is running: " + Thread.currentThread().getName());
        }
    }

    // Method 2: Implementing Runnable
    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Task (Runnable) is running: " + Thread.currentThread().getName());
        }
    }

    public void demonstrate() {
        if (!keepRunning) return; // Use the volatile flag
        MyThread t1 = new MyThread();
        t1.start(); // Q: Why not call run()? A: start() creates a new thread! run() is just a normal method call.

        Thread t2 = new Thread(new MyTask());
        t2.start();
    }

    // =========================================================================
    // SECTION 2: THREAD LIFECYCLE (States)
    // =========================================================================

    /*
     * 1. New: Born but not started.
     * 2. Runnable: Ready for execution (JVM scheduler decides).
     * 3. Running: In progress.
     * 4. Blocked/Waiting/Timed Waiting: Paused for lock or I/O.
     * 5. Terminated: Execution finished.
     */

    // =========================================================================
    // SECTION 3: SYNCHRONIZATION (Preventing Race Conditions)
    // =========================================================================

    // Q: What is a Race Condition?
    // A: Multiple threads access shared data simultaneously, leading to corrupt counts.
    static class Counter {
        private int count = 0;

        // Q: What does 'synchronized' do?
        // A: Locks the method to one thread at a time.
        public synchronized void increment() {
            count++;
        }

        public int getCount() { return count; }
    }

    // =========================================================================
    // SECTION 4: VOLATILE & ATOMIC (Interview Critical)
    // =========================================================================

    /*
     * Q: What is 'volatile'?
     * A: Ensures the variable is always read from/written to the MAIN MEMORY, 
     *    not the thread's local cache. Guarantees visibility.
     * 
     * Q: What are Atomic variables?
     * A: Use lock-free CPU instructions to perform hardware-level atomic operations.
     */
    private volatile boolean keepRunning = true; 

    // =========================================================================
    // SECTION 5: WAIT, NOTIFY, AND DEADLOCKS
    // =========================================================================

    /*
     * wait(): Thread goes to waiting pool. Releasing the lock.
     * notify(): Wakes up one thread from the pool.
     * notifyAll(): Wakes up all threads.
     * 
     * Q: What is Deadlock?
     * A: Thread A holds Lock 1 and waits for Lock 2. 
     *    Thread B holds Lock 2 and waits for Lock 1. Both wait forever!
     */

    // =========================================================================
    // SECTION 6: MODERN CONCURRENCY (ExecutorService)
    // =========================================================================

    /*
     * Q: Why not create new threads every time?
     * A: Creating threads is expensive (Heap memory + Context switching).
     * FIX: Use a Thread Pool (ExecutorService) to reuse a fixed number of threads.
     */

    public void demonstrateLifecycle() {
        System.out.println("--- 2. Thread Methods ---");
        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread sleeping...");
                Thread.sleep(1000); // Timed Waiting
                System.out.println("Thread woke up!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        try {
            t.join(); // Main thread waits for 't' to finish.
        } catch (InterruptedException e) {}
    }
}
