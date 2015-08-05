/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import java.io.Serializable;

/**
 *
 * @author Keun Lee
 */
public class Character implements Serializable {
    /**
     * serialVersionUID for serializable class.
     */
    private static final long serialVersionUID = 1;
    /**
     * Name of the character.
     */
    private String name;
    /**
     * Pilot Level of the character.
     */
    private int pilotLevel;
    /**
     * Fighter Level of the character.
     */
    private int fighterLevel;
    /**
     * Trader Level of the character.
     */
    private int traderLevel;
    /**
     * Engineer Level of the character.
     */
    private int engineerLevel;
    /**
     * Investor Level of the character.
     */
    private int investorLevel;
    /**
     * Character constructor.
     * @param pName name of the character
     * @param pilot initial pilot level
     * @param fighter initial fighter level
     * @param trader initial trader level
     * @param engineer initial engineer level
     * @param investor initial investor level
     */
    public Character(final String pName, final int pilot, final int fighter,
            final int trader, final int engineer, final int investor) {
        name = pName;
        pilotLevel = pilot;
        fighterLevel = fighter;
        traderLevel = trader;
        engineerLevel = engineer;
        investorLevel = investor;
    }
    /**
     * Setter for the character's name.
     * @param pName the name for the character
     */
    public final void setName(final String pName) {
        name = pName;
    }
    /**
     * Levels up the Pilot skill by 1 point.
     */
    public final void pilotLevelUp() {
        pilotLevel++;
    }
    /**
     * Setter for the Pilot skill level.
     * @param point the point to set the Pilot level
     */
    public final void setPilotLevel(final int point) {
        pilotLevel = point;
    }
    /**
     * Levels up the Fighter skill by 1 point.
     */
    public final void fighterLevelUp() {
        fighterLevel++;
    }
    /**
     * Setter for the Fighter skill level.
     * @param point the point to set the Fighter level
     */
    public final void setFighterLevel(final int point) {
        fighterLevel = point;
    }
    /**
     * Levels up the Trader skill by 1 point.
     */
    public final void traderLevelUp() {
        traderLevel++;
    }
    /**
     * Setter for the Trader skill level.
     * @param point the point to set the Trader level
     */
    public final void setTraderLevel(final int point) {
        traderLevel = point;
    }
    /**
     * Levels up the Engineer skill by 1 point.
     */
    public final void engineerLevelUp() {
        engineerLevel++;
    }
    /**
     * Setter for the Engineer skill level.
     * @param point the point to set the Engineer level
     */
    public final void setEngineerLevel(final int point) {
        engineerLevel = point;
    }
    /**
     * Levels up the Investor skill by 1 point.
     */
    public final void investorLevelUp() {
        investorLevel++;
    }
    /**
     * Setter for the Investor skill level.
     * @param point the point to set the Investor level
     */
    public final void setInvestorLevel(final int point) {
        investorLevel = point;
    }
    /**
     * Getter for character's name.
     * @return name
     */
    public final String getName() {
        return name;
    }
    /**
     * Getter for Pilot skill level.
     * @return Pilot level
     */
    public final int getPilotLevel() {
        return pilotLevel;
    }
    /**
     * Getter for Fighter skill level.
     * @return Fighter level
     */
    public final int getFighterLevel() {
        return fighterLevel;
    }
    /**
     * Getter for Trader skill level.
     * @return Trader level
     */
    public final int getTraderLevel() {
        return traderLevel;
    }
    /**
     * Getter for Engineer skill level.
     * @return Engineer level
     */
    public final int getEngineerLevel() {
        return engineerLevel;
    }
    /**
     * Getter for Investor skill level.
     * @return Investor level
     */
    public final int getInvestorLevel() {
        return investorLevel;
    }
    /**
     * Copy the attributes of another character.
     * @param character sample character to copy from
     */
    public final void copyCharacter(final Character character) {
        this.name = character.getName();
        this.pilotLevel = character.getPilotLevel();
        this.fighterLevel = character.getFighterLevel();
        this.traderLevel = character.getTraderLevel();
        this.engineerLevel = character.getEngineerLevel();
        this.investorLevel = character.getInvestorLevel();
    }
    public final void addPilotLevel(final int level) {
        pilotLevel += level;
    }
    public final void addFighterLevel(final int level) {
        fighterLevel += level;
    }
    public final void addTraderLevel(final int level) {
        traderLevel += level;
    }
    public final void addEngineerLevel(final int level) {
        engineerLevel += level;
    }
    public final void addInvestorLevel(final int level) {
        investorLevel += level;
    }
    public final void reducePilotLevel(final int level) {
        pilotLevel -= level;
    }
    public final void reduceFighterLevel(final int level) {
        fighterLevel -= level;
    }
    public final void reduceTraderLevel(final int level) {
        traderLevel -= level;
    }
    public final void reduceEngineerLevel(final int level) {
        engineerLevel -= level;
    }
    public final void reduceInvestorLevel(final int level) {
        investorLevel -= level;
    }
}
