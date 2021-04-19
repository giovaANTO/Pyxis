package it.unibo.pyxis.element.brick;

import it.unibo.pyxis.element.Element;
import it.unibo.pyxis.event.movement.BallMovementEvent;

public interface Brick extends Element {

    void handleBallMovement(BallMovementEvent movementEvent);

    int getDurability();
}
