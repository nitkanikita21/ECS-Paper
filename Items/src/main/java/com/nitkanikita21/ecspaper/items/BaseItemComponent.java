package com.nitkanikita21.ecspaper.items;

import com.nitkanikita21.ecspaper.core.Component;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public abstract class BaseItemComponent implements Component<ItemStack, ItemBundle>, Listener {
    private final String name;

    public BaseItemComponent(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
