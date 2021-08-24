package it.unibo.pyxis.model.element;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallImpl;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickImpl;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.pad.PadImpl;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.element.powerup.PowerupImpl;
import it.unibo.pyxis.model.element.powerup.PowerupType;
import it.unibo.pyxis.model.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    private Ball ball;
    private Brick brick;
    private Pad pad;
    private Powerup powerup;
    private Vector startingPace;
    private Coord startingCoordBall;
    private Coord startingCoordBrick;
    private Coord startingCoordPad;
    private Coord startingCoordPowerup;
    private Dimension startingDimension;
    private double dt;

    /**
     * Creates a new instance of all the elements, ready to be tested.
     */
    @BeforeEach
    public void setUp() {
        this.startingPace = new VectorImpl(new PairImpl<Double>(2.0, 5.0));
        this.startingCoordBall = new CoordImpl(200, 250);
        this.startingCoordBrick = new CoordImpl(2.0, 5.0);
        this.startingCoordPad = new CoordImpl(200, 400);
        this.startingCoordPowerup = new CoordImpl(10, 15);
        this.startingDimension = new DimensionImpl(50, 10);
        this.dt = 200;
        this.ball = new BallImpl.Builder()
                .pace(this.startingPace.copyOf())
                .initialPosition(this.startingCoordBall.copyOf())
                .ballType(BallType.NORMAL_BALL)
                .id(0)
                .build();
        this.pad = new PadImpl(this.startingDimension.copyOf(), this.startingCoordPad.copyOf(), "0");
        this.brick = new BrickImpl(BrickType.RED, this.startingCoordBrick.copyOf());
        this.powerup = new PowerupImpl(PowerupType.ATOMIC_BALL, this.startingCoordPowerup.copyOf());
    }

    @Test
    public void testDimension() {
        Dimension changeDimension = this.pad.getDimension();
        assertEquals(changeDimension, this.startingDimension);
        changeDimension.setHeight(this.startingDimension.getHeight() + 10);
        assertNotEquals(changeDimension, this.startingDimension);

        this.pad.setHeight(this.pad.getDimension().getHeight() + 10);
        Dimension testDimension = this.startingDimension.copyOf();
        testDimension.setHeight(testDimension.getHeight() + 10);
        assertEquals(this.pad.getDimension(), testDimension);
    }

    @Test
    public void testPosition() {
        Coord changePosition = this.ball.getPosition();
        assertEquals(changePosition, this.startingCoordBall);
        changePosition.setX(this.ball.getPosition().getX() + 10);
        assertNotEquals(changePosition, this.ball.getPosition());
        assertThrows(NullPointerException.class, () -> this.ball.setPosition(null));
    }

    @Test
    public void testUpdate() {
        assertThrows(UnsupportedOperationException.class, () -> this.pad.update(this.dt));
        assertThrows(UnsupportedOperationException.class, () -> this.brick.update(this.dt));
        this.ball.update(this.dt);
        double updatedX = this.startingCoordBall.getX() +
                (this.ball.getPace().getX() * this.dt * this.ball.getUpdateTimeMultiplier());
        double updatedY = this.startingCoordBall.getY() +
                (this.ball.getPace().getY() * this.dt * this.ball.getUpdateTimeMultiplier());
        Coord updatedCoord = new CoordImpl(updatedX, updatedY);
        assertEquals(this.ball.getPosition(), updatedCoord);
    }
}
