package net.kevin.commands.listeners;

import net.kevin.Main;
import net.kevin.commands.CommandManager;
import net.kevin.gui.Console;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CommandKeys extends KeyAdapter {

    private Console console;
    private CommandManager commandManager;

    public CommandKeys(Console console, CommandManager commandManager){
        Main.report("Program Created new instance of keylogger now!");
        this.console = console;
        this.commandManager = commandManager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (console.getCommandPanel().getText().equals(""))
                return;
            String CMD = console.getCommandPanel().getText();
            console.getCommandPanel().setText("");
            commandManager.submitInterpretation(CMD);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (!console.getCommandPanel().getText().equals(""))

                return;
        }
    }
}
