/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import spacetrader.model.GameContext;
import spacetrader.model.Player;
import spacetrader.ScreenNavigator;
import spacetrader.model.WorldGenerator;

/**
 * FXML Controller class.
 *
 * @author Keun Lee
 */
public class ConfigurationDialogController implements Initializable {
    /**
     * max points player can distribute.
     */
    private static final int MAXPOINTS = 15;
    /**
     * current player points.
     */
    private int points;
    /**
     * players pilot points.
     */
    private int pilot;
    /**
     * player's fighter points.
     */
    private int fighter;
    /**
     * player's trader points.
     */
    private int trader;
    /**
     * player's engineer points.
     */
    private int engineer;
    /**
     * player's investor points.
     */
    private int investor;

    /**
     * Initializes the controller class.
     */
    /**@FXML
    private transient Button acceptButton;
    @FXML
    private Button cancelButton;*/
    /**
     * names text field.
     */
    @FXML
    private transient TextField nameField;
    /**
     * self explanatory.
     */
    @FXML
    private transient Label pointsLabel;
    /**
     * self explanatory.
     */
    @FXML
    private transient Label pilotLabel;
    /**
     * self explanatory.
     */
    @FXML
    private transient Label fighterLabel;
    /**
     * self explanatory.
     */
    @FXML
    private transient Label traderLabel;
    /**
     * self explanatory.
     */
    @FXML
    private transient Label engineerLabel;
    /**
     * self explanatory.
     */
    @FXML
    private transient Label investorLabel;
    /**
     * self explanatory.
     */
    @FXML
    private transient Button pilotUp;
    /**
     * self explanatory.
     */
    @FXML
    private transient Button pilotDown;
    /**
     * self explanatory.
     */
    @FXML
    private transient Button fighterUp;
    /**
     * self explanatory.
     */
    @FXML
    private transient Button fighterDown;
    /**
     * self explanatory.
     */
    @FXML
    private transient Button traderUp;
    /**
     * self explanatory.
     */
    @FXML
    private transient Button traderDown;
    /**
     * self explanatory.
     */
    @FXML
    private transient Button engineerUp;
    /**
     * self explanatory.
     */
    @FXML
    private transient Button engineerDown;
    /**
     * self explanatory.
     */
    @FXML
    private transient Button investorUp;
    /**
     * self explanatory.
     */
    @FXML
    private transient Button investorDown;

