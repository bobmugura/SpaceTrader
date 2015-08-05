/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.enums;

/**
 *
 * @author Jasper
 */
public enum ShieldType {
            //name   cost  minTechLV  shield
    /**
     *
     */
    ENERGY ("Energy", 5000, 0,         100),
    /**
     *
     */
    REFLECTIVE ("Reflective", 200000, 4, 200);
    /**
     *
     */
    private final String name;
    /**
     *
     */
    private final int cost, minTechLv, shield;
    /**
     *
     * @param pname tah
     * @param pcost tag
     * @param pminTechLv a
     * @param pshield a
     */
    ShieldType(final String pname, final int pcost,
            final int pminTechLv, final int pshield) {
        this.name = pname;
        this.cost = pcost;
        this.minTechLv = pminTechLv;
        this.shield = pshield;
    }
/**
 *
 * @return tag
 */
    public String getName() {
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
        return (int) (cost * .6);
    }
    /**
     *
     * @return tag
     */
    public int getMTLV() {
        return minTechLv;
    }
    /**
     *
     * @return tag
     */
    public int getShield() {
        return shield;
    }
}
