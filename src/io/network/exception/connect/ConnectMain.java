package io.network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectMain {

    public static void main(String[] args) throws IOException {
        // 아이피나 도메인이 존재하지 않을 떄
        unknownHostEx1();
        unknownHostEx2();
        // 연결이 거절되었을 때
        // 네트워크를 통해 IP의 서버 컴퓨터에 접속은 했다는 뜻이다.
        // 하지만 해당 컴퓨터가 해당 포트를 사용하지 않아 거절한다.
        // RST(리셋) 패킷을 보내 거절한다.
        connectionRefused();
    }

    private static void connectionRefused() throws IOException {
        try {
            Socket socket = new Socket("localhost", 45678);
        } catch (ConnectException e) {
            throw new RuntimeException(e);
        }
    }

    private static void unknownHostEx1() {
        try {
            Socket socket = new Socket("999.999.999.999", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void unknownHostEx2() {
        try {
            Socket socket = new Socket("google.go", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
