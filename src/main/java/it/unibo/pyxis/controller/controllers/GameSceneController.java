package it.unibo.pyxis.controller.controllers;

import java.util.Set;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.state.GameState;
import it.unibo.pyxis.model.state.StateEnum;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.view.scene.SceneType;

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

    public final void back() {
        this.getLinker().menu();
    }

    public final void commandPadLeft(final GameState inputGameState) {
        if (this.getLinker().getGameState().getState() == StateEnum.RUN) {
            inputGameState.getCurrentLevel().getArena().movePadLeft();
        }
    }

    public final void commandPadRight(final GameState inputGameState) {
        if (this.getLinker().getGameState().getState() == StateEnum.RUN) {
            inputGameState.getCurrentLevel().getArena().movePadRight();
        }
    }

    public final void commandStart(final GameState inputGameState) {
        if (inputGameState.getState() != StateEnum.RUN) {
            inputGameState.setState(StateEnum.RUN);
        }
    }

//    public final Integer getLevelNumber() {
//        return this.getLevel().getNumber();
//    }

}
