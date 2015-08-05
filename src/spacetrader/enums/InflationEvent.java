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
public enum InflationEvent implements Serializable {
    /**
     * Drought.
     */
    DROUGHT(0, "Drought"),
    /**
     * Cold.
     */
    COLD(1, "Cold"),
    /**
     * Crop fail.
     */
    CROPFAIL(2, "Crop Fail"),
    /**
     * War.
     */
    WAR(3, "War"),
    /**
     * Boredom.
     */
    BOREDOM(4, "Boredom"),
    /**
     * Plague.
     */
    PLAGUE(5, "Plague"),
    /**
     * Lack of workers.
     */
    LACKOFWORKERS(6, "Lack of Workers");

    /**
     * Event key.
     */
    private final int key;

    /**
     * Event string.
     */
    private final String name;

    /**
     * Inflation Event constructor.
     * @param pKey key for event
     * @param pName name of event
     */
    private InflationEvent(final int pKey, final String pName) {
        this.key = pKey;
        this.name = pName;
    }

    /**
     * Get key.
     * @return key
     */
    public int getKey() {
        return key;
    }

    /**
     * Get name.
     * @return name
     */
    public String getName() {
        return name;
    }
}
