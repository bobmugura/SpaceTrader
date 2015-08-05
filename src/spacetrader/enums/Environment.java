/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.enums;

import java.io.Serializable;

/**
 *
 * @author Keun Lee
 */
public enum Environment implements Serializable {
    /**
     * No Special Resources.
     */
    NOSPECIALRESOURCES(0, "No Special Resources"),
    /**
     * Mineral rich.
     */
    MINERALRICH(1, "Mineral Rich"),
    /**
     * Mineral poor.
     */
    MINERALPOOR(2, "Mineral Poor"),
    /**
     * Desert.
     */
    DESERT(3, "Desert"),
    /**
     * Lots of water.
     */
    LOTSOFWATER(4, "Lots of Water"),
    /**
     * Rich soil.
     */
    RICHSOIL(5, "Rich Soil"),
    /**
     * Poor soil.
     */
    POORSOIL(6, "Poor Soil"),
    /**
     * Rich fauna.
     */
    RICHFAUNA(7, "Rich Fauna"),
    /**
     * Lifeless.
     */
    LIFELESS(8, "Lifeless"),
    /**
     * Weird mushrooms.
     */
    WEIRDMUSHROOMS(9, "Weird Mushrooms"),
    /**
     * Lots of herbs.
     */
    LOTSOFHERBS(10, "Lots of Herbs"),
    /**
     * Artistic.
     */
    ARTISTIC(11, "Artistic"),
    /**
     * Warlike.
     */
    WARLIKE(12, "Warlike");

    /**
     * Environment key.
     */
    private final int key;

    /**
     * Environment string.
     */
    private final String string;

    /**
     * Environment constructor.
     * @param pKey the key to set the environment
     * @param pString the description from said key
     */
    private Environment(final int pKey, final String pString) {
        this.key = pKey;
        this.string = pString;
    }

    /**
     * Get key.
     * @return key
     */
    public int getKey() {
        return key;
    }

    @Override
    /**
     * Write Environment as string.
     */
    public String toString() {
        return string;
    }

}
