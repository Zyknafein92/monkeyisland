package fr.superprof.model;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public abstract class Monkey extends Character implements Runnable {

    private Integer moveSpeed;

    public Monkey(Integer moveSpeed, Cell cell) {
        super(cell);
        this.moveSpeed = moveSpeed;
    }

    public Monkey(Cell cell) {
        this(CrazyMonkey.SPEED, cell);
    }

    abstract public void run();

    public void exec() {
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(this, 0, this.moveSpeed, TimeUnit.SECONDS);
    }

    @Override
    public Boolean canMove(Cell cell) {
        return super.canMove(cell) && !(cell.getCharacter() instanceof Monkey);
    }

    @Override
    public void moveTo(Cell cell) {
        super.moveTo(cell);
        Island.getInstance().notifyObservers(this);
    }

    @Override
    public void meetCharacter(Character character) {
        if (character instanceof Pirate) {
            Pirate pirate = (Pirate) character;
            pirate.setEnergy(0);
            this.getCell().getIsland().removePirate(pirate.getId());
        }
    }

    @Override
    public void foundItem(Item item) {
        /*DO NOTHING*/
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
