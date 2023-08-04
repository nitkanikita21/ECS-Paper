package com.nitkanikita21.ecspaper.items;

import com.nitkanikita21.ecspaper.core.Component;
import net.kyori.adventure.key.Key;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public abstract class BaseItemComponent implements Component<ItemStack, Key, ItemBundle>, Listener {
    private final Key key;

    public BaseItemComponent(Key key) {
        this.key = key;
    }

    @Override
    public Key getKey() {
        return key;
    }
}
