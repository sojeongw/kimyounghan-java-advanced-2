package io.chat.server;

import io.chat.server.command.ChangeCommand;
import io.chat.server.command.Command;
import io.chat.server.command.DefaultCommand;
import io.chat.server.command.ExitCommand;
import io.chat.server.command.JoinCommand;
import io.chat.server.command.MessageCommand;
import io.chat.server.command.UsersCommand;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandManagerV4 implements CommandManager {

    private static final String DELIMITER = "\\|";
    private final Map<String, Command> commands = new HashMap<>();
    private final DefaultCommand defaultCommand = new DefaultCommand();

    public CommandManagerV4(SessionManager sessionManager) {
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
        
        // nullObject 패턴
        // null일 때의 상황을 객체처럼 다룬다.
        Command command = commands.getOrDefault(key, defaultCommand);
        command.execute(args, session);
    }
}
