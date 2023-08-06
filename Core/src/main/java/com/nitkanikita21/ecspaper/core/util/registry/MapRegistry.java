package com.nitkanikita21.ecspaper.core.util.registry;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class MapRegistry<K, T> extends Registry<K, T> {

    private final Map<K, T> storage = new HashMap<>();
    private final boolean overridable;

    MapRegistry(@NotNull String name, boolean overridable) {
        super(name);
        this.overridable = overridable;
    }

    MapRegistry(String name) {
        super(name);
        this.overridable = true;
    }

    @Override
    public T register(K key, @NotNull T object) {
        T value = Objects.requireNonNull(object);
        if (storage.containsKey(key) && overridable) {
            logger.error(String.format(
                    "[%s] Attempting to replace an existing value with ID %s",
                    getName(),
                    key.toString()
            ));
            return storage.get(key);
        }
        storage.put(key, value);
        return value;
    }

    @Override
    public Optional<T> unregister(K key) {
        if (!storage.containsKey(key)) {
            logger.error(String.format(
                    "Attempting to delete an non-existing value with ID %s",
                    key.toString()
            ));
            return Optional.empty();
        }
        return Optional.ofNullable(storage.put(key, null));
    }

    @Override
    public Optional<T> get(K key) {
        return Optional.ofNullable(storage.get(key));
    }
}
