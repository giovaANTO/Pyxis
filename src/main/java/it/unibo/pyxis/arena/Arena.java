package it.unibo.pyxis.arena;

import java.util.stream.Stream;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.element.ball.Ball;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.element.powerup.Powerup;
import it.unibo.pyxis.event.notify.BrickDestructionEvent;

public interface Arena {

    
    /**
     * Load file composition of the current level
     */
    void loadConfigurationFile();
    
    
    /**
     * Update the elements of the arena
     */
    void update();
    
    
    /**
     * Brick's destruction process handling
     * @param brickCoord
     */
    void handleBrickDestruction(final BrickDestructionEvent event);
    
    
    /**
     * Checks the completition of the current level.
     * @return TRUE if there are no more bricks to destroy,
     * FALSE otherwise
     */
    boolean isArenaClear();
    
    
    /**
     * Returns the dimensions of the Arena
     * @return the dimensions of the Arena
     */
    Dimension getDimensions();
    
    
    void setHeight(final double height);
    
    
    void setWidth(final double width);
    
    
    Stream<Ball> getBallStream();
    
    
    Stream<Brick> getBrickStream();
    
    
    Stream<Powerup> getPowerupStream();
    
    
    Pad getPad();
    
    
}
