package fr.superprof.model;

import java.util.Random;

public class CrazyMonkey extends Monkey {

    public static final Integer SPEED = 1;

    public CrazyMonkey(Cell cell) {
        super(cell);
    }

    public Cell getRandomAdjacentCell(Cell cell) {

        int row, col, roll;
        Cell adjacentCell = cell;
        Random r = new Random();
        roll = r.nextInt(4);

        switch (roll) {
            case 0:
                row = cell.getRow() - SPEED;
                col = cell.getCol();
                break;
            case 1:
                row = cell.getRow() + SPEED;
                col = cell.getCol();
                break;
            case 2:
                row = cell.getRow();
                col = cell.getCol() - SPEED;
                break;
            case 3:
                row = cell.getRow();
                col = cell.getCol() + SPEED;
                break;
            default:
                break;
        }
            return adjacentCell;
        }


    @Override
    public void behavior() {
     Cell moveCrazyMonkey = null;
     do {
         moveCrazyMonkey = getRandomAdjacentCell(this.getCell());
         if(moveCrazyMonkey.canAccess() == false) moveCrazyMonkey = null;
     } while(moveCrazyMonkey == null);
     this.moveTo(moveCrazyMonkey);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
