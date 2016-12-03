package net.kevin.commands.commands;

import net.kevin.Main;
import net.kevin.commands.Command;

import java.util.List;

public class Memory implements Command {
    @Override
    public void onCommand(String Command, List<String> Args) {
        Runtime runtime = Runtime.getRuntime();
        long UsedMem = runtime.totalMemory() - runtime.freeMemory();
        UsedMem =  UsedMem/1024;
        Main.say("Memory Used: " + String.valueOf(UsedMem));
    }
}