    /**
     * ActionListener for the 'cancel' button.
     * @param event event that occurs when linked button is pressed
     */
    @FXML
    public final void openWelcomeScreen(final ActionEvent event) {
        ScreenNavigator.loadScreen(ScreenNavigator.MENU);
    }
    /**
     * ActionListener for 'accept' button.
     * Creation of the universe and the player occurs.
     * @param event even that occurs when linked button is pressed
     */
    @FXML
    public final void openGameScreen(final ActionEvent event) {
        if ((points == 0) && !(nameField.getText().isEmpty())) {
            final Player player = new Player(nameField.getText(), pilot,
                    fighter, trader, engineer, investor);
            GameContext.instance().loadPlayer(player);
            new WorldGenerator().newGame();
            ScreenNavigator.loadScreen(ScreenNavigator.GAME);
        }
    }
    /**
     * ActionListener for the pilot level control buttons.
     * @param event event that occurs when linked button is pressed
     */
    @FXML
    public final void pilotLevelChange(final ActionEvent event) {
        if (points > 0 && event.getSource().equals(pilotUp)) {
            pilot++;
            points--;
        } else if (pilot > 0 && event.getSource().equals(pilotDown)) {
            pilot--;
            points++;
        }
        pilotLabel.setText(Integer.toString(pilot));
        updatePointsLabel();
    }
    /**
     * ActionListener for the fighter level control buttons.
     * @param event occurs when linked button is pressed
     */
    public final void fighterLevelChange(final ActionEvent event) {
        if (points > 0 && event.getSource().equals(fighterUp)) {
            fighter++;
            points--;
        } else if (fighter > 0 && event.getSource().equals(fighterDown)) {
            fighter--;
            points++;
        }
        fighterLabel.setText(Integer.toString(fighter));
        updatePointsLabel();
    }
    /**
     * ActionListener for the trader level control buttons.
     * @param event occurs when linked button is pressed
     */
    public final void traderLevelChange(final ActionEvent event) {
        if (points > 0 && event.getSource().equals(traderUp)) {
            trader++;
            points--;
        } else if (trader > 0 && event.getSource().equals(traderDown)) {
            trader--;
            points++;
        }
        traderLabel.setText(Integer.toString(trader));
        updatePointsLabel();
    }
    /**
     * ActionListener for the engineer level control buttons.
     * @param event when linked button is pressed
     */
    public final void engineerLevelChange(final ActionEvent event) {
        if (points > 0 && event.getSource().equals(engineerUp)) {
            engineer++;
            points--;
        } else if (engineer > 0 && event.getSource().equals(engineerDown)) {
            engineer--;
            points++;
        }
        engineerLabel.setText(Integer.toString(engineer));
        updatePointsLabel();
    }
    /**
     * ActionListener for the investor level control buttons.
     * @param event occurs when linked button is pressed
     */
    public final void investorLevelChange(final ActionEvent event) {
        if (points > 0 && event.getSource().equals(investorUp)) {
            investor++;
            points--;
        } else if (investor > 0 && event.getSource().equals(investorDown)) {
            investor--;
            points++;
        }
        investorLabel.setText(Integer.toString(investor));
        updatePointsLabel();
    }

    /**
     * update the points level on the view.
     */
    private void updatePointsLabel() {
        pointsLabel.setText(Integer.toString(points));
    }

    @Override
    /**
     * Runs when the ConfigurationDialog screen loads
     * Set the screen to default.
     */
    public final void initialize(final URL url,
            final ResourceBundle resourceb) {
        points = MAXPOINTS;
        pilot = 0;
        fighter = 0;
        trader = 0;
        engineer = 0;
        investor = 0;
        pointsLabel.setText(Integer.toString(points));
        pilotLabel.setText("0");
        fighterLabel.setText("0");
        traderLabel.setText("0");
        engineerLabel.setText("0");
        investorLabel.setText("0");
    }
    /**
     * get current points.
     * @return players current points
     */
    public final int getPoints() {
        return points;
    }
    /**
     * players pilot points.
     * @return pilot points
     */
    public final int getPilot() {
        return pilot;
    }
    /**
     * player's fighter points.
     * @return fighter points
     */
    public final int getFighter() {
        return fighter;
    }
    /**
     * player's trader points.
     * @return trader points
     */
    public final int getTrader() {
        return trader;
    }
    /**
     * player's engineer points.
     * @return engineer points
     */
    public final int getEngineer() {
        return engineer;
    }
    /**
     * player's investor points.
     * @return investor points
     */
    public final int getInvestor() {
        return investor;
    }

    /**
     * get current points.
     * @param points1 points to set
     */
    public final void setPoints(final int points1) {
        this.points = points1;
    }
    /**
     * players pilot points.
     * @param points1 points to set
     */
    public final void setPilot(final int points1) {
        this.pilot = points1;
    }
    /**
     * player's fighter points.
     * @param points1 points to set
     */
    public final void setFighter(final int points1) {
        this.fighter = points1;
    }
    /**
     * player's trader points.
     * @param points1 points to set
     */
    public final void setTrader(final int points1) {
        this.trader = points1;
    }
    /**
     * player's engineer points.
     * @param points1 points to set
     */
    public final void setEngineer(final int points1) {
        this.engineer = points1;
    }
    /**
     * player's investor points.
     * @param points1 points to set
     */
    public final void setInvestor(final int points1) {
        this.investor = points1;
    }
}
