/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;


import java.io.Serializable;
import java.util.List;
import java.util.Random;
import spacetrader.enums.Environment;
import spacetrader.enums.Government;
import spacetrader.enums.InflationEvent;
import spacetrader.enums.TechLevel;

/**
 *
 * @author Kevin
 */
public class Planet implements Serializable {

    /**
     * Initial Normal Quantity.
     */
    private transient int inq = 20;
    /**
     * Initial High Quantity.
     */
    private transient int ihq = 30;
    /**
     * Initial Extra Quantity.
     */
    private transient int ieq = 5;
    /**
     * the name of the planet.
     */
    private String name;
    /**
     * the coordinate of a planet.
     */
    private Coordinate coordinate;
    /**
     * the quantity of the planet.
     */
    private Quantity quantity;
    /**
     * the techLevel of the planet.
     */
    private final TechLevel techLevel;
    /**
     * the environment of the planet.
     */
    private Environment environment;
    /**
     * the inflation level of the planet.
     */
    private InflationEvent inflationEvent;
    /**
     * the government of the planet.
     */
    private Government government;
    /**
     * number of governments exist.
     */
    private static final int NUMOFGOVERNMENTS = 17;
    /**
     * the market level of the planet.
     */
    private MarketPlace market;
    /**
     * number of tech levels used in setTechLevel.
     */
    private static final int NUMOFTECHLEVELS = 8;
    /**
     * number for the warlike property.
     */
    private static final int WARLIKE = 3;
    /**
     * number for the lots of herbs.
     */
    private static final int LOTSOFHERBS = 4;
    /**
     * random number for the political level.
     */
    private static final int RANDOMNUM = 180;
    /**
     * corresponding mod for RANDOMNUM.
     */
    private static final int RANDOMNUMMOD = 18;
    /**
     * narcotic.
     */
    private static final int NARCOTIC = 5;
    /**
     * levels of environment.
     */
    private static final int ENVIRONMENTLEVEL = 20;
    /**
     * Maximum pieces of lands that can be sold.
     */
    private static final int MAX_PROPERTY_NUM = 100;
    /**
     * Current # of available lands for sale.
     */
    private int property;
    /**
     * Interest amount per property.
     */
    private int interest;
    /**
     *
     * @param name1 name of the Planet
     * @param coordinate1 the coordinate of the planet
     */
    public Planet(final String name1, final Coordinate coordinate1) {
        this.name = name1;
        this.coordinate = coordinate1;
        techLevel = setTechLevel();
        government = setGovernment();
        environment = setEnvironment();
        setInitialQuantity();
        //inflationEvent = null;
        market = new MarketPlace(techLevel.getKey(), government.getPriceMultiplierList());
        property = MAX_PROPERTY_NUM;
    }
    private Government setGovernment() {
        Government result;
        switch(new Random().nextInt(NUMOFGOVERNMENTS)) {
            case 0:
                result = Government.ANARCHY;
                break;
            case 1:
                result = Government.CAPITALIST;
                break;
            case 2:
                result = Government.COMMUNIST;
                break;
            case 3:
                result = Government.CONFEDERACY;
                break;
            case 4:
                result = Government.CORPORATE;
                break;
            case 5:
                result = Government.CYBERNETIC;
                break;
            case 6:
                result = Government.DEMOCRACY;
                break;
            case 7:
                result = Government.DICTATORSHIP;
                break;
            case 8:
                result = Government.FASCIST;
                break;
            case 9:
                result = Government.FEUDAL;
                break;
            case 10:
                result = Government.MILITARY;
                break;
            case 11:
                result = Government.MONARCHY;
                break;
            case 12:
                result = Government.PACIFIST;
                break;
            case 13:
                result = Government.SOCIALIST;
                break;
            case 14:
                result = Government.SATORI;
                break;
            case 15:
                result = Government.TECNOCRACY;
                break;
            default:
                result = Government.THEOCRACY;
                break;                
        }
        return result;
    }
    
