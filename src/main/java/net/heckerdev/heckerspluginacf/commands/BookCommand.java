package net.heckerdev.heckerspluginacf.commands;

import net.heckerdev.heckerspluginacf.HeckersPluginACF;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

@CommandAlias("book")
@Description("Gives you a book.")
public class BookCommand extends BaseCommand {

    @Syntax("")
    @Default
    public void onDefault(CommandSender sender) {
        // Check if the sender is a player
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Check if the player has permission
            if (player.hasPermission("heckerspluginacf.command.book")) {
                // Create a new ItemStack
                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bookMeta = (BookMeta) book.getItemMeta();
                //Edit the book's meta
                BaseComponent[] page0 = new ComponentBuilder("Get 1 Diamond and 20 Bricks!").color(ChatColor.DARK_AQUA).bold(false).underlined(true)
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kit kit"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Execute /kit kit.").create()))
                        .append(", ").color(ChatColor.RESET)
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ""))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
                        .append("Get 1 Oak Plank.").color(ChatColor.DARK_AQUA).bold(false).underlined(true)
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kit wood"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Execute /kit wood.").create()))
                        .append(" OR ").color(ChatColor.RESET).bold(true).underlined(false)
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ""))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
                        .append("Get this book (again).").color(ChatColor.DARK_AQUA).bold(false).underlined(true)
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/book"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Execute /book.").create()))
                        .create();

                bookMeta.spigot().addPage(page0);
                bookMeta.setTitle("A very cool book!");
                bookMeta.setAuthor("Hecker_01");

                book.setItemMeta(bookMeta);
                // Give the player the book
                player.getInventory().addItem(book);
                player.sendMessage(org.bukkit.ChatColor.GREEN + org.bukkit.ChatColor.BOLD.toString() + "✔" + org.bukkit.ChatColor.RESET + org.bukkit.ChatColor.GREEN + " Successfully received book!");
            } else player.sendMessage(org.bukkit.ChatColor.RED + "⚠ You do not have permission to use this command!");
        } else {
            sender.sendMessage(org.bukkit.ChatColor.DARK_RED + "You can only execute this as a player!");
        }
    }
}
