package me.cirosanchez.cutils.inventory;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {
    private final InventoryManager manager;

    public InventoryListener(InventoryManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        this.manager.handleClick(event);
    }
    @EventHandler
    public void onOpen(InventoryOpenEvent event){
        this.manager.handleOpen(event);
    }
    @EventHandler
    public void onClose(InventoryCloseEvent event){
        this.manager.handleClose(event);
    }

}
