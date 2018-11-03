package jsr.threadsPractice;

import java.util.concurrent.Callable;

public class CallableExample implements Callable{
    @Override
    public String call() throws Exception {
        return "Jai Sai Ram ";
    }
}
