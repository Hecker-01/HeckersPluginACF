package net.heckerdev.heckerspluginacf.events;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getWorld;

public class PlayerJoinEventListener implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        @NotNull Player player = event.getPlayer();
        World world = getWorld("world");
        assert world != null;
        // change the pitch and yaw to 0 and -180 to make the player face the opposite direction.
        Location spawnLocation = world.getSpawnLocation().add(0.5, 0, 0.5);
        spawnLocation.setPitch(0);
        spawnLocation.setYaw(-180);
        player.teleport(spawnLocation);
        player.sendMessage(ChatColor.YELLOW + "Welcome to the server, " + player.getName() + "!");
    }
}
