/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.controlsfx.dialog.Dialogs;
import spacetrader.ScreenNavigator;

/**
 *
 * @author Keun Lee
 */
public final class GameContext {
    /**
     * Singleton instance of GameContext.
     */
    private static final GameContext INSTANCEFIELD = new GameContext();
    /**
     * Number of maximum planets in the universe.
     */
    private static final int MAX_PLANET_COUNT = 25;
    /**
     * Map of all the Planets in universe with their coordinates as keys.
     */
    private Map<Coordinate, Planet> universe;
    /**
     * Current Player.
     */
    private Player player;
    /**
     * True if game is running, and false if game has ended.
     */
    private boolean gameOn;
    /**
     * Construct the game context (universe).
     */
    private GameContext() {
        universe = new HashMap();
        gameOn = true;
    }
    /**
     * Print out every planet within the universe.
     * @return Multi-line string of all the planet info
     */
    public String toStringUniverse() {
        final StringBuffer buffer = new StringBuffer();
        for (Planet p : universe.values()) {
            buffer.append(p.toString());
            buffer.append(",\n");
        }
        return buffer.toString();
    }
    
    public ArrayList<String> planetNames() {
        ArrayList<String> planetNames = new ArrayList<>();
        for (Planet p: universe.values()) {
            planetNames.add(p.getName());
        }
        return planetNames;
    }
    /**
     * Get the player of the game.
     * @return player
     */
    public Player getPlayer() {
        return player;
    }
    /**
     * Load a player as the player for this particular game.
     * @param pPlayer the game player
     */
    public void loadPlayer(final Player pPlayer) {
        player = pPlayer;
    }
    /**
     * Load a universe (consisting of coordinates and planets) as
     * the universe for this particular game,\.
     * @param pUniverse the game universe
     */
    public void loadUniverse(final Map<Coordinate, Planet> pUniverse) {
        universe = pUniverse;
        gameOn = true;
    }
    /**
     * Get the universe of this game context.
     * @return the game universe
     */
    public Map<Coordinate, Planet> getUniverse() {
        return universe;
    }
    /**
     * Get the instance of this game context.
     * @return the game context's instance
     */
    public static GameContext instance() {
        return INSTANCEFIELD;
    }
    /**
     * Get the planet the player is currently on.
     * @return the current planet
     */
    public Planet currentPlanet() {
        return universe.get(player.getCoordinate());
    }
    /**
     * Get the player's current spaceship.
     * @return the current spaceship
     */
    public Spaceship currentShip() {
        return player.getShip();
    }
    /**
     * Getter for the Instance field.
     * Exactly same as instance() method.
     * @return instance field;
     */
    public static GameContext getINSTANCEFIELD() {
        return INSTANCEFIELD;
    }
    /**
     * Getter fro the max planet count number.
     * @return Maximum number of planets in the universe
     */
    public static int getMAXPLANETCOUNT() {
        return MAX_PLANET_COUNT;
    }
    /**
     * Setter for the universe.
     * @param pUniverse new universe for the current instance
     */
    public void setUniverse(final Map<Coordinate, Planet> pUniverse) {
        universe = pUniverse;
    }
    /**
     * Setter for the new player.
     * Exactly same as loadPlayer() method.
     * @param pPlayer new player
     */
    public void setPlayer(final Player pPlayer) {
        player = pPlayer;
    }
    public void spaceTravel(Coordinate destination) {
        player.getShip().useFuel(destination.distanceTo(player.getCoordinate()));
        new TurnSimulator(destination);
        if (player != null) {
            player.setCoordinate(destination);
            ScreenNavigator.loadScreen(ScreenNavigator.PLANET);
        }
    }
    public final void gameOver(final String msg) {
        Dialogs.create()
                .title("Game Over")
                .masthead(msg)
                .message("Your journey came to an end, abruptly...")
                .showInformation();
        player = null;
        universe.clear();
        gameOn = false;
        ScreenNavigator.loadScreen(ScreenNavigator.MENU);
    }
    public int getPlayerHealth() {
        return player.getHealth();
    }
    public int getPlayerShield() {
        return player.getShield();
    }
    public int getPlayerDamage() {
        return player.getDamage();
    }
    public boolean isGameOn() {
        return gameOn;
    }
}
