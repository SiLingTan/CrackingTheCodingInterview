package Chap15_ThreadsAndLocks.ThreadsUsingExtension;

public class ThreadExample extends Thread {
    int count = 0;

    public void run() {
        System.out.println("Thread starting");

        while (count < 5){
            try {
                System.out.println("Incrementing count");
                count++;
                Thread.sleep(500);
            } catch (InterruptedException ex){
                System.out.println("Thread Interrupted");
            }
        }

        System.out.println("Thread terminating");
    }

}
