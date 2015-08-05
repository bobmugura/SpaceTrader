/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.dialog.Dialogs;
import spacetrader.ScreenNavigator;
import spacetrader.model.GameContext;
import spacetrader.model.Planet;
import spacetrader.model.Stock;
import spacetrader.model.StockHolder;
import spacetrader.model.Trade;
import spacetrader.model.Transaction;

/**
 *
 * @author Kevin
 */
public class StockScreenController implements Initializable{
    
    @FXML private Label planet1;
    @FXML private Label planet2;
    @FXML private Label planet3;
    @FXML private Label planet4;
    @FXML private Label planet5;
    @FXML private Label planet6;
    @FXML private Label planet7;
    @FXML private Label planet8;
    @FXML private Label planet9;
    @FXML private Label planet10;
    @FXML private Label planet11;
    @FXML private Label planet12;
    @FXML private Label planet13;
    @FXML private Label planet14;
    @FXML private Label planet15;
    @FXML private Label planet16;
    @FXML private Label planet17;
    @FXML private Label planet18;
    @FXML private Label planet19;
    @FXML private Label planet20;
    @FXML private Label planet21;
    @FXML private Label planet22;
    @FXML private Label planet23;
    @FXML private Label planet24;
    @FXML private Label planet25;
    @FXML private ArrayList<Label> labelPlanets;
    
    @FXML private Label playerCreditLabel;
    @FXML private Label playerNameLabel;
    
    @FXML private Label price1;
    @FXML private Label price2;
    @FXML private Label price3;
    @FXML private Label price4;
    @FXML private Label price5;
    @FXML private Label price6;
    @FXML private Label price7;
    @FXML private Label price8;
    @FXML private Label price9;
    @FXML private Label price10;
    @FXML private Label price11;
    @FXML private Label price12;
    @FXML private Label price13;
    @FXML private Label price14;
    @FXML private Label price15;
    @FXML private Label price16;
    @FXML private Label price17;
    @FXML private Label price18;
    @FXML private Label price19;
    @FXML private Label price20;
    @FXML private Label price21;
    @FXML private Label price22;
    @FXML private Label price23;
    @FXML private Label price24;
    @FXML private Label price25;
    
    @FXML private ArrayList<Label> labelPrices;
    
    @FXML private Label interest1;
    @FXML private Label interest2;
    @FXML private Label interest3;
    @FXML private Label interest4;
    @FXML private Label interest5;
    @FXML private Label interest6;
    @FXML private Label interest7;
    @FXML private Label interest8;
    @FXML private Label interest9;
    @FXML private Label interest10;
    @FXML private Label interest11;
    @FXML private Label interest12;
    @FXML private Label interest13;
    @FXML private Label interest14;
    @FXML private Label interest15;
    @FXML private Label interest16;
    @FXML private Label interest17;
    @FXML private Label interest18;
    @FXML private Label interest19;
    @FXML private Label interest20;
    @FXML private Label interest21;
    @FXML private Label interest22;
    @FXML private Label interest23;
    @FXML private Label interest24;
    @FXML private Label interest25;
    
    @FXML private ArrayList<Label> labelInterests;
    
    @FXML private Button buy1;
    @FXML private Button buy2;
    @FXML private Button buy3;
    @FXML private Button buy4;
    @FXML private Button buy5;
    @FXML private Button buy6;
    @FXML private Button buy7;
    @FXML private Button buy8;
    @FXML private Button buy9;
    @FXML private Button buy10;
    @FXML private Button buy11;
    @FXML private Button buy12;
    @FXML private Button buy13;
    @FXML private Button buy14;
    @FXML private Button buy15;
    @FXML private Button buy16;
    @FXML private Button buy17;
    @FXML private Button buy18;
    @FXML private Button buy19;
    @FXML private Button buy20;
    @FXML private Button buy21;
    @FXML private Button buy22;
    @FXML private Button buy23;
    @FXML private Button buy24;
    @FXML private Button buy25;
    
    @FXML private ArrayList<Button> buyButtonList;
    
