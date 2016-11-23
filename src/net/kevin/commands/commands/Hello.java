package net.kevin.commands.commands;

import net.kevin.Main;
import net.kevin.commands.Command;

import java.util.List;

public class Hello implements Command {


    @Override
    public void onCommand(String Command, List<String> Args) {
        Main.getConsole().say("Sucessfully Played Hello Command!");
        Main.getConsole().say("Hey Kevin!");
    }

}
