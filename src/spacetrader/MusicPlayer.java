/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader;

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Keun Lee
 */
public class MusicPlayer {
    public static final String SIREN = "music/PoliceSiren.wav";
    public static final String GUN = "music/PirateGunshot.wav";
    public static final String TEST = "music/TestMusic.mp3";    
    private static MediaPlayer player;    
    public static void playMusic(final String music) {
        player = new MediaPlayer(new Media(Paths.get(music).toUri().toString()));
        player.play();
    }
    public static void pauseMusic() {
        player.pause();
    }    
}
