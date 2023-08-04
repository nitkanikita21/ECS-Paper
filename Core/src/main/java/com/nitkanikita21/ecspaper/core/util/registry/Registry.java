package com.nitkanikita21.ecspaper.core.util.registry;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;

public abstract class Registry<I, T> {

    private static CoreRegistry coreRegistry;

    public static <I, T> Registry<I, T> createMapRegistry(String name, boolean overridable) {
        return new MapRegistry<>(name, overridable);
    }

    @Getter
    private final String name;

    protected final Logger logger = LoggerFactory.getLogger("ECS-Registry");

    protected Registry(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public abstract T register(I id, T object);

    public abstract Optional<T> unregister(I id);

    public abstract Optional<T> get(I id);
}
