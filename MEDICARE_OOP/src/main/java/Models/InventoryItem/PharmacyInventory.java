/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.InventoryItem;

/**
 *
 * @author REBOOT
 */
import java.util.ArrayList;
import java.util.List;

public class PharmacyInventory {
    private List<InventoryItem> inventoryItems;

    public PharmacyInventory() {
        inventoryItems = new ArrayList<>();
    }

    // Add an item to the inventory
    public void addItem(InventoryItem item) {
        inventoryItems.add(item);
    }

    // Update an item in the inventory
    public void updateItem(String inventoryID, String newName, String newDescription, String  newAvailability) {
        for (InventoryItem item : inventoryItems) {
            if (item.getInventoryID().equals(inventoryID)) {
                item.setInventoryName(newName);
                item.setDescription(newDescription);
                item.setAvailability(newAvailability);
                break;
            }
        }
    }

    // Remove an item from the inventory
    public void removeItem(String inventoryID) {
        inventoryItems.removeIf(item -> item.getInventoryID().equals(inventoryID));
    }

    // Get all items in the inventory
    public List<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }
}
