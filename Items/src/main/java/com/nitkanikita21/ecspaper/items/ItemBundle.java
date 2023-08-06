package com.nitkanikita21.ecspaper.items;

import com.nitkanikita21.ecspaper.core.Bundle;
import com.nitkanikita21.ecspaper.core.TemporaryBundleData;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTList;
import net.kyori.adventure.key.Key;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A class that is a collection of components. The bundle can be applied to some {@link ItemStack}
 */
public class ItemBundle implements Bundle<ItemStack, Key, BaseItemComponent> {

    ItemBundle() {}

    private final List<BaseItemComponent> components = new LinkedList<>();
    private TemporaryBundleData temporaryBundleData;

    private void writeComponents(ItemStack target) {
        NBTItem nbtItem = new NBTItem(target);
        NBTList<String> nbtComponentsList = nbtItem.getStringList(ItemBundleApi.NBT_COMPONENTS_TAG);
        nbtComponentsList.clear();
        for (int i = 0; i < components.size(); i++) {
            nbtComponentsList.add(i + ItemBundleApi.NBT_COMPONENT_CODE_SPLITTER + components.get(i).getKey());
        }
        nbtItem.applyNBT(target);
    }

    /**
     * Apply bundle to item
     * @param target item
     */
    @Override
    public void applyTo(ItemStack target) {
        temporaryBundleData = new TemporaryBundleData();
        components.forEach(component -> {
            component.init(target, this);
        });
        components.forEach(component -> {
            component.apply(target, this);
        });
        writeComponents(target);
    }

    /**
     * Get all components
     * @return list of all components
     */
    @Override
    public List<BaseItemComponent> getComponents() {
        return components;
    }

    /**
     * Adds a component to a bundle
     * @param index order index where the component will be added
     * @param component component for adding
     * @return added component object
     */
    @Override
    public BaseItemComponent addComponent(int index, BaseItemComponent component) {
        components.add(index, component);
        return component;
    }

    /**
     * Getter for {@link TemporaryBundleData}
     * @return temporary storage object for one iteration of component processing
     */
    @Override
    public TemporaryBundleData getTempData() {
        return temporaryBundleData;
    }

    /**
     * Method for checking the existence of a component in a bundle
     * @param target item
     * @param key id
     * @return does the bundle have the specified component
     */
    @Override
    public boolean hasComponent(ItemStack target, Key key) {
        return components.stream().anyMatch(it -> Objects.equals(it.getKey(), key));
    }
}
