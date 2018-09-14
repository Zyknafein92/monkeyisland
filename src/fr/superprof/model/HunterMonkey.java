package fr.superprof.model;

public class HunterMonkey extends Monkey {

    public static final Integer SPEED = 1;

    private Pirate target;

    public HunterMonkey(Cell cell) {
        super(cell);
    }

    public Integer getDistance(Pirate pirate) {
        return null;
    }

    public Pirate getCloserTarget(){
        return null;
    }

    public Pirate getTarget() {
        return target;
    }

    public void setTarget(Pirate target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
