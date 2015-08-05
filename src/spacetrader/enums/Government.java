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
public enum Government implements Serializable {
    ANARCHY(0, "Anarchy", 1, 1, 1.5, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1.5, 1),
    CAPITALIST(1, "Capitalist State", 1, 1, 1, 1.5, 1, 1, 1, 1, 1, 1, 1, 0, 0.2, 0),
    COMMUNIST(2, "Communist State", 1, 1, 1, 1, 1, 1.2, 1, 1, 1.5, 1, 1.5, 1, 1, 0),
    CONFEDERACY(3, "Confederacy", 1, 1, 1, 1, 1.5, 1, 1, 1, 1, 1, 1, 0, 1, 0),
    CORPORATE(4, "Corporate State", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.5, 1, 0, 1, 0),
    CYBERNETIC(5, "Cybernetic State", 1, 1, 1, 1.5, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1),
    DEMOCRACY(6, "Democracy", 1, 1, 1, 1, 1.5, 1, 1, 1, 1, 1, 0.5, 0, 0.5, 0),
    DICTATORSHIP(7, "Dictatorship", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.5, 1, 1.5, 0),
    FASCIST(8, "Fascist State", 1, 1, 1, 1, 1, 1, 1, 1.5, 0, 1, 1.5, 1, 1, 0),
    FEUDAL(9, "Feudal State", 1, 1, 1, 1, 1, 1.5, 1, 1, 1, 1, 0, 0, 1.5, 0),
    MILITARY(10, "Military State", 1, 1, 1, 1, 1, 1, 1, 1, 0, 1.5, 1.5, 1, 0, 0),
    MONARCHY(11, "Monarchy", 1, 1, 1, 1, 1, 1, 1.5, 1, 1, 1, 1.2, 0, 1, 0),
    PACIFIST(12, "Pacifist State", 1.2, 1.2, 1.2, 1, 1, 0, 1, 0, 1, 0, .2, 0, 0, 0),
    SOCIALIST(13, "Socialist State", 1, 1, 1, 1, 1, 1, 1, 1, 1.5, 1, .5, 0, 1.5, 1),
    SATORI(14, "State of Satori", 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0),
    TECNOCRACY(15, "Technocracy", 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.2, 0),
    THEOCRACY(16, "Theocracy", 1, 1, 1, 1, 1, 0, 1, 1, 1.5, 1, 1.5, 0, 1, 0);
    private final int key;
    private final String name;
    private final double waterMultiplier;
    private final double furMultiplier;
    private final double foodMultiplier;
    private final double oreMultiplier;
    private final double gameMultiplier;
    private final double firearmMultiplier;
    private final double medicineMultiplier;
    private final double machineMultiplier;
    private final double narcoticMultiplier;
    private final double robotMultiplier;
    private final double policeEncounterMultiplier;
    private final int policeLevelUp;
    private final double pirateEncounterMultiplier;
    private final int pirateLevelUp;
    /**
     * serialVersionUID for serializable class.
     */
    private static final long serialVersionUID = 1;    
    private Government(final int pKey, final String pName, final double water,
            final double fur, final double food, final double ore, final double game,
            final double firearm, final double medicine, final double machine,
            final double narcotic, final double robot, final double policeEncounter,
            final int policeLvlUp, final double pirateEncounter,
            final int pirateLvlUp) {
        key = pKey;
        name = pName;
        waterMultiplier = water;
        furMultiplier = fur;
        foodMultiplier = food;
        oreMultiplier = ore;
        gameMultiplier = game;
        firearmMultiplier = firearm;
        medicineMultiplier = medicine;
        machineMultiplier = machine;
        narcoticMultiplier = narcotic;
        robotMultiplier = robot;
        policeEncounterMultiplier = policeEncounter;
        policeLevelUp = policeLvlUp;
        pirateEncounterMultiplier = pirateEncounter;
        pirateLevelUp = pirateLvlUp;
    }
    public double[] getPriceMultiplierList() {
        return new double[] {waterMultiplier, furMultiplier, foodMultiplier,
            oreMultiplier, gameMultiplier, firearmMultiplier, medicineMultiplier
                , machineMultiplier, narcoticMultiplier, robotMultiplier};
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getWaterMultiplier() {
        return waterMultiplier;
    }

    public double getFurMultiplier() {
        return furMultiplier;
    }

    public double getFoodMultiplier() {
        return foodMultiplier;
    }

    public double getOreMultiplier() {
        return oreMultiplier;
    }

    public double getGameMultiplier() {
        return gameMultiplier;
    }

    public double getFirearmMultiplier() {
        return firearmMultiplier;
    }

    public double getMedicineMultiplier() {
        return medicineMultiplier;
    }

    public double getMachineMultiplier() {
        return machineMultiplier;
    }

    public double getNarcoticMultiplier() {
        return narcoticMultiplier;
    }

    public double getRobotMultiplier() {
        return robotMultiplier;
    }

    public double getPoliceEncounterMultiplier() {
        return policeEncounterMultiplier;
    }

    public int getPoliceLevelUp() {
        return policeLevelUp;
    }

    public double getPirateEncounterMultiplier() {
        return pirateEncounterMultiplier;
    }

    public int getPirateLevelUp() {
        return pirateLevelUp;
    }
    public final String toString() {
        return name;
    }    
}
