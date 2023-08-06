package com.nitkanikita21.ecspaper.core;

/**
 * Represents an abstract component in the ECS architecture
 * @param <T> the target for which this component will be applied
 * @param <K> object identifier by which the component will be identified
 * @param <B> bundle in which this component will be stored
 */
public interface Component<T, K, B extends Bundle<T, K, ?>> {
    K getKey();

    /**
     * The method that is called before all components are applied. You can use it just like the update method
     * @param target the target on which this component will be initialized
     * @param bundle the bundle in which this component is located
     */
    void init(T target, B bundle);

    /**
     * The method that applies the component to the target. You can use it like the init method
     * @param target the target on which this component will be applied
     * @param bundle the bundle in which this component is located
     */
    void apply(T target, B bundle);
}
