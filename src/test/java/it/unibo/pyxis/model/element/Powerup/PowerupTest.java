package it.unibo.pyxis.model.element.Powerup;

import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.element.powerup.PowerupImpl;
import it.unibo.pyxis.model.element.powerup.PowerupType;
import it.unibo.pyxis.model.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PowerupTest {

    private Powerup powerup1;
    private Coord startingCoordinates;
    private PowerupType checkType;
    private int dt;

    @BeforeEach
    private void setUp() {
        this.startingCoordinates = new CoordImpl(3, 5);
        this.checkType = PowerupType.INCREASE_PAD;
        this.powerup1 = new PowerupImpl(this.checkType, this.startingCoordinates.copyOf());
        this.dt = 200;
    }

    @Test
    public void testStartingSetters() {
        System.out.println("testStartingSetters");
        assertEquals(this.powerup1.getType(), this.checkType);
        assertEquals(this.powerup1.getPosition(), this.startingCoordinates);
    }

    @Test
    public void testUpdate() {
        this.powerup1.update(this.dt);
        assertNotEquals(this.powerup1.getPosition(), this.startingCoordinates);
        final Coord updatedCoordinates = new
                CoordImpl(this.startingCoordinates.getX() +
                            this.powerup1.getPace().getX() * this.dt *
                                    this.powerup1.getUpdateTimeMultiplier(),
                        this.startingCoordinates.getY() +
                                this.powerup1.getPace().getY() * this.dt *
                                        this.powerup1.getUpdateTimeMultiplier());
        assertEquals(this.powerup1.getPosition(), updatedCoordinates);
    }
}
