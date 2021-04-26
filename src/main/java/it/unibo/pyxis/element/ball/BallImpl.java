package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.event.notify.CollisionEvent;
import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

public class BallImpl extends AbstractElement implements Ball {

    public BallImpl(final Dimension inputDimension, final Coord inputPosition) {
        super(inputDimension, inputPosition);
    }

    @Override
    public void handleBrickCollision(final CollisionEvent<Brick> collisionEvent) {

    }

    @Override
    public void handlePadCollision(final CollisionEvent<Pad> collisionEvent) {

    }

    @Override
    public void setStatus() {

    }

    @Override
    public void setPace() {

    }
}
