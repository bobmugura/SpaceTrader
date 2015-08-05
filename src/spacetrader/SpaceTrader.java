/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

import spacetrader.controller.ScreenBoardController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Keun Lee
 */
public class SpaceTrader extends Application {
    /**
     * Place the ScreenBoard screen onto the stage and enables it
     */
    /**
     * Place the screenBoard screen onto the stage and enables it.
     * @param stage new stage
     * @throws Exception when it doesn't work
     */
    @Override
    public final void start(final Stage stage) throws Exception {
        MusicPlayer.playMusic(MusicPlayer.TEST);
        stage.setScene(new Scene(loadScreenBox()));
        stage.show();
    }
    /**
     * Loading Screen Box.
     * @return pane
     * @throws IOException when loading fails
     */
    private Pane loadScreenBox() throws IOException {
            FXMLLoader loader;
            loader = new FXMLLoader();
            Pane board;
            board = (Pane) loader.load(getClass().getResourceAsStream(
                    ScreenNavigator.BOARD));
            ScreenBoardController boardController;
            boardController = loader.getController();
            ScreenNavigator.setScreenBoardController(boardController);
            ScreenNavigator.loadScreen(ScreenNavigator.MENU);
            return board;
    }
    /**
     * Main method.
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
