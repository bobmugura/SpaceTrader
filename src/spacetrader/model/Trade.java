/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import org.controlsfx.dialog.Dialogs;
import spacetrader.enums.GadgetType;
import spacetrader.enums.ShieldType;
import spacetrader.enums.WeaponType;

/**
 * Transaction class which allows the player to buy and sell.
 * @author Jasper
 */
public class Trade {
    /**
     * Player's current coordinate.
     */
    private final transient Coordinate playerCoord;
    /**
     * Trade constructor.
     */
    public Trade() {
        playerCoord = GameContext.instance().getPlayer().getCoordinate();
    }
    /**
     * Do we really need?.
     * @param itemPrice price
     * @param qty quantity
     * @return true
     */
    public final boolean sellable(final int itemPrice, final int qty) {
        return true;
    }
    /**
     * Checks if the item is available to buy.
     * @param itemPrice item's price
     * @param qty item's quantity
     * @return true if the item is buyable, otherwise false
     */
    public final boolean buyable(final int itemPrice, final int qty) {
        return ((GameContext.instance().getPlayer().getCredit()
                >=
                itemPrice * qty) && (GameContext.instance().getPlayer().
                getShip().getQuantity().getCargoLeft()) >= qty);
    }
    /**
     * Buys the item from MarketPlace.
     * @param itemPrice Item's price
     * @param qty Quantity the player wants to buy
     * @param keyNum Integer representations of trade goods from 0 to 10
     */
    public final void buyTransaction(final int itemPrice, final int qty
            , final int keyNum) {
        if (GameContext.instance().getPlayer().subtractCredit(qty * itemPrice))
        {
            if (GameContext.instance().getUniverse().get(playerCoord)
            .getQuantity().subtractWithKey(keyNum, qty)) {
                GameContext.instance().getPlayer().getShip().getQuantity()
                .addWithKey(keyNum, qty);
            } else {
                Dialogs.create()
                        .title("Transactio Failed")
                        .message("Not enough stock in the market")
                        .showInformation();
            }
        } else {
            Dialogs.create()
                        .title("Transactio Failed")
                        .message("You don't have enough credit.")
                        .showInformation();
        }
    }
    /**
     * Sells the item to MarketPlace.
     * @param itemPrice Item's price
     * @param qty Quantity the player wants to buy
     * @param keyNum Integer representations of trade goods from 0 to 10
     */
    public final void sellTransaction(final int itemPrice, final int qty
            , final int keyNum) {
        GameContext.instance().getPlayer().addCredit(qty * itemPrice);
        if (!GameContext.instance().getPlayer().getShip().getQuantity()
        .subtractWithKey(keyNum, qty)) {
            Dialogs.create()
            .title("Transactio Failed")
            .message("You can't sell more than what you have")
            .showInformation();
        }
    }
    /**
     * Buys the item at max amount depends on marketplace's availability
     * and player's credit.
     * @param itemPrice Item's price
     * @param keyNum Integer representations of trade goods from 0 to 10
     */
    public final void buyMax(final int itemPrice, final int keyNum) {
        final GameContext instance = GameContext.instance();
        int maxQty = instance.getPlayer().getCredit() / itemPrice;
        int num = instance.getPlayer().getShip().getQuantity().getCargoLeft();
        if (num < maxQty) {
            maxQty = num;
        }
        num = instance.getUniverse().get(playerCoord).getQuantity()
            .getWithKey(keyNum);
        if (num < maxQty) {
            maxQty = num;
        }
        GameContext.instance().getPlayer().subtractCredit(maxQty * itemPrice);
        GameContext.instance().getPlayer().getShip().getQuantity()
                .addWithKey(keyNum, maxQty);
        GameContext.instance().getUniverse().get(playerCoord).getQuantity()
                .subtractWithKey(keyNum, maxQty);
    }
    /**
     * Sells the item at max amount which player's spaceship has.
     * @param itemPrice Item's price
     * @param keyNum Integer representations of trade goods from 0 to 10
     */
    public final void sellMax(final int itemPrice, final int keyNum) {
        final int maxQty = GameContext.instance().getPlayer().getShip()
                .getQuantity().getWithKey(keyNum);
        GameContext.instance().getPlayer().addCredit(maxQty * itemPrice);
        GameContext.instance().getPlayer().getShip().getQuantity()
                .subtractWithKey(keyNum, maxQty);
    }
    /**
     * Checks if the weapon is able to be bought.
     * @param itemPrice Weapon price
     * @param qty Weapon quantity
     * @return true if it is purchasable
     */
    public final boolean weaponBuyable(final int itemPrice, final int qty) {
        final int currentAmt = GameContext.instance().getPlayer().getShip()
                .getShipType().getWeaponSlot().getCurrentAmount();
        final int maxCap = GameContext.instance().getPlayer().getShip()
                .getShipType().getWeaponSlot().getMaxCapacity();
        final int roomToBuy = maxCap - currentAmt;
        return ((GameContext.instance().getPlayer().getCredit()
                >= itemPrice * qty) && ((roomToBuy) >= qty));
    }
    /**
     * Checks if the shield is able to be bought.
     * @param itemPrice shield price
     * @param qty shield quantity
     * @return true if it is purchasable
     */
    public final boolean shieldBuyable(final int itemPrice, final int qty) {
        final int currentAmt = GameContext.instance().getPlayer().getShip()
                .getShipType().getShieldSlot().getCurrentAmount();
        final int maxCap = GameContext.instance().getPlayer().getShip()
                .getShipType().getShieldSlot().getMaxCapacity();
        final int roomToBuy = maxCap - currentAmt;
        return ((GameContext.instance().getPlayer().getCredit()
                >= itemPrice * qty) && ((roomToBuy) >= qty));
    }
    /**
     * Checks if the gadget is able to be bought.
     * @param itemPrice gadget price
     * @param qty gadget quantity
     * @return true if it is purchasable
     */
    public final boolean gadgetBuyable(final int itemPrice, final int qty) {
        final int currentAmt = GameContext.instance().getPlayer().getShip()
                .getShipType().getGadgetSlot().getCurrentAmount();
        final int maxCap = GameContext.instance().getPlayer().getShip()
                .getShipType().getGadgetSlot().getMaxCapacity();
        final int roomToBuy = maxCap - currentAmt;
        return ((GameContext.instance().getPlayer().getCredit()
                >= itemPrice * qty) && ((roomToBuy) >= qty));
    }
    /**
     * Buys gadget.
     * @param itemPrice gadget price
     * @param qty gadget quantity
     * @param gadget gadget type
     */
    public final void gadgetBuyTransaction(final int itemPrice, final int qty,
            final GadgetType gadget) {
        for (int i = 0; i < qty; i++) {
            GameContext.instance().getPlayer().getShip().getShipType()
                    .getGadgetSlot().addGadget(gadget);
            if (gadget.equals(GadgetType.CARGOBAY)) {
                GameContext.instance().getPlayer().addMaxCargo(5);
            }
            GameContext.instance().getPlayer().subtractCredit(itemPrice);
        }
    }
    /**
     * Buys weapon.
     * @param itemPrice weapon price
     * @param qty weapon quantity
     * @param weapon weapon type
     */
    public final void weaponBuyTransaction(final int itemPrice,
            final int qty, final WeaponType weapon) {
        for (int i = 0; i < qty; i++) {
               GameContext.instance().getPlayer().getShip().getShipType()
                       .getWeaponSlot().addWeapon(weapon);
               GameContext.instance().getPlayer().subtractCredit(itemPrice);
        }
    }
    /**
     * Buys shield.
     * @param itemPrice shield price
     * @param qty shield quantity
     * @param shield shield type
     */
    public final void shieldBuyTransaction(final int itemPrice, final int qty
            , final ShieldType shield) {
        for (int i = 0; i < qty; i++) {
           GameContext.instance().getPlayer().getShip().getShipType()
                   .getShieldSlot().addShield(shield);
           GameContext.instance().getPlayer().subtractCredit(itemPrice);

        }
    }
    /**
     * Sells the item to MarketPlace.
     * @param itemPrice Item's price
     * @param qty Quantity the player wants to buy
     * @param weapon weapon type
     */
    public final void sellWeaponTransaction(final int itemPrice, final int qty
            , final WeaponType weapon) {
        GameContext.instance().getPlayer().addCredit(qty * itemPrice);
        for (int i = 0; i < qty; i++) {
            if (GameContext.instance().getPlayer().getShip().getShipType()
                    .getWeaponSlot().removeWeapon(weapon)) {
                Dialogs.create()
                .title(" Status ")
                .message("Transaction completed")
                .showInformation();
            } else {
                Dialogs.create()
                .title(" Status ")
                .message("You can't sell more than what you have.");
            }
        }
    }
    /**
     * Sells the item to MarketPlace.
     * @param itemPrice Item's price
     * @param qty Quantity the player wants to buy
     * @param shield shield type
     */
    public final void sellShieldTransaction(final int itemPrice, final int qty
            , final ShieldType shield) {
        GameContext.instance().getPlayer().addCredit(qty * itemPrice);
        for (int i = 0; i < qty; i++) {
            if (GameContext.instance().getPlayer().getShip().getShipType()
                    .getShieldSlot().removeShield(shield)) {
                Dialogs.create()
                .title("Status ")
                .message("Transaction completed")
                .showInformation();
            } else {
                 Dialogs.create()
                .title("Status ")
                .message("You can't sell more than what you have.");
            }
        }
    }
    /**
     * Sells the item to MarketPlace.
     * @param itemPrice Item's price
     * @param qty Quantity the player wants to buy
     * @param gadget gadget type
     */
    public final void sellGadgetTransaction(final int itemPrice, final int qty
            , final GadgetType gadget) {
        GameContext.instance().getPlayer().addCredit(qty * itemPrice);
        for (int i = 0; i < qty; i++) {
            if (GameContext.instance().getPlayer().getShip().getShipType()
                    .getGadgetSlot().removeGadget(gadget)) {
                if (gadget.equals(GadgetType.CARGOBAY)) {
                    GameContext.instance().getPlayer().reduceMaxCargo(5);
                }                
                Dialogs.create()
                .title("Status")
                .message("Transaction completed")
                .showInformation();
            } else {
                Dialogs.create()
                .title("Status")
                .message("You can't sell more than what you have.");
            }
        }
    }
    /**
     * Checks if the item is available to buy.
     * @param itemPrice item's price
     * @param qty item's quantity
     * @return true if the item is buyable, otherwise false
     */
    public final boolean stockBuyable(final int stockPrice, final int qty, int index) {
        if (qty > 5) { //player cannot have more than 5 of any stock
            return false;
        }
        if ((GameContext.instance().getPlayer().getCredit() >= stockPrice * qty)) { //make sure player has enough money
            for (StockHolder stockHolder: GameContext.instance().getPlayer().getStocks()) {
                if (stockHolder.getStock().getName().equals(GameContext.instance().getUniverse().values().toArray()[index])) { //find the place in the players inventory that already holds this stock
                    if (stockHolder.getQuantity() + qty <= stockHolder.getStock().getMaxToOwn()) { //check to see if there is already inventory in players stock, make sure it doesn't exceed max
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
        Dialogs.create()
                    .title("Transaction Failed")
                    .message("You don't have enough credit.")
                    .showInformation();
        return false;
    }
    
    /**
     * Buys the item from MarketPlace.
     * @param itemPrice Item's price
     * @param qty Quantity the player wants to buy
     * @param keyNum Integer representations of trade goods from 0 to 10
     */
    public final void buyStock(final int stockPrice, final int qty
            , final int index) {
        GameContext.instance().getPlayer().subtractCredit(stockPrice*qty);
        Stock toAdd = new Stock((Planet) GameContext.instance().getUniverse().values().toArray()[index]);
        boolean added = false;
        for (StockHolder stockHolder: GameContext.instance().getPlayer().getStocks()) {
            if (stockHolder.getStock().getName().equals(toAdd.getName())) {
                stockHolder.incrementQuantity(qty);
                added = true;
            }
        }
        if (!added) {
            GameContext.instance().getPlayer().getStocks().add(new StockHolder(toAdd, qty));
        }
    }
    public boolean sellableStock(int stockPrice, int qty, String stockName) {
        boolean found = false;
        for (StockHolder stockHolder: GameContext.instance().getPlayer().getStocks()) {
            if (stockHolder.getStock().getName().equals(stockName)) {
                found = true;
                if (stockHolder.getQuantity() < qty || stockHolder.getQuantity() == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        if (!found) {
            return false;
        }
        return true;
    }

    public final void sellStock(final int itemPrice, final int qty, String name) {
        GameContext.instance().getPlayer().addCredit(qty * itemPrice);
        for (StockHolder stockHolder: GameContext.instance().getPlayer().getStocks()) {
            if (stockHolder.getStock().getName().equals(name)) {
                stockHolder.decreaseQuantity(qty);
            }
        }
    }
}
