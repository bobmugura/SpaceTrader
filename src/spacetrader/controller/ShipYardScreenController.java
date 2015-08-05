/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import spacetrader.ScreenNavigator;
import spacetrader.enums.Spacecraft;
import spacetrader.model.GameContext;
import spacetrader.model.ShipYard;

/**
 * FXML Controller class
 *
 * @author Kevin & Jasper
 */
public class ShipYardScreenController implements Initializable{
    //Ending with P represent the player
    @FXML private ComboBox cbShipTypes;
    @FXML private Label shipTypesP;
    @FXML private Label maxCargoBay;
    @FXML private Label maxCargoBayP;
    @FXML private Label maxWeaponSlots;
    @FXML private Label maxWeaponSlotsP;
    @FXML private Label maxShieldSlots;
    @FXML private Label maxShieldSlotsP;
    @FXML private Label maxGadgetSlots;
    @FXML private Label maxGadgetSlotsP;
    @FXML private Label maxCrewSize;
    @FXML private Label maxCrewSizeP;
    @FXML private Label maxFuel;
    @FXML private Label maxFuelP;
    @FXML private Label fuelCost;
    @FXML private Label fuelCostP;
    @FXML private Label hullStrength;
    @FXML private Label hullStrengthP;
    @FXML private Label fuelLv;
    @FXML private Label price;
    @FXML private Label creditP;
    @FXML private Button tradeB; //No need
    Spacecraft currentSpacecraftSelected;
    ArrayList <Spacecraft> shipEnums;
    ArrayList<String> shipNames;
    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public final void initialize(URL url, ResourceBundle rb) {
        GameContext instance = GameContext.instance();
        Spacecraft playerShip = instance.getPlayer().getShip().getShipType();
        shipTypesP.setText(playerShip.getName());
        maxCargoBayP.setText(Integer.toString(playerShip.getCargoBay()));
        maxWeaponSlotsP.setText(Integer.toString(playerShip.getWeaponSlot().getMaxCapacity()));
        maxShieldSlotsP.setText(Integer.toString(playerShip.getShieldSlot().getMaxCapacity()));
        maxGadgetSlotsP.setText(Integer.toString(playerShip.getGadgetSlot().getMaxCapacity()));
        maxCrewSizeP.setText(Integer.toString(playerShip.getCrew()));
        maxFuelP.setText(Integer.toString(playerShip.getFuel()));
        fuelCostP.setText(Integer.toString(playerShip.getFuelCost()));
        hullStrengthP.setText(Integer.toString(playerShip.getHullStrength()));
        fuelLv.setText(Integer.toString(instance.getPlayer().getShip().getFuelTank()));
        creditP.setText(Integer.toString(instance.getPlayer().getCredit()));
        shipEnums = new ArrayList<Spacecraft>(EnumSet.of(Spacecraft.FLEA, Spacecraft.GNAT, Spacecraft.FIREFLY, Spacecraft.MOSQUITO, Spacecraft.BUMBLEBEE));
        shipNames = new ArrayList<>();
        for (Spacecraft ship : shipEnums) {
            if (instance.currentPlanet().getTechLevel().getKey() == 4 && ship.getName().equals(ship.FLEA.getName())) {
                shipNames.add(ship.getName());
            } else if (instance.currentPlanet().getTechLevel().getKey() >= 5) {
                shipNames.add(ship.getName());
            }
        }
        cbShipTypes.getItems().setAll(shipNames);
        currentSpacecraftSelected = shipEnums.get(0);
        cbShipTypes.setValue(currentSpacecraftSelected.getName());
        updateShipInfo(currentSpacecraftSelected.getName());
        if (shipNames.size() == 0){
            System.out.println("Planet Tech Level isn't high enough!");
            buttonDisabler();
        } else {
            buttonEnabler();
        }
    }
    /**
     * Ship type Combo box
     */
    @FXML void choiceBoxSelect()
    {
        updateShipInfo((String) cbShipTypes.getValue());
    }
    /**
     * Navigates to Planet screen
     */
    @FXML void clickBackButton()
    {
        ScreenNavigator.loadScreen(ScreenNavigator.PLANET);
    }
    /**
     * Navigates to Equipment Screen
     */
    @FXML void clickEquipmentButton() {
        ScreenNavigator.loadScreen(ScreenNavigator.EQUIPMENT);
    }
    public void updateMyShip()
    {
        shipTypesP.setText(GameContext.instance().getPlayer().getShip().getShipType().getName());
        maxCargoBayP.setText(Integer.toString(GameContext.instance().getPlayer().getShip().getShipType().getCargoBay()));
        maxWeaponSlotsP.setText(Integer.toString(GameContext.instance().getPlayer().getShip().getShipType().getWeaponSlot().getMaxCapacity()));
        maxShieldSlotsP.setText(Integer.toString(GameContext.instance().getPlayer().getShip().getShipType().getShieldSlot().getMaxCapacity()));
        maxGadgetSlotsP.setText(Integer.toString(GameContext.instance().getPlayer().getShip().getShipType().getGadgetSlot().getMaxCapacity()));
        maxCrewSizeP.setText(Integer.toString(GameContext.instance().getPlayer().getShip().getShipType().getCrew()));
        maxFuelP.setText(Integer.toString(GameContext.instance().getPlayer().getShip().getShipType().getFuel()));
        fuelCostP.setText(Integer.toString(GameContext.instance().getPlayer().getShip().getShipType().getFuelCost()));
        hullStrengthP.setText(Integer.toString(GameContext.instance().getPlayer().getShip().getShipType().getHullStrength()));
        fuelLv.setText(Integer.toString(GameContext.instance().getPlayer().getShip().getFuelTank()));
        creditP.setText(Integer.toString(GameContext.instance().getPlayer().getCredit()));
    }
    /**
     * Displays selected ship information
     * @param shipName
     */
    public void updateShipInfo(String shipName) {
        for (Spacecraft shipEnum: shipEnums) {
            if (shipEnum.getName().equals(shipName)) {
                maxCargoBay.setText(Integer.toString(shipEnum.getCargoBay()));
                maxWeaponSlots.setText(Integer.toString(shipEnum.getWeaponSlot().getMaxCapacity()));
                maxShieldSlots.setText(Integer.toString(shipEnum.getShieldSlot().getMaxCapacity()));
                maxGadgetSlots.setText(Integer.toString(shipEnum.getGadgetSlot().getMaxCapacity()));
                maxCrewSize.setText(Integer.toString(shipEnum.getCrew()));
                maxFuel.setText(Integer.toString(shipEnum.getFuel()));
                fuelCost.setText(Integer.toString(shipEnum.getFuelCost()));
                hullStrength.setText(Integer.toString(shipEnum.getHullStrength()));
                price.setText(Integer.toString(shipEnum.getPrice()));
                currentSpacecraftSelected = shipEnum;
            }
        }
    }
    /**
     * Trades-in with currently own ship to a new ship
     */
    @FXML void clickTradeButton() {
        ShipYard shipYard = new ShipYard();
        shipYard.tradeShip(currentSpacecraftSelected);
        //creditP.setText(Integer.toString(GameContext.instance().getPlayer().getCredit()));
        System.out.println("Players current ship is: " + GameContext.instance().getPlayer().getShip().getShipType().getName());
        updateMyShip();
    }
    /**
     * refuels the current ship
     */
    @FXML void clickRefuelButton() {
        GameContext.instance().currentShip().reFuel();
        fuelLv.setText(Integer.toString(GameContext.instance().getPlayer().getShip().getFuelTank()));
        creditP.setText(Integer.toString(GameContext.instance().getPlayer().getCredit()));
    }
    private void buttonDisabler() {
        cbShipTypes.setDisable(true);
        tradeB.setDisable(true);
    }
    private void buttonEnabler() {
        cbShipTypes.setDisable(false);
        tradeB.setDisable(false);
    }
}
