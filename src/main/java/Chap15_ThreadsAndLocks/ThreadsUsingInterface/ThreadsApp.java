package Chap15_ThreadsAndLocks.ThreadsUsingInterface;

public class ThreadsApp {
    public static void main(String[] args){
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();

        while(instance.count < 5){
            try {
                System.out.println("hey is this done?");
                Thread.sleep(100);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
