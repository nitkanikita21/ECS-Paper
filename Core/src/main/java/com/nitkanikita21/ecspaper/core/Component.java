package com.nitkanikita21.ecspaper.core;

public interface Component<T, K, B extends Bundle<T, K, ?>> {
    void init(T target, B bundle);

    K getKey();

    void update(T target, B bundle);
}
