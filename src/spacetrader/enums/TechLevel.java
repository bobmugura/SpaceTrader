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
public enum TechLevel implements Serializable {
    /**
     * Pre-Agriculture.
     */
    PREAGRICULTURE (0, "Pre-Agriculture"),
    /**
     * Agriculture.
     */
    AGRICULTURE (1, "Agriculture"),
    /**
     * Medieval.
     */
    MEDIEVAL (2, "Medieval"),
    /**
     * Renaissance.
     */
    RENAISSANCE (3, "Renaissance"),
    /**
     * Early Industrial.
     */
    EARLYINDUSTRIAL (4, "Early Industrial"),
    /**
     * Industrial.
     */
    INDUSTRIAL (5, "Industrial"),
    /**
     * Post-Industrial.
     */
    POSTINDUSTRIAL (6, "Post Industrial"),
    /**
     * Hi-Tech.
     */
    HITECH (7, "Hi-Tech");

    /**
     * Key.
     */
    private final int key;
    /**
     * String.
     */
    private final String string;

    /**
     * Tech Level constructor.
     * @param pKey key
     * @param pString string
     */
    private TechLevel(final int pKey, final String pString) {
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

    /**
     * Get string.
     * @return string
     */
    @Override
    public String toString() {
        return string;
    }
}