    @FXML private Button sell1;
    @FXML private Button sell2;
    @FXML private Button sell3;
    @FXML private Button sell4;
    @FXML private Button sell5;
    @FXML private Button sell6;
    @FXML private Button sell7;
    @FXML private Button sell8;
    @FXML private Button sell9;
    @FXML private Button sell10;
    @FXML private Button sell11;
    @FXML private Button sell12;
    @FXML private Button sell13;
    @FXML private Button sell14;
    @FXML private Button sell15;
    @FXML private Button sell16;
    @FXML private Button sell17;
    @FXML private Button sell18;
    @FXML private Button sell19;
    @FXML private Button sell20;
    @FXML private Button sell21;
    @FXML private Button sell22;
    @FXML private Button sell23;
    @FXML private Button sell24;
    @FXML private Button sell25;
    
    @FXML private ArrayList<Button> sellButtonList;
    
    //bqt = buy quantity textbox
    @FXML private TextField bqt1;
    @FXML private TextField bqt2;
    @FXML private TextField bqt3;
    @FXML private TextField bqt4;
    @FXML private TextField bqt5;
    @FXML private TextField bqt6;
    @FXML private TextField bqt7;
    @FXML private TextField bqt8;
    @FXML private TextField bqt9;
    @FXML private TextField bqt10;
    @FXML private TextField bqt11;
    @FXML private TextField bqt12;
    @FXML private TextField bqt13;
    @FXML private TextField bqt14;
    @FXML private TextField bqt15;
    @FXML private TextField bqt16;
    @FXML private TextField bqt17;
    @FXML private TextField bqt18;
    @FXML private TextField bqt19;
    @FXML private TextField bqt20;
    @FXML private TextField bqt21;
    @FXML private TextField bqt22;
    @FXML private TextField bqt23;
    @FXML private TextField bqt24;
    @FXML private TextField bqt25;
    
    @FXML private Label inv1;
    @FXML private Label inv2;
    @FXML private Label inv3;
    @FXML private Label inv4;
    @FXML private Label inv5;
    @FXML private Label inv6;
    @FXML private Label inv7;
    @FXML private Label inv8;
    @FXML private Label inv9;
    @FXML private Label inv10;
    @FXML private Label inv11;
    @FXML private Label inv12;
    @FXML private Label inv13;
    @FXML private Label inv14;
    @FXML private Label inv15;
    @FXML private Label inv16;
    @FXML private Label inv17;
    @FXML private Label inv18;
    @FXML private Label inv19;
    @FXML private Label inv20;
    @FXML private Label inv21;
    @FXML private Label inv22;
    @FXML private Label inv23;
    @FXML private Label inv24;
    @FXML private Label inv25;
    
    
    @FXML private ArrayList<Label> labelInvList;
    @FXML private ArrayList<TextField> bqtList;
    @FXML private ArrayList<String> planetNames;
    
    GameContext instance;
    Trade trade;
    
