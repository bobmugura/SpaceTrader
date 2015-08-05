/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.controlsfx.dialog.Dialogs;
import spacetrader.ScreenNavigator;
import spacetrader.command.ButtonPress;
import spacetrader.command.Command;
import spacetrader.command.MarketPlaceButton;
import spacetrader.command.RedoTransactionCommand;
import spacetrader.command.UndoTransactionCommand;
import spacetrader.model.Coordinate;
import spacetrader.model.GameContext;
import spacetrader.model.Navigator;
import spacetrader.model.Planet;
import spacetrader.model.Trade;
import spacetrader.model.Transaction;

/**
 * FXML Controller class.
 *
 * @author Keun Lee
 */
public class PlanetScreenController implements Initializable {

    //Sell Price Label -> spl
    @FXML private transient Label spl0; @FXML private transient Label spl1;
    @FXML private transient Label spl2; @FXML private transient Label spl3;
    @FXML private transient Label spl4; @FXML private transient Label spl5;
    @FXML private transient Label spl6; @FXML private transient Label spl7;
    @FXML private transient Label spl8; @FXML private transient Label spl9;
    //Sell Quantity Label -> sql
    @FXML private transient Label sql0; @FXML private transient Label sql1;
    @FXML private transient Label sql2; @FXML private transient Label sql3;
    @FXML private transient Label sql4; @FXML private transient Label sql5;
    @FXML private transient Label sql6; @FXML private transient Label sql7;
    @FXML private transient Label sql8; @FXML private transient Label sql9;
    //Sell Quantity Textfield -> sqt
 @FXML private transient TextField sqt0; @FXML private transient TextField sqt1;
 @FXML private transient TextField sqt2; @FXML private transient TextField sqt3;
 @FXML private transient TextField sqt4; @FXML private transient TextField sqt5;
 @FXML private transient TextField sqt6; @FXML private transient TextField sqt7;
 @FXML private transient TextField sqt8; @FXML private transient TextField sqt9;
    //Sell Button -> sb
    @FXML private transient Button sb0; @FXML private transient Button sb1;
    @FXML private transient Button sb2; @FXML private transient Button sb3;
    @FXML private transient Button sb4; @FXML private transient Button sb5;
    @FXML private transient Button sb6; @FXML private transient Button sb7;
    @FXML private transient Button sb8; @FXML private transient Button sb9;
    //Sell Max -> sm
    @FXML private transient Button sm0; @FXML private transient Button sm1;
    @FXML private transient Button sm2; @FXML private transient Button sm3;
    @FXML private transient Button sm4; @FXML private transient Button sm5;
    @FXML private transient Button sm6; @FXML private transient Button sm7;
    @FXML private transient Button sm8; @FXML private transient Button sm9;
    //Buy Price Label -> bpl
    @FXML private transient Label bpl0; @FXML private transient Label bpl1;
    @FXML private transient Label bpl2; @FXML private transient Label bpl3;
    @FXML private transient Label bpl4; @FXML private transient Label bpl5;
    @FXML private transient Label bpl6; @FXML private transient Label bpl7;
    @FXML private transient Label bpl8; @FXML private transient Label bpl9;
    //Buy Quantity Label -> bql
    @FXML private transient Label bql0; @FXML private transient Label bql1;
    @FXML private transient Label bql2; @FXML private transient Label bql3;
    @FXML private transient Label bql4; @FXML private transient Label bql5;
    @FXML private transient Label bql6; @FXML private transient Label bql7;
    @FXML private transient Label bql8; @FXML private transient Label bql9;
    //Buy Quantity Textfield -> bqt
 @FXML private transient TextField bqt0; @FXML private transient TextField bqt1;
 @FXML private transient TextField bqt2; @FXML private transient TextField bqt3;
 @FXML private transient TextField bqt4; @FXML private transient TextField bqt5;
 @FXML private transient TextField bqt6; @FXML private transient TextField bqt7;
 @FXML private transient TextField bqt8; @FXML private transient TextField bqt9;
    //Buy Button -> bb
    @FXML private transient Button bb0; @FXML private transient Button bb1;
    @FXML private transient Button bb2; @FXML private transient Button bb3;
    @FXML private transient Button bb4; @FXML private transient Button bb5;
    @FXML private transient Button bb6; @FXML private transient Button bb7;
    @FXML private transient Button bb8; @FXML private transient Button bb9;
    //Buy Max -> bm
    @FXML private transient Button bm0; @FXML private transient Button bm1;
    @FXML private transient Button bm2; @FXML private transient Button bm3;
    @FXML private transient Button bm4; @FXML private transient Button bm5;
    @FXML private transient Button bm6; @FXML private transient Button bm7;
    @FXML private transient Button bm8; @FXML private transient Button bm9;

