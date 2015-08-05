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
public enum WeaponType {
            //name        cost  minTechLevel    //Damage
    /**
     *
     */
    PULSE("Pulse",      2000,        0,          15),
    /**
     *
     */
    BEAM("Beam",        12500,        3,          25),
    /**
     *
     */
    MILITARY("Military", 35000,       5,          35);
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
    private final int damage;
    /**
     * Multiplier for the cost of this item.
     */
    private static final double COST_MULTIPLIER = 0.6;
    /**
     *
     * @param pname a
     * @param pcost a
     * @param pminTechLevel a
     * @param odamage a
     */
    WeaponType(final String pname, final int pcost,
            final int pminTechLevel, final int odamage) {
        this.name = pname;
        this.cost = pcost;
        this.minTechLevel = pminTechLevel;
        this.damage = odamage;
    }
    /**
     *
     * @return tag
     */
    public String getWeaponName() {
        return name;
    }
    /**
     *
     * @return tag
     */
    public int getCost() {
        return cost;
    }
    /**
     *
     * @return tag
     */
    public int getSellCost() {
        return (int) (cost * COST_MULTIPLIER);
    }
    /**
     *
     * @return tga
     */
    public int getMTLV() {
        return minTechLevel;
    }
    /**
     *
     * @return tag
     */
    public int getDmg() {
        return damage;
    }
}
