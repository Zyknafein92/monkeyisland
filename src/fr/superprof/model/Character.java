package fr.superprof.model;

public abstract class Character {

    private Cell cell;

    public Character(Cell cell) {
        this.cell = cell;
        cell.setCharacter(this);
    }

    public void moveTo(Cell cell) {
        this.cell.setCharacter(null);
        cell.setCharacter(this);
        this.cell = cell;
    }

    public Boolean canMove(Cell cell) {
        return cell.canAccess() && this.cell.isAdjacent(cell);
    }

    public Cell getRelativeCell(Integer row, Integer col) {
        return this.cell.getRelativeCell(row, col);
    }

    public void meetCharacter(Character character) {}

    @Override
    public String toString() {
        return super.toString();
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}

