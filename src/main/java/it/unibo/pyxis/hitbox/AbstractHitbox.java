package it.unibo.pyxis.hitbox;

import java.util.Optional;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.DimensionImpl;

public abstract class AbstractHitbox implements Hitbox {

        private final Coord position;
        private final Dimension dimension;

        public AbstractHitbox(final Coord position, final Dimension dimension) {
                this.position = position;
                this.dimension = dimension;
        }

        @Override
        public Coord getPosition() {
                return this.position;
        }

        @Override
        public Dimension getDimension() {
                return this.dimension;
        }

        @Override
        public abstract boolean isCollidingWithPoint(Coord position);

        @Override
        public abstract boolean isCollidingWithOtherHB(Hitbox hitbox);

        @Override
        public abstract boolean isCollidingWithSameHB(Hitbox hitbox);

        @Override
        public abstract Optional<HitEdge> collidingEdgeWithOtherHB(Hitbox hitbox);

}
