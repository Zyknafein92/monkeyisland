package fr.superprof.model;

public abstract class Character {

    private Cell cell;

    public Character(Cell cell) {
        this.cell = cell;
    }

    public void moveTo(Cell cell){}

    public Boolean canMove(){
    return false;
    }

    public void meetCharacter(Character character){}

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

