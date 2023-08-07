package com.example;

import com.nitkanikita21.ecspaper.items.BaseItemComponent;
import com.nitkanikita21.ecspaper.items.ItemBundle;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

public class UtilComponent extends BaseItemComponent {
    public static final Key KEY = Key.key("example", "util_componet");
    public static final String TEMP_ANY_DATA = "any_data";
    public UtilComponent() {
        super(KEY);
    }

    @Override
    public void onRegistered() {
        Bukkit.getLogger().info("Util component has been successfully registered!");
    }

    @Override
    public void init(ItemStack target, ItemBundle bundle) {
        bundle.getTempData()
                .init(TEMP_ANY_DATA, 5);
    }

    public void sayLog() {
        Bukkit.getLogger().info("Hello world!");
    }

    @Override
    public void apply(ItemStack target, ItemBundle bundle) {
         bundle.getTempData()
                 .<Integer>get("any_data")
                 .ifPresent(anyData -> {
                     target.editMeta(meta -> {
                         meta.displayName(Component.text(anyData));
                     });
                 });
    }
}
