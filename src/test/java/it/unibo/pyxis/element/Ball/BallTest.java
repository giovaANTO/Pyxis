package it.unibo.pyxis.element.Ball;

import it.unibo.pyxis.element.ball.Ball;
import it.unibo.pyxis.element.ball.BallImpl;
import it.unibo.pyxis.element.ball.BallType;
import it.unibo.pyxis.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class BallTest {

    private Ball ball1;
    private Coord startingCoordinates;
    private Vector startingPace;
    private Dimension startingDimension;

    /**
     * Sets a new ball with dimension, position and pace as startingDimension,
     * startingCoordinates and startingPace.
     */
    @BeforeEach
    private void setUp() {
        this.startingDimension = new DimensionImpl(3, 3);
        this.startingCoordinates = new CoordImpl(3, 5);
        this.startingPace = new VectorImpl(new PairImpl<Double>(2.0, 5.0));
        this.ball1 = new BallImpl.BallBuilderImpl()
                        .dimension(startingDimension.copyOf())
                        .position(this.startingCoordinates.copyOf())
                        .pace(this.startingPace.copyOf())
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
        assertEquals(this.ball1.getPosition(), this.startingCoordinates);
        this.ball1.update();
        final double multiplier = this.ball1.getType().getPaceMultiplier();
        final double modX = this.startingCoordinates.getX() + (this.ball1.getPace().getX() * multiplier);
        final double modY = this.startingCoordinates.getY() + (this.ball1.getPace().getY() * multiplier);
        Coord updatedCoordinates = new CoordImpl(modX, modY);
        assertEquals(this.ball1.getPosition(), updatedCoordinates);
    }

    @Test
    public void testBuilder() {
        System.out.println("testBuilder");
        assertThrows(NoSuchElementException.class, () -> {
            new BallImpl.BallBuilderImpl().build();
        });
        assertThrows(NullPointerException.class, () -> {
            new BallImpl.BallBuilderImpl()
                    .dimension(null)
                    .build();
        });
        assertDoesNotThrow(() -> {
            new BallImpl.BallBuilderImpl()
                    .dimension(this.startingDimension)
                    .position(this.startingCoordinates)
                    .pace(this.startingPace)
                    .build();
        });
        final Ball testBall = new BallImpl.BallBuilderImpl()
                .dimension(this.startingDimension)
                .position(this.startingCoordinates)
                .pace(this.startingPace)
                .build();
        assertEquals(testBall.getPosition(), this.startingCoordinates);
        assertEquals(testBall.getPace(), this.startingPace);
        assertEquals(testBall.getDimension(), this.startingDimension);
        assertEquals(testBall.getType(), BallType.NORMAL_BALL);
    }
}
