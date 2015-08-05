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
public class Pirate extends Character {
    private int level;
    private int reward;
    private Spaceship ship;
    public Pirate(final int pLevel) {
        super ("Pirate_lvl_" + pLevel, pLevel * 2, pLevel * 2, pLevel, pLevel, pLevel);
        level = ((pLevel > 4) ? 4 : pLevel);
        reward = level * 100;
        switch(level) {
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
        }
    }
    public int getLevel() {
        return level;
    }
    public int getReward() {
        return reward;
    }
    public final int getDamage() {  
        return Math.round(ship.getDamage()
                * (((float)getFighterLevel()) / 10 + 1));
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
}
