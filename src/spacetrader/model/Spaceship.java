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
import spacetrader.enums.ShieldType;
import spacetrader.enums.Spacecraft;
import spacetrader.enums.WeaponType;

/**
 * Spaceship class.
 * @author Kevin Fallon
 */
public class Spaceship implements Serializable {
    /**
     * serialVersionUID for serializable class.
     */
    private static final long serialVersionUID = 1;
    /**
     * SpaceCraft type.
     */
    private Spacecraft shipType;
    /**
     * Ship's cargo.
     */
    private Quantity cargo;
    /**
     * Fuel Tank level.
     */
    private int fuelTank;
    /**
     * list of crew.
     */
    private List<Character> crew;
    /**
     * Hull strength of the ship.
     */
    private int health;
    /**
     * Current Shield strength of the ship.
     */
    private int shield;
    /**
     * Constructor for Spaceship.
     * @param type the type of Spacecraft
     */
    public Spaceship(final Spacecraft type) {
        shipType = type;
        cargo = new Quantity(shipType.getCargoBay(),
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        fuelTank = shipType.getFuel();
        crew = new ArrayList(shipType.getCrew());
        health = type.getHullStrength();
        shield = 0;
    }
/**
 * Returns the ArrayList of Characters that are current crew.
 * @return ArrayList of crew Characters
 */
    public final List<Character> getCrew() {
        return crew;
    }
/**
 * Set the current crew.
 * @param pcrew ArrayList of Characters that represent crew
 */
    public final void setCrew(final List<Character> pcrew) {
        this.crew = pcrew;
    }
/**
 * Set fuel.
 * @param pfuelTank new fuel amount
 */
    public final void setFuelTank(final int pfuelTank) {
        this.fuelTank = pfuelTank;
    }
/**
 * Get fuel.
 * @return fuel amount number
 */
    public final int getFuelTank() {
        return fuelTank;
    }
    /**
     * Get Spacecraft type.
     * @return Spacecraft type
     */
    public final Spacecraft getShipType() {
        return shipType;
    }
    /**
     * Get spaceship's Quantity for merchandises.
     * @return Quantity of merchandises
     */
    public final Quantity getQuantity() {
        return cargo;
    }
   /**
     * Uses the ships fuel to travel.
     * @param distance to travel as an int
     * @return a boolean , true if you have enough fuel for the distance
     */
    public final boolean useFuel(final int distance) {
        boolean bool;
        if (distance > fuelTank) {
            bool = false;
        } else {
            fuelTank -= distance;
            bool = true;
        }
        return bool;
     }
    /**
     * Refuels the ship to maximum.
     * @return boolean, false if player does not have enough credits to refuel,
     * otherwise fills tank, reduces credits and returns true
     */
    public final boolean reFuel() {
        boolean bool;
        final int credits = GameContext.instance().getPlayer().getCredit();
        final int cost
                = (shipType.getFuel() - fuelTank) * shipType.getFuelCost();
        if (cost > credits) {
            bool = false;
        } else {
            fuelTank = shipType.getFuel();
            GameContext.instance().getPlayer().setCredit(credits - cost);
            bool = true;
        }
        return bool;
    }
    /**
     * Calculates the credit amount to refuel the ship.
     * @return credit amount to refuel the ship
     */
    public final int costToReFuel() {
        return (shipType.getFuel() - fuelTank) * shipType.getFuelCost();
    }
    /**
     * Getter for Cargo.
     * @return cargo
     */
    public final Quantity getCargo() {
        return cargo;
    }
    /**
     * Setter for Ship type.
     * @param pShipType new ship type
     */
    public final void setShipType(final Spacecraft pShipType) {
        shipType = pShipType;
    }
    /**
     * Setter for Cargo.
     * @param pCargo new cargo
     */
    public final void setCargo(final Quantity pCargo) {
        cargo = pCargo;
    }
    public final boolean addWeapon(WeaponType weapon) {
        return shipType.addWeapon(weapon);
    }
    public final boolean addShield(ShieldType pShield) {
        boolean result = shipType.addShield(pShield);
        shield = shipType.getMaxShield();
        return result;        
    }
    public final boolean addGadget(GadgetType gadget) {
        return shipType.addGadget(gadget);
    }
    public final int getDamage() {
        return shipType.getDamage();
    }
    public final int getShield() {
        return shield;
    }
    public void setHealth(int pHealth) {
        health = pHealth;
    }
    public int getHealth() {
        return health;
    }
    public final boolean takeDmgAndAlive(final int damage) {
        boolean result;
        health -= reduceDamage(damage);
        if (health > 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    /**
     * Reduce the incoming damage with the shield first.
     * @param damage Incoming damage
     * @return Damage that passed through the shield
     */
    public final int reduceDamage(final int damage) {
        int result;
        if (shield >= damage) {
            shield -= damage;
            result = 0;
        } else {
            result = damage - shield;
            shield = 0;
        }
        return result;
    }
    public final void replenishShield() {
        shield = shipType.getMaxShield();
    }
    public final void loseAllCargo() {
        cargo.loseAllCargo();
    }
    public final boolean hasCargoBay() {
        return shipType.hasCargoBay();
    }
    public final boolean hasGPS() {
        return shipType.hasGPS();
    }
    public final boolean hasAutoRepair() {
        return shipType.hasAutoRepair();
    }
    public final boolean hasTargetting() {
        return shipType.hasTargetting();
    }
    public final boolean hasClock() {
        return shipType.hasClock();
    }
    public final void addMaxCargo(final int add) {
        cargo.addMaxCargo(add);
    }
    public final void reduceMaxCargo(final int reduce) {
        cargo.reduceMaxCargo(reduce);
    }
    public final void recoverHP(final int recover) {
        if (health <= shipType.getHullStrength() - recover) {
            health += recover;
        } else {
            health = shipType.getHullStrength();
        }
    }
    public final void fullHP() {
        health = shipType.getHullStrength();
    }
}
