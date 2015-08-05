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
//import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.controlsfx.dialog.Dialogs;
import spacetrader.ScreenNavigator;
import spacetrader.model.GameContext;
import spacetrader.model.Player;
import spacetrader.model.WorldGenerator;

/**
 * FXML Controller class.
 *
 * @author Keun Lee
 */
public class GameScreenController implements Initializable {

    //@FXML
    //private Button planetScreen;
    /**
     * label displaying players investor points.
     */
    @FXML
    private transient Label nameLabel;
    /**
     * label displaying players investor points.
     */
    @FXML
    private transient Label pilotLabel;
    /**
     * label displaying players investor points.
     */
    @FXML
    private transient Label fighterLabel;
    /**
     * label displaying players investor points.
     */
    @FXML
    private transient Label traderLabel;
    /**
     * label displaying players investor points.
     */
    @FXML
    private transient Label engineerLabel;
    /**
     * label displaying players investor points.
     */
    @FXML
    private transient Label investorLabel;



    /**
     * Initializes the controller class.
     * @param url unused
     * @param resourceb unused
     */
    @Override
    public final void initialize(final URL url,
            final ResourceBundle resourceb) {
        final Player player = GameContext.instance().getPlayer();
        nameLabel.setText(player.getName());
        pilotLabel.setText(Integer.toString(player.getPilotLevel()));
        fighterLabel.setText(Integer.toString(player.getFighterLevel()));
        traderLabel.setText(Integer.toString(player.getTraderLevel()));
        engineerLabel.setText(Integer.toString(player.getEngineerLevel()));
        investorLabel.setText(Integer.toString(player.getInvestorLevel()));
    }
    /**
     * Dumps the universe onto the console by listing all the planets.
     */
    @FXML
    public final void buttonListener() {
        final String str = GameContext.instance().toStringUniverse();
        Dialogs.create()
                .title("Planet list")
                .message(str)
                .showInformation();
    }
    /**
     * regenerate the game.
     */
    @FXML
    public final void recreateUniverse() {
        WorldGenerator generator;
        generator = new WorldGenerator();
        generator.deleteInstance();
        generator.newGame();
        Dialogs.create()
                .title("Universe Generated")
                .message("New randomly generated universe was created")
                .showInformation();
    }
    /**
     * Moves the player to the Planet screen.
     */
    @FXML
    public final void openPlanetScreen() {
        ScreenNavigator.loadScreen(ScreenNavigator.PLANET);
    }

}
