package io.chat;

import java.util.ArrayList;
import java.util.List;

public class SessionManager {

    private final List<Session> sessions = new ArrayList<>();

    public void add(Session session) {
        sessions.add(session);
    }

    public void remove(Session session) {
        sessions.remove(session);
    }

    public void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
    }
}