    /**
     * set the tech level of a planet.
     * @return the tech level of the planet at random
     */
    private TechLevel setTechLevel() {
        TechLevel toReturn;
        switch(new Random().nextInt(NUMOFTECHLEVELS)) {
            case 0:
                toReturn = TechLevel.PREAGRICULTURE;
                break;
            case 1:
                toReturn = TechLevel.AGRICULTURE;
                break;
            case 2:
                toReturn = TechLevel.MEDIEVAL;
                break;
            case 3:
                toReturn = TechLevel.RENAISSANCE;
                break;
            case 4:
                toReturn = TechLevel.EARLYINDUSTRIAL;
                break;
            case 5:
                toReturn = TechLevel.INDUSTRIAL;
                break;
            case 6:
                toReturn = TechLevel.POSTINDUSTRIAL;
                break;
            default:
                toReturn = TechLevel.HITECH;
        }
        return toReturn;
    }
    /**
     * This method sets the initial quantity based on the tech level and
     * environment
     */
    private void setInitialQuantity() {
        switch(techLevel) {
            case PREAGRICULTURE:
                quantity = new Quantity(inq, ihq, 0, 0, 0, 0, 0, 0, 0, 0);
                break;
            case AGRICULTURE:
                quantity = new Quantity(inq, inq, inq, 0, 0, 0, 0, 0, 0, 0);
                break;
            case MEDIEVAL:
                quantity = new Quantity(inq, inq, inq, inq, 0, 0, 0, 0, 0, 0);
                break;
            case RENAISSANCE:
                quantity = new Quantity(inq, inq, inq, ihq, inq, inq,
                        0, 0, 0, 0);
                break;
            case EARLYINDUSTRIAL:
                quantity = new Quantity(inq, inq, inq, inq, inq, inq, inq, inq,
                        0, 0);
                break;
            case INDUSTRIAL:
                quantity = new Quantity(inq, inq, inq, inq, inq, ihq, inq, ihq,
                        ihq, 0);
                break;
            case POSTINDUSTRIAL:
                quantity = new Quantity(inq, inq, inq, inq, inq, inq, ihq, inq,
                        inq, inq);
                break;
            case HITECH:
                quantity = new Quantity(inq, inq, inq, inq, inq, inq, inq, inq,
                        inq, inq);
                break;
            default:
        }
        switch(environment) {
            case MINERALRICH:
                if (techLevel.getKey() >= 2) {
                    quantity.addOre(ieq);
                }
                break;
            case MINERALPOOR:
                if (techLevel.getKey() >= 2) {
                    quantity.subtractOre(ieq);
                }
                break;
            case DESERT:
                quantity.subtractWater(ieq);
                break;
            case LOTSOFWATER:
                quantity.addWater(ieq);
                break;
            case RICHSOIL:
                if (techLevel.getKey() >= 1) {
                    quantity.addFood(ieq);
                }
                break;
            case POORSOIL:
                if (techLevel.getKey() >= 1) {
                    quantity.subtractFood(ieq);
                }
                break;
            case RICHFAUNA:
                quantity.addFur(ieq);
                break;
            case LIFELESS:
                quantity.subtractFur(ieq);
                break;
            case WEIRDMUSHROOMS:
                if (techLevel.getKey() >= NARCOTIC) {
                    quantity.addNarcotic(ieq);
                }
                break;
            case LOTSOFHERBS:
                if (techLevel.getKey() >= LOTSOFHERBS) {
                    quantity.addMedicine(ieq);
                }
                break;
            case ARTISTIC:
                if (techLevel.getKey() >= WARLIKE) {
                    quantity.addGame(ieq);
                }
                break;
            case WARLIKE:
                if (techLevel.getKey() >= WARLIKE) {
                    quantity.addFirearm(ieq);
                }
                break;
            default:
        }
        int index = 0;
        for (double d : government.getPriceMultiplierList()) {
            if (d == 0) {
                quantity.setWithKey(index, 0);
            }
            index++;
        }
    }

