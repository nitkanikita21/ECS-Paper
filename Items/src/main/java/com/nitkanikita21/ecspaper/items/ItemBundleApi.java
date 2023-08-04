package com.nitkanikita21.ecspaper.items;

import com.nitkanikita21.ecspaper.core.Bundle;
import com.nitkanikita21.ecspaper.core.util.registry.MapRegistry;
import com.nitkanikita21.ecspaper.core.util.registry.Registry;
import com.nitkanikita21.ecspaper.paper.EventRegister;
import de.tr7zw.nbtapi.NBTItem;
import lombok.Getter;
import net.kyori.adventure.key.Key;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class ItemBundleApi implements Bundle.BundleApi<ItemStack, BaseItemComponent, ItemBundle> {

    private static final Registry<Key, ItemBundle> bundlesRegistry =
            Registry.createMapRegistry("item_bundles", true);
    private static final Registry<Key, BaseItemComponent> componentsRegistry =
            Registry.createMapRegistry("item_components", true);

    public Registry<Key, ItemBundle> getBundlesRegistry() {
        return bundlesRegistry;
    }

    public Registry<Key, BaseItemComponent> getComponentsRegistry() {
        return componentsRegistry;
    }

    static final String NBT_COMPONENTS_TAG = "ecs#components";
    static final String NBT_COMPONENT_CODE_SPLITTER = "@";


    public ItemBundle registerStaticBundle(Key id, ItemBundle bundle) {
        return bundlesRegistry.register(id, bundle);
    }

    public BaseItemComponent registerStaticComponent(Key id, BaseItemComponent component) {
        EventRegister.register(component);
        return componentsRegistry.register(id, component);
    }

    @Override
    public ItemBundle getBundle(ItemStack target) {
        ItemBundle bundle = createEmptyBundle();
        NBTItem nbt = new NBTItem(target);

        nbt.getStringList(NBT_COMPONENTS_TAG)
                .toListCopy()
                .forEach(code -> {
                    String[] split = code.split(NBT_COMPONENT_CODE_SPLITTER);
                    int index = Integer.parseInt(split[0]);
                    Optional<BaseItemComponent> optionalComponent = componentsRegistry.get(Key.key(split[1]));
                    optionalComponent.ifPresent(component -> bundle.addComponent(index, component));

                });

        return bundle;
    }

    @Override
    public ItemBundle createEmptyBundle() {
        return new ItemBundle();
    }

    @Override
    public void applyTo(ItemStack target, ItemBundle bundle) {

    }


}
