package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMainV2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] input = {65, 66, 67, 68};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] buffer = new byte[10];
        // 부분적으로 읽거나 읽은 내용을 처리하면서 계속 읽어야할 때 적합하다. 메모리 사용량을 제어할 수 있다.
        // ex. 아주 큰 파일을 조각 조각 읽어들인다.
        int readCount = fis.read(buffer, 0, 10);
        System.out.println("readCount = " + readCount);
        System.out.println("buffer = " + Arrays.toString(buffer));
        fis.close();
    }
}
