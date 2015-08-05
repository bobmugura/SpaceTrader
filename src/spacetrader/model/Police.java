/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.model;

import spacetrader.enums.ShieldType;
import spacetrader.enums.Spacecraft;
import spacetrader.enums.WeaponType;

/**
 *
 * @author Keun Lee
 */
public class Police extends Character {
    /**
     * Rank of the office.
     */
    private int rank;
    /**
     * Possible bribe credit amount.
     */
    private int bribe;
    /**
     * Ship type.
     */
    private Spaceship ship;
    /**
     * Police constructor.
     * Rank determines the skill level.
     * @param pRank police rank
     */
    public Police(final int pRank) {        
        super("Police_lvl_" + pRank, pRank * 2, pRank * 2, pRank, pRank, pRank);
        rank = ((pRank > 4) ? 4 : pRank);
        bribe = rank * 100;
        switch(rank) {
            case 1: 
                ship = new Spaceship(Spacecraft.GNAT);
                ship.addWeapon(WeaponType.PULSE);
                break;
            case 2:
                ship = new Spaceship(Spacecraft.FIREFLY);
                ship.addWeapon(WeaponType.BEAM);
                ship.addShield(ShieldType.ENERGY);
                break;
            case 3:
                ship = new Spaceship(Spacecraft.MOSQUITO);
                ship.addWeapon(WeaponType.PULSE);
                ship.addWeapon(WeaponType.BEAM);
                ship.addShield(ShieldType.ENERGY);
                break;
            case 4:
                ship = new Spaceship(Spacecraft.BUMBLEBEE);
                ship.addWeapon(WeaponType.MILITARY);
                ship.addShield(ShieldType.REFLECTIVE);
                ship.addShield(ShieldType.ENERGY);
                break;
            default:
                ship = new Spaceship(Spacecraft.FLEA);
        }
    }
    /**
     * Getter for the police rank.
     * @return police rank.
     */
    public int getRank() {
        return rank;
    }
    public final int getShield() {
        return ship.getShield();
    }
    public final int getHealth() {
        return ship.getHealth();
    }
    public final String getShipName() {
        return ship.getShipType().getName();
    }
    public final boolean takeDmgAndAlive(final int damage, final int aim) {
        boolean result;
        if (Math.random() * 20 + aim < getPilotLevel()) {
            result = true;
        } else {
            result = ship.takeDmgAndAlive(damage);
        }           
        return result;
    }
    public final int getDamage() {  
        return Math.round(ship.getDamage()
                * (((float)getFighterLevel()) / 10 + 1));
    }
    public final int getBribe() {
        return bribe;
    }
}
