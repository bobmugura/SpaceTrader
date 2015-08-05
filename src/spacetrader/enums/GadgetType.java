/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.enums;

/**
 *
 * @author Kevin
 */
public enum GadgetType {
               //name          cost      minTechLevel    upgrade ability
    /**
     *
     */
    CARGOBAY("5 Extra Cargo Bays",    1000,       0,              1),
    /**
     *
     */
    GPS("GPS for Mini Map",          3000,       2,              4),
    /**
     *
     */
    AUTOREPAIR("Auto-Repair System",   4000,       2,              3),
    /**
     *
     */
    TARGETTING("Targeting System",  5000,       3,              4),
    /**
    *
     */
    CLOAK("Cloaking Device",        10000,      5,              8);
    /**
     *
     */
    private final String name;
    /**
     *
     */
    private final int cost;
    /**
     *
     */
    private final int minTechLevel;
    /**
     *
     */
    private final int upgradeAbility;
    /**
     * Multiplier for the cost of this item.
     */
    private static final double COST_MULTIPLIER = 0.6;
/**
 *
 * @param pname stuff
 * @param pcost stuff
 * @param pminTechLevel stuff
 * @param pupgradeAbility stuff
 */
    private GadgetType(final String pname, final int pcost,
            final int pminTechLevel, final int pupgradeAbility) {
        this.name = pname;
        this.cost = pcost;
        this.minTechLevel = pminTechLevel;
        this.upgradeAbility = pupgradeAbility;
    }
/**
 *
 * @return tag
 */
    public final String getGadgetName() {
        return name;
    }
/**
 *
 * @return tag
 */
    public final int getCost() {
        return cost;
    }
/**
 *
 * @return tag
 */
    public final int getSellCost() {
        return (int) (cost * COST_MULTIPLIER);
    }
/**
 *
 * @return tag
 */
    public final int getMTLV() {
        return minTechLevel;
    }
/**
 *
 * @return tag
 */
    public final int getUpgradeAbility() {
        return upgradeAbility;
    }
}
