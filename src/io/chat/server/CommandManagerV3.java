package io.chat.server;

import io.chat.server.command.ChangeCommand;
import io.chat.server.command.Command;
import io.chat.server.command.ExitCommand;
import io.chat.server.command.JoinCommand;
import io.chat.server.command.MessageCommand;
import io.chat.server.command.UsersCommand;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandManagerV3 implements CommandManager {

    private static final String DELIMITER = "\\|";
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManagerV3(SessionManager sessionManager) {
        commands.put("/join", new JoinCommand(sessionManager));
        commands.put("/message", new MessageCommand(sessionManager));
        commands.put("/change", new ChangeCommand(sessionManager));
        commands.put("/users", new UsersCommand(sessionManager));
        commands.put("/exit", new ExitCommand());
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMITER);
        String key = args[0];
        Command command = commands.get(key);
        if (command == null) {
            session.send("처리할 수 없는 명령어입니다. " + totalMessage);
            return;
        }
        command.execute(args, session);
    }
}
