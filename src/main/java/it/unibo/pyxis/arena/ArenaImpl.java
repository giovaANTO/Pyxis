package it.unibo.pyxis.arena;

import java.util.*;
import java.util.stream.Stream;

import it.unibo.pyxis.element.ball.Ball;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.element.powerup.Powerup;
import it.unibo.pyxis.element.powerup.PowerupImpl;
import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.DimensionImpl;
import it.unibo.pyxis.util.VectorImpl;
import it.unibo.pyxis.element.powerup.PowerupType;
import it.unibo.pyxis.event.notify.BrickDestructionEvent;

public class ArenaImpl implements Arena {

    private final Dimension dimension;
    private final Map<Coord, Brick> brickMap;
    private final Set<Ball> ballSet;
    private final Set<Powerup> powerupSet;
    private Pad pad;

    public ArenaImpl(final Dimension inputDimension) {
        this.brickMap = new HashMap<>();
        this.ballSet = new HashSet<>();
        this.powerupSet = new HashSet<>();
        this.dimension = inputDimension;
    }

    private void spawnPowerup(final Coord spawnCoord) {
        final Random rand = new Random();
        final PowerupType selectedType = PowerupType.values()[rand.nextInt(PowerupType.values().length)];
        final Powerup powerup = new PowerupImpl(selectedType, new DimensionImpl(1, 1), spawnCoord, new VectorImpl(1, 1));
        this.addPowerup(powerup);
    }

    @Override
    public void update(final Double delta) {
        this.ballSet.forEach(Ball::update);
        this.powerupSet.forEach(Powerup::update);
    }

    @Override
    public void handleBrickDestruction(final BrickDestructionEvent event) {

    }

    @Override
    public Dimension getDimension() {
        return this.dimension;
    }

    @Override
    public Stream<Ball> getBallStream() {
        return this.ballSet.stream();
    }

    @Override
    public Stream<Brick> getBrickStream() {
        return this.brickMap.values().stream();
    }

    @Override
    public Stream<Powerup> getPowerupStream() {
        return this.powerupSet.stream();
    }

    @Override
    public Pad getPad() {
        return this.pad;
    }

    @Override
    public void setPad(final Pad inputPad) {
        this.pad = inputPad;
    }

    @Override
    public void addBrick(final Brick brick) {
        this.brickMap.put(brick.getPosition(), brick);
    }

    @Override
    public void addBall(final Ball ball) {
        this.ballSet.add(ball);
    }

    @Override
    public void addPowerup(final Powerup powerup) {
        this.powerupSet.add(powerup);
    }
}
