package it.unibo.pyxis.model.element.brick;

import it.unibo.pyxis.model.element.Element;


public interface Brick extends Element {

    /**
     * Allows to access the typology of the {@link Brick}.
     *
     * @return The {@link BrickType} value for this {@link Brick}.
     */
    BrickType getBrickType();

    /**
     * Returns the {@link Brick}'s durability.
     *
     * @return The integer representing the durability of the brick.
     */
    int getDurability();

    /**
     * Sets the {@link Brick}'s durability.
     *
     * @param inputDurability The durability to set.
     */
    void setDurability(int inputDurability);
}
