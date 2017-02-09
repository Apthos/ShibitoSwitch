package net.kevin;

import net.kevin.commands.CommandManager;
import net.kevin.files.DeadFile;
import net.kevin.gui.Console;

import java.io.File;

public class Main {

    private static Console console;
    private static CommandManager commandManager;

    public Main() {
        System.out.print("Testing");
    }

    public static void main(String... args) {
        try {
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Ted");
            System.setProperty("com.apple.macos.useScreenMenuBar", "true");
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        } catch (SecurityException e) {
            Main.report(e.getMessage());
        }
        setup();

        DeadFile deadFile1 = new DeadFile(new File("/Users/apthos/Desktop/test.shb"));

    }

    private static void setup() {
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

    public static CommandManager getCommandManager() {
        return commandManager;
    }
}
