/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.util.Duration;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import java.nio.file.Paths;

/**
 * FXML Controller class
 *
 * @author Keun Lee
 */
public class EncounterScreenController implements Initializable {
    @FXML private transient Canvas canvas;
    private static final double[][] MINUTE_ARROW = {{-1, -200}, {0, -200},
        {12, -161}, {12, -121}, {7, -135}, {7, -1}, {-8, -1}, {-8, -135},
        {-13, -121}, {-13, -161}};
    private static final double[][] HOUR_ARROW = {{-1, -150}, {0, -150},
        {12, -130}, {9, -115}, {9, -1}, {-10, -1}, {-10, -115}, {-13, -130}};
    private static final double[][] MINUTE_ROTATE = {{Math.cos(Math.PI / 12),
        Math.sin(Math.PI / 12)}, {-Math.sin(Math.PI / 12),
            Math.cos(Math.PI / 12)}};
    private static final double[][] HOUR_ROTATE = {{Math.cos(Math.PI / 144),
        Math.sin(Math.PI / 144)}, {-Math.sin(Math.PI / 144),
            Math.cos(Math.PI / 144)}};
    private static final RealMatrix minuteRotateMatrix = new Array2DRowRealMatrix(MINUTE_ROTATE);
    private static final RealMatrix hourRotateMatrix = new Array2DRowRealMatrix(HOUR_ROTATE);
    private transient GraphicsContext context;
    private transient RealMatrix minuteMatrix;
    private transient RealMatrix hourMatrix;
    private static Timeline timeline;
    private transient int inCount;
    private transient int outCount;    
    private transient boolean upDown;    
    
    @FXML public static void stopAnimation() {
        timeline.stop();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        minuteMatrix = new Array2DRowRealMatrix(MINUTE_ARROW);
        hourMatrix = new Array2DRowRealMatrix(HOUR_ARROW);
        context = canvas.getGraphicsContext2D();
        context.translate(375, 275);
        context.setFill(Color.CORNFLOWERBLUE);
        context.fillPolygon(minuteMatrix.getColumn(0), minuteMatrix.getColumn(1), 10);
        context.setFill(Color.MEDIUMAQUAMARINE);
        context.fillPolygon(hourMatrix.getColumn(0), hourMatrix.getColumn(1), 8);
        timeline = new Timeline();       
        timeline.setCycleCount(Timeline.INDEFINITE);
        inCount = 0;
        upDown = true;
        KeyFrame frame = new KeyFrame(Duration.seconds(1.0/24),
                new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println(inCount);
                context.clearRect(-375, -275, 750, 550);
                context.setStroke(Color.rgb(0, outCount, 127 + outCount));
                context.setLineWidth(61);
                context.strokeOval(-230, -230, 460, 460);
                context.setStroke(Color.rgb(0, (outCount + 30) % 128, 127 + (outCount + 30) % 128));
                context.strokeOval(-290, -290, 580, 580);
                context.setStroke(Color.rgb(0, (outCount + 60) % 128, 127 + (outCount + 60) % 128));
                context.strokeOval(-350, -350, 700, 700);
                context.setStroke(Color.rgb(0, (outCount + 90) % 128, 127 + (outCount + 90) % 128));
                context.setLineWidth(100);
                context.strokeOval(-430, -430, 860, 860);

                context.setFill(new LinearGradient(-200, -200, 200, 200, false,
                        CycleMethod.NO_CYCLE, new Stop(0, Color.rgb(255,
                                255 - inCount, inCount)), new Stop(1,
                                        Color.rgb(255- inCount, 0, 255))));
                context.fillOval(-200, -200, 400, 400);
                minuteMatrix = minuteMatrix.multiply(minuteRotateMatrix);
                hourMatrix = hourMatrix.multiply(hourRotateMatrix);
                context.setFill(Color.CORNFLOWERBLUE);
                context.fillPolygon(minuteMatrix.getColumn(0), minuteMatrix.getColumn(1), 10);
                context.setFill(Color.MEDIUMAQUAMARINE);
                context.fillPolygon(hourMatrix.getColumn(0), hourMatrix.getColumn(1), 8);
                if (inCount % 20 < 10) {
                    context.drawImage(new Image(Paths.get("image/star.png").toUri().toString(), 360, 360, false, false), -180, -180);
                } else {
                    context.drawImage(new Image(Paths.get("image/star.png").toUri().toString(), 300, 300, false, false), -150, -150);
                }
                if (upDown) {
                    inCount += 3;
                    if (inCount >= 255) {
                        upDown = false;
                    }
                } else {
                    inCount -= 3;
                    if (inCount <= 0) {
                        upDown = true;
                    }
                }
                if (outCount >= 128) {
                    outCount = 0;
                } else {
                    outCount += 8;
                }
            }
        });
        timeline.getKeyFrames().add(frame);
        timeline.play();
    }
}
