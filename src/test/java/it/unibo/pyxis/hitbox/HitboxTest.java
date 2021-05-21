package it.unibo.pyxis.hitbox;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.CoordImpl;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.DimensionImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HitboxTest {
    
    @Test
    void isCollidingWithPoint() {
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
    void isCollidingWithOtherHB() {
    }

    @Test
    void isCollidingWithSameHB() {

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
    void collidingEdgeWithOtherHB() {
    }
}