/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.enums.Spacecraft;
import spacetrader.model.GameContext;
import spacetrader.model.Player;
import spacetrader.model.Spaceship;
import spacetrader.model.ShipYard;
import spacetrader.model.WorldGenerator;

/**
 *
 * @author Alex
 */
public class tradeTest {
    
    Spaceship ship;
    Spacecraft flea;
    Spacecraft gnat;
    ShipYard shipyard;
    
    public tradeTest() {
        flea = Spacecraft.FLEA;
        gnat = Spacecraft.GNAT;
        ship = new Spaceship(flea);
        shipyard = new ShipYard();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        GameContext.instance().loadPlayer(new Player("test", 1, 1, 1, 1, 1));
        new WorldGenerator().newGame();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {        
        GameContext.instance().getPlayer().setShip(flea);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tradeSuccess() {
        GameContext.instance().getPlayer().setCredit(20000);
        shipyard.tradeShip(gnat);
        assertEquals(gnat, GameContext.instance().getPlayer().getShip().getShipType());
    }
    
    @Test
    public void tradeFailure() {
        GameContext.instance().getPlayer().setCredit(0);
        shipyard.tradeShip(gnat);
        assertEquals(flea, GameContext.instance().getPlayer().getShip().getShipType());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
