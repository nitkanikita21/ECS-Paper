package com.nitkanikita21.ecspaper;

import com.nitkanikita21.ecspaper.commons.EventRegister;
import com.nitkanikita21.ecspaper.items.ItemBundle;
import com.nitkanikita21.ecspaper.items.ItemBundleApi;
import com.nitkanikita21.ecspaper.testing.DisplayComponent;
import com.nitkanikita21.ecspaper.testing.SayComponent;
import net.kyori.adventure.key.Key;
import org.bukkit.plugin.java.JavaPlugin;

public class EcsPaperPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        ECS ecs = new ECS(new EventRegister(this));

        ecs.getItemBundleApi().registerStaticComponent(
                new SayComponent(Key.key("test", "say_my_name"))
        );
        ecs.getItemBundleApi().registerStaticComponent(
                new DisplayComponent(Key.key("test", "display"))
        );

        ItemBundle testBundle = ecs.getItemBundleApi().createEmptyBundle();
        testBundle.addComponent(new SayComponent(Key.key("test", "say_my_name")));
        testBundle.addComponent(new DisplayComponent(Key.key("test", "display")));

        ecs.getItemBundleApi().registerStaticBundle(
                Key.key("test", "aboba"),
                testBundle
        );
    }


}
