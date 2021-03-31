package it.unibo.model.event;

public interface EventFactory {
    BallPositionEvent createBallPositionEvent(String position);
}
