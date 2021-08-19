package it.unibo.pyxis.view.soundplayer;

public enum Sound {
    /**
     * The Main Menu background Music.
     */
    MENU_MUSIC("menu_music"),

    /**
     * The In Game background Music.
     */
    IN_GAME_MUSIC("in_game_music"),

    /**
     * The sound of a collision between
     * a {@link it.unibo.pyxis.model.element.ball.Ball}
     * and a {@link it.unibo.pyxis.model.element.pad.Pad}.
     */
    PAD_COLLISION("pad_impact"),

    /**
     * The sound of a collision between
     * a {@link it.unibo.pyxis.model.element.ball.Ball}
     * and the borders of the {@link it.unibo.pyxis.model.arena.Arena}.
     */
    BORDER_COLLISION("border_impact"),

    /**
     * The sound of a collision between
     * a {@link it.unibo.pyxis.model.element.ball.Ball}
     * and a non-grey {@link it.unibo.pyxis.model.element.brick.Brick}.
     */
    BREAKABLE_BRICK_COLLISION("breakable_brick_impact"),

    /**
     * The sound of a collision between
     * a {@link it.unibo.pyxis.model.element.ball.Ball}
     * and a grey {@link it.unibo.pyxis.model.element.brick.Brick}.
     */
    UNBREAKABLE_BRICK_COLLISION("unbreakable_brick_impact"),

    /**
     * The sound of losing a life.
     */
    LIFE_DECREASED("life_decreased"),

    /**
     * The sound of
     * a {@link it.unibo.pyxis.model.element.powerup.Powerup} activation.
     */
    POWERUP_ACTIVATION("powerup_activation"),

    /**
     * The sound of the start game button and the resume button.
     */
    START_GAME_BUTTON("start_game_button"),

    /**
     * The sound of a generic button.
     */
    GENERIC_BUTTON("generic_button");

    private final String soundName;

    Sound(final String soundName) {
        this.soundName = soundName;
    }

    /**
     * Returns the sound name.
     *
     * @return The name.
     */
    public String getSoundName() {
        return this.soundName;
    }

}
