package it.unibo.pyxis.arena;

import java.util.stream.Stream;

import it.unibo.pyxis.util.Coord;

public interface Arena {

    
    /*
     * Load file composition of the current level
     */
    void loadConfigurationFile();
    
    
    /*
     * Update the elements of the arena
     */
    void update();
    
    
    /*
     * Pad's movement based on player input
     */
    void movePad();
    
    
    /*
     * Brick's destruction process handling
     */
    void handleBrickDestruction(Coord brick);
    
    
    /*
     * Creation of a new Powerup Element
     * after a brick destruction
     */
    void spawnPowerup();
    
    
    /*
     * Powerup activation process handling
     */
    void handlePowerupActivation();
    
    
    /*
     * Checks the completition of the current level.
     * Returns TRUE if there are no more bricks to destroy,
     * otherwise returns FALSE
     */
    boolean isArenaClear();
    
    
    /*
     * Adds an element to the arena
     */
    void addElement();
    
    
    void getLevel();
    
    
    void getDimensions();
    
    
    void setDimensions();
    
    
    Stream<Object> getBallStream();
    
    
    Stream<Object> getBrickStream();
    
    
    void getPad();
    
    
}
