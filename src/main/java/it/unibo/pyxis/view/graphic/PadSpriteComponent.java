package it.unibo.pyxis.view.graphic;

import it.unibo.pyxis.ecs.component.sprite.AbstractSpriteComponent;
import it.unibo.pyxis.model.element.pad.Pad;

public final class PadSpriteComponent extends AbstractSpriteComponent<Pad> {

    private static final String PAD_FOLDER = "pad/";

    public PadSpriteComponent(final Pad entity) {
        super(entity);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getFileName() {
        return this.getSpritesPath() + PAD_FOLDER + "PAD.png";
    }

}
