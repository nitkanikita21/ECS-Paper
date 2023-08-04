package com.nitkanikita21.ecspaper;

import com.nitkanikita21.ecspaper.items.ItemBundleApi;
import com.nitkanikita21.ecspaper.paper.EventRegister;
import com.nitkanikita21.ecspaper.testing.SayComponent;
import net.kyori.adventure.key.Key;
import org.bukkit.plugin.java.JavaPlugin;

public class EcsPaperPlugin extends JavaPlugin {
    public static ItemBundleApi getItemBundleApi() {
        return itemBundleApi;
    }

    private static ItemBundleApi itemBundleApi;

    @Override
    public void onEnable() {
        new EventRegister(this);
        itemBundleApi = new ItemBundleApi();

        itemBundleApi.registerStaticComponent(
                Key.key("test", "say_my_name"), new SayComponent("say_my_name")
        );
    }


}
