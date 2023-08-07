package net.heckerdev.heckerspluginacf.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.command.CommandSender;

@CommandAlias("test")
@Description("Just a test command.")
public class TestCommand extends BaseCommand {

    @Syntax("")
    @Default
    @CatchUnknown
    public void onDefault(CommandSender sender) {
        //send a message to the sender
        sender.sendMessage("test!");
    }
}
