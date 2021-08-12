package it.unibo.pyxis.controller;

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

public class GameController extends AbstractController {

    /**
     * Returns the current {@link Arena} loaded.
     *
     * @return An {@link Arena} instance.
     */
    private Arena getArena() {
        return this.getLinker().getGameState().getCurrentLevel().getArena();
    }
    /**
     * Returns the {@link Arena}'s {@link Dimension}.
     *
     * @return The {@link Dimension}.
     */
    public final Dimension getArenaDimension() {
        return this.getArena().getDimension();
    }
    /**
     * Returns the {@link Arena}'s {@link Ball}.
     *
     * @return The {@link Ball}'s {@link Set}.
     */
    public final Set<Ball> getBalls() {
        return this.getArena().getBalls()
                .stream()
                .peek(b -> b.registerComponent(new BallSpriteComponent(b)))
                .collect(Collectors.toSet());
    }
    /**
     * Returns the {@link Arena}'s {@link Brick}s.
     *
     * @return The {@link Brick}'s {@link Set}.
     */
    public final Set<Brick> getBricks() {
        return this.getArena().getBricks()
                .stream()
                .peek(b -> b.registerComponent(new BrickSpriteComponent(b)))
                .collect(Collectors.toSet());
    }
    /**
     * Returns the current {@link Level} number.
     *
     * @return The {@link Level} number.
     */
    public final Integer getCurrentLevelNumber() {
        return this.getLinker().getGameState().getCurrentLevel().getLevelNumber();
    }
    /**
     * Returns the current {@link Level} background.
     *
     * @return The background {@link Image}.
     */
    public final Image getLevelImage() {
        final Level currentLevel = this.getLinker().getGameState().getCurrentLevel();
        if (!currentLevel.hasComponent(SpriteComponent.class)) {
            currentLevel.registerComponent(new LevelSpriteComponent(currentLevel));
        }
        return currentLevel.getComponent(SpriteComponent.class).obtainSprite();
    }
    /**
     * Returns the current {@link Level}'s lives.
     *
     * @return The lives number.
     */
    public final Integer getLives() {
        return this.getLinker().getGameState().getCurrentLevel().getLives();
    }
    /**
     * Returns the {@link Arena}'s {@link Pad}.
     *
     * @return The {@link Pad}.
     */
    public final Pad getPad() {
        final Pad arenaPad = this.getArena().getPad();
        arenaPad.registerComponent(new PadSpriteComponent(arenaPad));
        return arenaPad;
    }
    /**
     * Returns the {@link Arena}'s {@link Powerup}.
     *
     * @return The {@link Powerup}'s {@link Set}.
     */
    public final Set<Powerup> getPowerups() {
        return this.getArena().getPowerups()
                .stream()
                .peek(p -> p.registerComponent(new PowerupSpriteComponent(p)))
                .collect(Collectors.toSet());
    }
    /**
     * Returns the current {@link Level}'s score.
     *
     * @return The score.
     */
    public final Integer getScore() {
        return this.getLinker().getGameState().getCurrentLevel().getScore();
    }
}
