package myjava.concurrent.completableFuture;

import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureTest {
    public static CompletableFuture<String> readPage(URL url) {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        });
    }

    public static void main(String[] args) {
        try {
            CompletableFuture<String> contents = readPage(new URL(""));
            CompletableFuture<List<URL>> links = contents.thenApply(Parser::getLinks);
        } catch (Exception e) {

        }
    }
}

class Parser {
    public static List<URL> getLinks(String page) {
        return null;
    }
}
