package it.unibo.pyxis.model.element;

import it.unibo.pyxis.model.hitbox.Hitbox;
import it.unibo.pyxis.model.hitbox.RectHitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    private Element element1;
    private Dimension startingDimension;
    private Coord startingPosition;
    private Hitbox hitbox;

    @BeforeEach
    void setUp() {
        this.startingDimension = new DimensionImpl(4.0, 5.0);
        this.startingPosition = new CoordImpl(4.0, 5.0);
        this.hitbox = new RectHitbox(startingPosition,startingDimension);
        this.element1 = new ToTestElement(startingDimension.copyOf(), startingPosition.copyOf(), hitbox);
    }

    @Test
    public void testDimension() {
        System.out.println("testDimension");
        assertEquals(this.element1.getDimension(), this.startingDimension);
        final Dimension modifyDimension = this.element1.getDimension();
        modifyDimension.increaseHeight(5);
        assertNotEquals(this.element1.getDimension(), modifyDimension);
        this.element1.increaseHeight(5);
        assertEquals(this.element1.getDimension(), modifyDimension);
    }

    @Test
    public void testPosition() {
        System.out.println("testPosition");
        assertEquals(this.element1.getPosition(), this.startingPosition);
        final Coord modifyPosition = this.element1.getPosition();
        modifyPosition.setX(this.startingPosition.getX() + 10);
        assertNotEquals(this.element1.getPosition(), modifyPosition);
        final Coord newPosition = new CoordImpl(this.element1.getPosition().getX() + 10, this.element1.getPosition().getY());
        this.element1.setPosition(newPosition);
        assertEquals(this.element1.getPosition(), modifyPosition);
    }

}