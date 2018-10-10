package fr.superprof.model;

public class CrazyMonkey extends Monkey {

    public static final Integer SPEED = 1;

    public CrazyMonkey(Cell cell) {
        super(cell);
    }

    public Cell getRandomAdjacentCell(Cell cell){
        return null;
    }

    @Override
    public void behavior() {
        //TODO
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
