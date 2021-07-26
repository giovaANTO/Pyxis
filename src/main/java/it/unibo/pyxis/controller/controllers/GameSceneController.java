package it.unibo.pyxis.controller.controllers;

import java.util.Set;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.pad.Pad;

public class GameSceneController extends AbstractController {

    public final Set<Brick> getBricks() {
        return this.getLevel().getArena().getBricks();
    }

    public final Set<Ball> getBalls() {
        return this.getLevel().getArena().getBalls();
    }

    public final Pad getPad() {
        return this.getLevel().getArena().getPad();
    }

    public final Double getArenaWidth() {
        return this.getLevel().getArena().getDimension().getWidth();
    }

    public final Double getArenaHeight() {
        return this.getLevel().getArena().getDimension().getHeight();
    }

    public final Integer getLives() {
        return this.getLevel().getLives();
    }

    public final Integer getScore() {
        return this.getLevel().getScore();
    }

//    public final Integer getLevelNumber() {
//        return this.getLevel().getNumber();
//    }

}
