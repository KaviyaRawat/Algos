package jsr.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class completableFutureTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hi");
        Path path = Paths.get("/Users/karawat/Desktop/jsr.sh");
        Stream<String> lines = Files.lines(path);
        process(lines).thenRunAsync(() -> {
            System.out.println("Hi2");
            lines.forEach(line->{
                System.out.println(line);
            });
            try {
                int a = 5 + 15;
                System.out.println(a);
            } catch (Exception e) {
                System.out.println("In Catch");
            }
            finally {
                System.out.println("Finally");
            }

        });
        Thread.sleep(10000);
    }


    public static CompletableFuture<Void> process(Stream<String> line){
        line.forEach(ln->{
            System.out.println(ln);
        });

        return new CompletableFuture<>();

    }

}
