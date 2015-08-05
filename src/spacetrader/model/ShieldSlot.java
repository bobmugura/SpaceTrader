/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import spacetrader.enums.ShieldType;

/**
 *
 * @author Kevin
 */
public class ShieldSlot implements Serializable {
    /**
     * serialVersionUID for serializable class.
     */
    private static final long serialVersionUID = 1;
    /**
     * Maximum capacity of this slot.
     */
    private int maxCapacity;
    /**
     * Current number of shields in this slot.
     */
    private int currentAmount;
    /**
     * All the shields this slot is holding.
     */
    private List<ShieldType> shields;
    /**
     * Constructor for setting initial Shield Slot.
     * @param pMaxCapacity number of max capacity
     */
    public ShieldSlot(final int pMaxCapacity) {
        maxCapacity = pMaxCapacity;
        currentAmount = 0;
        shields = new ArrayList();
    }
    /**
     * Add a new shield into this slot.
     * @param shield new shield to ass to the slot
     * @return True if adding was successful, false if not
     */
    public final boolean addShield(final ShieldType shield) {
        boolean result;
        if (currentAmount < maxCapacity) {
            shields.add(shield);
            currentAmount++;
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    /**
     * Remove a shield from the slot.
     * @param shield the type of shield to remove
     * @return True if removal was successful, false if not
     */
    public final boolean removeShield(final ShieldType shield) {
        boolean result;
        if (currentAmount > 0) {
            shields.remove(shield);
            currentAmount--;
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    /**
     * Getter for the shields list.
     * @return shields
     */
    public final List<ShieldType> getShields() {
        return shields;
    }
    /**
     * Getter for the max capacity.
     * @return number of max capacity
     */
    public final int getMaxCapacity() {
        return maxCapacity;
    }
    /**
     * Getter for the current weapon count.
     * @return current amount
     */
    public final int getCurrentAmount() {
        return currentAmount;
    }
    /**
     * Count number of a certain type of shield in the slot.
     * @param pShield certain type of shield to count
     * @return number of the certain type of shield
     */
    public final int countNumberOfShield(final ShieldType pShield) {
        int count = 0;
        for (ShieldType shield : shields) {
            if (shield.getName().equals(pShield.getName())) {
                count += 1;
            }
        }
        return count;
    }
    /**
     * Setter for the max capacity.
     * @param pMaxCapacity new max capacity
     */
    public final void setMaxCapacity(final int pMaxCapacity) {
        maxCapacity = pMaxCapacity;
    }
    /**
     * Setter for the current amount.
     * @param pCurrentAmount new current amount
     */
    public final void setCurrentAmount(final int pCurrentAmount) {
        currentAmount = pCurrentAmount;
    }
    /**
     * Setter for the shields list.
     * @param pShields new Shields list
     */
    public final void setShields(final List<ShieldType> pShields) {
        shields = pShields;
    }
    /**
     * Get the max amount of shield capacity.
     * @return Shield capacity
     */
    public final int getShield() {
        int result = 0;
        for (ShieldType shield : shields) {
            result += shield.getShield();
        }
        return result;
    }
}
