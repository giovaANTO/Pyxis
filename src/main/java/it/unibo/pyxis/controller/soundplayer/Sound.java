package it.unibo.pyxis.controller.soundplayer;

public enum Sound {

    MENU_MUSIC("menu_music"),
    IN_GAME_MUSIC("in_game_music"),
    PAD_COLLISION("pad_impact"),
    BORDER_COLLISION("border_impact"),
    BREAKABLE_BRICK_COLLISION("breakable_brick_impact"),
    UNBREAKABLE_BRICK_COLLISION("unbreakable_brick_impact"),
    BALL_DESTROYED("ball_destroyed"),
    POWERUP_ACTIVATION("powerup_activation"),
    GAME_OVER("game_over"),
    START_GAME_BUTTON("start_game_button"),
    GENERIC_BUTTON("generic_button");

    private final String soundName;

    Sound(final String soundName) {
        this.soundName = soundName;
    }

    public String getSoundName() {
        return this.soundName;
    }

}
