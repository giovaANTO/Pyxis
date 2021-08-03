package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.util.Dimension;

import java.util.Set;

public class GameSceneController extends AbstractController {

    public final Set<Brick> getBricks() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getBricks();
    }

    public final Set<Ball> getBalls() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getBalls();
    }

    public final Set<Powerup> getPowerups() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getPowerups();
    }

    public final Pad getPad() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getPad();
    }

    public final Dimension getArenaDimension() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getDimension();
    }

    public final Integer getLives() {
        return this.getLinker().getGameState().getCurrentLevel().getLives();
    }

    public final Integer getScore() {
        return this.getLinker().getGameState().getCurrentLevel().getScore();
    }

//    public final Integer getLevelNumber() {
//        return this.getLevel().getNumber();
//    }

}
