/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.model;

/**
 *
 * @author naveen
 */
public class Transaction {
    /**
     *
     */
    private int credits;
    /**
     *
     */
    private int qty;
    /**
     *
     */
    private int itemNum;
    /**
     *
     * @param pcredits credits
     * @param pqty qty
     * @param pitemNum num
     */
    public Transaction(final int pcredits, final int pqty, final int pitemNum) {
        this.credits = pcredits;
        this.qty = pqty;
        this.itemNum = pitemNum;
    }
/**
 *
 * @param pitemPrice price
 * @param pitemNum num
 */
    public Transaction(final int pitemPrice, final int pitemNum) {
        final GameContext instance = GameContext.instance();
        int maxQty = instance.getPlayer().getCredit() / pitemPrice;
        int num = instance.getPlayer().getShip().getQuantity().getCargoLeft();
        if (num < maxQty) {
            maxQty = num;
        }
        num = instance.getUniverse().get(instance.getPlayer().getCoordinate())
                .getQuantity().getWithKey(pitemNum);
        if (num < maxQty) {
            maxQty = num;
        }
        credits = -maxQty * pitemPrice;
        qty = maxQty;
        itemNum = pitemNum;
    }
/**
 *
 * @return tag
 */
    public final int getCredits() {
        return credits;
    }
/**
 *
 * @param pcredits param
 */
    public final void setCredits(final int pcredits) {
        this.credits = pcredits;
    }
/**
 *
 * @return tag
 */
    public final int getQty() {
        return qty;
    }
/**
 *
 * @param pqty qty
 */
    public final void setQty(final int pqty) {
        this.qty = pqty;
    }
/**
 *
 * @return tag
 */
    public final int getItemNum() {
        return itemNum;
    }
/**
 *
 * @param pitemNum num
 */
    public final void setItemNum(final int pitemNum) {
        this.itemNum = pitemNum;
    }
}
