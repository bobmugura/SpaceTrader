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
import spacetrader.ScreenNavigator;

/**.
 * FXML controller class
 *
 * @author Keun Lee
 */
public class WelcomeScreenController implements Initializable {
/**
 *
 */
    /**
     *
     */
    /**.
     * Navigates to configuration dialog screen
     * when the 'new game' button is clicked
     */
    @FXML final void openConfigurationDialogScreen() {
        ScreenNavigator.loadScreen(ScreenNavigator.NEW);
    }
    /**.
     * Navigates to load screen
     */
    @FXML final void openLoadScreen() {
        ScreenNavigator.loadScreen(ScreenNavigator.LOAD);
    }
    @Override
    public void initialize(final URL url, final ResourceBundle rb3) {
        // TODO
    }
}
