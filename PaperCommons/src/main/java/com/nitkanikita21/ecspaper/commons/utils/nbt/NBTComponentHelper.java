package com.nitkanikita21.ecspaper.commons.utils.nbt;

import de.tr7zw.nbtapi.NBTCompound;

/**
 * A simple helper for working with component NBT data
 * @param <T> type for compoud. Example: {@link de.tr7zw.nbtapi.NBTItem}
 */
public class NBTComponentHelper<T extends NBTCompound> {
    public static final String NBT_PROPS_TAG = "ComponentProps";
    public static final String NBT_DATA_TAG = "ComponentData";
    private final String nbtComponentKey;
    private final T compound;

    public NBTComponentHelper(T compound, String nbtComponentKey) {
        this.compound = compound;
        this.nbtComponentKey = nbtComponentKey;
    }

    /**
     * Get props compound
     * @return props compound
     */
    public NBTCompound getProps() {
        return compound
                .getCompound(NBT_PROPS_TAG)
                .getCompound(nbtComponentKey);
    }
    /**
     * Get data compound
     * @return data compound
     */
    public NBTCompound getData() {
        return compound
                .getCompound(NBT_DATA_TAG)
                .getCompound(nbtComponentKey);
    }

    /**
     * Get the object that was passed to the helper
     * @return the object that was passed to the helper
     */
    public T get() {
        return compound;
    }
}
