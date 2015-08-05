/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.controller;

import javafx.scene.image.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import spacetrader.model.Coordinate;
import spacetrader.model.GameContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import spacetrader.ScreenNavigator;
import spacetrader.model.Navigator;
import spacetrader.model.Planet;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class.
 *
 * @author Keun Lee
 */
public class NavigationScreenController implements Initializable {
    /**
     * Mini map size multiplier for x-axis.
     */
    private static final int X_MULTIPLIER = 8;
    /**
     * Mini map size multiplier for y-axis.
     */
    private static final int Y_MULTIPLIER = 8;
    /**
     * Mini map planet circles size multiplier.
     */
    private static final int OVAL_MULTIPLIER = 3;
    /**
     * Pixel size of the one side of mini map.
     */
    private static final int MAP_LENGTH = 400;
    @FXML private transient Label lbName;
    @FXML private transient Label lbCoordinate;
    @FXML private transient Label lbTechLevel;
    @FXML private transient Label lbEnvironment;
    @FXML private transient Label lbGovernment;
    @FXML private transient Label lbDestName;
    @FXML private transient Label lbDestCoordinate;
    @FXML private transient Label lbDestTechLevel;
    @FXML private transient Label lbDestEnvironment;
    @FXML private transient Label lbDestGovernment;
    @FXML private transient Label lbMessage1;
    @FXML private transient Label lbMessage2;    
    @FXML private transient ComboBox cbDestination;
    @FXML private transient Canvas canvas;
    @FXML private transient Canvas outerCanvas;
    /**
     * Coordinate of the player.
     */
    private transient Coordinate coordinate;
    /**
     * List of coordinates of the planets within traveling reach.
     */
    private transient List<Coordinate> planetList;
    /**
     * saves the files by using serializable for the universe
     * and player when the save button is pressed.
     * saves the files as save/universe.ser and save/player.ser
     * @param event event to be used when the button is pressed
     */
    @FXML public final void clickSave(final ActionEvent event) {
         try {
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("save/universe.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(GameContext.instance().getUniverse());
            fileOut = new FileOutputStream("save/player.ser");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(GameContext.instance().getPlayer());
            out.close();
            fileOut.close();
            Dialogs.create()
                    .title("Game Save")
                    .message("Your game has been saved successfully.")
                    .showInformation();
        } catch (IOException i) {
            Dialogs.create()
                    .title("Save Game")
                    .masthead("Can't load the save file")
                    .showWarning();
        }
    }
    /**
     * updates the players destination on the UI not in the backend.
     * first gets the current planets info and updates the labels in the UI
     * @param index Newly picked destination planet index
     */
    private void updateDestination(final int index) {
        Planet planet;
        planet = GameContext.instance().getUniverse().get(
                planetList.get(index));
        lbDestName.setText(planet.getName());
        lbDestCoordinate.setText(planet.getCoordinate().toString());
        lbDestTechLevel.setText(planet.getTechLevel().toString());
        lbDestEnvironment.setText(planet.getEnvironment().toString());
        lbDestGovernment.setText(planet.getGovernment().toString());
    }
    /**
     * when the travel button is clicked the players
     * coordinate is updated to new planet.
     * fuel gets spent from travel and a random event could possibly occur.
     * New Planet is then loaded to screen
     * @param event the action event to be used when the user clicks on the
     * button. not currently being used.
     */
    @FXML public final void clickTravelButton(final ActionEvent event) {
        GameContext.instance().spaceTravel(planetList.get(cbDestination.
                getSelectionModel().getSelectedIndex()));
    }
    /**
     * loads the planet screen when the back button is pressed.
     * @param event event to be used when button is clicked. not used currently
     */
    @FXML public final void clickBackButton(final ActionEvent event) {
        ScreenNavigator.loadScreen(ScreenNavigator.PLANET);
    }
    /**
     * updates the UI for the new planet that is chosen
     * on the drop down box.
     * @param event event to be used when button is clicked.
     */
    @FXML public final void choiceBoxSelect(final ActionEvent event) {
        int index;
        index = cbDestination.getSelectionModel().getSelectedIndex();
        Coordinate coord;
        coord = planetList.get(index);
        resetDestIndicator(coord);
        updateDestination(index);
        refreshFuelMessage();
    }
    /**
     * this reloads the estimated fuel cost to the next planet chosen in
     * the drop down box and updates the current fuel of the ship.
     */
    private void refreshFuelMessage() {
        int fuelCost;
        fuelCost = planetList.get(cbDestination.getSelectionModel()
                .getSelectedIndex()).distanceTo(coordinate);
        lbMessage2.setText("Fuel cost to the destination: " + fuelCost);
        int fuelTank;
        fuelTank = GameContext.instance().getPlayer().getShip().getFuelTank();
        lbMessage1.setText("Current fuel: " + fuelTank);
    }
    /**
     * Draw mini map on Canvas.
     */
    private void drawMinimap() {
        GraphicsContext context = canvas.getGraphicsContext2D();
        final Image image = new Image(getClass().getResourceAsStream(
                "image/MinimapBackground.jpg"));
        context.drawImage(image, 0, 0);
        if (GameContext.instance().getPlayer().hasGPS()) {
            Collection<Planet> universe;
            universe = GameContext.instance().getUniverse().values();
            Coordinate coord;
            for (Planet p : universe) {
                coord = p.getCoordinate();
                if (coord.equals(coordinate)) {
                    context.setFill(Color.GREEN);
                } else if (planetList.contains(coord)) {
                    context.setFill(Color.YELLOW);
                } else {
                    context.setFill(Color.BLUE);
                }
                context.fillOval(coord.getRow() * X_MULTIPLIER, coord.getCol()
                        * Y_MULTIPLIER, X_MULTIPLIER, Y_MULTIPLIER);
            }
            coord = planetList.get(0);
            context = outerCanvas.getGraphicsContext2D();
            context.strokeOval((coord.getRow() - 1) * X_MULTIPLIER,
                    (coord.getCol() - 1) * Y_MULTIPLIER, OVAL_MULTIPLIER
                            * X_MULTIPLIER, OVAL_MULTIPLIER * X_MULTIPLIER);
        }
    }
    /**
     * Relocate the destination indicator in mini map.
     * @param coord new coordinate
     */
    private void resetDestIndicator(final Coordinate coord) {
        if (GameContext.instance().getPlayer().hasGPS()) {
            GraphicsContext context;
                    context = outerCanvas.getGraphicsContext2D();
            context.clearRect(0, 0, MAP_LENGTH, MAP_LENGTH);
            context.strokeOval((coord.getRow() - 1) * X_MULTIPLIER, (coord.getCol()
                    - 1) * Y_MULTIPLIER, OVAL_MULTIPLIER * X_MULTIPLIER,
                    OVAL_MULTIPLIER * X_MULTIPLIER);
            context.strokeLine(coordinate.getRow() * X_MULTIPLIER + X_MULTIPLIER
                    / 2, coordinate.getCol() * Y_MULTIPLIER + Y_MULTIPLIER / 2,
                    coord.getRow() * X_MULTIPLIER + X_MULTIPLIER / 2,
                    coord.getCol() * Y_MULTIPLIER + Y_MULTIPLIER / 2);
        }        
    }
    /**
     * Runs when the user clicks on mini map.
     * @param event Mouse event
     */
    @FXML public final void mouseClickHandler(final MouseEvent event) {
        Coordinate coord;
        coord = new Coordinate((int) event.getX() / X_MULTIPLIER,
                (int) event.getY() / Y_MULTIPLIER);
        if (GameContext.instance().getUniverse().containsKey(coord)) {
            if (planetList.contains(coord)) {
                resetDestIndicator(coord);
                cbDestination.getSelectionModel().select(GameContext.
                        instance().getUniverse().get(coord).getName());
                refreshFuelMessage();
            } else {
                Dialogs.create()
                        .title("Minimap")
                        .message("This planet is too far away to travel")
                        .showInformation();
            }
        }
    }
    /**
     * Initializes the controller class.
     * sets up the labels, and the elements to be placed into the UI of
     * the navigation screen.fxml
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameContext instance;
        instance = GameContext.instance();
        coordinate = instance.getPlayer().getCoordinate();
        Navigator navigator;
        navigator = new Navigator();
        planetList = navigator.sortCoordinateArray();
        List<String> planetNames;
        planetNames = new ArrayList();
        lbName.setText(instance.getUniverse().get(coordinate).getName());
        lbCoordinate.setText(instance.getUniverse().
                get(coordinate).getCoordinate().toString());
        lbTechLevel.setText(instance.getUniverse().
                get(coordinate).getTechLevel().toString());
        lbEnvironment.setText(instance.getUniverse().
                get(coordinate).getEnvironment().toString());
        lbGovernment.setText(instance.getUniverse().
                get(coordinate).getGovernment().toString());
        for (Coordinate coord : planetList) {
            planetNames.add(instance.getUniverse().get(coord).getName());
        }
        outerCanvas.getGraphicsContext2D().setStroke(Color.WHITE);
        cbDestination.getItems().setAll(planetNames);
        cbDestination.getSelectionModel().select(0);
         refreshFuelMessage();
         drawMinimap();
    }
}
