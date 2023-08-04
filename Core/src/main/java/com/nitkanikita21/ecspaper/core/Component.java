package com.nitkanikita21.ecspaper.core;

public interface Component<T, B extends Bundle<T, ?>> {
    void init(T target, B bundle);

    String getName();

    void update(T target, B bundle);
}
