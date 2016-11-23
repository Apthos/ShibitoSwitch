package net.kevin.commands;

import java.util.List;

public interface Command {

    void onCommand(String Command, List<String> Args);

}
