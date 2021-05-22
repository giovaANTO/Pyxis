package it.unibo.pyxis.element.brick;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.event.movement.BallMovementEvent;
import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

public class BrickImpl extends AbstractElement implements Brick {

    private final BrickType brickType;
    private int durability;

    public BrickImpl(final BrickType type, final Dimension inputDimension, final Coord inputPosition) {
        super(inputDimension, inputPosition);
        this.brickType = type;
        this.durability = type.getDurability();
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Operation not implemented yet");
    }

    @Override
    public void handleBallMovement(final BallMovementEvent movementEvent) {

    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public BrickType getBrickType() {
        return this.brickType;
    }
}
