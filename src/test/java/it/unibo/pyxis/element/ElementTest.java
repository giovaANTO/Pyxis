package it.unibo.pyxis.element;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.CoordImpl;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.DimensionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ElementTest {

    private Element element1;

    @BeforeEach
    void setUp() {
        this.element1 = new ToTestElement(new DimensionImpl(4.0, 5.0), new CoordImpl(4.0, 5.0));
    }

    @Test
    public void testDimension() {
        System.out.println("testDimension");
        Dimension elemDimension = new DimensionImpl(4.0, 5.0);
        assertEquals(this.element1.getDimension(), elemDimension);
    }

    @Test
    public void testPosition() {
        System.out.println("testPosition");
        Coord elemPosition = new CoordImpl(4.0, 5.0);
        assertEquals(this.element1.getPosition(), elemPosition);
    }

}