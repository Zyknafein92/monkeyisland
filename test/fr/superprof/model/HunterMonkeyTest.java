package fr.superprof.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HunterMonkeyTest {

    private Island island;
    private HunterMonkey hunterMonkey;
    private Pirate pirateAxel;
    private Pirate pirateJerome;
    private Cell hunterCell;
    private Cell pirateAxelCell;
    private Cell pirateJeromeCell;

    @Before
    public void setUp() throws Exception {
        island = Island.getInstance();
        hunterCell = island.getCell(1, 1);
        hunterMonkey = new HunterMonkey(hunterCell);
        pirateAxelCell = island.getCell(5, 2);
        pirateAxel = new Pirate(pirateAxelCell, 0);
        pirateJeromeCell = island.getCell(1, 3);
        pirateJerome = new Pirate(pirateJeromeCell, 1);
        island.addPirate(pirateAxel);
        island.addPirate(pirateJerome);
    }

    @Test
    public void getDistance() {
        assertEquals("Distance is not equal", 5, hunterMonkey.getDistance(pirateAxel).longValue());
    }

    @Test
    public void getCloserTarget() {
        assertEquals("PirateJerome must be the target", pirateJerome, hunterMonkey.getCloserTarget());
    }

    @Test
    public void getCloserPathToTarget() {
        Cell expected = hunterMonkey.getRelativeCell(0,1);
        hunterMonkey.setTarget(pirateJerome);
        assertEquals("Not the correct path to pirate", expected, hunterMonkey.getCloserPathToTarget());
    }

}