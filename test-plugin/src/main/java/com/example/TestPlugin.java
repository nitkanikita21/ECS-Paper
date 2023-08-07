package com.example;

import com.nitkanikita21.ecspaper.ECS;
import com.nitkanikita21.ecspaper.items.ItemBundle;
import com.nitkanikita21.ecspaper.items.ItemBundleApi;
import net.kyori.adventure.key.Key;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        ItemBundleApi bundleApi = ECS.getAPI()
                .getItemBundleApi();

        //registering components
        bundleApi.registerStaticComponent(new ExampleComponent());
        bundleApi.registerStaticComponent(new UtilComponent());

        //!!! when adding a component to a bundle, consider the order in which you add the components
        ItemBundle exampleBundle = bundleApi.createEmptyBundle();
        exampleBundle.addComponent(new UtilComponent());
        exampleBundle.addComponent(new ExampleComponent());

        bundleApi.registerStaticBundle(
                Key.key("example", "example_bundle"),
                exampleBundle
        );
    }
}
