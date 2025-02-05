package io.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.text.TextConst.FILE_NAME;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";

        FileWriter fw = new FileWriter(FILE_NAME);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();

        System.out.println(sb);
    }
}
