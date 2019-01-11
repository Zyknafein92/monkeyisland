package fr.superprof.model;

import fr.superprof.MonkeyIsland;
import java.util.Observable;
import java.util.Observer;

public class Pirate extends Character implements Observer {

    public static final Integer MAX_ENERGY = Integer.valueOf(MonkeyIsland.CONFIG.getString("PIRATE_MAX_ENERGY"));

    private Integer id;
    private Integer energy;
    private Cell cell;

    public Pirate(Cell cell, Integer id) {
        super(cell);
        this.id = id;
        this.energy = MAX_ENERGY;
    }

    public Boolean isDead() {
        return this.energy <= 0;
    }

    public String toStringWithEnergy() {
        return super.toString() + "-" + this.energy;
    }

    public String toStringWithEnergyAndId() {
        return this.toString() + "-" + this.energy;
    }

    @Override
    public String toString() {
        return this.id + "-" + super.toString();
    }

    @Override
    public Boolean canMove(Cell cell) {
        return super.canMove(cell) && cell.getCharacter() == null;
    }

    @Override
    public void moveTo(Cell cell) {
        super.moveTo(cell);
        this.energy--;
    }

    @Override
    public void foundItem(Item item) {
        if (item instanceof Rhum) {
            this.energy += Rhum.ENERGY_RECOVER;
            if (this.energy > MAX_ENERGY) {
                this.energy = MAX_ENERGY;
            }
            item.setVisibility(false);
        } else if (item instanceof Treasure) {
            item.setVisibility(true);
            item.setFound(true);
        }
    }

    @Override
    public void meetCharacter(Character character) {
        /* DO NOTHING */
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }
}
