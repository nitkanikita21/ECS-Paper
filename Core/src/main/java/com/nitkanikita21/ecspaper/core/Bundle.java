package com.nitkanikita21.ecspaper.core;

import java.util.List;
import java.util.Optional;

/**
 * Represents a set of components in the ECS architecture.
 * You can use this class for example to manage components,
 * to apply a bundle to a target.
 * @param <T> the target for which this bundle will be applied
 * @param <K> object identifier by which the component will be identified
 * @param <C> the base type of the component that will be stored in this bundle
 */
public interface Bundle<T, K, C extends Component<T, K, ?>> {
    /**
     * The base api that should be implemented by the system.
     * @param <T> the target in which this API will be processed
     * @param <K> the key of component in which this API will be processed
     * @param <C> the base component in which this API will be processed
     * @param <B> the bundle in which this API will be processed
     */
    interface BundleApi<T, K, C extends Component<T, K, ?>, B extends Bundle<T, K, C>> {
        /**
         * API Method for Getting a Bundle for a target
         * @param target the target for which you need to get the bundle
         * @return bundle
         */
        B getBundle(T target);

        /** Create empty bundle
         * @return empty bundle
         */
        B createEmptyBundle();

        /** Apply bundle to target
         * @param target target
         * @param bundle bundle for applying
         */
        void applyTo(T target, B bundle);

    }

    /** Apply bundle to target
     * @param target target
     */
    void applyTo(T target);

    /**
     * Get all components
     * @return list of all components
     */
    List<C> getComponents();

    /**
     * Adds a component to a bundle
     * @param index order index where the component will be added
     * @param component component for adding
     * @return added component object
     */
    C addComponent(int index, C component);

    /**
     * Getter for {@link TemporaryBundleData}
     * @return temporary storage object for one iteration of component processing
     */
    TemporaryBundleData getTempData();

    /**
     * Method for checking the existence of a component in a bundle
     * @param target target
     * @param key id
     * @return does the bundle have the specified component
     */
    boolean hasComponent(T target, K key);

    /**
     * Method for checking the existence of a component in a bundle
     * @param target item
     * @param component component
     * @return does the bundle have the specified component
     */
    default boolean hasComponent(T target, C component) {
        return hasComponent(target, component.getKey());
    }

    /**
     * Adds a component to the end of the list of bundle components
     * @param component component for adding
     * @return added component object
     */
    default C addComponent(C component) {
        return addComponent(getComponents().size(), component);
    }

    /**
     * Gets a component from the bundle by the specified key
     * @param key component key
     * @param <CC> the type of component to look for
     * @return component with specified id of specified type
     */
    default <CC extends C> Optional<CC> getComponent(K key) {
        return (Optional<CC>) getComponents()
                .stream()
                .filter(it -> it.getKey().equals(key))
                .findFirst();
    }

    /** Adds the specified list of components to the end of the component set
     * @param components list of components
     */
    default void addComponents(List<C> components) {
        int size = components.size();
        for (int i = 0; i < size; i++) {
            addComponent(size + i, components.get(i));
        }
    }

    /** Adds the specified array of components to the end of the component set
     * @param components array of components
     */
    default void addComponents(C ...components) {
        int size = components.length;
        for (int i = 0; i < size; i++) {
            addComponent(size + i, components[i]);
        }
    }

}
