package fr.superprof.model;

public class Rhum extends Item {

    public static final Integer ENERGY_RECOVER = 10;
    public static final Integer RESPAWN_TIMER = 10;

    private Integer id;

    public Rhum(Cell cell, Integer id) {
        super(cell);
        this.id = id;
    }

    public String toStringWithId() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
