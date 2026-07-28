package com.eclectusstudio.pantheon;

import com.eclectusstudio.pantheon.commands.GetCustomItemCommand;
import com.eclectusstudio.pantheon.event.ItemListener;
import com.eclectusstudio.pantheon.event.PlayerJoinEventHandler;
import com.eclectusstudio.pantheon.event.ServerLoadEventHandler;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pantheon extends JavaPlugin {
    public static Pantheon pantheon;
    public static NamespacedKey customItemKey = new NamespacedKey("pantheon", "custom-item");

    @Override
    public void onEnable() {
        //Init
        pantheon = this;
        saveDefaultConfig();

        //Load Config
        Config.init();

        //Events
        Bukkit.getPluginManager().registerEvents(new ServerLoadEventHandler(), this);
        Bukkit.getPluginManager().registerEvents(new ItemListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEventHandler(), this);

        //Commands
        getLifecycleManager().registerEventHandler(
                LifecycleEvents.COMMANDS,
                event -> {
                    event.registrar().register(
                            "getitem",
                            new GetCustomItemCommand()
                    );
                }
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        ServerLoadEventHandler.stopHosting();
    }
}
