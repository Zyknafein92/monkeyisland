package fr.superprof.command;

import fr.superprof.model.*;

import java.util.stream.Stream;

public class Command {

    private CommandEnum header;
    private String body;

    private Command() {}

    private Command(CommandEnum header, String body) {
        this.header = header;
        this.body = body;
    }

    public static Command valueOf(String message) {
        String[] array = message.split(" ", 2);
        return new Command(CommandEnum.fromString(array[0]), array[1]);
    }

    /* COMMAND CLIENT - SERVER */

    public static void movePirate(Integer pirateId, String body) {
        String message = null;
        Island island = Island.getInstance();
        int[] values = Stream.of(body.split(" ")).mapToInt(Integer::valueOf).toArray();
        try {
            island.movePirate(pirateId, values[0], values[1]);
            message = allowMovePirate(island.getPirates().get(pirateId));
        } catch (PirateException e) {
            message = denyMovePirate();
        } finally {
            if (message != null) {
                island.getPirates().get(pirateId).getCom().emit(message);
            }
        }
    }

    public static void suscribePirate() {
        // HAVE ALREADY DONE !!! :))
    }

    /* COMMAND SERVER - CLIENT */

    public static String identifyPirate(Pirate pirate) {
        return CommandEnum.PIRATE + " " + pirate.toStringWithEnergyAndId();
    }

    public static String denyMovePirate() {
        return CommandEnum.DENY_MOVE_PIRATE.toString();
    }

    public static String allowMovePirate(Pirate pirate) {
        return CommandEnum.ALLOW_MOVE_PIRATE + " " + pirate.toStringWithEnergy();
    }

    public static String islandPirates() {
        Island island = Island.getInstance();
        StringBuilder sb = new StringBuilder();
        for (Pirate pirate : island.getPirates().values()) {
            sb.append(pirate).append("-");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return CommandEnum.PIRATES + " " + sb.toString();
    }

    public static String newPirate(Pirate pirate) {
        return CommandEnum.NEW_PIRATE + " " + pirate;
    }

    public static String deletePirate(Pirate pirate) {
        return CommandEnum.DELETE_PIRATE + " " + pirate.getId();
    }

    public static String movePirate(Pirate pirate) {
        return CommandEnum.MOVE_PIRATE + " " + pirate;
    }

    public static String islandShape() {
        return CommandEnum.ISLAND + " " + Island.getInstance();
    }

    private static String identifyMonkeys(Class<?> cls) {
        Island island = Island.getInstance();
        StringBuilder sb = new StringBuilder();
        for(Monkey monkey : island.getMonkeys(cls)){
            sb.append(monkey).append("-");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String identifyCrazyMonkeys() {
        return CommandEnum.CRAZY_MONKEYS + " " +  identifyMonkeys(CrazyMonkey.class);
    }

    public static String identifyHunterMonkeys() {
        return CommandEnum.HUNTER_MONKEYS + " " + identifyMonkeys(HunterMonkey.class);
    }

    public static String identifyRhums() {
        Island island = Island.getInstance();
        StringBuilder sb = new StringBuilder();
        for(Item rhum: island.getRhums()) {
            sb.append(rhum).append("-").append(rhum.getVisibility()).append("-");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return CommandEnum.RHUMS + " " + sb.toString();
    }

    public static String visibiltyRhum(Rhum rhum) {
        return CommandEnum.RHUM + " " + rhum.toStringWithId();
    }

    public static String foundTreasure(Treasure treasure) {
            return CommandEnum.TREASURE + " " + treasure;
    }

    public static String startNewGame() {
            return CommandEnum.NEW_GAME.toString();
        }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public CommandEnum getHeader() {
        return header;
    }

    public void setHeader(CommandEnum header) {
        this.header = header;
    }
}
