package it.unibo.pyxis.level;

import it.unibo.pyxis.arena.Arena;

public interface Level {

    /**
     * Decrease a life.
     */
    void decreaseLife();

    /**
     * Return the total number of lifes.
     * @return
     *          The number of current lifes
     */
    int getLifes();

    /**
     * Return the total score of this level.
     * @return
     *         The score
     */
    int getScore();

    /**
     * Increase the score of this level.
     * @param score
     *               The score to increase
     */
    void increaseScore(int score);

    /**
     * Get the {@link Arena} associated to this level.
     * @return
     *          The instance of {@link Arena}
     */
    Arena getArena();
}
