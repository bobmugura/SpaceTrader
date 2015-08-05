/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class Navigator {
    /**
*
     */
    private List<Coordinate> coordinateArray;

/**
 *
 * @return tag
 */
    public final List<Coordinate> getCoordinateArray() {
        return coordinateArray;
    }

    /**
     *
     * @param pcoordinateArray array
     */
    public final void setCoordinateArray(
            final List<Coordinate> pcoordinateArray) {
        this.coordinateArray = pcoordinateArray;
    }
    /**
     * Calculates the distances between
     * the player and all the planets in universe
     * and returns the ArrayList of
     * coordinates of planets that the player can travel to.
     * @return ArrayList of coordinates of
     * planets that players can travel to in distance-wise order
     */
    public final List sortCoordinateArray() {
        final GameContext instance = GameContext.instance();
        final Coordinate playerCoord = instance.getPlayer().getCoordinate();
        coordinateArray = new ArrayList
                (instance.getUniverse().keySet());
        Collections.sort(coordinateArray);
        coordinateArray.remove(0);
        for (Coordinate coordinate : instance.getUniverse().keySet()) {
            if (!coordinate.withinReach(playerCoord,
                    instance.getPlayer().getShip().getFuelTank())) {
                coordinateArray.remove(coordinate);
            }
        }
        return coordinateArray;
    }


}
