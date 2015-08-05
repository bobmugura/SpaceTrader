import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import spacetrader.enums.Spacecraft;
import spacetrader.model.GameContext;
import spacetrader.model.Player;
import spacetrader.model.Spaceship;

/** *
 * @author Keun Lee
 * This JUnit test checks the reFuel() method in Spaceship class to achieve branch coverage.
 */
public class RefuelTest {
    Spaceship ship;
    Spacecraft flea;
    
    /**
     * initialize Spaceship variable with a Spacecraft type
     */
    public RefuelTest() 
    {
        flea = Spacecraft.FLEA;
        ship = new Spaceship(flea);
    }
    
    /**
     * Create an instance of the GameContext and add a temporary player
     */
    @BeforeClass
    public static void setUpClass() 
    {
        GameContext.instance().loadPlayer(new Player("test", 1, 1, 1, 1, 1));
    }
    
    /**
     * empty the fuel tank of the ship before each test
     */
    @Before
    public void setUp() 
    {        
        ship.setFuelTank(0);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /**
     * checks the case where the player doesn't have enough credit to refuel the ship
     */
    @Test
    public void RefuelInsufficientCredit()
    {
        GameContext.instance().getPlayer().setCredit(10);  
        assertFalse(ship.reFuel());
    }
    
    /**
     * checks the case where the player has enough credit to refuel the ship
     */
    @Test
    public void RefuelSufficientCredit()
    {
        GameContext.instance().getPlayer().setCredit(1000);
        assertTrue(ship.reFuel());
    }
}
