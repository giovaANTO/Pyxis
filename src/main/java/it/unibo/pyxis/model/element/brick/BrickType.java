package it.unibo.pyxis.model.element.brick;

import java.util.Optional;

/**
 * Enumerator for the typologies of bricks.
 */
public enum BrickType {
    /**
     * Brick that can handle only one collision.
     */
    RED(Optional.of(1), "RED"),

    /**
     * Brick that can handle two collisions.
     */
    ORANGE(Optional.of(2), "ORANGE"),

    /**
     * Brick that can handle three collisions.
     */
    YELLOW(Optional.of(3), "YELLOW"),

    /**
     * Brick that can handle four collisions.
     */
    GREEN(Optional.of(4), "GREEN"),

    /**
     * Brick that can handle five collisions.
     */
    BLUE(Optional.of(5), "BLUE"),

    /**
     * Brick that can handle six collisions.
     */
    PURPLE(Optional.of(6), "PURPLE"),

    /**
     * Brick that can't be destroyed.
     */
    INDESTRUCTIBLE(Optional.empty(), "INDESTRUCTIBLE");

    private final Optional<Integer> durability;

    private final String typeString;

    BrickType(final Optional<Integer>  inputLife, final String inputType) {
        this.durability = inputLife;
        this.typeString = inputType;
    }

    /**
     * Check if a certain brick type is indestructible.
     *
     * @return
     *          True if the brick is indestructible, false otherwise.
     */
    public boolean isIndestructible() {
        return durability.isEmpty();
    }

    /**
     * Return the initial durability of the brick.
     *
     * @return
     *           An integer representing the durability of the the brick
     */
    public int getDurability() {
        return durability.orElse(0);
    }

    /**
     * Return a string indicating the type of the brick.
     * @return
     *          The string indicating the type of brick.
     */
    public String getTypeString() {
        return this.typeString;
    }
}
