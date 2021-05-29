package it.unibo.pyxis.model.element.brick;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;
import it.unibo.pyxis.model.hitbox.RectHitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public class BrickImpl extends AbstractElement implements Brick {

    private final BrickType brickType;
    private int durability;

    public BrickImpl(final BrickType type, final Dimension inputDimension, final Coord inputPosition) {
        super(inputDimension, inputPosition, new RectHitbox(inputPosition, inputDimension));
        this.brickType = type;
        this.durability = type.getDurability();
    }

    @Override
    public void update(final int delta) {
        throw new UnsupportedOperationException("You can't call update on a brick");
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
