/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package spacetrader.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 *
 * @author Keun Lee
 */
public final class WorldGenerator {
    /**
     * Maximum number of planets.
     */
    private static final int MAX_PLANET_COUNT = 25;
    /**
     * Row size of the map.
     */
    private static final int MAP_ROW_SIZE = 50;
    /**
     * Column size of the map.
     */
    private static final int MAP_COL_SIZE = 50;
    /**
     * List of all the possible planet names.
     */
    private static final String[] NAME_ARRAY = {
    "Acamar",
    "Adahn",            // The alternate personality for The Nameless One
    "Aldea",            //        in "Planescape: Torment"
    "Andevian",
    "Antedi",
    "Balosnee",
    "Baratas",
    "Brax",             // One of the heroes in Master of Magic
    "Bretel",           // This is a Dutch device for keeping your pants up.
    "Calondia",
    "Campor",
    "Capelle",          // The city I lived in while programming this game
    "Carzon",
    "Castor",           // A Greek demi-god
    "Cestus",
    "Cheron",
    "Courteney",        // After Courteney Cox…
    "Daled",
    "Damast",
    "Davlos",
    "Deneb",
    "Deneva",
    "Devidia",
    "Draylon",
    "Drema",
    "Endor",
    "Esmee",            // One of the witches in Pratchett's Discworld
    "Exo",
    "Ferris",           // Iron
    "Festen",           // A great Scandinavian movie
    "Fourmi",           // An ant, in French
    "Frolix",            // A solar system in one of Philip K. Dick's novels
    "Gemulon",
    "Guinifer",         // One way of writing the name of king Arthur's wife
    "Hades",            // The underworld
    "Hamlet",           // From Shakespeare
    "Helena",           // Of Troy
    "Hulst",            // A Dutch plant
    "Iodine",           // An element
    "Iralius",
    "Janus",            // A seldom encountered Dutch boy's name
    "Japori",
    "Jarada",
    "Jason",            // A Greek hero
    "Kaylon",
    "Khefka",
    "Kira",             // My dog's name
    "Klaatu",           // From a classic SF movie
    "Klaestron",
    "Korma",            // An Indian sauce
    "Kravat",           // Interesting spelling of the French word for "tie"
    "Krios",
    "Laertes",          // A king in a Greek tragedy
    "Largo",
    "Lave",             // The starting system in Elite
    "Ligon",
    "Lowry",            // The name of the "hero" in Terry Gilliam's "Brazil"
    "Magrat",           // The second of the witches in Pratchett's Discworld
    "Malcoria",
    "Melina",
    "Mentar",           // The Psilon home system in Master of Orion
    "Merik",
    "Mintaka",
    "Montor",           // A city in Ultima III and Ultima VII part 2
    "Mordan",
    "Myrthe",           // The name of my daughter
    "Nelvana",
    "Nix",       // An interesting spelling of a word meaning "nothing" in Dutch
    "Nyle",             // An interesting spelling of the great river
    "Odet",
    "Og",               // The last of the witches in Pratchett's Discworld
    "Omega",            // The end of it all
    "Omphalos",         // Greek for navel
    "Orias",
    "Othello",          // From Shakespeare
    "Parade",           // This word means the same in Dutch and in English
    "Penthara",
    "Picard",           // The enigmatic captain from ST:TNG
    "Pollux",           // Brother of Castor
    "Quator",
    "Rakhar",
    "Ran",              // A film by Akira Kurosawa
    "Regulas",
    "Relva",
    "Rhymus",
    "Rochani",
    "Rubicum",          // The river Ceasar crossed to get into Rome
    "Rutia",
    "Sarpeidon",
    "Sefalla",
    "Seltrice",
    "Sigma",
    "Sol",             // That's our own solar system
    "Somari",
    "Stakoron",
    "Styris",
    "Talani",
    "Tamus",
    "Tantalos",        // A king from a Greek tragedy
    "Tanuga",
    "Tarchannen",
    "Terosa",
    "Thera",           // A seldom encountered Dutch girl's name
    "Titan",           // The largest moon of Jupiter
    "Torin",           // A hero from Master of Magic
    "Triacus",
    "Turkana",
    "Tyrus",
    "Umberlee",  // A god from AD&D, which has a prominent role in Baldur's Gate
    "Utopia",          // The ultimate goal
    "Vadera",
    "Vagra",
    "Vandor",
    "Ventax",
    "Xenon",
    "Xerxes",          // A Greek hero
    "Yew",             // A city which is in almost all of the Ultima games
    "Yojimbo",         // A film by Akira Kurosawa
    "Zalkon",
    "Zuul"             // From the first Ghostbusters movie
};
    /**
     * Randomizer for the class.
     */
    private static final Random RANDOM = new Random();
    /**
     * List for creating non-repeating random numbers.
     */
    private static final List<Integer> LIST = new ArrayList();
    /**
     * Represent a quarter, one fourth.
     */
    private static final double QUARTER = 0.25;
    /**
     * Number of planets in each row of the map.
     */
    private transient double row;
    /**
     * Number of planets in each column of the map.
     */
    private transient double col;
    /**
     * A quarter of the row size of each planet's area.
     */
    private final transient int rowqtr;
    /**
     * A quarter of the column size of each planet's area.
     */
    private final transient int colqtr;
    /**
     * Constructor for the WorldGenerator.
     */
    public WorldGenerator() {
        row = MAP_ROW_SIZE / Math.sqrt(MAX_PLANET_COUNT);
        col = MAP_COL_SIZE / Math.sqrt(MAX_PLANET_COUNT);
        rowqtr = (int) (row * QUARTER);
        colqtr = (int) (col * QUARTER);
    }
    /**
     * When this method get called, it randomly generates
     * the new universe and saves it into GameContext instance.
     */
    public void newGame() {
        for (int i = 0; i < NAME_ARRAY.length; i++) {
            LIST.add(i);
        }
        Collections.shuffle(LIST, RANDOM);
/*        double row = MAP_ROW_SIZE / Math.sqrt(MAX_PLANET_COUNT);
        double col = MAP_COL_SIZE / Math.sqrt(MAX_PLANET_COUNT);
        final int rowQtr = (int) (row * QUARTER);
        final int colQtr = (int) (col * QUARTER);*/
        int planetCounter = 0;
        while (row < MAP_ROW_SIZE) {
            while (col < MAP_COL_SIZE && planetCounter < MAX_PLANET_COUNT) {
                final Coordinate coord = new Coordinate((int) (row - rowqtr
                        - RANDOM.nextInt(2 * rowqtr)), (int) (col - colqtr
                                - RANDOM.nextInt(2 * colqtr)));
                GameContext.instance().getUniverse().put(coord,
                        new Planet(NAME_ARRAY[LIST.remove(0)], coord));
                col += (int) (1 / QUARTER) * colqtr;
                if (planetCounter == Math.round(MAX_PLANET_COUNT / 2.0)) {
                    GameContext.instance().getPlayer().setCoordinate(coord);
                }
                planetCounter++;
            }
            row += (int) (1 / QUARTER) * rowqtr;
            col = MAP_COL_SIZE / Math.sqrt(MAX_PLANET_COUNT);
        }
    }
    /**
     * Clears the current universe.
     */
    public void deleteInstance() {
        GameContext.instance().getUniverse().clear();
    }
}
