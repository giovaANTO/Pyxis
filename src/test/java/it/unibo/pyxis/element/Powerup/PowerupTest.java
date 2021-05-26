package it.unibo.pyxis.element.Powerup;

import it.unibo.pyxis.element.powerup.Powerup;
import it.unibo.pyxis.element.powerup.PowerupImpl;
import it.unibo.pyxis.element.powerup.PowerupType;
import it.unibo.pyxis.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PowerupTest {

    private Powerup powerup1;
    private Coord startingCoordinates;
    private Vector startingPace;
    private Dimension startingDimension;
    private PowerupType startingType;

    @BeforeEach
    private void setUp() {
        this.startingCoordinates = new CoordImpl(3, 5);
        this.startingType = PowerupType.INCREASE_PAD;
        this.powerup1 = new PowerupImpl(this.startingType, this.startingCoordinates.copyOf());
        this.startingPace = new VectorImpl(1, 1);
        this.startingDimension = new DimensionImpl(1, 1);
    }

    @Test
    public void testStartingSetters() {
        System.out.println("testStartingSetters");
        assertEquals(this.powerup1.getType(), this.startingType);
        assertEquals(this.powerup1.getPosition(), this.startingCoordinates);
        assertEquals(this.powerup1.getPace(), this.startingPace);
        assertEquals(this.powerup1.getDimension(), this.startingDimension);
    }

    @Test
    public void testUpdate() {
        this.powerup1.update();
        assertNotEquals(this.powerup1.getPosition(), this.startingCoordinates);
        final Coord updatedCoordinates = new
                CoordImpl(this.startingCoordinates.getX() + this.startingPace.getX(),
                        this.startingCoordinates.getY() + this.startingPace.getY());
        assertEquals(this.powerup1.getPosition(), updatedCoordinates);
    }
}
