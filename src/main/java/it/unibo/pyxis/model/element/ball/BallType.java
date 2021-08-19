package it.unibo.pyxis.model.element.ball;

import java.util.Optional;

public enum BallType {

    /**
     * The {@link Ball}'s standard type.
     */
    NORMAL_BALL(Optional.of(1), 1, true, "NORMAL"),

    /**
     * The {@link Ball}'s type that gives infinite damage and no bouncing peculiarities.
     */
    ATOMIC_BALL(Optional.empty(), 1, false, "ATOMIC"),

    /**
     * The {@link Ball}'s type that gives infinite damage.
     */
    STEEL_BALL(Optional.empty(), 1, true, "STEEL");

    private final Optional<Integer> damage;
    private final double paceMultiplier;
    private final boolean bounce;
    private final String typeString;

    BallType(final Optional<Integer> inputDamage,
             final double inputPaceMultiplier, final boolean inputBounce, final String type) {
        this.damage = inputDamage;
        this.paceMultiplier = inputPaceMultiplier;
        this.bounce = inputBounce;
        this.typeString = type;
    }

    /**
     * Returns the {@link Ball}'s property of bouncing if collided with a destructible
     * {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @return True if the {@link Ball} bounces.
     *         False if the {@link Ball} doesn't bounce.
     */
    public boolean bounce() {
        return this.bounce;
    }

    /**
     * Returns the {@link Ball}'s damage as Optional<Integer>.
     *
     * @return  Optional empty if damage is infinite.
     *          Optional of an integer representing damage.
     */
    public Optional<Integer> getDamage() {
        return this.damage;
    }

    /**
     * Returns the {@link Ball}'s {@link it.unibo.pyxis.model.util.Vector} pace
     * multiplier.
     *
     * @return double representing {@link Ball}'s
     * {@link it.unibo.pyxis.model.util.Vector} pace multiplier.
     */
    public double getPaceMultiplier() {
        return this.paceMultiplier;
    }

    /**
     * Returns the {@link String} representing the {@link BallType}.
     *
     * @return The {@link BallType}.
     */
    public String getType() {
        return this.typeString;
    }
}
