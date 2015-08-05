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
public interface Command {
    /**
     *
     *@param trans
     */
    void execute(Transaction trans);
}
