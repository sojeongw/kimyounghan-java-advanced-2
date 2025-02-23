package io.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class Server {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        SessionManager sessionManager = new SessionManager();

        Shutdown shutdown = new Shutdown(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdown, "shutdown"));
        Session session = null;

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                session = new Session(socket);
                sessionManager.add(session);

                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            log("서버 소켓 종료: " + e);
        } finally {
            sessionManager.remove(session);
        }
    }

    static class Shutdown implements Runnable {

        private final ServerSocket serverSocket;
        private final SessionManager sessionManager;

        public Shutdown(ServerSocket serverSocket, SessionManager sessionManager) {
            this.serverSocket = serverSocket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {
            try {
                sessionManager.closeAll();
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
