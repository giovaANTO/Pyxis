package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.ecs.component.sprite.SpriteComponent;
import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.view.graphic.BallSpriteComponent;
import it.unibo.pyxis.view.graphic.BrickSpriteComponent;
import it.unibo.pyxis.view.graphic.LevelSpriteComponent;
import it.unibo.pyxis.view.graphic.PadSpriteComponent;
import it.unibo.pyxis.view.graphic.PowerupSpriteComponent;
import javafx.scene.image.Image;

import java.util.Set;
import java.util.stream.Collectors;

public class GameSceneController extends AbstractController {

    /**
     * Return the current {@link Arena} loaded.
     * @return
     *          An {@link Arena} instance
     */
    private Arena getArena() {
        return this.getLinker().getGameState().getCurrentLevel().getArena();
    }

    public final Set<Brick> getBricks() {
        return this.getArena().getBricks()
                .stream()
                .peek(b -> b.registerComponent(new BrickSpriteComponent(b)))
                .collect(Collectors.toSet());
    }

    public final Set<Ball> getBalls() {
        return this.getArena().getBalls()
                .stream()
                .peek(b -> b.registerComponent(new BallSpriteComponent(b)))
                .collect(Collectors.toSet());
    }

    public final Set<Powerup> getPowerups() {
        return this.getArena().getPowerups()
                .stream()
                .peek(p -> p.registerComponent(new PowerupSpriteComponent(p)))
                .collect(Collectors.toSet());
    }

    public final Pad getPad() {
        final Pad arenaPad = this.getArena().getPad();
        arenaPad.registerComponent(new PadSpriteComponent(arenaPad));
        return arenaPad;
    }

    public final Dimension getArenaDimension() {
        return this.getArena().getDimension();
    }

    public final Integer getScore() {
        return this.getLinker().getGameState().getCurrentLevel().getScore();
    }

    public final Integer getCurrentLevelNumber() {
        return this.getLinker().getGameState().getCurrentLevel().getLevelNumber();
    }

    public final Image getLevelImage() {
        final Level currentLevel = this.getLinker().getGameState().getCurrentLevel();
        if (!currentLevel.hasComponent(SpriteComponent.class)) {
           currentLevel.registerComponent(new LevelSpriteComponent(currentLevel));
        }
        return currentLevel.getComponent(SpriteComponent.class).obtainSprite();
    }

    public final Integer getLives() {
        return this.getLinker().getGameState().getCurrentLevel().getLives();
    }
}
