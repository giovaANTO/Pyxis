package it.unibo.pyxis.ecs.component.sprite;

import it.unibo.pyxis.ecs.component.AbstractComponent;
import it.unibo.pyxis.ecs.entity.Entity;
import javafx.scene.image.Image;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractSpriteComponent<E extends Entity> extends AbstractComponent<E> implements SpriteComponent<E> {

    private boolean isAttached;

    public AbstractSpriteComponent(final E entity) {
        super(entity);
    }

    /**
     * Return a {@link Logger} instance.
     * @return
     *          A {@link Logger} instance
     */
    private Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }

    @Override
    public void attach() {
        this.isAttached = true;
        this.getLogger().log(Level.INFO, "Sprite component attached");
    }

    @Override
    public void detach() {
        this.isAttached = false;
        this.getLogger().log(Level.INFO, "Sprite component detached");
    }

    @Override
    public boolean isAttached() {
        return this.isAttached;
    }

    @Override
    public abstract Image obtainSprite();
}
