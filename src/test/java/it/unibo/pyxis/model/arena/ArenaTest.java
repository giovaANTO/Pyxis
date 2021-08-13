package it.unibo.pyxis.model.arena;

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
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    private Arena testArena;
    private final Dimension inputDimensions = new DimensionImpl(500, 500);

    @BeforeEach
    public void init() {
        this.testArena = new ArenaImpl(this.inputDimensions);
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
    public void testPadMovementLeft() {
        final Pad inputPad = new PadImpl(new CoordImpl(250, 8));
        this.testArena.setPad(inputPad);
        assertEquals(250, this.testArena.getPad().getPosition().getX());
        this.testArena.movePadLeft();
        assertEquals(240, this.testArena.getPad().getPosition().getX());
    }

    @Test
    public void testPadMovementRigth() {
        final Pad inputPad = new PadImpl(new CoordImpl(250, 8));
        this.testArena.setPad(inputPad);
        assertEquals(250, this.testArena.getPad().getPosition().getX());
        this.testArena.movePadRight();
        assertEquals(260, this.testArena.getPad().getPosition().getX());
    }

    @Test
    public void testModifyPadDimension() {
        this.testArena.setPad(new PadImpl(new CoordImpl(7,8)));
        assertEquals(70, this.testArena.getPad().getDimension().getWidth());
        this.testArena.increasePadWidth(10);
        assertEquals(80, this.testArena.getPad().getDimension().getWidth());
        this.testArena.increasePadWidth(-30);
        assertEquals(50, this.testArena.getPad().getDimension().getWidth());
    }

    @Test
    public void testRestorePadDimension() {
        final Pad inputPad = new PadImpl(new CoordImpl(7,8));
        assertEquals(70, inputPad.getDimension().getWidth());
        this.testArena.setPad(inputPad);
        this.testArena.increasePadWidth(10);
        this.testArena.restorePadDimension();
        assertEquals(70, this.testArena.getPad().getDimension().getWidth());
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

    @Test
    public void testBrickClear() {
        for (int i = 1; i <= 10; i++) {
            final Brick brick = new BrickImpl(BrickType.BLUE, new CoordImpl(i, 6));
            this.testArena.addBrick(brick);
        }
        assertEquals(10, this.testArena.getBricks().size());
        this.testArena.clearBricks();
        assertEquals(0, this.testArena.getBricks().size());
    }

    @Test
    public void testCantRegisterTwoBricksInSamePosition() {
        final Brick brick1 = new BrickImpl(BrickType.RED, new CoordImpl(2,2));
        final Brick brick2 = new BrickImpl(BrickType.PURPLE, new CoordImpl(2,2));
        this.testArena.addBrick(brick1);
        assertTrue(this.testArena.getBricks().contains(brick1));
        assertThrows(IllegalArgumentException.class, () -> this.testArena.addBrick(brick2));
    }

    @Test
    public void testAddPowerup() {
        final Powerup toAddPowerup = new PowerupImpl(PowerupType.ATOMIC_BALL, new CoordImpl(1, 1));
        this.testArena.addPowerup(toAddPowerup);
        assertTrue(this.testArena.getPowerups().contains(toAddPowerup));
    }

    @Test
    public void testPowerupClear() {
        for (int i = 1; i <= 10; i++) {
            final PowerupType selectedType = PowerupType.values()[new Random().nextInt(PowerupType.values().length)];
            final Powerup powerup = new PowerupImpl(selectedType, new CoordImpl(i, 20));
            this.testArena.addPowerup(powerup);
        }
        assertEquals(10, this.testArena.getPowerups().size());
        this.testArena.clearPowerups();
        assertEquals(0, this.testArena.getPowerups().size());
    }
}