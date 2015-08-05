/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import spacetrader.ScreenNavigator;
import spacetrader.model.Banking;
import spacetrader.model.GameContext;
import spacetrader.model.Player;

/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class BankingScreenController implements Initializable {
    @FXML private Label creditP;
    @FXML private Label interestRate;
    @FXML private Label loanedAmount;
    @FXML private TextField loanInput;
    @FXML private TextField payInput;
    
    private Banking bank = new Banking();
    
    @FXML void clickBackButton() {
        ScreenNavigator.loadScreen(ScreenNavigator.PLANET);
    }

    @FXML void clickLoanButton() {
        final int loaningAmount = Integer.parseInt(loanInput.getText());
        //Banking bank = new Banking(GameContext.instance().getPlayer().getCurrentLoan());
        bank.getLoan(GameContext.instance().getPlayer(), loaningAmount);
        refreshScreen();
    }
    
    @FXML void clickPayButton() {
        final int payingAmount = Integer.parseInt(payInput.getText());
        //Banking bank = new Banking(GameContext.instance().getPlayer().getCurrentLoan());
        bank.payLoan(GameContext.instance().getPlayer(), payingAmount);
        refreshScreen();       
    }
    private void refreshScreen() {
        Player myPlayer = GameContext.instance().getPlayer();
        //Banking bank = new Banking(myPlayer.getCurrentLoan());
        creditP.setText(Integer.toString(myPlayer.getCredit()));
        loanedAmount.setText(Integer.toString(bank.getCurrentLoan()));
        interestRate.setText(Double.toString(bank.getInterestRate(myPlayer)));
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Player myPlayer = GameContext.instance().getPlayer();
        //Banking bank = new Banking(myPlayer.getCurrentLoan());
        creditP.setText(Integer.toString(myPlayer.getCredit()));
        loanedAmount.setText(Integer.toString(bank.getCurrentLoan()));
        interestRate.setText(Double.toString(bank.getInterestRate(myPlayer)));
        
    }
}
