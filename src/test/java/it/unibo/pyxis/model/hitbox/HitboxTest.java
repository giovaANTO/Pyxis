package it.unibo.pyxis.model.hitbox;

import it.unibo.pyxis.model.element.ball.BallImpl;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.pad.PadImpl;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.VectorImpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

class HitboxTest {

    @Test
    void testCollidingWithPoint() {
        final Coord coord = new CoordImpl(10,10);
        final Dimension dimension = new DimensionImpl(3,5);
        final Hitbox rectBox = new PadImpl(dimension, coord).getHitbox();

        assertTrue(rectBox.isCollidingWithPoint(new CoordImpl(11, 8)));
        assertTrue(rectBox.isCollidingWithPoint(new CoordImpl(11.5, 7.5)));
        assertFalse(rectBox.isCollidingWithPoint(new CoordImpl(11.6, 7.5)));
        assertFalse(rectBox.isCollidingWithPoint(new CoordImpl(11, 7)));
    }

    @Test
    void testCollidingWithHB() {

        final Coord coord1 = new CoordImpl(10, 10);
        final Coord coord2 = new CoordImpl(10, 11);
        final Coord coord3 = new CoordImpl(10, 1);

        final Dimension dimension1 = new DimensionImpl(3,5);
        final Dimension dimension2 = new DimensionImpl(2,1);

        final Hitbox rectHB2 = new PadImpl(dimension1, coord1).getHitbox();
        final Hitbox rectHBToHit = new PadImpl(dimension2, coord2).getHitbox();
        final Hitbox rectHBToMiss = new PadImpl(dimension2, coord3).getHitbox();

        assertTrue(rectHB2.isCollidingWithHB(rectHBToHit));
        assertFalse(rectHB2.isCollidingWithHB(rectHBToMiss));
    }

    @Test
    void testCollidingInformationWithHB() {

        final Coord coord1 = new CoordImpl(10, 10);
        final Coord coord2 = new CoordImpl(15, 17);
        final Coord coord3 = new CoordImpl(15.5, 10);
        final Coord coord4 = new CoordImpl(10, 19.5);
        final Coord coord5 = new CoordImpl(7, 15);
        final Coord coord6 = new CoordImpl(17.5, 17.5);

        final Dimension dimension1 = new DimensionImpl(3, 5);
        final Dimension dimension2 = new DimensionImpl(9, 10);

        final Hitbox rectHB = new PadImpl(dimension1, coord1).getHitbox();
        final Hitbox rectHBToHitCorner = new PadImpl(dimension2, coord2).getHitbox();
        final Hitbox ballHBToHitVertical = new BallImpl.Builder()
                                                .ballType(BallType.NORMAL_BALL)
                                                .id(0)
                                                .pace(new VectorImpl(0, 0))
                                                .initialPosition(coord3)
                                                .build()
                                                .getHitbox();
        final Hitbox ballHBToHitHorizontal = new BallImpl.Builder()
                                                .ballType(BallType.NORMAL_BALL)
                                                .id(0)
                                                .pace(new VectorImpl(0, 0))
                                                .initialPosition(coord4)
                                                .build()
                                                .getHitbox();
        final Hitbox ballHBToHitCorner = new BallImpl.Builder()
                                                .ballType(BallType.NORMAL_BALL)
                                                .id(0)
                                                .pace(new VectorImpl(1, -1))
                                                .initialPosition(coord5)
                                                .build()
                                                .getHitbox();
        final Hitbox ballHBToHitMiss = new BallImpl.Builder()
                                                .ballType(BallType.NORMAL_BALL)
                                                .id(0)
                                                .pace(new VectorImpl(0, 0))
                                                .initialPosition(coord6)
                                                .build()
                                                .getHitbox();

        Optional<CollisionInformation> result = rectHB.collidingInformationWithHB(rectHBToHitCorner);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.CORNER, result.get().getHitEdge());
        assertEquals(new DimensionImpl(1, 0.5), result.get().getCollisionOffset());

