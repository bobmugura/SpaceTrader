import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import spacetrader.model.MarketPlace;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author naveen
 */
public class MarketPlaceTest {
    List buy,sell;
    MarketPlace current;
    int tech = 5;
    public MarketPlaceTest() {
        current = new MarketPlace(tech);
    }
}
