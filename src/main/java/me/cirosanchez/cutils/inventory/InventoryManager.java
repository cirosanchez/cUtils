package me.cirosanchez.cutils.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import java.util.HashMap;

public class InventoryManager {
    private final HashMap<Inventory, InventoryHandler> inventories = new HashMap<>();

    public void registerHandledInventory(Inventory inventory, InventoryHandler inventoryHandler){
        this.inventories.put(inventory, inventoryHandler);
    }
    public void unregisterInventory(Inventory inventory){
        this.inventories.remove(inventory);
    }
    public void handleOpen(InventoryOpenEvent event){
        InventoryHandler handler = this.inventories.get(event.getInventory());
        if (handler != null){
            handler.onOpen(event);
        }
    }
    public void handleClose(InventoryCloseEvent event){
        Inventory inventory = event.getInventory();
        InventoryHandler handler = this.inventories.get(inventory);
        if (handler != null){
            handler.onClose(event);
            this.unregisterInventory(inventory);
        }
    }
    public void handleClick(InventoryClickEvent event){
        InventoryHandler handler = this.inventories.get(event.getInventory());
        if (handler != null){
            handler.onClick(event);
        }
    }
    public void openGUI(InventoryGUI gui, Player player){
        this.registerHandledInventory(gui.getInventory(), gui);
        player.openInventory(gui.getInventory());
    }
}
