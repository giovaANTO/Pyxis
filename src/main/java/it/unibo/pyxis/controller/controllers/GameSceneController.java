package it.unibo.pyxis.controller.controllers;

import java.util.Set;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.pad.Pad;

public class GameSceneController extends AbstractController {

    public final Set<Brick> getBricks() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getBricks();
    }

    public final Set<Ball> getBalls() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getBalls();
    }

    public final Pad getPad() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getPad();
    }

    public final double getArenaWidth() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getDimension().getWidth();
    }

    public final double getArenaHeight() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getDimension().getHeight();
    }

}
