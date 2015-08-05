/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package spacetrader.controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.dialog.Dialogs;
import spacetrader.ScreenNavigator;
import spacetrader.model.Coordinate;
import spacetrader.model.GameContext;
import spacetrader.model.Planet;
import spacetrader.model.Player;


/**
 * FXML Controller class.
 *
 * @author Keun Lee
 */
public class LoadScreenController implements Initializable {
    /**
     * Run when the Load button gets clicked.
     * @param event action event
     */
    @FXML public final void clickLoadButton(final ActionEvent event) {
        try {
            FileInputStream fileIn = new FileInputStream("save/universe.ser");
            ObjectInputStream inStream = new ObjectInputStream(fileIn);
            GameContext.instance().loadUniverse((Map<Coordinate, Planet>)
                    (inStream.readObject()));
            fileIn = new FileInputStream("save/player.ser");
            inStream = new ObjectInputStream(fileIn);
            GameContext.instance().loadPlayer((Player) inStream.readObject());
            inStream.close();
            fileIn.close();
            Dialogs.create()
                    .title("Loading Game")
                    .message("Loading was successful!")
                    .showInformation();
        } catch (IOException i) {
            Dialogs.create()
                    .title("Warning")
                    .message("Loading file failed")
                    .showWarning();
        } catch (ClassNotFoundException c) {
            Dialogs.create()
                    .title("Warning")
                    .message("Class was not found!")
                    .showWarning();
        }
        ScreenNavigator.loadScreen(ScreenNavigator.GAME);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
