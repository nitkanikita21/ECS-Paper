package com.nitkanikita21.ecspaper.testing;

import com.nitkanikita21.ecspaper.EcsPaperPlugin;
import com.nitkanikita21.ecspaper.items.BaseItemComponent;
import com.nitkanikita21.ecspaper.items.ItemBundle;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
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
        EcsPaperPlugin
                .getItemBundleApi()
                .getBundlesRegistry()
                .get(Key.key("test", "aboba"))
                .get()
                .applyTo(item);

        event.getPlayer().getInventory().setItemInMainHand(item);
    }

    @Override
    public void init(ItemStack target, ItemBundle bundle) {

    }

    @Override
    public void update(ItemStack target, ItemBundle bundle) {
        bundle
                .<DisplayComponent>getComponent(
                        Key.key("test", "display")
                )
                .get()
                .setDisplayName(bundle, Component.text("A"));

    }
}
