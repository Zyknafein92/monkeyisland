package fr.superprof.network;

import fr.superprof.MonkeyIsland;
import fr.superprof.model.Island;
import fr.superprof.model.Pirate;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static final Integer PORT = Integer.valueOf(MonkeyIsland.CONFIG.getString("PORT"));

    public static void listen() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server listening on " + PORT);
        Island island = Island.getInstance();
        try {
            while (true) {
                Pirate pirate = island.addPirate(serverSocket.accept());
                new Thread(pirate).run();
            }
        } finally {
            serverSocket.close();
        }
    }

}