    @FXML private transient Label planetName;
    @FXML private transient Label planetCoordinate;
    @FXML private transient Label planetTechLevel;
    @FXML private transient Label planetResource;
    @FXML private transient Label planetGovernment;
    @FXML private transient Label shipType;
    @FXML private transient Label cargoHold; //Current cargo hold of the ship
    @FXML private transient Label cargoCap; //Current ship's cargo max capacity
    @FXML private transient Label fuelTank; //Current fuel level
    @FXML private transient Label fuelCap; //Fuel Capacity for the Ship
    @FXML private transient Button undoButton;
    @FXML private transient Button redoButton;
    @FXML private transient Label playerName;
    @FXML private transient Label playerCredit;
    private transient Label[] splArray;
    private transient Label[] sqlArray;
    private transient TextField[] sqtArray;
    private transient Button[] sbArray;
    private transient Button[] smArray;
    private transient Label[] bplArray;
    private transient Label[] bqlArray;
    private transient TextField[] bqtArray;
    private transient Button[] bbArray;
    private transient Button[] bmArray;
    private transient Coordinate coordinate;
    private transient Trade trade;
    private transient List<Transaction> undoList;
    private transient List<Transaction> redoList;
    private transient ButtonPress commandButton;
    private transient Command redo;
    private transient Command undo;
    /**
     * Command button to undo and redo transaction.
     * @param event Action listener
     */
    @FXML public final void commandButtonListener(final ActionEvent event) {
        if (event.getSource().equals(undoButton) && (!undoList.isEmpty())) {
            final Transaction tran = undoList.get(undoList.size() - 1);
            redoList.add(tran);
            commandButton.execute(undo, tran);
        } else if (event.getSource().equals(redoButton)
                && (!redoList.isEmpty())) {
            final Transaction tran = redoList.get(undoList.size() - 1);
            undoList.add(tran);
            commandButton.execute(redo, tran);
        } else {
            Dialogs.create()
            .title("Command Status")
            .message("No Match")
            .showInformation();
        }
        refreshScreen();
    }

