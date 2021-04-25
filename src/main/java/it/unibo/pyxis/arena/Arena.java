package it.unibo.pyxis.arena;

import java.util.stream.Stream;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.element.*;
import it.unibo.pyxis.element.ball.Ball;
import it.unibo.pyxis.element.pad.Pad;

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
     * Pad's movement based on player input
     */
    void movePad();
    
    
    /**
     * Brick's destruction process handling
     */
    void handleBrickDestruction(Coord brick);
    
    
    /**
     * Creation of a new Powerup Element
     * after a brick destruction
     */
    void spawnPowerup();
    
    
    /**
     * Powerup activation process handling
     */
    void handlePowerupActivation();
    
    
    /**
     * Checks the completition of the current level.
     * Returns TRUE if there are no more bricks to destroy,
     * otherwise returns FALSE
     */
    boolean isArenaClear();
    
    
    /**
     * Adds an element to the arena
     */
    void addElement(Element element);
    
    
    void getLevel();
    
    
    Dimension getDimensions();
    
    
    void setDimensions(Dimension dimension);
    
    
    Stream<Ball> getBallStream();
    
    
    Stream<Pad> getBrickStream();
    
    
    void getPad();
    
    
}
