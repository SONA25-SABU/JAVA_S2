import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class JobApplicationThread extends Thread {
    private static int applicationCount = 0;
    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        // Simulating a user applying for a job
        applyForJob();
    }

    private void applyForJob() {
        // Assume some job application logic here
        // For simplicity, we'll just increment a counter
        lock.lock();
        try {
            applicationCount++;
            System.out.println("Job application submitted by user " + Thread.currentThread().getId() +
                    ". Total applications: " + applicationCount);
        } finally {
            lock.unlock();
        }
    }
}

public class MultiThreadedJobApplicationExample {
    public static void main(String[] args) {
        int numUsers = 5;

        // Create and start multiple threads
        JobApplicationThread[] jobApplicationThreads = new JobApplicationThread[numUsers];
        for (int i = 0; i < numUsers; i++) {
            jobApplicationThreads[i] = new JobApplicationThread();
            jobApplicationThreads[i].start();
        }

        // Wait for all threads to finish
        try {
            for (JobApplicationThread thread : jobApplicationThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All job applications completed.");}}
    

