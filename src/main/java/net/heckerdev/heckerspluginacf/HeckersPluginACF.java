package net.heckerdev.heckerspluginacf;

import net.heckerdev.heckerspluginacf.commands.*;
import net.heckerdev.heckerspluginacf.events.BlockBreakEventListener;
import net.heckerdev.heckerspluginacf.events.BlockPlaceEventListener;
import net.heckerdev.heckerspluginacf.events.PlayerJoinEventListener;
import net.milkbowl.vault.permission.Permission;

import co.aikar.commands.PaperCommandManager;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class HeckersPluginACF extends JavaPlugin {

    private static Permission perms = null;
    private static FileConfiguration config = null;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        // registering listeners.
        setupListeners();
        setupPermissions();
        setupCommands();
        getLogger().info("Successfully loaded HeckersPlugin!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Goodbye!");
    }

    private void setupCommands() {
        // Registering commands.
        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new GroupsCommand());
        manager.registerCommand(new KitCommand());
        manager.registerCommand(new BookCommand());
        manager.registerCommand(new SpawnCommand());
        manager.registerCommand(new FlyCommand());
        manager.registerCommand(new SmiteCommand());
    }

    private boolean setupPermissions() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            getLogger().warning(" - Disabled because Vault is not installed!");
            getServer().getPluginManager().disablePlugin(this);
            return false;
        }
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        if (rsp == null) {
            return false;
        }
        perms = rsp.getProvider();
        return perms != null;
    }

    private void setupListeners() {
        //BlockPlaceEvent
        boolean placeMessage = getConfig().getBoolean("Listeners.PlaceMessage");
        if (placeMessage) {
            Bukkit.getPluginManager().registerEvents(new BlockPlaceEventListener(), this);
        }
        //BlockBreakEvent
        boolean breakMessage = getConfig().getBoolean("Listeners.BreakMessage");
        if (breakMessage) {
            Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(), this);
        }
        //PlayerJoinEvent
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEventListener(), this);
    }

    public static Permission getPermissions() {
        return perms;
    }
}
