package it.unibo.pyxis.model.element.brick;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public class BrickImpl extends AbstractElement implements Brick {

    private final BrickType brickType;
    private int durability;

    public BrickImpl(final BrickType type, final Dimension inputDimension, final Coord inputPosition) {
        super(inputDimension, inputPosition);
        this.brickType = type;
        this.durability = type.getDurability();
    }

    @Override
    public void update(final int delta) {
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
