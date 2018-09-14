package fr.superprof.model;

public class Cell {

    public static final Integer WATER = 0;
    public static final Integer EARTH = 1;

    private Integer row;
    private Integer col;
    private Integer type;
    private Item item;
    private Character character;
    private Island island;

    public Cell(Integer row, Integer col, Island island) {
        this.row = row;
        this.col = col;
        this.type = EARTH;
        this.island = island;
    }

    public Boolean canAccess(){
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Island getIsland() {
        return island;
    }

    public void setIsland(Island island) {
        this.island = island;
    }
}
