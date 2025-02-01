/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.InventoryItem;

/**
 *
 * @author REBOOT
 */
public class InventoryItem {
    private String inventoryID;
    private String inventoryName;
    private String description;
    private boolean availability;

    public InventoryItem(String inventoryID, String inventoryName, String description, boolean availability) {
        this.inventoryID = inventoryID;
        this.inventoryName = inventoryName;
        this.description = description;
        this.availability = availability;
    }

    // Getters and Setters
    public String getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(String inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
