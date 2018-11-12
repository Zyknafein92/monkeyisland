package fr.superprof.model;

import java.util.Random;

public class HunterMonkey extends Monkey {

    public static final Integer SPEED = 1;

    private Pirate target;

    public HunterMonkey(Cell cell) {
        super(cell);
    }

    public Integer getDistance(Pirate pirate) {
        return Math.abs(this.getCell().getRow() - pirate.getCell().getRow())
                + Math.abs(this.getCell().getCol() - pirate.getCell().getCol());
    }

    public Pirate getCloserTarget() {
        Pirate target = null;
        Integer closerDistance = -1;
        for (Pirate pirate : this.getCell().getIsland().getPirates().values()) {
            Integer distance = this.getDistance(pirate);
            if (distance < closerDistance || closerDistance < 0) {
                closerDistance = distance;
                target = pirate;
            }
        }
        return target;
    }

    public Cell getCloserPathToTarget() {
        Cell cell = null;
        Random rand = new Random();
        Boolean direction;

        if (this.target != null) {
            if (this.getCell().getRow().equals(this.target.getCell().getRow())) {
                direction = false;
            } else if (this.getCell().getCol().equals(this.target.getCell().getCol())) {
                direction = true;
            } else {
                direction = rand.nextBoolean();
            }

            if (direction) {
                Integer sign = Integer.signum(this.target.getCell().getRow() - this.getCell().getRow());
                cell = this.getRelativeCell(sign, 0);
            } else {
                Integer sign = Integer.signum(this.target.getCell().getCol() - this.getCell().getCol());
                cell = this.getRelativeCell(0, sign);
            }
        }
        return cell;
    }

    public Pirate getTarget() {
        return target;
    }

    public void setTarget(Pirate target) {
        this.target = target;
    }

    @Override
    public void behavior() {
        this.target = getCloserTarget();
        if (this.target != null) {
            this.moveTo(getCloserPathToTarget());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
