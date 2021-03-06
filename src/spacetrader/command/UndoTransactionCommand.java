/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.command;

import spacetrader.model.Transaction;

/**
 *
 * @author naveen
 */
public class UndoTransactionCommand implements Command {
    /**
     *
     */
    private static MarketPlaceButton theButton;
    /**
     *
     * @param but tag
     */
    public UndoTransactionCommand(final MarketPlaceButton but) {
        theButton = but;
    }
    /**
     *
     * @param trans tag
     */
    public final void execute(final Transaction trans) {
       theButton.undo(trans);
    }
}
