package com.nitkanikita21.ecspaper.items;

import com.nitkanikita21.ecspaper.core.Bundle;
import com.nitkanikita21.ecspaper.core.TemporaryBundleData;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTList;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ItemBundle implements Bundle<ItemStack, BaseItemComponent> {
    private final List<BaseItemComponent> components = new LinkedList<>();
    private TemporaryBundleData temporaryBundleData;

    private void writeComponents(ItemStack target) {
        NBTItem nbtItem = new NBTItem(target);
        NBTList<String> nbtComponentsList = nbtItem.getStringList(ItemBundleApi.NBT_COMPONENTS_TAG);
        nbtComponentsList.clear();
        for (int i = 0; i < components.size(); i++) {
            nbtComponentsList.add(i + ItemBundleApi.NBT_COMPONENT_CODE_SPLITTER + components.get(i).getName());
        }
        nbtItem.applyNBT(target);
    }

    @Override
    public void applyTo(ItemStack target) {
        temporaryBundleData = new TemporaryBundleData();
        components.forEach(component -> {
            component.update(target, this);
        });
        writeComponents(target);
    }

    @Override
    public List<BaseItemComponent> getComponents() {
        return components;
    }

    @Override
    public BaseItemComponent addComponent(int index, BaseItemComponent component) {
        components.add(index, component);
        return component;
    }

    @Override
    public TemporaryBundleData getTempData() {
        return temporaryBundleData;
    }

    @Override
    public boolean hasComponent(ItemStack target, String id) {
        return components.stream().anyMatch(it -> Objects.equals(it.getName(), id));
    }
}
