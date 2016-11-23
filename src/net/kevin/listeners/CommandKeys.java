package net.kevin.listeners;

import net.kevin.Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CommandKeys extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER ){
            if (Main.getConsole().getCommandPanel().getText().equals(""))
                return;
            String CMD = Main.getConsole().getCommandPanel().getText();
            Main.getConsole().getCommandPanel().setText("");
            Main.getCommandManager().submitInterpretation(CMD);
        }
    }
}