    @Override
    public final void initialize(final URL url,final ResourceBundle resourceb) {
        instance = GameContext.instance();
        trade = new Trade();
        labelPlanets = new ArrayList<Label>();
        labelInterests = new ArrayList<>();
        labelPrices = new ArrayList<>();
        buyButtonList = new ArrayList<Button>();
        bqtList = new ArrayList<TextField>();
        sellButtonList = new ArrayList<Button>();
        labelInvList = new ArrayList<>();
        
        labelPlanets.add(planet1);
        labelPlanets.add(planet2);
        labelPlanets.add(planet3);
        labelPlanets.add(planet4);
        labelPlanets.add(planet5);
        labelPlanets.add(planet6);
        labelPlanets.add(planet7);
        labelPlanets.add(planet8);
        labelPlanets.add(planet9);
        labelPlanets.add(planet10);
        labelPlanets.add(planet11);
        labelPlanets.add(planet12);
        labelPlanets.add(planet13);
        labelPlanets.add(planet14);
        labelPlanets.add(planet15);
        labelPlanets.add(planet16);
        labelPlanets.add(planet17);
        labelPlanets.add(planet18);
        labelPlanets.add(planet19);
        labelPlanets.add(planet20);
        labelPlanets.add(planet21);
        labelPlanets.add(planet22);
        labelPlanets.add(planet23);
        labelPlanets.add(planet24);
        labelPlanets.add(planet25);
        
        labelInterests.add(interest1);
        labelInterests.add(interest2);
        labelInterests.add(interest3);
        labelInterests.add(interest4);
        labelInterests.add(interest5);
        labelInterests.add(interest6);
        labelInterests.add(interest7);
        labelInterests.add(interest8);
        labelInterests.add(interest9);
        labelInterests.add(interest10);
        labelInterests.add(interest11);
        labelInterests.add(interest12);
        labelInterests.add(interest13);
        labelInterests.add(interest14);
        labelInterests.add(interest15);
        labelInterests.add(interest16);
        labelInterests.add(interest17);
        labelInterests.add(interest18);
        labelInterests.add(interest19);
        labelInterests.add(interest20);
        labelInterests.add(interest21);
        labelInterests.add(interest22);
        labelInterests.add(interest23);
        labelInterests.add(interest24);
        labelInterests.add(interest25);
        
        labelPrices.add(price1);
        labelPrices.add(price2);
        labelPrices.add(price3);
        labelPrices.add(price4);
        labelPrices.add(price5);
        labelPrices.add(price6);
        labelPrices.add(price7);
        labelPrices.add(price8);
        labelPrices.add(price9);
        labelPrices.add(price10);
        labelPrices.add(price11);
        labelPrices.add(price12);
        labelPrices.add(price13);
        labelPrices.add(price14);
        labelPrices.add(price15);
        labelPrices.add(price16);
        labelPrices.add(price17);
        labelPrices.add(price18);
        labelPrices.add(price19);
        labelPrices.add(price20);
        labelPrices.add(price21);
        labelPrices.add(price22);
        labelPrices.add(price23);
        labelPrices.add(price24);
        labelPrices.add(price25);
        
        buyButtonList.add(buy1);
        buyButtonList.add(buy2);
        buyButtonList.add(buy3);
        buyButtonList.add(buy4);
        buyButtonList.add(buy5);
        buyButtonList.add(buy6);
        buyButtonList.add(buy7);
        buyButtonList.add(buy8);
        buyButtonList.add(buy9);
        buyButtonList.add(buy10);
        buyButtonList.add(buy11);
        buyButtonList.add(buy12);
        buyButtonList.add(buy13);
        buyButtonList.add(buy14);
        buyButtonList.add(buy15);
        buyButtonList.add(buy16);
        buyButtonList.add(buy17);
        buyButtonList.add(buy18);
        buyButtonList.add(buy19);
        buyButtonList.add(buy20);
        buyButtonList.add(buy21);
        buyButtonList.add(buy22);
        buyButtonList.add(buy23);
        buyButtonList.add(buy24);
        buyButtonList.add(buy25);
        
        sellButtonList.add(sell1);
        sellButtonList.add(sell2);
        sellButtonList.add(sell3);
        sellButtonList.add(sell4);
        sellButtonList.add(sell5);
        sellButtonList.add(sell6);
        sellButtonList.add(sell7);
        sellButtonList.add(sell8);
        sellButtonList.add(sell9);
        sellButtonList.add(sell10);
        sellButtonList.add(sell11);
        sellButtonList.add(sell12);
        sellButtonList.add(sell13);
        sellButtonList.add(sell14);
        sellButtonList.add(sell15);
        sellButtonList.add(sell16);
        sellButtonList.add(sell17);
        sellButtonList.add(sell18);
        sellButtonList.add(sell19);
        sellButtonList.add(sell20);
        sellButtonList.add(sell21);
        sellButtonList.add(sell22);
        sellButtonList.add(sell23);
        sellButtonList.add(sell24);
        sellButtonList.add(sell25);
        
        bqtList.add(bqt1);
        bqtList.add(bqt2);
        bqtList.add(bqt3);
        bqtList.add(bqt4);
        bqtList.add(bqt5);
        bqtList.add(bqt6);
        bqtList.add(bqt7);
        bqtList.add(bqt8);
        bqtList.add(bqt9);
        bqtList.add(bqt10);
        bqtList.add(bqt11);
        bqtList.add(bqt12);
        bqtList.add(bqt13);
        bqtList.add(bqt14);
        bqtList.add(bqt15);
        bqtList.add(bqt16);
        bqtList.add(bqt17);
        bqtList.add(bqt18);
        bqtList.add(bqt19);
        bqtList.add(bqt20);
        bqtList.add(bqt21);
        bqtList.add(bqt22);
        bqtList.add(bqt23);
        bqtList.add(bqt24);
        bqtList.add(bqt25);
        
        labelInvList.add(inv1);
        labelInvList.add(inv2);
        labelInvList.add(inv3);
        labelInvList.add(inv4);
        labelInvList.add(inv5);
        labelInvList.add(inv6);
        labelInvList.add(inv7);
        labelInvList.add(inv8);
        labelInvList.add(inv9);
        labelInvList.add(inv10);
        labelInvList.add(inv11);
        labelInvList.add(inv12);
        labelInvList.add(inv13);
        labelInvList.add(inv14);
        labelInvList.add(inv15);
        labelInvList.add(inv16);
        labelInvList.add(inv17);
        labelInvList.add(inv18);
        labelInvList.add(inv19);
        labelInvList.add(inv20);
        labelInvList.add(inv21);
        labelInvList.add(inv22);
        labelInvList.add(inv23);
        labelInvList.add(inv24);
        labelInvList.add(inv25);
        
        ArrayList<Stock> stockList = new ArrayList<>();
        planetNames = instance.planetNames();
        for (int i = 0; i < 25; i++) {
            labelPlanets.get(i).setText(planetNames.get(i));
            Stock stockToAdd = new Stock((Planet) instance.getUniverse().values().toArray()[i]);
            stockList.add(stockToAdd);
            labelPrices.get(i).setText(Integer.toString(stockToAdd.getPrice()));
            labelInterests.get(i).setText(Double.toString(stockToAdd.getInterest()*100));
        }
        playerNameLabel.setText(instance.getPlayer().getName());
        playerCreditLabel.setText(Integer.toString(instance.getPlayer().getCredit()));
    }
    
