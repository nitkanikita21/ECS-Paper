package com.nitkanikita21.ecspaper.testing;

import com.nitkanikita21.ecspaper.items.BaseItemComponent;
import com.nitkanikita21.ecspaper.items.ItemBundle;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;

public class DisplayComponent extends BaseItemComponent {
    private final String TEST_DISPLAY = "displayTest";

    public DisplayComponent(Key key) {
        super(key);
    }

    @Override
    public void init(ItemStack target, ItemBundle bundle) {

    }

    @Override
    public void update(ItemStack target, ItemBundle bundle) {
        target.editMeta(meta -> {
            meta.displayName(bundle.getTempData().<Component>get(TEST_DISPLAY).get());
        });
    }

    public void setDisplayName(ItemBundle bundle, Component component) {
        bundle.getTempData()
                .set(TEST_DISPLAY, component);
    }
}
