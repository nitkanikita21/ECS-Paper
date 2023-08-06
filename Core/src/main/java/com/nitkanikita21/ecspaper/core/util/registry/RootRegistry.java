package com.nitkanikita21.ecspaper.core.util.registry;

public class RootRegistry extends MapRegistry<String, Registry<?, ?>> {

    public RootRegistry() {
        super("main");
    }

}
