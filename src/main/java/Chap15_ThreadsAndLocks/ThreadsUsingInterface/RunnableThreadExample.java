package Chap15_ThreadsAndLocks.ThreadsUsingInterface;

public class RunnableThreadExample implements Runnable {
    public int count = 0;

    public void run() {
        System.out.println("Inside Runnable Thread");

        try {
            while(count < 5){
                System.out.println("incrementing count");
                count++;
                Thread.sleep(500);
            }
        } catch (InterruptedException ex){
            System.out.println("RunnableThread interrupted");
        }

        System.out.println("RunnableThread terminating");
    }
}