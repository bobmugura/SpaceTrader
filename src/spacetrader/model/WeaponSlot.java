/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import java.util.ArrayList;
import java.util.List;
import spacetrader.enums.WeaponType;

/**
 *
 * @author Kevin
 */
public class WeaponSlot {
    /**
     * Weapon current slots.
     */
    private int currentAmount;
    /**
     * Weapon slot capacity.
     */
    private final int maxCapacity;
    /**
     * weapon slot of arraylist.
     */
    private final List <WeaponType> weapons;
    /**
     * WeaponSlot constructor.
     * @param maxHoldingAmount maximum capacity
     */
    public WeaponSlot(final int maxHoldingAmount) {
        maxCapacity = maxHoldingAmount;
        currentAmount = 0;
        weapons = new ArrayList();
    }
    /**
     * Adds weapon.
     * @param weapon weapon type
     * @return true if it was successful to add
     */
    public final boolean addWeapon(final WeaponType weapon) {
        boolean bool;
        if (currentAmount < maxCapacity) {
            weapons.add(weapon);
            currentAmount += 1;
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }
    /**
     * Removes weapon.
     * @param weapon weapon type
     * @return true if it was successful to remove
     */
    public final boolean removeWeapon(final WeaponType weapon) {
        boolean bool = false;
        if (currentAmount > 0 && weapons.remove(weapon)) {
            currentAmount--;
            bool = true;
        }
        return bool;
    }
    /**
     * Gets weapon list.
     * @return weapon list
     */
    public final List getWeapons() {
        return weapons;
    }
    /**
     * Gets maximum capacity of weapon holds.
     * @return maximum capacity
     */
    public final int getMaxCapacity() {
        return maxCapacity;
    }
    /**
     * Gets current amount of weapons.
     * @return current weapon amount
     */
    public final int getCurrentAmount() {
        return currentAmount;
    }
    /**
     * Gets the number of weapons in the slots.
     * @param weaponT weapon type
     * @return number of weapons
     */
    public final int countNumberOfWeapon(final WeaponType weaponT) {
        int count = 0;
        for (WeaponType weapon : weapons) {
            if (weapon.getWeaponName().equals(weaponT.getWeaponName())) {
                count += 1;
            }
        }
        return count;
    }
    public final int getDamage() {
        int result = 0;
        for (WeaponType weapon : weapons) {
            result += weapon.getDmg();
        }
        return result;
    }
}
