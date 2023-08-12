package net.heckerdev.heckerspluginacf.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandAlias("kit")
@Description("Just a test command.")
public class KitCommand extends BaseCommand {

    @Syntax("<Kit>")
    @Default
    public void onDefault(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!sender.hasPermission("heckerspluginacf.command.kit")) {
                player.sendMessage(ChatColor.RED + "⚠ You do not have permission to use this command!");

            } else {
                player.sendMessage(ChatColor.RED + "⚠ You need to specify a kit to receive!" + ChatColor.RESET + ChatColor.GRAY + " Usage: /kit " + ChatColor.UNDERLINE + "<kit>" + ChatColor.RESET);
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You can only execute this as a player!");
        }

    }

    @Subcommand("Kit")
    public void onKit(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("heckerspluginacf.command.kit.kit")) {
                ItemStack diamond = new ItemStack(Material.DIAMOND);

                ItemStack bricks = new ItemStack(Material.BRICK, 20);

                player.getInventory().addItem(bricks, diamond);
                player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "✔" + ChatColor.RESET + ChatColor.GREEN + " Successfully received Kit \"Kit\"!");
            } else {
                player.sendMessage(ChatColor.RED + "⚠ You do not have permission to receive this kit!");
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You can only execute this as a player!");
        }
    }

    @Subcommand("Wood")
    public void onWood(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("heckerspluginacf.command.kit.wood")) {
                ItemStack wood = new ItemStack(Material.OAK_PLANKS);

                player.getInventory().addItem(wood);
                player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "✔" + ChatColor.RESET + ChatColor.GREEN + " Successfully received Kit \"Wood\"!");
            } else {
                player.sendMessage(ChatColor.RED + "⚠ You do not have permission to receive this kit!");
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You can only execute this as a player!");
        }
    }

    @CatchUnknown
    public void onUnknown(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.RED + "⚠ Kit \"" + args[0] + "\" Does not exist!");
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You can only execute this as a player!");
        }
    }
}
