package io.network.exception.connect;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ConnectTimeoutMainV2 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            // 비워서 생성하면 연결을 바로 시도하지 않는다.
            Socket socket = new Socket();
            // 타임아웃을 설정한다.
            socket.connect(new InetSocketAddress("192.168.1.250", 45678), 1000);
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + (end - start));
    }
}
