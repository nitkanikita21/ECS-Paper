package com.example;

import com.nitkanikita21.ecspaper.items.BaseItemComponent;
import com.nitkanikita21.ecspaper.items.ItemBundle;
import net.kyori.adventure.key.Key;
import org.bukkit.inventory.ItemStack;

public class ExampleComponent extends BaseItemComponent {
    public static final Key KEY = Key.key("example", "example_componet");
    public ExampleComponent() {
        super(KEY);
    }

    @Override
    public void apply(ItemStack target, ItemBundle bundle) {
        bundle
                .<UtilComponent>getComponent(UtilComponent.KEY)
                .ifPresent(component -> {
                    component.sayLog();
                });

        bundle.getTempData()
                .set(UtilComponent.TEMP_ANY_DATA, 15);
    }
}