    /**
     * Navigates to Planet screen
     */
    @FXML void clickBackButton()
    {
        ScreenNavigator.loadScreen(ScreenNavigator.PLANET);
    }
    
    /**
     * Buys the amount of the selected goods.
     * @param event action listener
     */
    @FXML public final void buyButtonClick(final ActionEvent event) {
        int input;
        for (int i = 0; i < buyButtonList.size(); i++) {
            if (event.getSource().equals(buyButtonList.get(i))) {
                try {
                    input = Integer.parseInt(bqtList.get(i).getText());
                } catch (NumberFormatException e) {
                    Dialogs.create()
                        .title("Status ")
                        .message("Please type in how many you want to buy")
                        .showInformation();
                    return;
                }
                final int price = Integer.parseInt(labelPrices.get(i).getText());
                System.out.println("Attempting trade.buy");
                if (trade.stockBuyable(price, input, i)) {
                   trade.buyStock(price, input, i);
                }
                break;
            }
        }
        refreshScreen();
        textFieldEraser();
    }
    
    /**
     * Sells the amount of the selected goods.
     * @param event action listener
     */
    @FXML public final void sellButtonClick(final ActionEvent event) {
        int input;
        for (int i = 0; i < sellButtonList.size(); i++) {
            if (event.getSource().equals(sellButtonList.get(i))) {
                try {
                    input = Integer.parseInt(bqtList.get(i).getText());
                } catch (NumberFormatException e) {
                    Dialogs.create()
                    .title("Status")
                    .message("Please type in integers only")
                    .showInformation();
                    break;
                }
                final int price = Integer.parseInt(labelPrices.get(i).getText());
                if (trade.sellableStock(price, input, planetNames.get(i))) {
                    trade.sellStock(price, input, planetNames.get(i));
                    refreshScreen();
                } else {
                    Dialogs.create()
                    .title("Status")
                    .message("Transaction canceled.")
                    .showInformation();
                }
                textFieldEraser();
                refreshScreen();
            }
        }
    }
                
    /**
     * Deletes all the textfields.
     * @param key keynum
     * @param sbutton button
     */
    private void textFieldEraser() {
        for (int i = 0; i < bqtList.size(); i++) {
            bqtList.get(i).clear();
        }
    }

    /**
     * Refreshes screen.
     */
    private void refreshScreen() {
        ArrayList<StockHolder> stocks = GameContext.instance().getPlayer().getStocks();
        playerCreditLabel.setText(Integer.toString(instance.getPlayer().getCredit()));
        for (int i = 0; i < planetNames.size(); i++) {
            for (int j = 0; j < stocks.size(); j++) {
                if (planetNames.get(i).equals(stocks.get(j).getStock().getName())) {
                    labelInvList.get(i).setText(Integer.toString(stocks.get(j).getQuantity()));
                }
            } 
        }
    }
}
