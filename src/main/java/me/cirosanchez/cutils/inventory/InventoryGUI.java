package me.cirosanchez.cutils.inventory;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class InventoryGUI implements InventoryHandler {
    public Inventory getInventory() {
        return inventory;
    }

    private final Inventory inventory;
    private final Map<Integer, InventoryButton> buttons = new HashMap<>();

    public InventoryGUI(Supplier<Inventory> inventoryCreator){
        inventory = inventoryCreator.get();
    }
    public void addButton(Integer slot, InventoryButton button){
        this.buttons.put(slot, button);
    }
    public void decorate(){
        this.buttons.forEach((slot, button)-> this.inventory.setItem(slot, button.getItem()));
    }
    @Override
    public void onClick(InventoryClickEvent event){
        int slot = event.getRawSlot();
        InventoryButton button = this.buttons.get(slot);
        if (button != null){
            button.onClick(event);
        }
    }
    @Override
    public void onOpen(InventoryOpenEvent event){
        this.decorate();
    }

    @Override
    public void onClose(InventoryCloseEvent event){}


}
