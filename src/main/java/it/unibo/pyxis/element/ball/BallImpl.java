package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.event.notify.CollisionEvent;
import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.Pair;
import it.unibo.pyxis.util.Vector;

public class BallImpl extends AbstractElement implements Ball {

    private BallType type;
    private final Vector pace;

    public BallImpl(final Dimension inputDimension, final Coord inputPosition,
                    final Vector inputPace) {
        super(inputDimension, inputPosition);
        this.type = BallType.NORMAL_BALL;
        this.pace = inputPace;
    }

    @Override
    public void handleBrickCollision(final CollisionEvent<Brick> collisionEvent) {

    }

    @Override
    public void handlePadCollision(final CollisionEvent<Pad> collisionEvent) {

    }

    @Override
    public BallType getType() {
        return this.type;
    }

    @Override
    public Vector getPace() {
        return this.pace;
    }

    @Override
    public void setType(BallType inputType) {
        this.type = inputType;
    }

    @Override
    public void setPace(Vector inputPace) {
        this.pace.setComponents(inputPace.getComponents());
    }
}
