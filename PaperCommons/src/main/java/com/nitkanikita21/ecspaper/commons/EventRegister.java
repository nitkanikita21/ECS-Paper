package com.nitkanikita21.ecspaper.commons;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class EventRegister {
    private final JavaPlugin plugin;

    public EventRegister(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public void register(Listener listener) {
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
