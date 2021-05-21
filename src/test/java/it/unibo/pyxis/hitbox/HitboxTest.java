package it.unibo.pyxis.hitbox;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.CoordImpl;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.DimensionImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HitboxTest {

    @Test
    void testCollidingWithPoint() {
        final Coord coord = new CoordImpl(10,10);
        final Dimension dimension = new DimensionImpl(3,5);
        final Hitbox rectBox = new HitboxImpl.RectHitbox(coord, dimension);

        assertTrue(rectBox.isCollidingWithPoint(new CoordImpl(11, 8)));
        assertTrue(rectBox.isCollidingWithPoint(new CoordImpl(11.5, 7.5)));
        assertFalse(rectBox.isCollidingWithPoint(new CoordImpl(11.6, 7.5)));
        assertFalse(rectBox.isCollidingWithPoint(new CoordImpl(11, 7)));

        final Hitbox circleBox = new HitboxImpl.CircleHitbox(coord, 5.9);

        assertTrue(circleBox.isCollidingWithPoint(new CoordImpl(11, 8)));
        assertTrue(circleBox.isCollidingWithPoint(new CoordImpl(11.5, 7.5)));
        assertFalse(circleBox.isCollidingWithPoint(new CoordImpl(11.6, 7.5)));
        assertFalse(circleBox.isCollidingWithPoint(new CoordImpl(10, 7)));
    }

    @Test
    void testCollidingWithOtherHB() {

        final Coord coord1 = new CoordImpl(10,10);
        final Coord coord2 = new CoordImpl(13, 11);
        final Coord coord3 = new CoordImpl(14, 11);

        final Dimension dimension1 = new DimensionImpl(3,5);
        final Dimension dimension2 = new DimensionImpl(2,1);

        final Hitbox rectBox = new HitboxImpl.RectHitbox(coord1, dimension1);
        final Hitbox circleBoxToHit = new HitboxImpl.CircleHitbox(coord2, 6.0);
        final Hitbox circleBoxToMiss = new HitboxImpl.CircleHitbox(coord3, 4.0);

        assertTrue(rectBox.isCollidingWithOtherHB((HitboxImpl) circleBoxToHit));
        assertFalse(rectBox.isCollidingWithOtherHB((HitboxImpl) circleBoxToMiss));

        final Hitbox circleBox = new HitboxImpl.CircleHitbox(coord1, 6.0);
        final Hitbox rectBoxToHit = new HitboxImpl.RectHitbox(coord2, dimension2);
        final Hitbox rectBoxToMiss = new HitboxImpl.RectHitbox(coord3, dimension2);

        assertTrue(circleBox.isCollidingWithOtherHB((HitboxImpl) rectBoxToHit));
        assertFalse(circleBox.isCollidingWithOtherHB((HitboxImpl) rectBoxToMiss));
    }

    @Test
    void testCollidingWithSameHB() {

        final Coord coord1 = new CoordImpl(10,10);
        final Coord coord2 = new CoordImpl(10, 11);
        final Coord coord3 = new CoordImpl(10, 1);

        final Dimension dimension1 = new DimensionImpl(3,5);
        final Dimension dimension2 = new DimensionImpl(2,1);

        final Hitbox rectBox = new HitboxImpl.RectHitbox(coord1, dimension1);
        final Hitbox rectBoxToHit = new HitboxImpl.RectHitbox(coord2, dimension2);
        final Hitbox rectBoxToMiss = new HitboxImpl.RectHitbox(coord3, dimension2);

        assertTrue(rectBox.isCollidingWithSameHB((HitboxImpl) rectBoxToHit));
        assertFalse(rectBox.isCollidingWithSameHB((HitboxImpl) rectBoxToMiss));

        final Hitbox circleBox = new HitboxImpl.CircleHitbox(coord1, 6.0);
        final Hitbox circleBoxToHit = new HitboxImpl.CircleHitbox(coord2, 4.0);
        final Hitbox circleBoxToMiss = new HitboxImpl.CircleHitbox(coord3, 4.0);

        assertTrue(circleBox.isCollidingWithSameHB((HitboxImpl) circleBoxToHit));
        assertFalse(circleBox.isCollidingWithSameHB((HitboxImpl) circleBoxToMiss));
    }

    @Test
    void testCollidingEdgeWithOtherHB() {
        final Coord coord1 = new CoordImpl(10,10);
        final Coord coord2 = new CoordImpl(13, 11);
        final Coord coord3 = new CoordImpl(12, 13);
        final Coord coord4 = new CoordImpl(9.5, 8);
        final Coord coord5 = new CoordImpl(8.5, 13.9);

        final Dimension dimension1 = new DimensionImpl(3,5);

        final Hitbox rectBox = new HitboxImpl.RectHitbox(coord1, dimension1);
        final Hitbox circleBoxToHit = new HitboxImpl.CircleHitbox(coord2, 6.0);

        Optional<HitEdge> result = rectBox.collidingEdgeWithOtherHB((HitboxImpl) circleBoxToHit);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.VERTICAL, result.get());

        final Hitbox circleBoxToHit2 = new HitboxImpl.CircleHitbox(coord3, 2.0);

        result = rectBox.collidingEdgeWithOtherHB((HitboxImpl) circleBoxToHit2);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.CORNER, result.get());

        final Hitbox circleBoxToHit3 = new HitboxImpl.CircleHitbox(coord3, 1.3);

        result = rectBox.collidingEdgeWithOtherHB((HitboxImpl) circleBoxToHit3);
        assertTrue(result.isEmpty());

        final Hitbox circleBoxToHit4 = new HitboxImpl.CircleHitbox(coord4, 10.0);

        result = rectBox.collidingEdgeWithOtherHB((HitboxImpl) circleBoxToHit4);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.VERTICAL, result.get());

        final Hitbox circleBoxToHit5 = new HitboxImpl.CircleHitbox(coord5, 10.0);

        result = rectBox.collidingEdgeWithOtherHB((HitboxImpl) circleBoxToHit5);
        assertTrue(result.isPresent());
        assertEquals(HitEdge.HORIZONTAL, result.get());
    }
}