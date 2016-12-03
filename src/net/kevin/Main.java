package net.kevin;

import net.kevin.commands.CommandManager;
import net.kevin.files.DeadFile;
import net.kevin.gui.Console;

import java.io.File;

public class Main {

    private static Console console;
    private static CommandManager commandManager;

    public Main(){
        System.out.print("Testing");
    }

    public static void main(String... args) {

        setup();

        DeadFile deadFile1 = new DeadFile(new File("/Users/apthos/Desktop/test.shb"));
        DeadFile deadFile2 = new DeadFile();

    }

    private static void setup(){
        console = new Console();
        commandManager = new CommandManager();
        console.initializeEvents(console, commandManager);
    }

    public static void say(String Message) {
        console.say(Message);
    }
    public static void warn(String Warning) {
        console.warn(Warning);
    }

    public static void report(String Report) {
        console.report(Report);
    }

    public static Console getConsole() {
        return console;
    }

    public static CommandManager getCommandManager(){
        return commandManager;
    }
}
