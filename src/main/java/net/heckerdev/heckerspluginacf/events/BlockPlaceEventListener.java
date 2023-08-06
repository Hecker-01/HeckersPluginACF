package net.heckerdev.heckerspluginacf.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Arrays;
import java.util.Locale;

public class BlockPlaceEventListener implements Listener {

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        @NotNull Player player = event.getPlayer();
        @NotNull Block block = event.getBlock();
        Material mat = block.getType();
        player.sendMessage(ChatColor.YELLOW + player.getName() + " Placed " + getNiceMaterialName(mat));
    }

    public static String getNiceMaterialName(final Material mat) {
        final StringBuilder builder = new StringBuilder();
        final Iterator<String> iterator = Arrays.stream(mat.name().split("_")).iterator();
        while (iterator.hasNext()) {
            builder.append(upperCaseFirstLetterOnly(iterator.next()));
            if (iterator.hasNext()) builder.append(" ");
        }
        return builder.toString();
    }


    public static String upperCaseFirstLetterOnly(final String word) {
        return upperCaseFirstLetter(word.toLowerCase(Locale.ROOT));
    }


    public static String upperCaseFirstLetter(final String word) {
        if (word.isEmpty()) return word;
        if (word.length() == 1) return word.toUpperCase(Locale.ROOT);
        return word.substring(0, 1).toUpperCase(Locale.ROOT) + word.substring(1);
    }
}