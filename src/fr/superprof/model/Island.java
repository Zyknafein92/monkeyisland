package fr.superprof.model;

import fr.superprof.MonkeyIsland;

import java.util.*;
import java.util.stream.Stream;

public class Island extends Observable {

    public static final Integer ROWS = Integer.valueOf(MonkeyIsland.CONFIG.getString("ISLAND_ROWS"));
    public static final Integer COLS = Integer.valueOf(MonkeyIsland.CONFIG.getString("ISLAND_COLS"));

    private Cell[][] cells = new Cell[ROWS][COLS];
    private Map<Integer, Pirate> pirates;
    private Treasure treasure;

    private Island() {
        pirates = new HashMap<>();
        this.initializeIsland();
    }

    private static class SingletonHolder {
        /** Instance unique non préinitialisée */
        private static final Island instance = new Island();
    }

    public static final Island getInstance() {
        return SingletonHolder.instance;
    }

    public Cell getCell(Integer row, Integer col) {
        try {
            return this.cells[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public Cell getCell(Cell relativeCell, Integer row, Integer col) {
        try {
            return this.cells[relativeCell.getRow() + row][relativeCell.getCol() + col];
        } catch (ArrayIndexOutOfBoundsException e) {
            return relativeCell;
        }
    }

    public List<Monkey> getMonkeys(Class<?> cls) {
        if (cls == null) {
            cls = Monkey.class;
        }
        List<Monkey> monkeys = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                Character character = cells[i][j].getCharacter();
                if (character != null && cls.isInstance(character)) {
                    monkeys.add((Monkey)character);
                }
            }
        }
        return monkeys;
    }

    public List<Rhum> getRhums() {
        List<Rhum> rhums = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                Item item = cells[i][j].getItem();
                if (item instanceof Rhum) {
                    rhums.add((Rhum) item);
                }
            }
        }
        return rhums;
    }

    public void initializeIsland() {
        this.initializeCells();
        this.initializeCrazyMonkey();
        this.initializeHunterMonkey();
        this.initializeTreasure();
        this.initializeRhum();
    }

    public void initializeCells() {
        String shape = MonkeyIsland.CONFIG.getString("ISLAND_SHAPE");
        int[] shapes = Arrays.stream(shape.split("-")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                cells[i][j] = new Cell(i, j, this, shapes[i * COLS + j]);
            }
        }
    }

    public void initializeTreasure() {
        //TODO + test
    }

    public void initializeHunterMonkey() {
        //TODO + test
    }

    public void initializeCrazyMonkey() {
        //TODO + test
    }

    public void initializeRhum() {
        //TODO + test
    }

    public Cell getRandomVoidEarth() {
        Random rand = new Random();
        Cell cell = null;
        do {
            Integer row = rand.nextInt(ROWS);
            Integer col = rand.nextInt(COLS);
            cell = this.getCell(row, col);
        } while(!cell.canAccess() || cell.getItem() != null || cell.getCharacter() != null);
        return cell;
    }

    public Pirate addPirate(Pirate pirate){
        pirates.put(pirate.getId(), pirate);
        return pirate;
    }

    public Pirate addPirate(Integer id){
        return null;
    }

    public Pirate removePirate(Integer id){
        return null;
    }

    public Pirate movePirate(int id, int moveX, int moveY) {
        return null;
    }

    public void newGame() {

    }

    public void notifyClients() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            sb.append("|");
            for (int j = 0; j < COLS; j++) {
               Cell cell = cells[i][j];
               if (cell.getType().equals(Cell.WATER)) {
                   sb.append("X|");
               } else if (cell.getItem() instanceof Treasure) {
                   sb.append("T|");
               } else if (cell.getItem() instanceof Rhum) {
                   sb.append("R|");
               } else if (cell.getCharacter() instanceof Pirate) {
                   sb.append("P|");
               } else if (cell.getCharacter() instanceof CrazyMonkey) {
                   sb.append("C|");
               } else if (cell.getCharacter() instanceof HunterMonkey) {
                   sb.append("H|");
               } else {
                   sb.append(" |");
               }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Map<Integer, Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(Map<Integer, Pirate> pirates) {
        this.pirates = pirates;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }
}
