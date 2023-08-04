package com.nitkanikita21.ecspaper.testing;

import com.nitkanikita21.ecspaper.EcsPaperPlugin;
import com.nitkanikita21.ecspaper.items.BaseItemComponent;
import com.nitkanikita21.ecspaper.items.ItemBundle;
import com.nitkanikita21.ecspaper.items.ItemBundleApi;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class SayComponent extends BaseItemComponent {
    public SayComponent(Key key) {
        super(key);
    }

    @EventHandler
    private void onClick(PlayerInteractEvent event) {
        ItemStack target = event.getPlayer()
                .getInventory()
                .getItemInMainHand();
        ItemBundle bundle = EcsPaperPlugin.getItemBundleApi()
                .getBundle(target);

        bundle.applyTo(target);
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemBundleApi bundleApi = EcsPaperPlugin.getItemBundleApi();
        bundleApi.getComponentsRegistry()
                .get(Key.key("test", "say_my_name"))
                .ifPresent(component -> {
                    ItemBundle emptyBundle = bundleApi.createEmptyBundle();
                    emptyBundle.addComponent(component);
                    emptyBundle.applyTo(item);
                });

        event.getPlayer().getInventory().setItemInMainHand(item);
    }

    @Override
    public void init(ItemStack target, ItemBundle bundle) {

    }

    @Override
    public void update(ItemStack target, ItemBundle bundle) {
        target.editMeta(meta -> {
            meta.displayName(MiniMessage.miniMessage().deserialize(
                    "<gold>POSHEL NAHUI"
            ));
        });

    }
}
