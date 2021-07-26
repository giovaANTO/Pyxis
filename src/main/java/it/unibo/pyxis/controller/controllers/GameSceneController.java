package it.unibo.pyxis.controller.controllers;

import java.util.Set;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.view.scene.SceneType;

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

    public final Double getArenaWidth() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getDimension().getWidth();
    }

    public final Double getArenaHeight() {
        return this.getLinker().getGameState().getCurrentLevel().getArena().getDimension().getHeight();
    }

    public final Integer getLives() {
        return this.getLinker().getGameState().getCurrentLevel().getLives();
    }

    public final Integer getScore() {
        return this.getLinker().getGameState().getCurrentLevel().getScore();
    }

    public final void back() {
        this.getLinker().switchScene(SceneType.MENU_SCENE);
    }

//    public final Integer getLevelNumber() {
//        return this.getLevel().getNumber();
//    }

}
