package net.heckerdev.heckerspluginacf.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.command.CommandSender;

@CommandAlias("test")
@CommandPermission("heckerspluginacf.command.test")
@Description("Just a test command.")
public class TestCommand extends BaseCommand {

    @Syntax("")
    @Default
    @CatchUnknown
    public void onDefault(CommandSender sender) {
        sender.sendMessage("test!");

    }
}
