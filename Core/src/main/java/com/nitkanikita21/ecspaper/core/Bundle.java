package com.nitkanikita21.ecspaper.core;

import java.util.List;
import java.util.Optional;

public interface Bundle<T, K, C extends Component<T, K, ?>> {
    interface BundleApi<T, K, C extends Component<T, K, ?>, B extends Bundle<T, K, C>> {
        B getBundle(T target);

        B createEmptyBundle();

        void applyTo(T target, B bundle);

    }

    void applyTo(T target);

    List<C> getComponents();

    C addComponent(int index, C component);

    TemporaryBundleData getTempData();

    boolean hasComponent(T target, K key);

    default boolean hasComponent(T target, C component) {
        return hasComponent(target, component.getKey());
    }

    default C addComponent(C component) {
        return addComponent(getComponents().size(), component);
    }

    default <CC extends C> Optional<CC> getComponent(String name) {
        return (Optional<CC>) getComponents()
                .stream()
                .filter(it -> it.getKey().equals(name))
                .findFirst();
    }

    default void addComponents(List<C> components) {
        int size = components.size();
        for (int i = 0; i < size; i++) {
            addComponent(size + i, components.get(i));
        }
    }

}
