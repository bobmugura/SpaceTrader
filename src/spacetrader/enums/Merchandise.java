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
public enum Merchandise implements Serializable {
    /**
     * Water.
     */
    WATER(0, "Water", 0, 0, 2, 30, 3, 4, InflationEvent.DROUGHT,
            Environment.LOTSOFWATER, Environment.DESERT, 30, 50),
    /**
     * Fur.
     */
    FUR(1, "Furs", 0, 0, 0, 250, 10, 10, InflationEvent.COLD,
            Environment.RICHFAUNA, Environment.DESERT, 30, 50),
    /**
     * Food.
     */
    FOOD(2, "Food", 1, 0, 1, 100, 5, 5, InflationEvent.CROPFAIL,
            Environment.RICHSOIL, Environment.POORSOIL, 90, 160),
    /**
     * Ore.
     */
    ORE(3, "Ore", 2, 2, 3, 350, 20, 10, InflationEvent.WAR,
            Environment.MINERALRICH, Environment.MINERALPOOR, 350, 420),
    /**
     * Game.
     */
    GAME(4, "Games", 3, 1, 6, 250, -10, 5, InflationEvent.BOREDOM,
            Environment.ARTISTIC, null, 160, 270),
    /**
     * Firearm.
     */
    FIREARM(5, "Firearms", 3, 1, 5, 1250, -75, 100, InflationEvent.WAR,
            Environment.WARLIKE, null, 600, 1100),
    /**
     * Medicine.
     */
    MEDICINE(6, "Medicine", 4, 1, 6, 650, -20, 10, InflationEvent.PLAGUE,
            Environment.LOTSOFHERBS, null, 400, 700),
    /**
     * Machine.
     */
    MACHINE(7, "Machines", 4, 3, 5, 900, -30, 5,
            InflationEvent.LACKOFWORKERS, null, null, 600, 800),
    /**
     * Narcotic.
     */
    NARCOTIC(8, "Narcotics", 5, 0, 5, 3500, -125, 150, InflationEvent.BOREDOM,
            Environment.WEIRDMUSHROOMS, null, 2000, 3000),
    /**
     * Robot.
     */
    ROBOT(9, "Robots", 6, 4, 7, 5000, -150, 100,
            InflationEvent.LACKOFWORKERS, null, null, 3500, 5000);

    /**
     * Key.
     */
    private final int key;

    /**
     * Name.
     */
    private final String name;

    /**
     * MTLP.
     */
    private final int mtlp;

    /**
     * MTLU.
     */
    private final int mtlu;

    /**
     * TTP.
     */
    private final int ttp;

    /**
     * Base price.
     */
    private final int basePrice;

    /**
     * IPL.
     */
    private final int ipl;

    /**
     * VAR.
     */
    private final int var;

    /**
     * IE.
     */
    private final InflationEvent incEvent;

    /**
     * CR.
     */
    private final Environment loPrice;

    /**
     * ER.
     */
    private final Environment hiPrice;

    /**
     * MTL.
     */
    private final int mtl;

    /**
     * MTH.
     */
    private final int mth;

    /**
     * Merchandise constructor.
     * @param pKey key
     * @param pName name
     * @param pMTLP mtlp
     * @param pMTLU mtlu
     * @param pTTP ttp
     * @param base base price
     * @param pIPL ipl
     * @param variance var
     * @param pIE ie
     * @param pCR cr
     * @param pER er
     * @param pMTL mtl
     * @param pMTH  mth
     */
    private Merchandise(final int pKey, final String pName, final int pMTLP,
            final int pMTLU, final int pTTP, final int base, final int pIPL,
            final int variance, final InflationEvent pIE, final Environment pCR,
            final Environment pER, final int pMTL, final int pMTH) {
        this.key = pKey;
        this.name = pName;
        this.mtlp = pMTLP;
        this.mtlu = pMTLU;
        this.ttp = pTTP;
        this.basePrice = base;
        this.ipl = pIPL;
        this.var = variance;
        this.incEvent = pIE;
        this.loPrice = pCR;
        this.hiPrice = pER;
        this.mtl = pMTL;
        this.mth = pMTH;
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

    /**
     * Get MTLP.
     * @return MTLP
     */
    public int getMtlp() {
        return mtlp;
    }

    /**
     * get MTLU.
     * @return MTLU
     */
    public int getMtlu() {
        return mtlu;
    }

    /**
     * Get TTP.
     * @return TTP
     */
    public int getTtp() {
        return ttp;
    }

    /**
     * Get base price.
     * @return base price
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * Get IPL.
     * @return IPL
     */
    public int getIpl() {
        return ipl;
    }

    /**
     * Get variance.
     * @return var
     */
    public int getVar() {
        return var;
    }

    /**
     * Get IE.
     * @return IE
     */
    public InflationEvent getIe() {
        return incEvent;
    }

    /**
     * Get CR.
     * @return CR
     */
    public Environment getCr() {
        return loPrice;
    }

    /**
     * Get ER.
     * @return ER
     */
    public Environment getEr() {
        return hiPrice;
    }

    /**
     * Get MTL.
     * @return MTL
     */
    public int getMtl() {
        return mtl;
    }

    /**
     * Get MTH.
     * @return MTH
     */
    public int getMth() {
        return mth;
    }



}
