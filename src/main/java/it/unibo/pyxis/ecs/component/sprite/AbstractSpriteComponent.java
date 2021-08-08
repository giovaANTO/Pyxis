package it.unibo.pyxis.ecs.component.sprite;

import it.unibo.pyxis.ecs.component.AbstractComponent;
import it.unibo.pyxis.ecs.Entity;
import javafx.scene.image.Image;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractSpriteComponent<E extends Entity> extends AbstractComponent<E> implements SpriteComponent<E> {

    private boolean isAttached;

    public AbstractSpriteComponent(final E entity) {
        super(entity);
    }

    /**
     * Returns a {@link Logger} instance.
     *
     * @return A {@link Logger} instance
     */
    private Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void attach() {
        this.isAttached = true;
        this.getLogger().log(Level.INFO, "Sprite component attached");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void detach() {
        this.isAttached = false;
        this.getLogger().log(Level.INFO, "Sprite component detached");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isAttached() {
        return this.isAttached;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract String getFileName();
    /**
     * {@inheritDoc}
     */
    @Override
    public final Image obtainSprite() {
        return new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(this.getFileName())));
    }
}
