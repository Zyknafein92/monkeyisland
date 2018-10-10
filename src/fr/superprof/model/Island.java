package fr.superprof.model;

import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Island extends Observable {

    public static final Integer ROWS = 10;
    public static final Integer COLS = 10;

    private Cell[][] cells = new Cell[ROWS][COLS];
    private Map<Integer, Pirate> pirates;
    private List<Monkey> crazyMonkey;
    private List<Monkey> hunterMonkey;
    private List<Rhum> rhums;
    private Treasure treasure;

    private Island() {}

    private static class SingletonHolder {
        /** Instance unique non préinitialisée */
        private static final Island instance = new Island();
    }

    public static final Island getInstance() {
        return SingletonHolder.instance;
    }

    public Cell getCell(int row, int col) {
        return this.cells[row][col];
    }

    public void newGame() {

    }

    public void initializeIsland() {

    }

    public void initializeCells() {

    }

    public void initializeTreasure() {

    }

    public void initializeHunterMonkey() {

    }

    public void initializeCrazyMonkey() {

    }

    public Pirate addPirate(Integer id){
        return null;
    }

    public Pirate removePirate(Integer id){
        return null;
    }

    public Cell getRandomVoidEarth() {
        return null;
    }

    public Pirate movePirate(int id, int moveX, int moveY) {
        return null;
    }

    public void notifyClients() {

    }

    @Override
    public String toString() {
        return super.toString();
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

    public List<Monkey> getCrazyMonkey() {
        return crazyMonkey;
    }

    public void setCrazyMonkey(List<Monkey> crazyMonkey) {
        this.crazyMonkey = crazyMonkey;
    }

    public List<Monkey> getHunterMonkey() {
        return hunterMonkey;
    }

    public void setHunterMonkey(List<Monkey> hunterMonkey) {
        this.hunterMonkey = hunterMonkey;
    }

    public List<Rhum> getRhums() {
        return rhums;
    }

    public void setRhums(List<Rhum> rhums) {
        this.rhums = rhums;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }
}
