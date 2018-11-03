package jsr.threadsPractice;

public class RunnableExample implements Runnable{
    @Override
    public void run() {
        System.out.println("Inside the RunnableExample run()   ");
        System.out.println(Thread.currentThread());
    }
}
