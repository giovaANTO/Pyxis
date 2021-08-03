package it.unibo.pyxis.model.element.brick;

import it.unibo.pyxis.model.element.Element;


public interface Brick extends Element {
    /**
     * Returns the brick's durability.
     * @return
     *          The integer representing the durability of the brick.
     */
    int getDurability();

    /**
     * Sets the brick's durability.
     * @param inputDurability
     *                        The durability to set.
     */
    void setDurability(int inputDurability);

    /**
     * Allow to access the typology of the brick.
     *
     * @return
     *          The {@link BrickType} value for this brick
     */
    BrickType getBrickType();
}
