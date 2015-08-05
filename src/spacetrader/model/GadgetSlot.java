/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import spacetrader.enums.GadgetType;

/**
 *
 * @author Kevin
 */
public class GadgetSlot implements Serializable {
    /**
     * serialVersionUID for serializable class.
     */
    private static final long serialVersionUID = 1;
    /**
     * Maximum number of gadgets this slot can hold.
     */
    private int maxCapacity;
    /**
     * Number of current gadgets in this slot.
     */
    private int currentAmount;
    /**
     * All the gadgets this slot is holding.
     */
    private List<GadgetType> gadgets;
    /**
     * Constructor for setting up initial Gadget Slot.
     * @param amount number of maximum capacity
     */
    public GadgetSlot(final int amount) {
        maxCapacity = amount;
        currentAmount = 0;
        gadgets = new ArrayList();
    }
    /**
     * Return the list of gadgets this slot is holding.
     * @return List of gadgets in this slot
     */
    public final List<GadgetType> getGadgets() {
        return gadgets;
    }
    /**
     * Add a new gadget into this slot.
     * @param pGadget new gadget to add to the slot
     * @return True if adding new gadget was successful. False if not.
     */
    public final boolean addGadget(final GadgetType pGadget) {
        boolean result;
        if (currentAmount < maxCapacity) {
            gadgets.add(pGadget);
            currentAmount++;
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    /**
     * Remove a gadget from the slot.
     * @param pGadget the type of gadget to remove
     * @return True if removal was successful, false if not
     */
    public final boolean removeGadget(final GadgetType pGadget) {
        boolean result;
        if (currentAmount > 0) {
            gadgets.remove(pGadget);
            currentAmount--;
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    /**
     * Setter for maxCapacity.
     * @param capacity new capacity amount
     */
    public final void setMaxCapacity(final int capacity) {
        maxCapacity = capacity;
    }
    /**
     * Getter for maxCapacity.
     * @return maxCapacity
     */
    public final int getMaxCapacity() {
        return maxCapacity;
    }
    /**
     * Getter for the current amount.
     * @return current amount
     */
    public final int getCurrentAmount() {
        return currentAmount;
    }
    /**
     * Count the number of a certain type of gadget in the slot.
     * @param pGadget type of gadget to check the count
     * @return number of the certain type of gadget in the slot
     */
    public final int countNumberOfGadget(final GadgetType pGadget) {
        int count = 0;
        for (GadgetType gadget : gadgets) {
            if (gadget.getGadgetName().equals(pGadget.getGadgetName())) {
                count++;
            }
        }
        return count;
    }
    /**
     * Setter for the current amount.
     * @param pCurrentAmount new current amount
     */
    public final void setCurrentAmount(final int pCurrentAmount) {
        currentAmount = pCurrentAmount;
    }
    /**
     * Setter for the gadget list.
     * @param pGadgets new list of gadgets
     */
    public final void setGadgets(final List<GadgetType> pGadgets) {
        gadgets = pGadgets;
    }
    public final boolean hasCargoBay() {
        return gadgets.contains(GadgetType.CARGOBAY);
    }
    public final boolean hasGPS() {
        return gadgets.contains(GadgetType.GPS);
    }
    public final boolean hasAutoRepair() {
        return gadgets.contains(GadgetType.AUTOREPAIR);
    }
    public final boolean hasTargetting() {
        return gadgets.contains(GadgetType.TARGETTING);
    }
    public final boolean hasClock() {
        return gadgets.contains(GadgetType.CLOAK);
    }
}