    /**
     * randomly sets the environment of the planet.
     * weighted towards nothing special
     * @return the environment
     */
    private Environment setEnvironment() {
        Environment toReturn;
        switch(new Random().nextInt(ENVIRONMENTLEVEL)) {
            case 0:
                toReturn =  Environment.MINERALRICH;
                break;
            case 1:
                toReturn =  Environment.MINERALPOOR;
                break;
            case 2:
                toReturn =  Environment.DESERT;
                break;
            case 3:
                toReturn =  Environment.LOTSOFWATER;
                break;
            case 4:
                toReturn =  Environment.RICHSOIL;
                break;
            case 5:
                toReturn =  Environment.POORSOIL;
                break;
            case 6:
                toReturn =  Environment.RICHFAUNA;
                break;
            case 7:
                toReturn =  Environment.LIFELESS;
                break;
            case 8:
                toReturn =  Environment.WEIRDMUSHROOMS;
                break;
            case 9:
                toReturn =  Environment.LOTSOFHERBS;
                break;
            case 10:
                toReturn =  Environment.ARTISTIC;
                break;
            case 11:
                toReturn =  Environment.WARLIKE;
                break;
            default:
                toReturn =  Environment.NOSPECIALRESOURCES;
                break;
        }
        return toReturn;
    }
    /**
     * Getter for the quantity.
     * @return returns the current quantity of the planet
     */
    public final Quantity getQuantity() {
        return quantity;
    }
    /**
     * get the name of the planet.
     * @return the name of the planet
     */
    public final String getName() {
        return name;
    }
    /**
     * get the coordinate of the planet.
     * @return the coordinate and location of the planet
     */
    public final Coordinate getCoordinate() {
        return coordinate;
    }
    /**
     * get the tech level of the planet.
     * @return the current tech level of the planet
     */
    public final TechLevel getTechLevel() {
        return techLevel;
    }
    /**
     * get the environment of the planet.
     * @return the current environment of the planet
     */
    public final Environment getEnvironment() {
        return environment;
    }
    /**
     * get the inflation of the planet.
     * @return the current inflation event of the planet
     */
    public final InflationEvent getInflationEvent() {
        return inflationEvent;
    }
    /**
     * this method fills the market with resources and prices.
     */
    public final void calculateMarketPlace() {
        market.fillMarket(government.getPriceMultiplierList());
    }
    /**
     * get an array list of buying prices.
     * @return the array list that contains the prices of all the items
     * in the market
     */
    public final List getBuyPrices() {
        return market.getBuyPrices();
    }
    /**
     * get array list of the selling prices.
     * @return the array list that contains the buying prices for the market
     */
    public final List getSellPrices() {
        return market.getSellPrices();
    }
    /**
     * override the to string method.
     * @return a string that can be used to print eh name,coordinate,tech level
     * and political level
     */
    @Override
    public final String toString() {
       return this.name + ", x:" + coordinate.getRow() + ", y:"
               + coordinate.getCol() + ", Techlvl:" + techLevel;
    }
    /**
     * getter for INQ.
     * @return the Initial Normal Quantity.
     */
    public final int getINQ() {
        return inq;
    }
    /**
     * setter for the initial Normal Quantity.
     * @param newINQ integer representing the normal quantity
     */
    public final void setINQ(final int newINQ) {
        this.inq = newINQ;
    }
    /**
     * getter for the initial high quantity.
     * @return the initial high quantity
     */
    public final int getIHQ() {
        return ihq;
    }
    /**
     * set the IHQ.
     * @param ihq1 integer representing the initial high quantity.
     */
    public final void setIHQ(final int ihq1) {
        this.ihq = ihq1;
    }
    /**
     * get the initial Extra Quantity.
     * @return the integer representing the extra quantity.
     */
    public final int getIEQ() {
        return ieq;
    }
    /**
     * Gets the environment of the planet.
     * @return the planets environment.
     */
    public final Environment getEnviornment() {
        return environment;
    }
    /**
     * get the market place of a planet.
     * @return the market planet of a planet
     */
    public final MarketPlace getMarket() {
        return market;
    }
    /**
     * set the market place.
     * @param marketPlace market to be set
     */
    public final void setMarket(final MarketPlace marketPlace) {
        this.market = marketPlace;
    }
    /**
     * setter for environment level.
     * @param envLevel environment level
     */
    public final void setEnvironment(final Environment envLevel) {
        this.environment = envLevel;
    }

    /**
     * set for the players name.
     * @param newName new name for the player
     */
    public final void setName(final String newName) {
        name = newName;
    }
    /**
     * set the new coordinate for the player.
     * @param newCoord players new coordinate
     */
    public final void setCoordinate(final Coordinate newCoord) {
        coordinate = newCoord;
    }
    /**
     * set the new Quantity for the player.
     * @param newQuant players new Quantity
     */
    public final void setQuantity(final Quantity newQuant) {
        quantity = newQuant;
    }
    /**
     * setter for the new inflation event.
     * @param newIE new inflation event to be set
     */
    public final void setInflationEvent(final InflationEvent newIE) {
        inflationEvent = newIE;
    }
    /**
     * setter for the market place.
     * @param newMarket new market to be set.
     */
    public final void setMarketPlace(final MarketPlace newMarket) {
        market = newMarket;
    }
    public final int getInterest() {
        return interest;
    }
    public final Government getGovernment() {
        return government;
    }
}
