package it.unibo.pyxis.model.arena;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallImpl;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.BrickImpl;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.pad.PadImpl;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.VectorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    private Arena testArena;
    private final Dimension inputDimensions = new DimensionImpl(10, 10);

    private void createDefaultArena() {
        this.testArena = new ArenaImpl(this.inputDimensions);
    }

    @BeforeEach
    public void init() {
        this.createDefaultArena();
    }

    @Test
    public void testArenaCreation() {
        assertEquals(this.inputDimensions, this.testArena.getDimension());
        final Dimension arenaDimension = this.testArena.getDimension();
        arenaDimension.setHeight(11);
        arenaDimension.setWidth(11);
        assertEquals(this.inputDimensions, this.testArena.getDimension());
    }

    @Test
    public void testSetPad() {
        final Pad inputPad = new PadImpl(new CoordImpl(7,8));
        this.testArena.setPad(inputPad);
        assertEquals(inputPad, this.testArena.getPad());
    }

    @Test
    public void testAddBall() {
        assertEquals(0, this.testArena.getBalls().size());
        final Ball newBall = new BallImpl.Builder()
                .ballType(BallType.NORMAL_BALL)
                .initialPosition(new CoordImpl(10, 10))
                .pace(new VectorImpl(5,9))
                .id(1)
                .build();

        this.testArena.addBall(newBall);
        assertEquals(1, this.testArena.getBalls().size());
        assertTrue(this.testArena.getBalls().contains(newBall));
    }

    @Test
    public void testAddBrick() {
        assertEquals(0, this.testArena.getBricks().size());
        this.testArena.addBrick(new BrickImpl(BrickType.RED, new CoordImpl(10, 10)));
        this.testArena.addBrick(new BrickImpl(BrickType.BLUE, new CoordImpl(11, 12)));
        this.testArena.addBrick(new BrickImpl(BrickType.GREEN, new CoordImpl(39, 40)));
        this.testArena.addBrick(new BrickImpl(BrickType.ORANGE, new CoordImpl(67, 11)));
        this.testArena.addBrick(new BrickImpl(BrickType.PURPLE, new CoordImpl(40, 23)));
        this.testArena.addBrick(new BrickImpl(BrickType.YELLOW, new CoordImpl(17, 22)));
        assertEquals(6, this.testArena.getBricks().size());
    }
}