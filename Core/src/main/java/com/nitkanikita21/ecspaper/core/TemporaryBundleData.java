package com.nitkanikita21.ecspaper.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Represents a temporary storage object for all bundle components.
 * Before each application of the bundle on the target,
 * one instance of this class is created
 * which is available from the {@link Bundle} method
 * TODO: rework the class for storing objects by typed keys with the name
 */
public class TemporaryBundleData {
    private final Map<String, Object> storage = new HashMap<>();

    public <T> Optional<T> get(String id) {
        return Optional.ofNullable((T) storage.get(id));
    }

    public boolean isExisting(String id) {
        return storage.containsKey(id);
    }

    public <T> TemporaryBundleData set(String id, T value) {
        storage.put(id, value);
        return this;
    }

    public <T> TemporaryBundleData init(String id, T startValue) {
        if (!isExisting(id)) {
            storage.put(id, startValue);
        }
        return this;
    }
}
