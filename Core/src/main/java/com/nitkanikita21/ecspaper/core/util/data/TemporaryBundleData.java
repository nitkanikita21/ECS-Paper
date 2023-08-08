package com.nitkanikita21.ecspaper.core.util.data;

import com.nitkanikita21.ecspaper.core.Bundle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Represents a temporary storage object for all bundle components.
 * Before each application of the bundle on the target,
 * one instance of this class is created
 * which is available from the {@link Bundle} method
 */
public class TemporaryBundleData {
    private final Map<TypedKey<?>, Object> storage = new HashMap<>();

    public <T> Optional<T> get(TypedKey<T> id) {
        return Optional.ofNullable((T) storage.get(id));
    }

    public boolean isExisting(TypedKey<?> id) {
        return storage.containsKey(id);
    }

    public <T> TemporaryBundleData set(TypedKey<T> id, T value) {
        storage.put(id, value);
        return this;
    }

    public <T> TemporaryBundleData init(TypedKey<T> id, T startValue) {
        if (!isExisting(id)) {
            storage.put(id, startValue);
        }
        return this;
    }
}
