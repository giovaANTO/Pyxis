package it.unibo.pyxis.model.element.brick;

import java.util.Optional;

/**
 * Enumerator for the typologies of bricks.
 */
public enum BrickType {
    /**
     * Brick that can handle only one collision.
     */
    RED(Optional.of(1)),

    /**
     * Brick that can handle two collisions.
     */
    ORANGE(Optional.of(2)),

    /**
     * Brick that can handle three collisions.
     */
    YELLOW(Optional.of(3)),

    /**
     * Brick that can handle four collisions.
     */
    GREEN(Optional.of(4)),

    /**
     * Brick that can handle five collisions.
     */
    BLUE(Optional.of(5)),

    /**
     * Brick that can handle six collisions.
     */
    PURPLE(Optional.of(6)),

    /**
     * Brick that can't be destroyed.
     */
    INDESTRUCTIBLE(Optional.empty());

    private final Optional<Integer> durability;

    BrickType(final Optional<Integer>  inputLife) {
        this.durability = inputLife;
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
}
