/*.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.controller;

import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**.
 * FXML Controller class
 *
 * @author Keun Lee
 */
public class ScreenBoardController {
    /**
     *
     */
    @FXML
    private transient StackPane screenBoard;
    /**.
     * This method clears the Screenboard and adds a new child scene under it
     * @param node it holds the information of the new scene
     */
    public final void setScreen(final Node node) {
        screenBoard.getChildren().clear();
        screenBoard.getChildren().setAll(node);
    }
}
