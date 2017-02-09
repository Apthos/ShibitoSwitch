package net.kevin.commands.listeners;

import net.kevin.Main;
import net.kevin.commands.CommandManager;
import net.kevin.gui.Console;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class CommandKeys extends KeyAdapter {

    private Console console;
    private CommandManager commandManager;

    private LinkedList<String> prevCommands = new LinkedList<>();
    private String currentCommand = null;


    public CommandKeys(Console console, CommandManager commandManager){
        Main.report("Program Created new instance of keylogger now!");
        this.console = console;
        this.commandManager = commandManager;
    }

    private void submitCommand(){
        console.getCommandPanel().setText("");
        commandManager.submitInterpretation(currentCommand);
        prevCommands.add(currentCommand);
        currentCommand = null;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (console.getCommandPanel().getText().equals(""))
                return;
            submitCommand();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (!console.getCommandPanel().getText().equals(""))
                return;
            console.getCommandPanel().setText(prevCommands.getLast());
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            String Txt = console.getCommandPanel().getText();
            if (Txt.equals(""))
                return;
            if (Txt.length()==1){
                currentCommand = null;
            }
        } else {
            currentCommand = console.getCommandPanel().getText();
        }
    }
}
