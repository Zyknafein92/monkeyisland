package fr.superprof;

import fr.superprof.model.Island;

public class MonkeyIsland {

    public static void main(String[] args) {
        Island island = Island.getInstance();
        System.out.println(island);
    }
}
