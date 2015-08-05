/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.enums;

import java.io.Serializable;
import spacetrader.model.GadgetSlot;
import spacetrader.model.ShieldSlot;
import spacetrader.model.WeaponSlot;

/**
 *
 * @author Keun Lee
 */
public enum Spacecraft implements Serializable {
    //name,cargo bay, weapon slots, shield slots, gadget slots,crew,
    //fuel, minTechLevel, fuel cost,
    //price, bounty, occurence, hull strength, police, pirate, trader,
    //repair cost, size

    /**
     * "Flea" ship.
     */
    FLEA("Flea", 10, 0, 0, 0, 1, 20, 4, 1, 2000, 5, 2, 25, -1, -1, 0, 1, 0),
    /**
     * "Gnat" ship.
     */
    GNAT("Gnat", 15, 1, 0, 1, 1, 14, 5, 2, 10000, 50, 28, 100, 0, 0, 0, 1, 1),
    /**
     * "Firefly" ship.
     */
    FIREFLY("Firefly", 20, 1, 1, 1, 1, 17, 5, 3, 25000, 75, 20, 100, 0, 0,
            0, 1, 1),
    /**
     * "Mosquito" ship.
     */
    MOSQUITO("Mosquito", 15, 2, 1, 1, 1, 13, 5, 5, 30000, 100, 20, 100, 0, 1,
            0, 1, 1),
    /**
     * "Bumblebee" ship.
     */
    BUMBLEBEE("Bumble Bee", 25, 1, 2, 2, 2, 15, 5, 7, 60000, 125, 15, 100,
            0, 1, 0, 1, 2);
    //BEETLE("Beetle", 50, 0, 1, 1, 3, 14, 5, )

    /**
     * Ship name.
     */
    private final String name;
    /**
     * Cargo bay.
     */
    private final int cargoBay;
    /**
     * Weapon slot.
     */
    private final WeaponSlot weaponSlot;
    /**
     * Shield slot.
     */
    private final ShieldSlot shieldSlot;
    /**
     * Gadget slot.
     */
    private final GadgetSlot gadgetSlot;
    /**
     * Crew.
     */
    private final int crew;
    /**
     * Fuel.
     */
    private final int fuel;
    /**
     * Minimum tech level.
     */
    private final int minTechLevel;
    /**
     * Fuel cost.
     */
    private final int fuelCost;
    /**
     * Price.
     */
    private final int price;
    /**
     * Bounty.
     */
    private final int bounty;
    /**
     * Occurrence.
     */
    private final int occurrence;
    /**
     * Hull strength.
     */
    private final int hullStrength;
    /**
     * Police.
     */
    private final int police;
    /**
     * Pirate.
     */
    private final int pirate;
    /**
     * Trader.
     */
    private final int trader;
    /**
     * Repair cost.
     */
    private final int repairCost;
    /**
     * Size.
     */
    private final int size;

    /**
     * Spacecraft constructor.
     * @param pName name
     * @param cargo cargo bay
     * @param weapon weapon slot
     * @param shield shield slot
     * @param gadget gadget slot
     * @param pCrew crew
     * @param pFuel fuel
     * @param min minimum tech level
     * @param refuel fuel cost
     * @param pPrice price
     * @param pBounty bounty
     * @param pOccurrence occurrence
     * @param hull hull strength
     * @param pPolice police
     * @param pPirate pirate
     * @param pTrader trader
     * @param repair repair cost
     * @param pSize size
     */
    private Spacecraft(final String pName, final int cargo, final int weapon,
            final int shield, final int gadget, final int pCrew,
            final int pFuel, final int min, final int refuel, final int pPrice,
            final int pBounty, final int pOccurrence, final int hull,
            final int pPolice, final int pPirate, final int pTrader,
            final int repair, final int pSize) {
        this.name = pName;
        this.cargoBay = cargo;
        this.weaponSlot = new WeaponSlot(weapon);
        this.shieldSlot = new ShieldSlot(shield);
        this.gadgetSlot = new GadgetSlot(gadget);
        this.crew = pCrew;
        this.fuel = pFuel;
        this.minTechLevel = min;
        this.fuelCost = refuel;
        this.price = pPrice;
        this.bounty = pBounty;
        this.occurrence = pOccurrence;
        this.hullStrength = hull;
        this.police = pPolice;
        this.pirate = pPirate;
        this.trader = pTrader;
        this.repairCost = repair;
        this.size = pSize;
    }

    /**
     * Get name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get cargo bay.
     * @return cargo bay
     */
    public int getCargoBay() {
        return cargoBay;
    }

    /**
     * Get weapon slot.
     * @return weapon slot
     */
    public WeaponSlot getWeaponSlot() {
        return weaponSlot;
    }
    public boolean addWeapon(final WeaponType weapon) {
        return weaponSlot.addWeapon(weapon);
    }
    public int getDamage() {
        return weaponSlot.getDamage();
    }

    /**
     * Get shield slot.
     * @return shield slot
     */
    public ShieldSlot getShieldSlot() {
        return shieldSlot;
    }
    public boolean addShield(final ShieldType shield) {
        return shieldSlot.addShield(shield);
    }
    public int getMaxShield() {
        return shieldSlot.getShield();
    }

    /**
     * Get gadget slot.
     * @return gadget slot
     */
    public GadgetSlot getGadgetSlot() {
        return gadgetSlot;
    }
    public boolean addGadget(final GadgetType gadget) {
        return gadgetSlot.addGadget(gadget);
    }
    public final boolean hasCargoBay() {
        return gadgetSlot.hasCargoBay();
    }
    public final boolean hasGPS() {
        return gadgetSlot.hasGPS();
    }
    public final boolean hasAutoRepair() {
        return gadgetSlot.hasAutoRepair();
    }
    public final boolean hasTargetting() {
        return gadgetSlot.hasTargetting();
    }
    public final boolean hasClock() {
        return gadgetSlot.hasClock();
    }
    /**
     * Get crew.
     * @return crew
     */
    public int getCrew() {
        return crew;
    }

    /**
     * Get fuel.
     * @return fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * Get minimum tech level.
     * @return minimum tech level
     */
    public int getMinTechLevel() {
        return minTechLevel;
    }

    /**
     * Get fuel cost.
     * @return fuel cost
     */
    public int getFuelCost() {
        return fuelCost;
    }

    /**
     * Get price.
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get bounty.
     * @return bounty
     */
    public int getBounty() {
        return bounty;
    }

    /**
     * Get occurrence.
     * @return occurrence
     */
    public int getOccurrence() {
        return occurrence;
    }

    /**
     * Get hull strength.
     * @return hull strength
     */
    public int getHullStrength() {
        return hullStrength;
    }

    /**
     * Get police.
     * @return police
     */
    public int getPolice() {
        return police;
    }

    /**
     * Get pirate.
     * @return pirate
     */
    public int getPirate() {
        return pirate;
    }

    /**
     * Get trader.
     * @return trader
     */
    public int getTrader() {
        return trader;
    }

    /**
     * Get repair cost.
     * @return repair cost
     */
    public int getRepairCost() {
        return repairCost;
    }

    /**
     * Get size.
     * @return size
     */
    public int getSize() {
        return size;
    }
}
