package fr.superprof.model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    private static Character character;
    private static Cell cell, north, south, east, west;

    @Before
    public void setUp() throws Exception {
        cell = new Cell(1, 1, null);
        north = new Cell(0, 1, null);
        south = new Cell(2, 1, null);
        east = new Cell(1, 2, null);
        west = new Cell(1, 0, null);
        character = new Character(cell) {};
    }

    @Test
    public void moveTo() {
        assertEquals(cell.getCharacter(), character);
        assertEquals(character.getCell(), cell);
        assertNotEquals(character.getCell(), north);
        assertNotEquals(north.getCharacter(), character);
        character.moveTo(north);
        assertNull(cell.getCharacter());
        assertEquals(character.getCell(), north);
        assertEquals(north.getCharacter(), character);
    }

    @Test
    public void canMove() {
        Cell destination = new Cell(5, 8, null);
        assertTrue("Can access to the north", character.canMove(north));
        assertTrue("Can access to the south", character.canMove(south));
        assertTrue("Can access to the east", character.canMove(east));
        assertTrue("Can access to the west", character.canMove(west));
        assertFalse("Access to a far cell", character.canMove(destination));
        assertTrue("Access to earth cell", character.canMove(north));
        north.setType(Cell.WATER);
        assertFalse("Access to Water cell", character.canMove(north));
    }

    @Test
    public void meetCharacter() {
        assertTrue(true);
    }

    @Test
    @Ignore
    public void toStringTest() {
    }
}