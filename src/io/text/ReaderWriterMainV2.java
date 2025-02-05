package io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV2 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);
        osw.write(writeString);
        osw.close();

        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, UTF_8);

        StringBuilder sb = new StringBuilder();
        int ch;
        // read()는 char를 반환한다.
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        isr.close();
        System.out.println("sb.toString() = " + sb);
    }
}
