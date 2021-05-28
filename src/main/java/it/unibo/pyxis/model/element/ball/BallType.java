package it.unibo.pyxis.model.element.ball;

import java.util.Optional;

public enum BallType {

    /**
     * The ball's standard type.
     */
    NORMAL_BALL(Optional.of(1), 1, true),
    /**
     * A ball's type that gives infinite damage and no bouncing peculiarity.
     */
    ATOMIC_BALL(Optional.empty(), 1, false),
    /**
     * A ball's type that gives infinite damage.
     */
    STEEL_BALL(Optional.empty(), 1, true);

    private final Optional<Integer> damage;
    private final double paceMultiplier;
    private final boolean bounce;

    BallType(final Optional<Integer> inputDamage,
                     final double inputPaceMultiplier, final boolean inputBounce) {
        this.damage = inputDamage;
        this.paceMultiplier = inputPaceMultiplier;
        this.bounce = inputBounce;
    }

    /**
     * Returns the ball's damage as Optional<Integer>.
     * @return  Optional empty if damage is infinite,
     *          Optional of an integer representing damage.
     */
    public Optional<Integer> getDamage() {
        return this.damage;
    }

    /**
     * Returns the ball's pace multiplier.
     * @return double representing ball's pace multiplier
     */
    public double getPaceMultiplier() {
        return this.paceMultiplier;
    }

    /**
     * Returns the ball's property of bouncing if collided with a destructible brick.
     * @return  true if the ball bounces,
     *          false if the ball doesn't bounce.
     */
    public boolean bounce() {
        return this.bounce;
    }
}
