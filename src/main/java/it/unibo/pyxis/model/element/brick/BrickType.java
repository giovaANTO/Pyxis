package it.unibo.pyxis.model.element.brick;

import java.util.Optional;

/**
 * Enumerator for the typologies of bricks.
 */
public enum BrickType {
    /**
     * Brick that is destroyed by only one collision.
     */
    RED(Optional.of(1), "RED", 100),

    /**
     * Brick that is destroyed by two collisions.
     */
    ORANGE(Optional.of(2), "ORANGE", 200),

    /**
     * Brick that is destroyed by three collisions.
     */
    YELLOW(Optional.of(3), "YELLOW", 300),

    /**
     * Brick that is destroyed by four collisions.
     */
    GREEN(Optional.of(4), "GREEN", 400),

    /**
     * Brick that is destroyed by five collisions.
     */
    BLUE(Optional.of(5), "BLUE", 500),

    /**
     * Brick that is destroyed by six collisions.
     */
    PURPLE(Optional.of(6), "PURPLE", 600),

    /**
     * Brick that can't be destroyed.
     */
    INDESTRUCTIBLE(Optional.empty(), "INDESTRUCTIBLE", 0);

    private final Optional<Integer> durability;
    private final String typeString;
    private final int points;

    BrickType(final Optional<Integer>  inputLife, final String inputType, final int inputPoints) {
        this.durability = inputLife;
        this.typeString = inputType;
        this.points = inputPoints;
    }

    /**
     * Returns the initial durability of the {@link Brick}.
     *
     * @return An integer representing the durability of the {@link Brick}.
     */
    public int getDurability() {
        return durability.orElse(0);
    }

    /**
     * Returns the number of points obtained on the {@link Brick} destruction.
     *
     * @return An integer value representing the points gained.
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Returns a string indicating the type of the {@link Brick}.
     *
     * @return The string indicating the type of {@link Brick}.
     */
    public String getTypeString() {
        return this.typeString;
    }

    /**
     * Checks if a certain {@link BrickType} is indestructible.
     *
     * @return True if the brick is indestructible.
     *         False otherwise.
     */
    public boolean isIndestructible() {
        return durability.isEmpty();
    }
}
