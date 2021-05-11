package it.unibo.pyxis.element.Ball;

import it.unibo.pyxis.element.ball.Ball;
import it.unibo.pyxis.element.ball.BallImpl;
import it.unibo.pyxis.element.ball.BallType;
import it.unibo.pyxis.util.DimensionImpl;
import it.unibo.pyxis.util.CoordImpl;
import it.unibo.pyxis.util.PairImpl;
import it.unibo.pyxis.util.VectorImpl;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTest {

    private Ball ball1;

    @BeforeEach
    private void setUp() {
        this.ball1 = new BallImpl(new DimensionImpl(3, 3),
                new CoordImpl(3, 5),
                new VectorImpl(new PairImpl<Double>(2.0, 5.0)));
    }

    public void testType() {
        System.out.println("testType");
        assertEquals(this.ball1.getType(), BallType.NORMAL_BALL);
        this.ball1.setType(BallType.ATOMIC_BALL);
        assertEquals(this.ball1.getType(), BallType.ATOMIC_BALL);
    }


}
