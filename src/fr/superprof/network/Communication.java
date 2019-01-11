package fr.superprof.network;

import fr.superprof.command.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Communication {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Communication(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
    }

    public void emit(String message) {
        this.out.println(message);
        System.out.println(this.toString() + ": [EMIT] " + message);
    }

    public String listen() {
        String message = null;
        try {
            message = in.readLine();
        } catch (IOException e) {}
        System.out.println(this.toString() + ": [LISTEN] " + message);
        return message;
    }

    public void onConnection() {
        //TODO AXEL
        /**
         * Envoyer les données suivantes:
         * - Island
         * - Pirates
         * - Monkeys
         * - Rhums
         */
    }

    public void onListening() {
        while (true) {
            String message = this.listen();
            if (message == null) {
                break;
            }
            switchCommand(message);
        }
    }

    public void onDisconnection() {
        //TODO AXEL
        System.err.println(this.toString() + " is disconnected!");
        /**
         * Supprimer le pirate de la map, coms, observer
         */
    }

    private void switchCommand(String message) {
        Command command = Command.valueOf(message);
        switch (command.getHeader()) {
            case CLIENT_SUBSCRIBE_PIRATE:
                Command.suscribePirate();
                break;
            case CLIENT_MOVE_PIRATE:
                Command.movePirate(this.socket.getPort(), command.getBody());
                break;
            default:
                System.err.println("Not implemented yet");
                break;
        }
    }
}
