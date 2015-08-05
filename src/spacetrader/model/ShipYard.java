/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import java.util.List;
import spacetrader.enums.Spacecraft;

/**
 *
 * @author Kevin & Jasper
 */
public class ShipYard {

    /**
     * Sell price rate.
     */
    private static final double SELLPRICE = 0.7;

    /**
     * Trade ship.
     * @param shipToBuy ship desired
     */
    public final void tradeShip(final Spacecraft shipToBuy) {
        final Spacecraft current = GameContext.instance()
                .getPlayer().getShip().getShipType();
        int playersNewCredit = GameContext.instance().getPlayer()
                .getCredit() + ((int) (current.getPrice() * SELLPRICE));
                        //70% selling price
        //System.out.println("Credit= " +playersNewCredit);
        playersNewCredit -= shipToBuy.getPrice();
        //System.out.println("after ship Sell Credit= " +playersNewCredit);

        final Planet currentPlanet = GameContext.instance().getUniverse().get(
                GameContext.instance().getPlayer().getCoordinate());

        for (int i = 0; i < GameContext.instance().getPlayer().getShip()
                .getQuantity().getAll().length; i++) {
            final List sellingPriceArray = currentPlanet.getSellPrices();
            final int sellingPricePer = (int) sellingPriceArray.get(i);
            int[] myCargo;
            myCargo = GameContext.instance().getPlayer()
                    .getShip().getQuantity().getAll();
            //System.out.println("Resourece=" + i + " MyCargoitemPrice
            //* sellingPrice=" + (myCargo[i]*sellingPricePer));
            playersNewCredit += myCargo[i] * sellingPricePer;

        }
//        for (int resource : GameContext.instance().getPlayer().getShip()
//            .getQuantity().getAll()) {
//            GameContext.instance().getPlayer().
//        }
        //if (GameContext.instance().getUniverse().get(GameContext.instance()
        //.getPlayer().getCoordinate());
        if (playersNewCredit >= 0) {
            GameContext.instance().getPlayer().setCredit(playersNewCredit);
            GameContext.instance().getPlayer().setShip(shipToBuy);
        }


    }
}
