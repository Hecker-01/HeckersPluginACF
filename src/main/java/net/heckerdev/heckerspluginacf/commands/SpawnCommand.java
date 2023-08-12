package net.heckerdev.heckerspluginacf.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("spawn")
@Description("Teleports you to spawn.")
public class SpawnCommand extends BaseCommand {

    @Syntax("")
    @Default
    @CatchUnknown
    public void onDefault(CommandSender sender) {
        //if the sender is a player
        if (sender instanceof Player) {
            Player player = (Player) sender;
            //if the player has permission to use the command
            if (player.hasPermission("testplugin.command.spawn")) {
                //teleporting the player to the world spawn
                Location spawnLocation = player.getWorld().getSpawnLocation().add(0.5, 0, 0.5);
                spawnLocation.setPitch(0);
                spawnLocation.setYaw(-180);
                player.teleport(spawnLocation);
                player.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "✔" + ChatColor.RESET + ChatColor.GREEN + " Successfully teleported to spawn!");
            } else {
                //error message
                player.sendMessage(ChatColor.RED + "⚠ You do not have permission to use this command!");
            }
        } else {
            //error message
            sender.sendMessage(ChatColor.DARK_RED + "You can only execute this as a player!");
        }
    }
}
