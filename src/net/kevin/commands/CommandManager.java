package net.kevin.commands;

import net.kevin.Main;
import net.kevin.commands.commands.Hello;
import net.kevin.commands.commands.Memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandManager {

    private HashMap<String, Command> Commands;

    public CommandManager() {
        Commands = new HashMap<>();
        registerCommands();
    }

    private void registerCommands() {
        Commands.put("hello", new Hello());
        Commands.put("memory", new Memory());
    }

    public void submitInterpretation(String CMD) {
        if (!Commands.containsKey(CMD.split(" ")[0].toLowerCase())) {
            Main.getConsole().report("ERROR: \"" + CMD.split(" ")[0] +
                    "\" isn't a valid command!");
            return;
        }
        List<String> Args = new ArrayList<>();
        boolean f = true;
        for (String S : CMD.split(" ")) {
            if (f) {
                f = false;
                continue;
            }
            Args.add(S);
        }
        Commands.get(CMD.split(" ")[0].toLowerCase()).onCommand(CMD.split(" ")[0]
                .toLowerCase(), Args);

    }
}