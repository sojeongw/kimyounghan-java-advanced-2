package io.network.exception.connect;

import java.io.IOException;
import java.net.Socket;

public class ConnectTimeoutMainV1 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        try {
            // 상대가 없거나 응답을 계속 기다려야 하는 상황
            // 일정 시간이 지나면 ConnectionTimeout 발생
            Socket socket = new Socket("192.168.1.250", 45678);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + (end - start));
    }
}
