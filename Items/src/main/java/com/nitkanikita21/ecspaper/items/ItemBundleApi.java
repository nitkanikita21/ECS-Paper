package com.nitkanikita21.ecspaper.items;

import com.nitkanikita21.ecspaper.commons.EventRegister;
import com.nitkanikita21.ecspaper.core.Bundle;
import com.nitkanikita21.ecspaper.core.util.registry.Registry;
import de.tr7zw.nbtapi.NBTItem;
import net.kyori.adventure.key.Key;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

/**
 * API for ECS Items
 */
public class ItemBundleApi implements Bundle.BundleApi<ItemStack, Key, BaseItemComponent, ItemBundle> {

    private final EventRegister eventRegister;

    public ItemBundleApi(EventRegister eventRegister) {
        this.eventRegister = eventRegister;
    }

    private static final Registry<Key, ItemBundle> bundlesRegistry =
            Registry.createMapRegistry("item_bundles", true);
    private static final Registry<Key, BaseItemComponent> componentsRegistry =
            Registry.createMapRegistry("item_components", true);

    /**
     * Getter for bundles Registry
     * @return Registry object for bundles
     */
    public Registry<Key, ItemBundle> getBundlesRegistry() {
        return bundlesRegistry;
    }

    /**
     * Getter for components Registry
     * @return Registry object for components
     */
    public Registry<Key, BaseItemComponent> getComponentsRegistry() {
        return componentsRegistry;
    }

    static final String NBT_COMPONENTS_TAG = "ecs#components";
    static final String NBT_COMPONENT_CODE_SPLITTER = "@";


    /**
     * Method to registering a static item bundle
     * @param id key for bundle
     * @param bundle item bundle object
     * @return registered item bundle
     */
    public ItemBundle registerStaticBundle(Key id, ItemBundle bundle) {
        return bundlesRegistry.register(id, bundle);
    }

    /**
     * Method to registering a static item component
     * @param component component object to registering
     * @return registered component
     */
    public BaseItemComponent registerStaticComponent(BaseItemComponent component) {
        eventRegister.register(component);
        return componentsRegistry.register(component.getKey(), component);
    }

    /**
     * @param id bundle id
     * @return optional of a registered static bundle by id
     */
    public Optional<ItemBundle> getStaticBundle(Key id) {
        return bundlesRegistry.get(id);
    }

    /** Get a static registered component
     * @param id component id
     * @return optional of a registered static component by id
     */
    public Optional<BaseItemComponent> getStaticComponent(Key id) {
        return componentsRegistry.get(id);
    }

    /** Gets a temporary ItemBundle of components for this item
     * @param target item
     * @return temporary ItemBundle of components
     */
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

    /** Create empty ItemBundle
     * @return empty ItemBudnle
     */
    @Override
    public ItemBundle createEmptyBundle() {
        return new ItemBundle();
    }

    /** Apply bundle to item
     * @param target item
     * @param bundle bundle for applying
     */
    @Override
    public void applyTo(ItemStack target, ItemBundle bundle) {
        bundle.applyTo(target);
    }


}
