package fr.superprof.model;

import java.util.Observable;
import java.util.Observer;

public class Pirate extends Character implements Observer {

    public static final Integer MAX_ENERGY = 20;

    private Integer id;
    private Integer energy;

    public Pirate(Cell cell, Integer id) {
        super(cell);
        this.id = id;
        this.energy = MAX_ENERGY;
    }

    public Boolean isDead(){
        return false;
    }

    public void foundItem(Item item) {
    }

    public String toStringWithEnergy(){
        return null;
    }

    public String toStringWithEnergyAndId(){
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void update(Observable o, Object arg) {
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
