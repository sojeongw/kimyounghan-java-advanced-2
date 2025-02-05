package io.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMainV1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        // byte 단위로 작성
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        /* // byte 단위로 읽음
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        // -1: EOF
        System.out.println(fis.read()); */

        int data;
        while ((data = fis.read()) != -1) {
            System.out.println("data = " + data);
        }

        // 외부 자원이기 때문에 반드시 닫아줘야 한다. 자동으로 GC되는 대상이 아니다.
        fis.close();
    }
}
