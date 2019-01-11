package fr.superprof.network;

import fr.superprof.command.Command;
import fr.superprof.MonkeyIsland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final Integer PORT = Integer.valueOf(MonkeyIsland.CONFIG.getString("PORT"));
    public static final Integer HOST = Integer.valueOf(MonkeyIsland.CONFIG.getString("HOST"));

    public static void listen() throws IOException {
        ServerSocket serverSocket = new ServerSocket(HOST, PORT);
        System.out.println("Server listening on " + PORT);
        try {
            while (true) {
                new Client(serverSocket.accept()).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class Client extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Client(Socket socket) throws IOException {
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

        @Override
        public void run() {
            this.onConnection();
            this.onListening();
            this.onDisconnection();
        }

        private void onConnection() {
            //TODO AXEL
            /**
             * Envoyer les données suivantes:
             * - Island
             * - Pirates
             * - Monkeys
             * - Rhums
             */
        }

        private void onListening() {
            while (true) {
                String message = this.listen();
                if (message == null) {
                    break;
                }
                switchCommand(message);
            }
        }

        private void onDisconnection() {
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

        @Override
        public String toString() {
            return this.socket.toString();
        }

    }

}
