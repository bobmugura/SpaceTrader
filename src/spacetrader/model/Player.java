/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import java.util.ArrayList;
import spacetrader.enums.Spacecraft;

/**
 *
 * @author Keun Lee
 */
public class Player extends Character {
    /**
     * Coordinate variable.
     */
    private Coordinate coordinate;

    /**
     * Credit variable.
     */
    private int credit;

    /**
     * Spaceship variable.
     */
    private Spaceship ship;
    private int currentLoan;     
    private boolean illegal;

    private ArrayList<StockHolder> stocks;
    /**
     * Initial credit value.
     */
    private static final int INITCREDIT = 2000;

    /**
     * Running parent's constructor
     * Initialize the player's attributes.
     * @param name name of the player
     * @param pilot initial pilot level
     * @param fighter initial fighter level
     * @param trader initial trader level
     * @param engineer initial engineer level
     * @param investor initial investor level
     */
    public Player(final String name, final int pilot, final int fighter,
            final int trader, final int engineer, final int investor) {
        super(name, pilot, fighter, trader, engineer, investor);
        ship = new Spaceship(Spacecraft.BUMBLEBEE);
        credit = INITCREDIT; //should be 2000!
        stocks = new ArrayList<StockHolder>();
        illegal = false;
        currentLoan = 0;
    }
    public void setCurrentLoan(int loan) {
        currentLoan = loan;
    }    
    public int getCurrentLoan() {
        return currentLoan;
    }    
    public ArrayList<StockHolder> getStocks() {
        return stocks;
    }    
    /**
     * Get player's ship.
     * @return player's spaceship
     */
    public final Spaceship getShip() {
        return ship;
    }

    /**
     * Set player's ship.
     * @param newShip the player's new spaceship
     */
    public final void setShip(final Spacecraft newShip) {
        ship = new Spaceship(newShip);
    }
    /**
     * Set player's coordinate.
     * @param coord the player's coordinate
     */
    public final void setCoordinate(final Coordinate coord) {
        this.coordinate = coord;
    }
    /**
     * Get player's coordinate.
     * @return player's coordinate
     */
    public final Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Set player's credit amount.
     * @param cred the player's credit
     */
    public final void setCredit(final int cred) {
        this.credit = cred;
    }

    /**
     * Get player's credit amount.
     * @return player's credit amount
     */
    public final int getCredit() {
        return credit;
    }

    /**
     * Add onto player's current credit.
     * @param cred the player's credit
     */
    public final void addCredit(final int cred) {
        this.credit += cred;
    }
    /**
     * Subtract from player's current credit
     * If player doesn't have enough credit, then return false.
     * @param cred the player's credit
     * @return true if player has more credit than the parameter.
     *  False otherwise
     */
    public final boolean subtractCredit(final int cred) {
        boolean check;
        if (this.credit < cred) {
            check = false;
        } else {
            this.credit -= cred;
            check = true;
        }
        return check;
    }
    public final boolean takeDmgAndAlive(final int damage) {
        boolean result;
        if (Math.random() * 20 < getPilotLevel()) {
            result = true;
        } else {
            result = ship.takeDmgAndAlive(damage);
        }           
        return result;
    }
    public final int getHealth() {
        return ship.getHealth();
    }
    public final int getShield() {
        return ship.getShield();
    }
    public final int getDamage() {
        System.out.println(Math.round(ship.getDamage()
                * (((float)getFighterLevel()) / 10 + 1)));
        return Math.round(ship.getDamage()
                * (((float)getFighterLevel()) / 10 + 1));
    }
    public boolean isIllegal() {
        return illegal;
    }
    public void setIllegal(boolean illegal) {
        this.illegal = illegal;
    }
    public void loseAllCargo() {
        ship.loseAllCargo();
    }
    public final boolean hasCargoBay() {
        return ship.hasCargoBay();
    }
    public final boolean hasGPS() {
        return ship.hasGPS();
    }
    public final boolean hasAutoRepair() {
        return ship.hasAutoRepair();
    }
    public final boolean hasTargetting() {
        return ship.hasTargetting();
    }
    public final boolean hasClock() {
        return ship.hasClock();
    }
    public final void addMaxCargo(final int add) {
        ship.addMaxCargo(add);
    }
    public final void reduceMaxCargo(final int reduce) {
        ship.reduceMaxCargo(reduce);
    }
    public final void recoverHP(final int recover) {
        ship.recoverHP(recover);
    }
}
