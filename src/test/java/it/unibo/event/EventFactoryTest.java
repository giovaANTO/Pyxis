package it.unibo.event;

import it.unibo.model.event.BallPositionEvent;
import it.unibo.model.event.EventFactory;
import it.unibo.model.event.EventType;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EventFactoryTest {

    private EventFactory eventFactory;

    @Test
    public void canCreateBallPositionEvent() {
        BallPositionEvent bpe = this.eventFactory.createBallPositionEvent("1;1");

        assertEquals(bpe.getEventType(), EventType.BALL_POSITION);
        assertEquals(bpe.getPosition(), "1;1");
    }
}
