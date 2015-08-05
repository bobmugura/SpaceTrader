/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;
import spacetrader.ScreenNavigator;
import org.controlsfx.dialog.DialogAction;
import spacetrader.MusicPlayer;
import spacetrader.controller.EncounterScreenController;
import spacetrader.enums.Spacecraft;

/**
 *
 * @author Keun Lee
 */
public class TurnSimulator {
    /**
     * Max random number for random event.
     */
    private static final int RANDOM_MAX = 100;
    /**
     * Chance of having fuel leak.
     */
    private static final int FUEL_LEAK = 5;
    /**
     * Chance of having crew mutiny.
     */
    private static final int CREW_MUTINY = 10;
    /**
     * Chance of losing food and water by robbery.
     */
    private static final int SUFFER_ROBBERY = 15;
    
    private static final int POLICE_ENCOUNTER = 20;
    private static final int PIRATE_ENCOUNTER = 30;
    
    private transient Coordinate destination;
    private transient Random rand;
    
    public TurnSimulator(Coordinate pDestination) {
        destination = pDestination;
        rand = new Random();
        ScreenNavigator.loadScreen(ScreenNavigator.ENCOUNTER);
        randomEncounter();
        if (GameContext.instance().isGameOn()) {
            randomEvent();
            randomChange();
            stockTracker();
            loanPayment();
        }
        EncounterScreenController.stopAnimation();
    }
    private void randomEncounter() {
        int chance;
        Planet planet = GameContext.instance().getUniverse().get(destination);
        while(GameContext.instance().isGameOn()) {
            if (GameContext.instance().getPlayer().hasClock()) {
                break;
            }
            chance = rand.nextInt(100);
            if (GameContext.instance().getPlayer().hasAutoRepair()) {
                GameContext.instance().getPlayer().recoverHP(10);
            }
            if (chance < POLICE_ENCOUNTER * planet.getGovernment().getPoliceEncounterMultiplier()) {
                if (planet.getTechLevel().getKey() > 4) {
                    encounter(new Police(4));
                } else if (planet.getTechLevel().getKey() > 0) {
                    encounter(new Police(planet.getTechLevel().getKey() + planet.getGovernment().getPoliceLevelUp()));
                } else {
                    break;
                }
            } else if (chance < POLICE_ENCOUNTER * planet.getGovernment().
                    getPoliceEncounterMultiplier() + PIRATE_ENCOUNTER * planet.
                            getGovernment().getPirateEncounterMultiplier()) {
                if (planet.getTechLevel().getKey() > 4) {
                    encounter(new Pirate(4));
                } else if (planet.getTechLevel().getKey() > 0) {
                    encounter(new Pirate(planet.getTechLevel().getKey() + planet.getGovernment().getPirateLevelUp()));
                } else {
                    break;
                }    
            } else {
                break;
            }
        }
    }
    private void encounter(Character enemy) {
        List<DialogAction> link = new ArrayList();
        GameContext.instance().getPlayer().getShip().replenishShield();
        if (enemy instanceof Pirate) {
            MusicPlayer.playMusic(MusicPlayer.GUN);
            Pirate pirate = (Pirate) enemy;
            link.add(new DialogAction("Attack"));
            link.add(new DialogAction("Flee"));
            link.add(new DialogAction("Surrender"));
            Action response = Dialogs.create()
                    .title("Pirate Encounter!")
                    .message("You encountered a " + pirate.getShipName() + " pirate ship. Choose your action.")
                    .showCommandLinks(link);
            while (true) {
                System.out.println("Response:" + response.getText());
                System.out.println(link.get(0).getText());
                if (response.getText().equals(link.get(0).getText())) {
                    if (!pirate.takeDmgAndAlive(GameContext.instance().getPlayerDamage(),
                            ((GameContext.instance().getPlayer().hasTargetting()) ? 5 : 0))) {
                        Dialogs.create()
                                .title("Battle Won")
                                .message("You have defeated the pirate and earned the reward of " + pirate.getReward() + " credit!")
                                .showInformation();
                        GameContext.instance().getPlayer().addCredit(pirate.getReward());
                        break;
                    }                        
                } else if (response.getText().equals(link.get(1).getText())) {
                    if (Math.random() * 10 < GameContext.instance().getPlayer().getPilotLevel()) {
                        Dialogs.create()
                                .title("Flee Success")
                                .message("You have successfully fleed away from the pirate.")
                                .showInformation();
                        break;
                    } else {
                        Dialogs.create()
                                .title("Flee Fail")
                                .message("You have failed to flee away from the pirate.")
                                .showInformation();
                    }
                } else if (response.getText().equals(link.get(2).getText()))  {
                    Dialogs.create()
                            .title("Surrender to pirate")
                            .message("You had to give up give up 25% of your credits in hand to save your skin.")
                            .showInformation();
                    GameContext.instance().getPlayer().setCredit(Math.round((float)GameContext.instance().getPlayer().getCredit() * (3 / 4)));
                    break;
                }
                if (GameContext.instance().getPlayer().takeDmgAndAlive(pirate.getDamage())) {
                    response = Dialogs.create()
                            .title("Pirate Encounter!")
                            .masthead("Your HP: " + GameContext.instance().
                                    getPlayerHealth() + "\tYour Shield: " +
                                    GameContext.instance().getPlayerShield() + 
                                    "\nPirate's HP: " + pirate.getHealth() + 
                                    "\tPirate's Shield: " + pirate.getShield())
                            .message("You are engaging a battle. Choose your action.")
                            .showCommandLinks(link);
                } else {
                    GameContext.instance().gameOver("Your ship took too much damage and exploded.");
                    return;
                }                    
            }
        } else if (enemy instanceof Police) {
            MusicPlayer.playMusic(MusicPlayer.SIREN);
            Police police = (Police) enemy;
            Action response = new DialogAction("Flee");
            link.add(new DialogAction("Attack"));
            link.add(new DialogAction("Flee"));
            if (GameContext.instance().getPlayer().isIllegal()) {
                link.add(new DialogAction("Surrender"));
                response = Dialogs.create()
                        .title("Police Encounter!")
                        .message("You encountered a " + police.getShipName() +
                                " police ship. They will take you down since you are a criminal. Choose your action.")
                        .showCommandLinks(link);                
            } else {
                link.add(new DialogAction("Submit"));
                link.add(new DialogAction("Bribe"));              
            }
            while (!GameContext.instance().getPlayer().isIllegal()) {
                response = Dialogs.create()
                        .title("Police Encounter!")
                        .message("You encountered a " + police.getShipName() + " police ship. Choose your action.")
                        .showCommandLinks(link);
                if (response.getText().equals(link.get(0).getText())) { //Attack
                    response = Dialogs.create()
                            .title("Warning")
                            .message("You will become a criminal if you attack the police. You sure you want to attack?")
                            .actions(Dialog.ACTION_YES, Dialog.ACTION_NO)
                            .showConfirm();
                    if (response == Dialog.ACTION_YES) {
                        link.remove(3);
                        link.remove(2);
                        link.add(new DialogAction("Surrender"));
                        GameContext.instance().getPlayer().setIllegal(true);
                        break;
                    }
                } else if (response.getText().equals(link.get(1).getText())) { //Flee
                    if (Math.random() * 10 < GameContext.instance().getPlayer().getPilotLevel()) {
                        Dialogs.create()
                                .title("Flee Success")
                                .message("You have successfully fleed away from the police.")
                                .showInformation();
                        break;
                    } else {
                        Dialogs.create()
                                .title("Flee Fail")
                                .message("You have failed to flee away from the police. They fired at you for running away.")
                                .showInformation();
                        if (!GameContext.instance().getPlayer().takeDmgAndAlive(police.getDamage())) {
                            GameContext.instance().gameOver("Your ship took too much damage and exploded.");
                            return;
                        }
                    }                    
                } else if (response.getText().equals(link.get(2).getText())) { //Submit
                    if (GameContext.instance().getPlayer().getShip().getCargo().possessIllegal()) {
                        Dialogs.create()
                                .title("Busted")
                                .message("Police found your illegal cargos. They seized all your cargo and fined you 20% of your credits in hands.")
                                .showInformation();
                        GameContext.instance().getPlayer().loseAllCargo();
                        GameContext.instance().getPlayer().setCredit(Math.round((float)GameContext.instance().getPlayer().getCredit() * (4 / 5)));
                    } else {
                        Dialogs.create()
                                .title("Nothing Wrong")
                                .message("Police found no illegal merchandise from you ship. You are free to go")
                                .showInformation();
                    }
                    break;
                } else if (response.getText().equals(link.get(3).getText())) { //Bribe
                    response = Dialogs.create()
                            .title("Bribe Police")
                            .message("You can bribe the police with " + police.getBribe() + " credits. Will you bribe the police?")
                            .actions(Dialog.ACTION_YES, Dialog.ACTION_NO)
                            .showConfirm();
                    if (response == Dialog.ACTION_YES) {
                        Dialogs.create()
                                .title("Bribe Police")
                                .message("You have bribed the police with " + police.getBribe() + " credits.")
                                .showInformation();
                        GameContext.instance().getPlayer().subtractCredit(police.getBribe());
                        break;
                    }
                }
            }
            while (GameContext.instance().getPlayer().isIllegal()) {
                if (response.getText().equals(link.get(0).getText())) { //Attack
                    if (!police.takeDmgAndAlive(GameContext.instance().getPlayerDamage(),
                            ((GameContext.instance().getPlayer().hasTargetting()) ? 5 : 0))) {
                        Dialogs.create()
                                .title("Battle Won")
                                .message("You have defeated the police.")
                                .showInformation();
                        break;
                    }
                } else if (response.getText().equals(link.get(1).getText())) { //Flee
                    if (Math.random() * 10 < GameContext.instance().getPlayer().getPilotLevel()) {
                        Dialogs.create()
                                .title("Flee Success")
                                .message("You have successfully fleed away from the police.")
                                .showInformation();
                        break;
                    } else {
                        Dialogs.create()
                                .title("Flee Fail")
                                .message("You have failed to flee away from the police.")
                                .showInformation();
                    }                                        
                } else if (response.getText().equals(link.get(2).getText())) { //Surrender
                    Dialogs.create()
                            .title("Surrender to Police")
                            .message("You lose your ship and forfeit 50% of your credits at hands")
                            .showInformation();
                    GameContext.instance().getPlayer().setCredit(Math.round((float)GameContext.instance().getPlayer().getCredit() * (1 / 2)));
                    GameContext.instance().getPlayer().setShip(Spacecraft.FLEA);
                    GameContext.instance().getPlayer().setIllegal(false);
                    break;                    
                }
                if (GameContext.instance().getPlayer().takeDmgAndAlive(police.getDamage())) {
                    response = Dialogs.create()
                            .title("Police Encounter!")
                            .masthead("Your HP: " + GameContext.instance().
                                    getPlayerHealth() + "\tYour Shield: " +
                                    GameContext.instance().getPlayerShield() + 
                                    "\nPolice's HP: " + police.getHealth() + 
                                    "\tPolice's Shield: " + police.getShield())
                            .message("You are engaging a battle. Choose your action.")
                            .showCommandLinks(link);
                } else {
                    GameContext.instance().gameOver("Your ship took too much damage and exploded.");
                    return;
                }                                    
            }
        }        
    }
    /**
     * Generate and notify the player of a random event.
     * @return a String notification of the event
     */
    private void randomEvent() {
        final Random randGen = new Random();
        String result;
        int num;
        num = randGen.nextInt(RANDOM_MAX);
        if (num < FUEL_LEAK) { // fuel leak
            final int leak = GameContext.instance().getPlayer().getShip().getFuelTank() / 2;
            GameContext.instance().getPlayer().getShip().setFuelTank(leak);
            result = "Sorry, you suffered from a fuel leak";
        } else if (num < CREW_MUTINY) { // crew mutiny
            GameContext.instance().getPlayer().getShip().getCrew().clear();
            result = "Sorry, you suffered a muntiny and your crew jumped ship";
        } else if (num < SUFFER_ROBBERY) { // loose you water and food
            GameContext.instance().getPlayer().getShip().getQuantity().setFood(0);
            GameContext.instance().getPlayer().getShip().getQuantity().setWater(0);
            result = "Sorry, you suffered a robbery and lost all your food"
                    + "and water";
        } else {
            result = "Random Event did not occur, you're lucky";
        }
        Dialogs.create()
        .title("Event")
        .message(result)
        .showInformation();        
    }
    private void randomChange() {
        
    }
    
    private void stockTracker() {
        if (GameContext.instance().getPlayer().getStocks().size() > 0) {
            for (StockHolder stockHolder: GameContext.instance().getPlayer().getStocks()) {
                double addedCredit = stockHolder.getQuantity() * stockHolder.getStock().getPrice() * stockHolder.getStock().getInterest();
                int toAdd = (int) Math.round(addedCredit);
                GameContext.instance().getPlayer().addCredit(toAdd);
            }
        }
    }
    private void loanPayment() {
        Player myPlayer = GameContext.instance().getPlayer();
        if (myPlayer.getCurrentLoan() > 0) {
            int interest = (int) (myPlayer.getCurrentLoan() * new Banking().getInterestRate(myPlayer));
            myPlayer.subtractCredit(interest);
            Dialogs.create()
                .title("Banking Notice")
                .message("You have paid " + interest + " credit to Space Bank for your loan")
                .showInformation();
        }
    }
}
