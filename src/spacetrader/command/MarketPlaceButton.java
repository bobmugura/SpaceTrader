/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.command;

import spacetrader.model.GameContext;
import spacetrader.model.Transaction;

/**
 *
 * @author naveen
 */
public class MarketPlaceButton {
/**
 *
 * @param trans as
 */
    public final void undo(final Transaction trans) {
        if (trans.getCredits() <= 0) { //buy transaction
            GameContext.instance().getPlayer().
                    subtractCredit(trans.getCredits());
            GameContext.instance().getPlayer().getShip().getQuantity().
            subtractWithKey(trans.getItemNum(), trans.getQty());
        } else { //sell transaction
            GameContext.instance().getPlayer().
            subtractCredit(trans.getCredits());
            GameContext.instance().getPlayer().getShip().
            getQuantity().addWithKey(trans.getItemNum(), trans.getQty());
        }
    }
    /**
     *
     * @param trans as
     */
    public final void redo(final Transaction trans) {
        if (trans.getCredits() <= 0) { //buy transaction
            GameContext.instance().getPlayer().addCredit(trans.getCredits());
            GameContext.instance().getPlayer().getShip().
            getQuantity().addWithKey(trans.getItemNum(), trans.getQty());
        } else { //sell transaction
            GameContext.instance().getPlayer().addCredit(trans.getCredits());
            GameContext.instance().getPlayer().getShip().
            getQuantity().subtractWithKey(trans.getItemNum(), trans.getQty());
        }
    }
}
