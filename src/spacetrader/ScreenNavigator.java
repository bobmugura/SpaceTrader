/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

import spacetrader.controller.ScreenBoardController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author Keun Lee
 */
public class ScreenNavigator {
    public static final String BOARD = "view/ScreenBoard.fxml";
    public static final String MENU = "view/WelcomeScreen.fxml";
    public static final String NEW = "view/ConfigurationDialog.fxml";
    public static final String GAME = "view/GameScreen.fxml";
    public static final String PLANET = "view/PlanetScreen.fxml";
    public static final String NAVIGATE = "view/NavigationScreen.fxml";
    public static final String LOAD = "view/LoadScreen.fxml";
    public static final String SHIPYARD = "view/ShipYardScreen.fxml";
    public static final String EQUIPMENT = "view/EquipmentScreen.fxml";
    public static final String ENCOUNTER = "view/EncounterScreen.fxml";
    public static final String STOCKMARKET = "view/StockMarketScreen.fxml";
    public static final String BANKING = "view/BankingScreen.fxml";
    /**
     * Controller for the screen board.
     */
    private static ScreenBoardController boardController;
    /**
     * Setter for the screenBoardController.
     * @param controller object of the ScreenBoardController
     */
    public static void setScreenBoardController(
            final ScreenBoardController controller) {
        boardController = controller;
    }
    /**
     * Loading new scene into the ScreenBoard.
     * @param fxml name of the screen to open up
     */
    public static void loadScreen(final String fxml) {
        try {
            boardController.setScreen(FXMLLoader.load(
                    ScreenNavigator.class.getResource(fxml)));
        } catch (IOException ex) {
            System.out.println("Got an IOException: " + ex.getMessage());
            Dialogs.create()
                    .title("Warning")
                    .message("Loading Screen Failed")
                    .showWarning();
        }
    }
}
