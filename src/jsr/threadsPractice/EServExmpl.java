package jsr.threadsPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class EServExmpl {

    public static void main(String[] args) {
        ExecutorService jsr = Executors.newFixedThreadPool(2);
        jsr.submit(new RunnableExample());
        try {
            System.out.println("submit(callable): "  +
                    jsr.submit(new CallableExample()).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(new CallableExample());
        try {
            List<Future<String>> futures = jsr.invokeAll(callables);
            System.out.println("invokeAll(callables).get(0).get(): " +
                    futures.get(0).get());
            String future = jsr.invokeAny(callables);
            System.out.println("invokeAny(callables):  " + future);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
