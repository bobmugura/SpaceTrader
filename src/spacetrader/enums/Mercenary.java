/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.enums;

import spacetrader.model.GameContext;

/**
 *
 * @author Alex Cignarella
 */
public enum Mercenary {
    STARBUCK("Starbuck", "Pilot", 600, 3, 0, 0, 0, 0),
    MANIAC("Maniac", "Pilot", 700, 4, 0, 0, 0, 0),
    JAYNE("Jayne", "Fighter", 500, 0, 2, 0, 0, 0),
    CHEWBACCA("Chewbacca", "Fighter", 800, 0, 5, 0, 0, 0),
    STARR("Starr", "Trader", 600, 0, 0, 3, 0, 0),
    JACKSON("Jackson", "Trader", 500, 0, 0, 4, 0, 0),
    EDWARD("Edward", "Engineer", 700, 0, 0, 0, 4, 0),
    FORGE("Forge", "Engineer", 1000, 0, 0, 0, 6, 0),
    FLEEGMAN("Fleegman", "Investor", 300, 0, 0, 0, 0, 2),
    VILA("Vila", "Investor", 500, 0, 0, 0, 0, 4);
    private String name;
    private String type;
    private int salary;
    private int pilotLevel;
    private int fighterLevel;
    private int traderLevel;
    private int engineerLevel;
    private int investorLevel;
    private Mercenary(String name, String type, int salary, int pilotLevel,
            int fighterLevel, int traderLevel, int engineerLevel, int investorLevel) {
        this.name = name;
        this.type = type;
        this.salary = salary;
        this.pilotLevel = pilotLevel;
        this.fighterLevel = fighterLevel;
        this.traderLevel = traderLevel;
        this.engineerLevel = engineerLevel;
        this.investorLevel = investorLevel;
    }
    public int getPilot() {
        return pilotLevel;
    }
    public int getFighter() {
        return fighterLevel;
    }
    public int getTrader() {
        return traderLevel;
    }
    public int getEngineer() {
        return engineerLevel;
    }
    public int getInvestor() {
        return investorLevel;
    }
    public void addMercLevel() {
        GameContext.instance().getPlayer().addPilotLevel(pilotLevel);
        GameContext.instance().getPlayer().addFighterLevel(fighterLevel);
        GameContext.instance().getPlayer().addTraderLevel(traderLevel);
        GameContext.instance().getPlayer().addEngineerLevel(engineerLevel);
        GameContext.instance().getPlayer().addInvestorLevel(investorLevel);
    }
    public void reduceMercLevel() {
        GameContext.instance().getPlayer().reducePilotLevel(pilotLevel);
        GameContext.instance().getPlayer().reduceFighterLevel(fighterLevel);
        GameContext.instance().getPlayer().reduceTraderLevel(traderLevel);
        GameContext.instance().getPlayer().reduceEngineerLevel(engineerLevel);
        GameContext.instance().getPlayer().reduceInvestorLevel(investorLevel);
    }    
}
