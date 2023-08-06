package net.heckerdev.heckerspluginacf.commands;

import net.heckerdev.heckerspluginacf.HeckersPluginACF;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@CommandAlias("groups")
@Description("Get the groups of yourself or another player.")
public class GroupsCommand extends BaseCommand {

    @Default
    @Syntax("(optional) <player>")
    @CommandCompletion("@players")
    public void onDefault(@NotNull CommandSender sender, String[] args) {
        if (!sender.hasPermission("testplugin.command.groups")) {
            sender.sendMessage(ChatColor.RED + "⚠ You do not have permission to use this command!");
        } else if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                String[] groups = HeckersPluginACF.getPermissions().getPlayerGroups(player);
                sender.sendMessage(ChatColor.GREEN + "Your groups are: " + String.join(", ", groups));
            } else {
                sender.sendMessage(ChatColor.RED + "You need to specify a player to get their groups!" + ChatColor.RESET + ChatColor.GRAY + " Usage: /groups " + ChatColor.UNDERLINE + "<player>" + ChatColor.RESET);
                sender.sendMessage(ChatColor.YELLOW + "You can also just use " + ChatColor.UNDERLINE + "/groups" + ChatColor.RESET + ChatColor.YELLOW + " to get your own groups, but you need to be a player to do that!" + ChatColor.RESET + ChatColor.GRAY + " Usage: " + ChatColor.UNDERLINE + "/groups");
            }
        } else {
            Player player = Bukkit.getPlayer(args[0]);
            if (player != null) {
                String[] groups = HeckersPluginACF.getPermissions().getPlayerGroups(player);
                sender.sendMessage(ChatColor.GREEN + player.getName() + "'s groups are: " + String.join(", ", groups));
            } else {
                sender.sendMessage(ChatColor.RED + args[0] + " is not a valid player! - Make sure the player is online!" + ChatColor.RESET + ChatColor.GRAY + " Usage: /groups " + ChatColor.UNDERLINE + "<player>" + ChatColor.RESET);
            }
        }
    }
}