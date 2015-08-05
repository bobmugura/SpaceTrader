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
public class Coordinate implements Comparable<Coordinate>, Serializable {
    /**
     * serialVersionUID for serializable class.
     */
    private static final long serialVersionUID = 1;
    /**
     * x-axis value.
     */
    private int row;
    /**
     * y-axis value.
     */
    private int col;
    /**
     * Coordinate constructor.
     * @param pRow x-coordinate
     * @param pCol y-coordinate
     */
    public Coordinate(final int pRow, final int pCol) {
            row = pRow;
            col = pCol;
    }
    /**
     * Getter for y-coordinate.
     * @return y-coordinate
     */
    public final int getCol() {
            return col;
    }
    /**
     * Getter for x-coordinate.
     * @return x-coordinate
     */
    public final int getRow() {
            return row;
    }
    /**
     * Getter for y-coordinate.
     * @param pCol y-coordinate
     */
    public final void setCol(final int pCol) {
        col = pCol;
    }
    /**
     * Setter for x-coordinate.
     * @param  pRow x-coordinate
     */
    public final void setRow(final int pRow) {
        row = pRow;
    }
    /**
     * Calculate distance to a planet.
     * @param coord the planet's coordinates
     * @return the distance to the planet
     */
    public final int distanceTo(final Coordinate coord) {
            return (int) Math.sqrt(Math.pow(row - coord.getRow(), 2)
                    + Math.pow(col - coord.getCol(), 2));
    }
    /**
     * Determines if the inputted coordinates match the current
     * coordinates.
     * @param obj the inputted coordinates
     * @return true if they match, false otherwise
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean result;
        if (obj instanceof Coordinate) {
            final Coordinate coord = (Coordinate) obj;
            result = row == coord.getRow() && col == coord.getCol();
        } else if (obj instanceof String) {
            final String str = (String) obj;
            result = str.equals("x:" + row + ", y:" + col);
        } else {
            result = false;
        }
        return result;
    }
    /**
     * Get the hash code for the coordinates.
     * @return the hash code
     */
    @Override
    public final int hashCode() {
            final String addXY = Integer.toString(row) + col;
            final String multXY = Integer.toString(row * col);
            return (addXY.hashCode() * multXY.hashCode())
                    % Integer.MAX_VALUE;
    }
    /**
     * Determine if a planet is within reach.
     * @param coord the planet's coordinates
     * @param travel the maximum distance that can be traveled
     * @return true if the planet is in range. false otherwise
     */
    public final boolean withinReach(final Coordinate coord,
            final int travel) {
        return (distanceTo(coord) < travel);
    }
    /**
     * Writes the coordinates.
     * @return the coordinates as a String
     */
    @Override
    public final String toString() {
        return "x:" + Integer.toString(row) + ", y:"
                + Integer.toString(col);
    }
    @Override
    public final int compareTo(final Coordinate coord) {
        final GameContext instance = GameContext.instance();
        int result;
        if (this.distanceTo(instance.getPlayer().getCoordinate())
                > coord.distanceTo(instance.getPlayer().getCoordinate())) {
            result = 1;
        } else if (this.distanceTo(instance.getPlayer().getCoordinate())
                < coord.distanceTo(instance.getPlayer().getCoordinate())) {
           result = -1;
        } else {
            result = 0;
        }
        return result;
    }
}
