package fr.superprof;

import fr.superprof.model.Island;

import java.util.ResourceBundle;

public class MonkeyIsland {

    public static final ResourceBundle CONFIG = ResourceBundle.getBundle("config");

    public static void main(String[] args) {
        Island island = Island.getInstance();
    }
}