    /**
     * Navigates to navigation screen.
     */
    @FXML public final void openNavigationScreen() {
        final Navigator navigator = new Navigator();
        if (navigator.sortCoordinateArray().isEmpty()) {
            Dialogs.create()
            .title("Navigation Status")
            .message("Need more Fuel")
            .showInformation();
        } else {
            ScreenNavigator.loadScreen(ScreenNavigator.NAVIGATE);

        }
    }
    @FXML public final void openBankingScreen() {
        ScreenNavigator.loadScreen(ScreenNavigator.BANKING);
    }    
    /**
     * Navigates to ship yard screen.
     */
    @FXML public final void openShipYardScreen() {
        ScreenNavigator.loadScreen(ScreenNavigator.SHIPYARD);
    }
    /**
     * Checks the input if it is in integer.
     * @param event Key listener
     */
    @FXML public final void intInputChecker(final KeyEvent event) {
        final String oldText = event.getText();
        String emptyString;
        emptyString = "";
        try {
            if (oldText.equals(emptyString)) {
                Dialogs.create()
                .title("Number Input")
                .message("Please input a quantity number")
                .showInformation();
                return;
            }
            final int newIntText = Integer.parseInt(oldText);
        } catch (NumberFormatException e) {
            Dialogs.create()
                .title("Title")
                .message("Please type in integers only")
                .showInformation();
            ((TextField) event.getSource()).clear();
        }
    }
    /**
     * Sells the amount of the selected goods.
     * @param event action listener
     */
    @FXML public final void sellButtonClick(final ActionEvent event) {
        int input;
        for (int i = 0; i < sbArray.length; i++) {
            if (event.getSource().equals(sbArray[i])) {
                try {
                    input = Integer.parseInt(sqtArray[i].getText());
                } catch (NumberFormatException e) {
                    Dialogs.create()
                    .title("Status")
                    .message("Please type in how many you want to sell")
                    .showInformation();
                    break;
                }
                if (input > Integer.parseInt(sqlArray[i].getText())) {
                    Dialogs.create()
                    .title("Status")
                    .message("You cannot sell more than you have.")
                    .showInformation();
                    break;
                } else {
                    final int price = Integer.parseInt(splArray[i].getText());
                    if (trade.sellable(price, input)) {
                        trade.sellTransaction(price, input, i);
                        undoList.add(new Transaction(price * input, input, i));
                        refreshScreen();
                    } else {
                        Dialogs.create()
                        .title("Status")
                        .message("Transaction canceled.")
                        .showInformation();
                    }
                }
                textFieldEraser(i, 0);
            }
        }
    }
    /**
     * Sells maximum amount of what player holds for that good.
     * @param event action listener
     */
    @FXML public final void sellMaxClick(final ActionEvent event) {
        for (int i = 0; i < smArray.length; i++) {
            if (event.getSource().equals(smArray[i])) {
                trade.sellMax(Integer.parseInt(splArray[i].getText()), i);
                undoList.add(new Transaction(Integer.parseInt(splArray[i]
                    .getText()) * GameContext.instance().getPlayer().getShip()
                    .getQuantity().getWithKey(i), GameContext.instance()
                    .getPlayer().getShip().getQuantity().getWithKey(i), i));
                refreshScreen();
                break;
            }
        }
        for (int i = 0; i < smArray.length; i++) {
            textFieldEraser(i, 0);
        }
    }
    /**
     * Buys the amount of the selected goods.
     * @param event action listener
     */
    @FXML public final void buyButtonClick(final ActionEvent event) {
        int input;
        for (int i = 0; i < bbArray.length; i++) {
            if (event.getSource().equals(bbArray[i])) {
                try {
                    input = Integer.parseInt(bqtArray[i].getText());
                } catch (NumberFormatException e) {
                    Dialogs.create()
                        .title("Status ")
                        .message("Please type in how many you want to buy")
                        .showInformation();
                    return;
                }
                if (input > Integer.parseInt(bqlArray[i].getText())) {
                    Dialogs.create()
                        .title("Status ")
                        .message("Market doesn't have enough stock")
                        .showInformation();
                } else {
                    final int price = Integer.parseInt(bplArray[i].getText());
                    if (trade.buyable(price, input)) {
                        trade.buyTransaction(price, input, i);
                        undoList.add(new Transaction(-(
                                price * input), input, i));
                        refreshScreen();
                    } else {
                        Dialogs.create()
                        .title("Status ")
                        .message("Transaction cancelled")
                        .showInformation();
                    }
                }
                break;
            }
        }
        for (int i = 0; i < bbArray.length; i++) {
            textFieldEraser(i, 1);
        }
    }
    /**
     * Buys maximum amount of the selected goods with player's credit.
     * @param event action listener
     */
    @FXML public final void buyMaxClick(final ActionEvent event) {
        for (int i = 0; i < bmArray.length; i++) {
            if (event.getSource().equals(bmArray[i])) {
                trade.buyMax(Integer.parseInt(bplArray[i].getText()), i);
                undoList.add(new Transaction(Integer.parseInt(
                        bplArray[i].getText()), i));
                refreshScreen();
                break;
            }
        }
        for (int i = 0; i < bmArray.length; i++) {
            textFieldEraser(i, 1);
        }
    }
    /**
     * Refreshes screen.
     */
    private void refreshScreen() {
        final GameContext instance = GameContext.instance();
        int[] planetQuantity = instance.getUniverse().get(coordinate)
                .getQuantity().getAll();
        final int[] cargoQuantity = instance.getPlayer().getShip()
                .getQuantity().getAll();
        for (int i = 0; i < bmArray.length; i++) {
            bqlArray[i].setText(Integer.toString(planetQuantity[i]));
            sqlArray[i].setText(Integer.toString(cargoQuantity[i]));
        }
        buttonDisabler();
        playerCredit.setText(Integer.toString(
                instance.getPlayer().getCredit()));
        cargoHold.setText(Integer.toString(
                instance.getPlayer().getShip().getQuantity().countAll()));
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Planet screen");
        splArray = new Label[]{spl0, spl1, spl2, spl3, spl4, spl5
                , spl6, spl7, spl8, spl9};
        sqlArray = new Label[]{sql0, sql1, sql2, sql3, sql4, sql5
                , sql6, sql7, sql8, sql9};
        sqtArray = new TextField[]{sqt0, sqt1, sqt2, sqt3, sqt4, sqt5
                , sqt6, sqt7, sqt8, sqt9};
        sbArray = new Button[]{sb0, sb1, sb2, sb3, sb4, sb5
                , sb6, sb7, sb8, sb9};
        smArray = new Button[]{sm0, sm1, sm2, sm3, sm4, sm5
                , sm6, sm7, sm8, sm9};
        bplArray = new Label[]{bpl0, bpl1, bpl2, bpl3, bpl4, bpl5
                , bpl6, bpl7, bpl8, bpl9};
        bqlArray = new Label[]{bql0, bql1, bql2, bql3, bql4, bql5
                , bql6, bql7, bql8, bql9};
        bqtArray = new TextField[]{bqt0, bqt1, bqt2, bqt3, bqt4, bqt5
                , bqt6, bqt7, bqt8, bqt9};
        bbArray = new Button[]{bb0, bb1, bb2, bb3, bb4, bb5
                , bb6, bb7, bb8, bb9};
        bmArray = new Button[]{bm0, bm1, bm2, bm3, bm4, bm5
                , bm6, bm7, bm8, bm9};

        GameContext instance;
        instance = GameContext.instance();
        coordinate = instance.getPlayer().getCoordinate();
        Planet planet;
        planet = instance.getUniverse().get(coordinate);
        trade = new Trade();
        playerCredit.setText(Integer.toString(instance
                .getPlayer().getCredit()));
        playerName.setText(instance.getPlayer().getName());
        planetName.setText(planet.getName());
        planetCoordinate.setText(planet.getCoordinate().toString());
        planetTechLevel.setText(planet.getTechLevel().toString());
        planetResource.setText(planet.getEnvironment().toString());
        planetGovernment.setText(planet.getGovernment().toString());
        shipType.setText(instance.getPlayer().getShip()
                .getShipType().getName());
        cargoHold.setText(Integer.toString(instance.getPlayer()
                .getShip().getQuantity().countAll()));
        cargoCap.setText(Integer.toString(instance.getPlayer()
                .getShip().getShipType().getCargoBay()));
        fuelTank.setText(Integer.toString(instance.getPlayer()
                .getShip().getFuelTank()));
        fuelCap.setText(Integer.toString(instance.getPlayer()
                .getShip().getShipType().getFuel()));
        undoList = new LinkedList();
        redoList = new LinkedList();
        commandButton = new ButtonPress();
        undo = new UndoTransactionCommand(new MarketPlaceButton());
        redo = new RedoTransactionCommand(new MarketPlaceButton());

        planet.calculateMarketPlace();
        List<Integer> buyPrice;
        buyPrice = planet.getBuyPrices();
        List<Integer> sellPrice;
        sellPrice = planet.getSellPrices();
        if (sellPrice.size() == sbArray.length) {
            for (int i = 0; i < sbArray.length; i++) {
                splArray[i].setText(Integer.toString(sellPrice.get(i)));
            }
        } else {
            Dialogs.create()
                .title(" Status")
                .message("Marketplace returned wrong value")
                .showInformation();
        }
        if (buyPrice.size() == bbArray.length) {
            for (int i = 0; i < bbArray.length; i++) {
                bplArray[i].setText(Integer.toString(buyPrice.get(i)));
            }
        } else {
            Dialogs.create()
                .title(" Status")
                .message("Marketplace returned wrong value")
                .showInformation();
        }
        int[] planetQuantity;
        planetQuantity = instance.getUniverse().get(coordinate)
                .getQuantity().getAll();
        int[] cargoQuantity;
        cargoQuantity = instance.getPlayer().getShip()
                .getQuantity().getAll();
        for (int i = 0; i < bbArray.length; i++) {
            bqlArray[i].setText(Integer.toString(planetQuantity[i]));
            sqlArray[i].setText(Integer.toString(cargoQuantity[i]));
        }
        buttonDisabler();
    }
    /**
     * Deletes all the textfields.
     * @param key keynum
     * @param sbutton button
     */
    private void textFieldEraser(final int key, final int sbutton) {
        if (sbutton == 0) {
            sqtArray[key].clear();
        } else {
            bqtArray[key].clear();
        }
    }
    /**
     * Disables all the buttons.
     */
    private void buttonDisabler() {
        for (int i = 0; i < bbArray.length; i++) {
            if (bqlArray[i].getText().equals("0")) {
                bbArray[i].setDisable(true);
                bmArray[i].setDisable(true);
            } else {
                bbArray[i].setDisable(false);
                bmArray[i].setDisable(false);
            }
            if (sqlArray[i].getText().equals("0")) {
                sbArray[i].setDisable(true);
                smArray[i].setDisable(true);
            } else {
                sbArray[i].setDisable(false);
                smArray[i].setDisable(false);
            }
        }
    }
    /**
     * Navigates to ship yard screen.
     */
    @FXML public final void openStockMarketScreen() {
        ScreenNavigator.loadScreen(ScreenNavigator.STOCKMARKET);
    }
}
