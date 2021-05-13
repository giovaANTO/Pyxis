package it.unibo.pyxis.element;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.CoordImpl;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.DimensionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    private Element element1;
    private Dimension startingDimension;
    private Coord startingPosition;

    @BeforeEach
    void setUp() {
        this.startingDimension = new DimensionImpl(4.0, 5.0);
        this.startingPosition = new CoordImpl(4.0, 5.0);
        this.element1 = new ToTestElement(startingDimension.copyOf(), startingPosition.copyOf());
    }

    @Test
    public void testDimension() {
        System.out.println("testDimension");
        assertEquals(this.element1.getDimension(), this.startingDimension);
        Dimension modifyDimension = this.element1.getDimension();
        modifyDimension.increaseHeight(5);
        assertNotEquals(this.element1.getDimension(), modifyDimension);
        this.element1.increaseHeight(5);
        assertEquals(this.element1.getDimension(), modifyDimension);
    }

    @Test
    public void testPosition() {
        System.out.println("testPosition");
        assertEquals(this.element1.getPosition(), this.startingPosition);
        Coord modifyPosition = this.element1.getPosition();
        modifyPosition.setX(this.startingPosition.getX() + 10);
        assertNotEquals(this.element1.getPosition(), modifyPosition);
        this.element1.setPosition(new CoordImpl(
                this.element1.getPosition().getX() + 10,
                this.element1.getPosition().getY()));
        assertEquals(this.element1.getPosition(), modifyPosition);
    }

}