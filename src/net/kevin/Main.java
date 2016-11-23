package net.kevin;

import net.kevin.commands.CommandManager;
import net.kevin.gui.Console;

public class Main {

    private static Console console;
    private static CommandManager commandManager;

    public static void main(String[] args) {
        setup();

    }

    public static void setup(){
        console = new Console();
        commandManager = new CommandManager();
    }

    public static Console getConsole(){
        return console;
    }

    public static CommandManager getCommandManager(){
        return commandManager;
    }
}
