package fr.superprof.model;

import org.junit.*;

import static org.junit.Assert.*;

public class IslandTest {

    private static Island island;
    private static Cell[][] cells;

    @BeforeClass
    public static void setUp() throws Exception {
        island = Island.getInstance();
        cells = new Cell[Island.ROWS][Island.COLS];
        for (int i = 0; i < Island.ROWS; i++) {
            for (int j = 0; j < Island.COLS; j++) {
                cells[i][j] = new Cell(i, j, island);
            }
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstance() {
        Island islandTest = Island.getInstance();
        assertEquals(island, islandTest);
    }

    @Test
    public void getCell() {
        Integer row = 2;
        Integer col = 3;
        island.setCells(cells);
        Cell cell = island.getCell(2, 3);
        assertEquals(cells[2][3], cell);
        assertEquals(row, cell.getRow());
        assertEquals(col, cell.getCol());
    }

    @Test
    public void newGame() {
        assertFalse(true);
    }

    @Test
    public void initializeIsland() {
        assertFalse(true);
    }

    @Test
    public void initializeCells() {
        assertFalse(true);
    }

    @Test
    public void initializeTreasure() {
        assertFalse(true);
    }

    @Test
    public void initializeHunterMonkey() {
        assertFalse(true);
    }

    @Test
    public void initializeCrazyMonkey() {
        assertFalse(true);
    }

    @Test
    public void addPirate() {
        assertFalse(true);
    }

    @Test
    public void removePirate() {
        assertFalse(true);
    }

    @Test
    public void getRandomVoidEarth() {
        assertFalse(true);
    }

    @Test
    public void movePirate() {
        assertFalse(true);
    }

    @Test
    public void notifyClients() {
        assertFalse(true);
    }

}