package io.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static io.network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class Session implements Runnable {

    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private boolean closed = false;

    public Session(Socket socket) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
    }

    public void close() {
        if (closed) {
            return;
        }
        closeAll(socket, input, output);
        closed = true;
        log("연결 종료: " + socket + " isClosed: " + socket.isClosed());
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String received = input.readUTF();
                log("client -> server: " + received);

                System.out.println("서버: ");
                String toSend = scanner.nextLine();
                output.writeUTF(toSend);

                if (toSend.equals("exit")) {
                    break;
                }

                log("server -> client: " + toSend);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
