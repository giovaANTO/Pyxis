package it.unibo.pyxis.model.element.Ball;

import it.unibo.pyxis.model.element.ball.BallImpl;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

    private it.unibo.pyxis.model.element.ball.Ball ball1;
    private Vector startingPace;
    private int dt;

    /**
     * Sets a new ball with dimension, position and pace as startingDimension,
     * startingCoordinates and startingPace.
     */
    @BeforeEach
    private void setUp() {
        this.startingPace = new VectorImpl(new PairImpl<Double>(2.0, 5.0));
        this.dt = 200;
        this.ball1 = new BallImpl.Builder()
                        .pace(this.startingPace.copyOf())
                        .id(0)
                        .build();
    }

    @Test
    public void testType() {
        System.out.println("testType");
        assertEquals(this.ball1.getType(), BallType.NORMAL_BALL);
        this.ball1.setType(BallType.ATOMIC_BALL);
        assertEquals(this.ball1.getType(), BallType.ATOMIC_BALL);
        this.ball1.setType(BallType.STEEL_BALL);
        assertEquals(this.ball1.getType(), BallType.STEEL_BALL);
    }

    @Test
    public void testPace() {
        System.out.println("testPace");
        assertEquals(this.ball1.getPace(), this.startingPace);
        final Vector modifyPace = this.ball1.getPace();
        modifyPace.setX(4.0);
        modifyPace.setY(6.2);
        assertNotEquals(this.ball1.getPace(), modifyPace);
        this.ball1.setPace(modifyPace);
        assertEquals(this.ball1.getPace(), modifyPace);
    }

    @Test
    public void testUpdate() {
        System.out.println("testUpdate");
        final Coord coordinates = this.ball1.getPosition();
        assertEquals(this.ball1.getPosition(), coordinates);
        this.ball1.update(this.dt);
        final double multiplier = this.ball1.getType().getPaceMultiplier();
        final double modX = coordinates.getX() + (this.ball1.getPace().getX() * multiplier * this.dt * this.ball1.getUpdateTimeMultiplier());
        final double modY = coordinates.getY() + (this.ball1.getPace().getY() * multiplier * this.dt * this.ball1.getUpdateTimeMultiplier());
        Coord updatedCoordinates = new CoordImpl(modX, modY);
        assertEquals(this.ball1.getPosition(), updatedCoordinates);
    }

    @Test
    public void testBuilder() {
        System.out.println("testBuilder");
        assertThrows(NoSuchElementException.class, () -> {
            new BallImpl.Builder().build();
        });
        assertThrows(NullPointerException.class, () -> {
            new BallImpl.Builder()
                    .pace(null)
                    .build();
        });
        assertDoesNotThrow(() -> {
            new BallImpl.Builder()
                    .pace(this.startingPace)
                    .id(1)
                    .build();
        });
        final it.unibo.pyxis.model.element.ball.Ball testBall = new BallImpl.Builder()
                .pace(this.startingPace)
                .id(2)
                .build();
        assertEquals(testBall.getPace(), this.startingPace);
        assertEquals(testBall.getType(), BallType.NORMAL_BALL);
        assertEquals(testBall.getId(), 2);
    }
}
