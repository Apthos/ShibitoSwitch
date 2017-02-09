package net.kevin.commands;

import java.util.List;

public abstract class Command {

    public abstract void onCommand(String Command, List<String> Args);

}
