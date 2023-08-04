package net.heckerdev.heckerspluginacf;

import co.aikar.commands.PaperCommandManager;
import net.heckerdev.heckerspluginacf.commands.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class HeckersPluginACF extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        setCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void setCommands() {
        // Registering commands.
        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new TestCommand());
    }
}
