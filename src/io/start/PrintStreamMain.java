package io.start;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PrintStreamMain {
    public static void main(String[] args) throws IOException {
        byte[] bytes = "Hello!\n".getBytes(StandardCharsets.UTF_8);
        PrintStream printStream = System.out;
        printStream.write(bytes);
    }
}
