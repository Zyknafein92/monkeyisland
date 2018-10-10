package fr.superprof.model;

public abstract class Monkey extends Character implements Runnable {

    private Integer moveSpeed;

    public Monkey(Integer moveSpeed, Cell cell) {
        super(cell);
        this.moveSpeed = moveSpeed;
    }

    public Monkey(Cell cell) {
        this(CrazyMonkey.SPEED, cell);
    }

    public void run() {
        this.behavior();
    }

    public void behavior() {}

    @Override
    public Boolean canMove(Cell cell) {
        return super.canMove(cell) && !(cell.getCharacter() instanceof Monkey);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Integer getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(Integer moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
