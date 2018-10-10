package fr.superprof.model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MonkeyTest {

    private static Monkey monkey;
    private static Cell cell;

    @Before
    public void setUp() throws Exception {
        cell = new Cell(1, 1, null);
        monkey = new Monkey(cell) {};
    }

    @Test
    @Ignore
    public void run() {
        Thread thread = new Thread(monkey);
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(monkey, 0, monkey.getMoveSpeed(), TimeUnit.SECONDS);

    }

    @Test
    @Ignore
    public void behavior() {
        assertTrue(true);
    }

    @Test
    public void canMove() {
        Cell destination = new Cell(1, 0, null);
        new Pirate(destination, 0);
        assertTrue(monkey.canMove(destination));
        new Monkey(destination) {};
        assertFalse(monkey.canMove(destination));
    }

    @Test
    @Ignore
    public void toStringTest() {
    }
}