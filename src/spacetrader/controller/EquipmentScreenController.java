/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.dialog.Dialogs;
import spacetrader.ScreenNavigator;
import spacetrader.enums.GadgetType;
import spacetrader.enums.ShieldType;
import spacetrader.enums.WeaponType;
import spacetrader.model.GameContext;
import spacetrader.model.Trade;

/**
 * FXML Controller class.
 *
 * @author Jasper
 */
public class EquipmentScreenController implements Initializable {
    /**
     * player credit.
     */
    @FXML private transient Label playerCredit;
    /**
     * ship max weapon slots.
     */
    @FXML private transient Label maxWeaponSlots;
    /**
     * ship max shield slots.
     */
    @FXML private transient Label maxShieldSlots;
    /**
     * ship max gadget slots.
     */
    @FXML private transient Label maxGadgetSlots;
    /**
     * Buying Weapon Price = bwp.
     */
    @FXML private transient Label bwp1, bwp2, bwp3;
    /**
     * Buying Shield Price = bsp.
     */
    @FXML private transient Label bsp1, bsp2;
    /**
     * Buying Gadget Price = bgp.
     */
    @FXML private transient Label bgp1, bgp2, bgp3, bgp4, bgp5;
    /**
     * Selling Weapon Price = swp.
     */
    @FXML private transient Label swp1, swp2, swp3;
    /**
     * Selling Shield Price = ssp.
     */
    @FXML private transient Label ssp1, ssp2;
    /**
     * Selling Gadget Price = sgp.
     */
    @FXML private transient Label sgp1, sgp2, sgp3, sgp4, sgp5;

    //Buy Button = bb
    /**
    * Buy Button = bb.
    */
    @FXML private transient Button bb1;
    /**
    * Buy Button = bb.
    */
    @FXML private transient Button bb2;
    /**
    * Buy Button = bb.
    */
    @FXML private transient Button bb3;
    /**
    * Buy Button = bb.
    */
    @FXML private transient Button bb4;
    /**
    * Buy Button = bb.
    */
    @FXML private transient Button bb5;
    /**
    * Buy Button = bb.
    */
    @FXML private transient Button bb6;
    /**
    * Buy Button = bb.
    */
    @FXML private transient Button bb7;
    /**
    * Buy Button = bb.
    */
    @FXML private transient Button bb8;
    /**
    * Buy Button = bb.
    */
    @FXML private transient Button bb9;
    /**
    * Buy Button = bb.
    */
    @FXML private transient Button bb10;
    /**
     * index of weapon in button array.
     */
    private static final int WEAPONIND = 2;
    /**
     * index of gadget in button array.
     */
    private static final int GADGETIND = 9;
    /**
     * index of shield in button array.
     */
    private static final int SHIELDIND = 4;
    /**
     * Sell Button = sb.
     */
    @FXML
    private transient Button sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8, sb9, sb10;

    /**
     * Buying Quantity = bqt.
     */
    @FXML
    /**
     * text field.
     */
    private transient TextField bqt1, bqt2, bqt3, bqt4, bqt5,
            bqt6, bqt7, bqt8, bqt9, bqt10;
    /**
     * Selling Quantity = sqt.
     */
    @FXML
    private transient TextField sqt1, sqt2, sqt3, sqt4, sqt5,
            sqt6, sqt7, sqt8, sqt9, sqt10;
    /**
    *labels.
    */
    @FXML
    private transient Label weaponLabel, shieldLabel, gadgetLabel;
    /**
     * button array.
     */
    private transient Button[] bbArray, sbArray;
    /**
     * bqtArray.
     */
    private transient TextField[] bqtArray, sqtArray;
    /**
     * bplArray.
     */
    private transient Label[] bplArray;
    /**
     * splArray.
     */
    private transient Label[] splArray;
    /**
     * trade.
     */
    private transient Trade trade;
    /**
     * gadget arrays.
     */
    private List<GadgetType> gadgetArray, myGadget;
    /**
     * weapon arrays.
     */
    private List<WeaponType> weaponArray, myWeapon;
    /**
    * shield arrays.
    */
    private List<ShieldType> shieldArray, myShield;

