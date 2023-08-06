package com.nitkanikita21.ecspaper.items;

import com.nitkanikita21.ecspaper.core.Component;
import net.kyori.adventure.key.Key;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

/**
 * Represents the base class of the component.
 * This is a unique item behavior that can be combined with other behaviors.
 * You can extend this class to implement custom logic for your {@link ItemStack}.
 * This class is a Bukkit {@link Listener} if any object of this class has been registered in {@link ItemBundleApi}
 */
public abstract class BaseItemComponent implements Component<ItemStack, Key, ItemBundle>, Listener {
    private final Key key;

    public BaseItemComponent(Key key) {
        this.key = key;
    }


    /** Getter for component ID
     * @return component id
     */
    @Override
    public Key getKey() {
        return key;
    }
}
