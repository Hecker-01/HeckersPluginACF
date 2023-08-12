package net.heckerdev.heckerspluginacf.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@CommandAlias("smite")
@Description("Strike someone with lightning.")
public class SmiteCommand extends BaseCommand {

    @Default
    @Syntax(" <player>")
    @CommandCompletion("@players")
    public void onDefault(@NotNull CommandSender sender, String[] args) {
        if (!sender.hasPermission("testplugin.command.fly")) {
            sender.sendMessage(ChatColor.RED + "⚠ You do not have permission to use this command!");
        } else if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "You need to specify a player to smite!" + ChatColor.RESET + ChatColor.GRAY + " Usage: /smite " + ChatColor.UNDERLINE + "<player>" + ChatColor.RESET);
        } else {
            Player player = Bukkit.getPlayer(args[0]);
            if (player != null) {
                player.getWorld().spawnEntity(player.getLocation(), EntityType.LIGHTNING);
                player.sendMessage(ChatColor.RED + "Thou hast been smitten!");
                sender.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "✔" + ChatColor.RESET + ChatColor.GREEN + " Successfully smited " + args[0] + "!");
            } else {
                sender.sendMessage(ChatColor.RED + args[0] + " is not a valid player! - Make sure the player is online!" + ChatColor.RESET + ChatColor.GRAY + " Usage: /fly " + ChatColor.UNDERLINE + "<player>" + ChatColor.RESET);
            }
        }
    }
}
