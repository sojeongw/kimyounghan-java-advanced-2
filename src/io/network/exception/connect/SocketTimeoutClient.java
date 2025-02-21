package io.network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketTimeoutClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        InputStream input = socket.getInputStream();

        try {
            // 소켓 타임아웃 = readTimeout 설정
            socket.setSoTimeout(1000);
            int read = input.read();
            System.out.println("read = " + read);
        } catch (Exception e) {
            e.printStackTrace();
        }
        socket.close();
    }
}