    /**
     * Initializes the controller class.
     * @param url unused
     * @param resourceb unused
     */
    @Override
    public final void initialize(final URL url,
            final ResourceBundle resourceb) {

        bbArray = new Button[] {bb1, bb2, bb3, bb4, bb5, bb6, bb7, bb8,
            bb9, bb10};
        bqtArray = new TextField[] {bqt1, bqt2, bqt3, bqt4, bqt5, bqt6, bqt7,
            bqt8, bqt9, bqt10};
        bplArray = new Label[] {bwp1, bwp2, bwp3, bsp1, bsp2, bgp1, bgp2, bgp3,
            bgp4, bgp5};

        sbArray = new Button[] {sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8, sb9,
            sb10};
        sqtArray = new TextField[] {sqt1, sqt2, sqt3, sqt4, sqt5, sqt6, sqt7,
            sqt8, sqt9, sqt10};
        splArray = new Label[] {swp1, swp2, swp3, ssp1, ssp2, sgp1, sgp2, sgp3,
            sgp4, sgp5};
        gadgetArray = new ArrayList();
        gadgetArray.addAll(EnumSet.allOf(GadgetType.class));
        myGadget = new ArrayList();

        weaponArray = new ArrayList();
        weaponArray.addAll(EnumSet.allOf(WeaponType.class));
        myWeapon = new ArrayList();

        shieldArray = new ArrayList();
        shieldArray.addAll(EnumSet.allOf(ShieldType.class));
        myShield = new ArrayList();

        gadgetArray = new ArrayList();

        gadgetArray.addAll(EnumSet.allOf(GadgetType.class));

        weaponArray = new ArrayList();

        weaponArray.addAll(EnumSet.allOf(WeaponType.class));

        shieldArray = new ArrayList();
        shieldArray.addAll(EnumSet.allOf(ShieldType.class));

        updatePlayerCredit();
        updateEquipStatus();
        updateBuyPrice();
        updateSellPrice();
        trade = new Trade();
        buttonDisabler(GameContext.instance().currentPlanet()
                .getTechLevel().getKey());
    }
    /**
     * Navigates back to Shipyard screen.
     */
    @FXML
    public final void clickBackButton() {
        ScreenNavigator.loadScreen(ScreenNavigator.SHIPYARD);
    }
    /**
     * updating the game information when the buy button is clicked.
     * @param event the event object linked to buy button
     */
    @FXML
    public final void clickBuyButton(final ActionEvent event) {
        for (int i = 0; i <= GADGETIND; i++) {
            if (event.getSource().equals(bbArray[i])) {
                int input;
                try {
                    input = Integer.parseInt(bqtArray[i].getText());
                }
                catch (NumberFormatException e) {
                    System.out.println("Please type in how many you want to buy");
                    return;
                }
                final int price = Integer.parseInt(bplArray[i].getText());
                if (trade.weaponBuyable(price, input) && i <= WEAPONIND) {
                        trade.weaponBuyTransaction(price, input,
                                weaponArray.get(i));
                }
                if (trade.shieldBuyable(price, input)
                        && (i > WEAPONIND && i <= SHIELDIND)) {
                        final int ans = i - (SHIELDIND - 1);
                        trade.shieldBuyTransaction(price, input,
                                shieldArray.get(ans));
                }
                if (trade.gadgetBuyable(price, input)
                        && (i > SHIELDIND && i <= GADGETIND)) {
                        final int answer = i - (SHIELDIND + 1);
                        trade.gadgetBuyTransaction(price, input,
                                gadgetArray.get(answer));
                }
            }
        }
        refreshScreen();
    }
    /**
     * update the players information when the sell button is clicked.
     * @param event the event object linked the sell button.
     */
    @FXML
    public final void clickSellButton(final ActionEvent event) {
        for (int i = 0; i <= GADGETIND; i++) {
            if (event.getSource().equals(sbArray[i])) {
                int input;
                try {
                    input = Integer.parseInt(sqtArray[i].getText());
                } catch (NumberFormatException e) {
                    Dialogs.create()
                            .title("Sell")
                            .message("Please type in how many you want to buy")
                            .showInformation();
                    return;
                }
                int amountHeld;
                if (i <= 2) {
                    amountHeld = GameContext.instance().getPlayer()
                            .getShip().getShipType().getWeaponSlot()
                            .countNumberOfWeapon(weaponArray.get(i));
                } else if (i > WEAPONIND && i <= SHIELDIND) {
                    amountHeld = GameContext.instance().getPlayer()
                            .getShip().getShipType().getShieldSlot()
                            .countNumberOfShield(shieldArray
                                    .get(i - (SHIELDIND - 1)));
                } else {
                    amountHeld = GameContext.instance().getPlayer()
                            .getShip().getShipType().getGadgetSlot()
                            .countNumberOfGadget(gadgetArray.
                                    get(i - (SHIELDIND + 1)));
                }
                if (input > amountHeld) {
                    Dialogs.create()
                            .title("Warning")
                            .message("You cannot sell more than you have")
                            .showInformation();
                } else {
                    final int price = Integer.parseInt(splArray[i].getText());
                    if (trade.sellable(price, input)) {
                        if (i <= 2) {
                            trade.sellWeaponTransaction(price,
                                    input, weaponArray.get(i));
                        } else if (i > WEAPONIND && i <= SHIELDIND) {
                            trade.sellShieldTransaction(price,
                                    input, shieldArray.
                                            get(i - (SHIELDIND - 1)));
                        } else {
                            trade.sellGadgetTransaction(price,
                                    input, gadgetArray
                                            .get(i - (SHIELDIND + 1)));
                        }
                    } else {
                        Dialogs.create()
                                .title("Transaction")
                                .message("Transaction canceled")
                                .showInformation();
                    }
                }
            }
        }
        refreshScreen();
        updatePlayerCredit();
    }
    /**
     * update the buy price of everything.
     */
    private void updateBuyPrice() {
        bwp1.setText(Integer.toString(WeaponType.PULSE.getCost()));
        bwp2.setText(Integer.toString(WeaponType.BEAM.getCost()));
        bwp3.setText(Integer.toString(WeaponType.MILITARY.getCost()));

        bsp1.setText(Integer.toString(ShieldType.ENERGY.getCost()));
        bsp2.setText(Integer.toString(ShieldType.REFLECTIVE.getCost()));

        bgp1.setText(Integer.toString(GadgetType.CARGOBAY.getCost()));
        bgp2.setText(Integer.toString(GadgetType.CLOAK.getCost()));
        bgp3.setText(Integer.toString(GadgetType.GPS.getCost()));
        bgp4.setText(Integer.toString(GadgetType.AUTOREPAIR.getCost()));
        bgp5.setText(Integer.toString(GadgetType.TARGETTING.getCost()));

    }
    /**
     * update the sell price of everything.
     */
    private void updateSellPrice() {
        swp1.setText(Integer.toString(WeaponType.PULSE.getSellCost()));
        swp2.setText(Integer.toString(WeaponType.BEAM.getSellCost()));
        swp3.setText(Integer.toString(WeaponType.MILITARY.getSellCost()));

        ssp1.setText(Integer.toString(ShieldType.ENERGY.getSellCost()));
        ssp2.setText(Integer.toString(ShieldType.REFLECTIVE.getSellCost()));

        sgp1.setText(Integer.toString(GadgetType.CARGOBAY.getSellCost()));
        sgp2.setText(Integer.toString(GadgetType.CLOAK.getSellCost()));
        sgp3.setText(Integer.toString(GadgetType.GPS.getSellCost()));
        sgp4.setText(Integer.toString(GadgetType.AUTOREPAIR.getSellCost()));
        sgp5.setText(Integer.toString(GadgetType.TARGETTING.getSellCost()));
    }
    /**
     * Updates player's credit.
     */
    private void updatePlayerCredit() {
        playerCredit.setText(Integer.toString(GameContext.instance()
                .getPlayer().getCredit()));
    }
    /**
     * Updates player's ship's equipment status.
     */
    private void updateEquipStatus() {
        maxWeaponSlots.setText(Integer.toString(GameContext.instance().
                getPlayer().getShip().getShipType().getWeaponSlot()
                .getMaxCapacity()));
        maxShieldSlots.setText(Integer.toString(GameContext.instance().
                getPlayer().getShip().getShipType().getShieldSlot()
                .getMaxCapacity()));
        maxGadgetSlots.setText(Integer.toString(GameContext.instance()
                .getPlayer().getShip().getShipType().getGadgetSlot()
                .getMaxCapacity()));

        myWeapon = GameContext.instance().getPlayer().getShip()
                .getShipType().getWeaponSlot().getWeapons();
        myShield = GameContext.instance().getPlayer().getShip()
                .getShipType().getShieldSlot().getShields();
        myGadget = GameContext.instance().getPlayer().getShip()
                .getShipType().getGadgetSlot().getGadgets();

        if (myWeapon.isEmpty()) {
            weaponLabel.setText("Empty");
        } else {
            weaponLabel.setText(myWeapon.toString());
        }
        if (myShield.isEmpty()) {
            shieldLabel.setText("Empty");
        } else {
            shieldLabel.setText(myShield.toString());
        }
        if (myGadget.isEmpty()) {
            gadgetLabel.setText("Empty");
        } else {
            gadgetLabel.setText(myGadget.toString());
        }
    }
    /**
     * refresh the screen.
     */
    private void refreshScreen() {
        updatePlayerCredit();
        updateEquipStatus();
    }
    /**
     * disable the buttons if appropriate.
     * @param techLevel tech level of current planet
     */
    private void buttonDisabler(final int techLevel) {
        for (int i = 0; i < bbArray.length; i++) {
            if (i <= 2) {
                if (weaponArray.get(i).getMTLV() > techLevel) {
                    bbArray[i].setDisable(true);
                }
            } else if (i > WEAPONIND && i <= SHIELDIND) {
                if (shieldArray.get(i - (SHIELDIND - 1))
                        .getMTLV() > techLevel) {
                    bbArray[i].setDisable(true);
                }
            } else {
               if (gadgetArray.get(i - (SHIELDIND + 1)).getMTLV() > techLevel) {
                   bbArray[i].setDisable(true);
               }
            }
        }
    }
    /**
     * get weapon Array.
     * @return weapon array
     */
    public final List getWeaponArray() {
        return weaponArray;
    }
    /**
     * set array.
     * @param array1 array to be set
     */
    public final void setWeaponArray(final List array1) {
        weaponArray = array1;
    }
    /**
     * get shield array.
     * @return shield array
     */
    public final List getShieldArray() {
        return shieldArray;
    }
    /**
     * set array.
     * @param array1 array to be set
     */
    public final void setShieldArray(final List array1) {
        shieldArray = array1;
    }
    /**
     * get gadgetArray.
     * @return gadget array
     */
    public final List getGadgetArray() {
        return gadgetArray;
    }
    /**
     * set array.
     * @param array1 array to be set
     */
    public final void setGadgetArray(final List array1) {
        gadgetArray = array1;
    }
    /**
     * get my Weapon.
     * @return my weapon array
     */
    public final List getMyWeapon() {
        return myWeapon;
    }
    /**
     * set array.
     * @param array1 array to be set
     */
    public final void setMyWeapon(final List array1) {
        myWeapon = array1;
    }
    /**
     * get my gadget array.
     * @return my gadget array.
     */
    public final List getMyGadget() {
        return myGadget;
    }
    /**
     * set array.
     * @param array1 array to be set
     */
    public final void setMyGadget(final List array1) {
        myGadget = array1;
    }
    /**
     * get my shield array.
     * @return my shield array
     */
    public final List getMyShield() {
        return myShield;
    }
    /**
     * set array.
     * @param array1 array to be set
     */
    public final void setMyShield(final List array1) {
        myShield = array1;
    }
}
