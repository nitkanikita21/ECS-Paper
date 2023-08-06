package com.nitkanikita21.ecspaper.core.util.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents an object store by key.
 * @param <K> key
 * @param <T> object
 */
public abstract class Registry<K, T> {

    private static CoreRegistry coreRegistry;

    public static <K, T> Registry<K, T> createMapRegistry(String name, boolean overridable) {
        return new MapRegistry<>(name, overridable);
    }

    private final String name;

    protected final Logger logger = LoggerFactory.getLogger("ECS-Registry");

    protected Registry(String name) {
        this.name = Objects.requireNonNull(name);
    }

    /**
     * @return registry name
     */
    public String getName() {
        return name;
    }

    /** Registers an object in the registry
     * @param key key
     * @param object object
     * @return registered object
     */
    public abstract T register(K key, T object);

    /**
     * Deletes an object by the specified key from the registry
     * @param id id
     * @return unregistered object
     */
    public abstract Optional<T> unregister(K id);

    /** Gets an object by the specified key
     * @param key key
     * @return object registered with the specified key
     */
    public abstract Optional<T> get(K key);
}
