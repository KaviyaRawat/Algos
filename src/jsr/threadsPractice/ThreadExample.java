package jsr.threadsPractice;

public class ThreadExample extends Thread{
    private static int a;
    private static String str = "Jai Sai Ram";

    public void run(){
        System.out.println("Inside the ThreadExample run()    "
                + Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException {
        //str.wait();
        ThreadExample thread1 = new ThreadExample();
        ThreadExample thread2 = new ThreadExample();
        ThreadExample thread7 = new ThreadExample();
        ThreadExample thread4 = new ThreadExample();
        ThreadExample thread5 = new ThreadExample();
        ThreadExample thread6 = new ThreadExample();
        ThreadExample thread9 = new ThreadExample();
        ThreadExample thread8 = new ThreadExample();

        thread1.start();
        Thread.sleep(2000);
        thread2.start();
        //thread1.start();
        //Thread.sleep(2000);
        thread2.sleep(2000);
        System.out.println("From main() " + Thread.currentThread());
        Thread thread3 = new Thread(new RunnableExample());
        thread3.start();
        thread7.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread9.start();
        thread8.start();
    }
}
