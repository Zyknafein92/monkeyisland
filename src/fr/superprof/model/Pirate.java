package fr.superprof.model;

import fr.superprof.MonkeyIsland;
import fr.superprof.command.Command;
import fr.superprof.network.Communication;

import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class Pirate extends Character implements Observer, Runnable {

    public static final Integer MAX_ENERGY = Integer.valueOf(MonkeyIsland.CONFIG.getString("PIRATE_MAX_ENERGY"));

    private Integer id;
    private Integer energy;
    private Communication com;
    private PirateStatusEnum status;

    public Pirate(Cell cell, Socket socket) {
        this(cell, socket.getPort());
        try {
            this.com = new Communication(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pirate(Cell cell, Integer id) {
        super(cell);
        this.id = id;
        this.energy = MAX_ENERGY;
        this.status = PirateStatusEnum.IDLE;
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
        if (this.isDead()) {
            this.getCell().getIsland().removePirate(this.id);
        }
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
        Island.getInstance().notifyObservers(item);
    }

    @Override
    public void meetCharacter(Character character) {
        /* DO NOTHING */
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Pirate) {
            Pirate pirate = (Pirate) arg;
            switch (pirate.getStatus()) {
                case ADD:
                    this.com.emit(Command.newPirate(pirate));
                    break;
                case MOVE:
                    this.com.emit(Command.movePirate(pirate));
                    break;
                case REMOVE:
                    this.com.emit(Command.deletePirate(pirate));
                    break;
                default:
                    break;
            }
            pirate.setStatus(PirateStatusEnum.IDLE);
        } else  if (arg instanceof CrazyMonkey) {
            this.com.emit(Command.identifyCrazyMonkeys());
        } else if (arg instanceof HunterMonkey) {
            this.com.emit(Command.identifyHunterMonkeys());
        } else if (arg instanceof Rhum) {
            this.com.emit(Command.visibiltyRhum((Rhum) arg));
        } else if (arg instanceof Treasure) {
            this.com.emit(Command.foundTreasure((Treasure) arg));
        }
    }

    @Override
    public void run() {
        this.com.onConnection();
        this.com.onListening();
        this.com.onDisconnection();
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

    public Communication getCom() {
        return com;
    }

    public void setCom(Communication com) {
        this.com = com;
    }

    public PirateStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PirateStatusEnum status) {
        this.status = status;
    }
}
