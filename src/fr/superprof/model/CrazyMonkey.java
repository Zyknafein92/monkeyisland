package fr.superprof.model;

import java.util.Random;

public class CrazyMonkey extends Monkey {

    public static final Integer SPEED = 1;

    public CrazyMonkey(Cell cell) {
        super(cell);
    }

    public Cell getRandomAdjacentCell() {
        Cell adjacent = null;
        Random rand = new Random();
        do {
            switch (rand.nextInt(4)) {
                case 0:
                    adjacent = this.getRelativeCell(-1, 0);
                    break;
                case 1:
                    adjacent = this.getRelativeCell(0, 1);
                    break;
                case 2:
                    adjacent = this.getRelativeCell(1, 0);
                    break;
                case 3:
                    adjacent = this.getRelativeCell(0, -1);
                    break;
                default:
                    break;
            }
        } while (!this.canMove(adjacent));
        return adjacent;
    }

    @Override
    public void behavior() {
        this.moveTo(getRandomAdjacentCell());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
