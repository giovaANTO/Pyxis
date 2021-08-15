package it.unibo.pyxis.model.element.factory;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallImpl;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickImpl;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Vector;
import it.unibo.pyxis.model.util.VectorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementFactoryTest {

    final ElementFactory factory = new ElementFactoryImpl();


    @Test
    void createRedBrick() {
        final Brick brick = this.factory.createRedBrick(new CoordImpl(1,1));
        assertEquals(BrickType.RED, brick.getBrickType());
        assertEquals(new CoordImpl(1,1), brick.getPosition());
    }

    @Test
    void createOrangeBrick() {
        final Brick brick = this.factory.createOrangeBrick(new CoordImpl(1,1));
        assertEquals(BrickType.ORANGE, brick.getBrickType());
        assertEquals(new CoordImpl(1,1), brick.getPosition());
    }

    @Test
    void createYellowBrick() {
        final Brick brick = this.factory.createYellowBrick(new CoordImpl(1,1));
        assertEquals(BrickType.YELLOW, brick.getBrickType());
        assertEquals(new CoordImpl(1,1), brick.getPosition());
    }

    @Test
    void createGreenBrick() {
        final Brick brick = this.factory.createGreenBrick(new CoordImpl(1,1));
        assertEquals(BrickType.GREEN, brick.getBrickType());
        assertEquals(new CoordImpl(1,1), brick.getPosition());
    }

    @Test
    void createBlueBrick() {
        final Brick brick = this.factory.createBlueBrick(new CoordImpl(1,1));
        assertEquals(BrickType.BLUE, brick.getBrickType());
        assertEquals(new CoordImpl(1,1), brick.getPosition());
    }

    @Test
    void createPurpleBrick() {
        final Brick brick = this.factory.createPurpleBrick(new CoordImpl(1,1));
        assertEquals(BrickType.PURPLE, brick.getBrickType());
        assertEquals(new CoordImpl(1,1), brick.getPosition());
    }

    @Test
    void createIndestructibleBrick() {
        final Brick brick = this.factory.createIndestructibleBrick(new CoordImpl(1,1));
        assertEquals(BrickType.INDESTRUCTIBLE, brick.getBrickType());
        assertEquals(new CoordImpl(1,1), brick.getPosition());
    }

    @Test
    void copyBallWithAngle() {
        final Vector initalPace = new VectorImpl(2,2);
        final Vector angledPace = initalPace.createVectorWithSameModule(20);
        final Coord initialPosition = new CoordImpl(1,1);
        final Ball ballToCopy = new BallImpl.Builder()
                .ballType(BallType.NORMAL_BALL)
                .id(1)
                .initialPosition(initialPosition)
                .pace(initalPace)
                .build();

        final Ball copiedBall = this.factory.copyBallWithAngle(ballToCopy, 20, 2);
        assertEquals(angledPace, copiedBall.getPace());
        assertEquals(ballToCopy.getType(), copiedBall.getType());
        assertEquals(ballToCopy.getPosition(), copiedBall.getPosition());
    }

    @Test
    void copyBallWithType() {
        final Vector initalPace = new VectorImpl(2,2);
        final Vector angledPace = initalPace.createVectorWithSameModule(20);
        final Coord initialPosition = new CoordImpl(1,1);
        final Ball ballToCopy = new BallImpl.Builder()
                .ballType(BallType.NORMAL_BALL)
                .id(1)
                .initialPosition(initialPosition)
                .pace(initalPace)
                .build();

        final Ball copiedBall = this.factory.copyBallWithType(ballToCopy, 20, 2, BallType.ATOMIC_BALL);
        assertEquals(angledPace, copiedBall.getPace());
        assertEquals(BallType.ATOMIC_BALL, copiedBall.getType());
        assertEquals(ballToCopy.getPosition(), copiedBall.getPosition());
    }
}