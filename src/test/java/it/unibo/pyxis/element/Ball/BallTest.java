package it.unibo.pyxis.element.Ball;

import it.unibo.pyxis.element.ball.Ball;
import it.unibo.pyxis.element.ball.BallImpl;
import it.unibo.pyxis.element.ball.BallType;
import it.unibo.pyxis.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BallTest {

    private Ball ball1;
    private Dimension startingDimension;
    private Coord startingCoordinates;
    private Vector startingPace;

    /**
     * Sets a new ball with dimension, position and pace as startingDimension,
     * startingCoordinates  and startingPace.
     */
    @BeforeEach
    private void setUp() {
        this.startingDimension = new DimensionImpl(3, 3);
        this.startingCoordinates = new CoordImpl(3, 5);
        this.startingPace = new VectorImpl(new PairImpl<Double>(2.0, 5.0));
        this.ball1 = new BallImpl(this.startingDimension.copyOf(),
                this.startingCoordinates.copyOf(), this.startingPace.copyOf());
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
        assertEquals(this.ball1.getPace().getComponents(), this.startingPace.getComponents());
        Vector modifyPace = this.ball1.getPace();
        modifyPace.setComponents(new PairImpl<Double>(4.0, 6.2));
        assertNotEquals(this.ball1.getPace().getComponents(), modifyPace.getComponents());
        this.ball1.setPace(modifyPace);
        assertEquals(this.ball1.getPace().getComponents(), modifyPace.getComponents());
    }
}
