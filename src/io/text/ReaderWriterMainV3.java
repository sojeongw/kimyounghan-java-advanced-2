package io.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.text.TextConst.FILE_NAME;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        FileWriter fw = new FileWriter(FILE_NAME);
        fw.write(writeString);
        fw.close();

        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, StandardCharsets.UTF_8);

        int ch;
        while ((ch = fr.read()) != -1) {
            sb.append((char) ch);
        }
        fr.close();

        System.out.println("sb = " + sb);
    }
}
