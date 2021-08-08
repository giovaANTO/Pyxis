package it.unibo.pyxis.model.level.component;

import it.unibo.pyxis.ecs.component.event.AbstractEventComponent;
import it.unibo.pyxis.model.event.notify.BrickDestructionEvent;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.status.LevelStatus;
import org.greenrobot.eventbus.Subscribe;

public class LevelEventComponent extends AbstractEventComponent<Level> {

    public LevelEventComponent(final Level entity) {
        super(entity);
    }

    /**
     * Handles a {@link DecreaseLifeEvent}.
     * @param event The instance of {@link DecreaseLifeEvent}.
     */
    @Subscribe
    public void handleDecreaseLife(final DecreaseLifeEvent event) {
        this.getEntity().decreaseLife();
        if (this.getEntity().getLives() <= 0) {
            this.getEntity().setLevelStatus(LevelStatus.GAME_OVER);
        }
    }
    /**
     * Handles a {@link BrickDestructionEvent}.
     * @param event The instance of {@link BrickDestructionEvent}.
     */
    @Subscribe
    public void handleBrickDestruction(final BrickDestructionEvent event) {
        this.getEntity().increaseScore(event.getPoints());
    }
}
