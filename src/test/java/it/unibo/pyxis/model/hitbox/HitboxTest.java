package it.unibo.pyxis.model.hitbox;

import it.unibo.pyxis.model.element.pad.PadImpl;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

        final Coord coord1 = new CoordImpl(10,10);
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
    void testCollidingEdgeWithHB() {

        final Coord coord1 = new CoordImpl(10,10);
        final Coord coord2 = new CoordImpl(15, 17);

        final Dimension dimension1 = new DimensionImpl(3, 5);
        final Dimension dimension2 = new DimensionImpl(9, 9);

        final Hitbox rectHB1 = new PadImpl(dimension1, coord1).getHitbox();
        final Hitbox rectHB2 = new PadImpl(dimension2, coord2).getHitbox();

//        final Optional<HitEdge> result = rectHB1.collidingEdgeWithHB(rectHB2);
//        assertTrue(result.isPresent());
//        assertEquals(HitEdge.CORNER, result.get());
    }

    @Test
    void testCollidingEdgeWithBorder() {
        final Coord coord1 = new CoordImpl(3, 3);
        final Coord coord2 = new CoordImpl(6, 5);
        final Coord coord3 = new CoordImpl(6, 25);
        final Coord coord4 = new CoordImpl(13, 19);

        final Dimension borderDimension = new DimensionImpl(20, 30);
        final Dimension dimension1 = new DimensionImpl(4, 6);
        final Dimension dimension2 = new DimensionImpl(12, 10);
        final Dimension dimension3 = new DimensionImpl(12, 9.9);

        final Dimension dimension4 = new DimensionImpl(12, 10);

        final Hitbox rectHBToHitUp = new PadImpl(dimension1, coord1).getHitbox();
        final Hitbox rectHBToHitCorner = new PadImpl(dimension2, coord2).getHitbox();
        final Hitbox rectHBToHitLeft = new PadImpl(dimension3, coord3).getHitbox();
        final Hitbox rectHBToMiss = new PadImpl(dimension4, coord4).getHitbox();

//        Optional<HitEdge> result = rectHBToHitUp.collidingEdgeWithBorder(borderDimension);
//        assertTrue(result.isPresent());
//        assertEquals(HitEdge.HORIZONTAL, result.get());
//
//        result = rectHBToHitCorner.collidingEdgeWithBorder(borderDimension);
//        assertTrue(result.isPresent());
//        assertEquals(HitEdge.CORNER, result.get());
//
//        result = rectHBToHitLeft.collidingEdgeWithBorder(borderDimension);
//        assertTrue(result.isPresent());
//        assertEquals(HitEdge.VERTICAL, result.get());
//
//        result = rectHBToMiss.collidingEdgeWithBorder(borderDimension);
//        assertFalse(result.isPresent());
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