        result = rectHB.collidingInformationWithHB(ballHBToHitVertical);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.VERTICAL, result.get().getHitEdge());
        assertEquals(new DimensionImpl(3, 0), result.get().getCollisionOffset());

        result = rectHB.collidingInformationWithHB(ballHBToHitHorizontal);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.HORIZONTAL, result.get().getHitEdge());
        assertEquals(new DimensionImpl(0, 0), result.get().getCollisionOffset());

        result = rectHB.collidingInformationWithHB(ballHBToHitCorner);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.CORNER, result.get().getHitEdge());

        result = rectHB.collidingInformationWithHB(ballHBToHitMiss);
        assertFalse(result.isPresent());
    }

    @Test
    void testCollidingInformationWithBorder() {
        final Coord coord1 = new CoordImpl(3, 3);
        final Coord coord2 = new CoordImpl(6, 5);
        final Coord coord3 = new CoordImpl(5, 25);
        final Coord coord4 = new CoordImpl(13, 19);
        final Coord coord5 = new CoordImpl(16, 15);

        final Dimension borderDimension = new DimensionImpl(20, 30);
        final Dimension dimension1 = new DimensionImpl(4, 7);
        final Dimension dimension2 = new DimensionImpl(12, 10);
        final Dimension dimension3 = new DimensionImpl(12, 9.9);

        final Dimension dimension4 = new DimensionImpl(12, 10);

        final Hitbox rectHBToHitUp = new PadImpl(dimension1, coord1).getHitbox();
        final Hitbox rectHBToHitCorner = new PadImpl(dimension2, coord2).getHitbox();
        final Hitbox rectHBToHitLeft = new PadImpl(dimension3, coord3).getHitbox();
        final Hitbox rectHBToMiss = new PadImpl(dimension4, coord4).getHitbox();
        final Hitbox ballHBToHitRight = new BallImpl.Builder()
                                                .ballType(BallType.NORMAL_BALL)
                                                .id(0)
                                                .pace(new VectorImpl(0, 0))
                                                .initialPosition(coord5)
                                                .build()
                                                .getHitbox();

        Optional<CollisionInformation> result = rectHBToHitUp.collidingInformationWithBorder(borderDimension);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.HORIZONTAL, result.get().getHitEdge());
        assertEquals(new DimensionImpl(0, 0.5), result.get().getCollisionOffset());

        result = rectHBToHitCorner.collidingInformationWithBorder(borderDimension);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.CORNER, result.get().getHitEdge());
        assertEquals(new DimensionImpl(0, 0), result.get().getCollisionOffset());

        result = rectHBToHitLeft.collidingInformationWithBorder(borderDimension);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.VERTICAL, result.get().getHitEdge());
        assertEquals(new DimensionImpl(1, 0), result.get().getCollisionOffset());

        result = rectHBToMiss.collidingInformationWithBorder(borderDimension);
        assertFalse(result.isPresent());

        result = ballHBToHitRight.collidingInformationWithBorder(borderDimension);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.VERTICAL, result.get().getHitEdge());
        assertEquals(new DimensionImpl(3, 0), result.get().getCollisionOffset());
    }

    @Test
    void testCollidingWithLowerBorder() {
        final Coord coord1 = new CoordImpl(9, 27);

        final Coord coord2 = new CoordImpl(5, 26);

        final Dimension borderDimension = new DimensionImpl(20, 30);
        final Dimension dimension1 = new DimensionImpl(5, 6);

        final Dimension dimension2 = new DimensionImpl(10, 7.9);

        final Hitbox rectHBToHit = new PadImpl(dimension1, coord1).getHitbox();
        final Hitbox rectHBToMiss = new PadImpl(dimension2, coord2).getHitbox();

        assertTrue(rectHBToHit.isCollidingWithLowerBorder(borderDimension));
        assertFalse(rectHBToMiss.isCollidingWithLowerBorder(borderDimension));
    }
}