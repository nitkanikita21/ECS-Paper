package com.nitkanikita21.ecspaper.core.util.registry;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class MapRegistry<I, T> extends Registry<I, T> {

    private final Map<I, T> storage = new HashMap<>();
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
    public T register(I id, @NotNull T object) {
        T value = Objects.requireNonNull(object);
        if (storage.containsKey(id) && overridable) {
            logger.error(String.format(
                    "[%s] Attempting to replace an existing value with ID %s",
                    getName(),
                    id.toString()
            ));
            return storage.get(id);
        }
        storage.put(id, value);
        return value;
    }

    @Override
    public Optional<T> unregister(I id) {
        if (!storage.containsKey(id)) {
            logger.error(String.format(
                    "Attempting to delete an non-existing value with ID %s",
                    id.toString()
            ));
            return Optional.empty();
        }
        return Optional.ofNullable(storage.put(id, null));
    }

    @Override
    public Optional<T> get(I id) {
        return Optional.ofNullable(storage.get(id));
    }
}
