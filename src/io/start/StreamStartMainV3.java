package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMainV3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] input = {65, 66, 67, 68};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        // 스트림이 끝날 때까지 모든 데이터를 통으로 읽어온다. 메모리 사용량을 제어할 수 없다.
        // 큰 파일은 OOM이 날 수 있다.
        byte[] readBytes = fis.readAllBytes();
        System.out.println("buffer = " + Arrays.toString(readBytes));
        fis.close();
    }
}
