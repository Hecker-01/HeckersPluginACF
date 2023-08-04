package net.heckerdev.heckerspluginacf.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.command.CommandSender;


@CommandAlias("test")
@CommandPermission("heckerspluginacf.command.test")
public class TestCommand extends BaseCommand {

    @Syntax("")
    @Description("Lists all of your or another players residences.")
    @Default
    public void onDefault(CommandSender sender) {
        sender.sendMessage("test!");

    }
}
