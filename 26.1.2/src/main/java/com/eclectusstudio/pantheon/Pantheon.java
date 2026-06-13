package com.eclectusstudio.pantheon;

import com.eclectusstudio.pantheon.event.ServerLoadEventHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pantheon extends JavaPlugin {
    public static Pantheon pantheon;

    @Override
    public void onEnable() {
        pantheon = this;

        Bukkit.getPluginManager().registerEvents(new ServerLoadEventHandler(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
