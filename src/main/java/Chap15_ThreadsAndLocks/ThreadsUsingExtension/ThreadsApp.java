package Chap15_ThreadsAndLocks.ThreadsUsingExtension;

public class ThreadsApp {
    public static void main(String[] args){
        ThreadExample instance = new ThreadExample();
        instance.start();

        while(instance.count != 5){
            try {
                System.out.println("what is the count? "+ instance.count);
                Thread.sleep(100);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
