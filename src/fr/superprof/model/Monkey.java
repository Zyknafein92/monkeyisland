package fr.superprof.model;

public abstract class Monkey extends Character {

    private Integer moveSpeed;

    public Monkey(Cell cell) {
        super(cell);
    }

    public void run() {}

    public void behavior() {}

    @Override
    public String toString() {
        return super.toString();
    }
}
