package com.nitkanikita21.ecspaper.core.util.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Represents an object store by key.
 *
 * @param <K> key
 * @param <T> object
 */
public abstract class Registry<K, T> {

    private static RootRegistry rootRegistry;

    /**
     * 99.99% of the time you don't need it. Gets the root registry of all registries.
     *
     * @return root registry
     */
    public static RootRegistry getRootRegistry() {
        return rootRegistry;
    }

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

    /**
     * Registers an object in the registry
     *
     * @param key    key
     * @param object object
     * @return registered object
     */
    public abstract T register(K key, T object);

    /**
     * Deletes an object by the specified key from the registry
     *
     * @param id id
     * @return unregistered object
     */
    public abstract Optional<T> unregister(K id);

    /**
     * Gets an object by the specified key
     *
     * @param key key
     * @return object registered with the specified key
     */
    public abstract Optional<T> get(K key);

    /**
     * @return all keys
     */
    public abstract List<K> getKeys();

    /**
     * @return all values
     */
    public abstract List<T> getValues();

    /**
     * @return all key & value pairs
     */
    public abstract List<Map.Entry<K, T>> getEntrySet();

}
