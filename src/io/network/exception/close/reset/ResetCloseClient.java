package io.network.exception.close.reset;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static util.MyLogger.log;

public class ResetCloseClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        log("소켓 연결: " + socket);

        // 서버에서 fin이 올 때까지 잠시 대기
        Thread.sleep(1000);

        // 같이 fin을 날리지 않고 그냥 push
        output.write(1);

        // fin에는 꼭 fin을 보내야 하기 때문에 서버에서 강제 종료: RST
        Thread.sleep(1000); // RST 전송 대기

        try {
            int read = input.read();
            System.out.println("read = " + read);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            // RST를 보내도 또 시도한다면 broken pipe
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        log("연결 종료: " + socket.isClosed());
    }

}
