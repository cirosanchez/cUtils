package me.cirosanchez.cutils.inventory;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public abstract class InventoryButton {
    private final ItemStack item;

    protected InventoryButton(ItemStack item) {
        this.item = item;
    }
    public ItemStack getItem(){
        return item;
    }
    public abstract void onClick(InventoryClickEvent event);
}
