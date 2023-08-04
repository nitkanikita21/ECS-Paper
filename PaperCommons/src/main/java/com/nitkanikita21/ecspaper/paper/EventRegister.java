package com.nitkanikita21.ecspaper.paper;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class EventRegister {
    private static JavaPlugin plugin;

    public EventRegister(JavaPlugin plugin){
        EventRegister.plugin = plugin;
    }

    public static void register(Listener listener) {
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
