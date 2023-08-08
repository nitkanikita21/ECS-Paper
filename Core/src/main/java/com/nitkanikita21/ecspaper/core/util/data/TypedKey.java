package com.nitkanikita21.ecspaper.core.util.data;

/**
 * Simple typed key
 * @param <T> Type for storing
 */
public class TypedKey<T> {
    private Class<T> type;
    private String id;

    public TypedKey(Class<T> type, String id) {
        this.type = type;
        this.id = id;
    }
}
