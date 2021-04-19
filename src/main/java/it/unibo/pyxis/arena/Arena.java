package it.unibo.pyxis.arena;

import java.util.stream.Stream;

import it.unibo.pyxis.sup.*;
import it.unibo.pyxis.util.Coord;

public interface Arena {

    /*
     * caricamento da file della composizione del livello corrente
     */
    void loadConfigurationFile();
    
    /*
     * aggiornamenti degli elementi nell'arena
     */
    void update();
    
    /*
     * movimento del pad su input del giocatore
     */
    void movePad();
    
    /*
     * Gestione della distruzione di un mattone
     */
    void handleBrickDestruction(Coord brick);
    
    /*
     * Aggiunta di un elemento powerup nell'arena come conseguenza
     * della distruzione di un mattone
     */
    void spawnPowerup();
    
    /*
     * Gestione dell'attivazione di un powerup
     */
    void handlePowerupActivation();
    
    /*
     * Check del completamento del livello corrente.
     * Ritorna TRUE se non ci sono più mattoncini da distruggere
     * altrimenti ritorna FALSE
     */
    boolean isArenaClear();
    
    /*
     * 
     */
    void getLevel();
    
    
    Dimension getDimensions();
    
    
    void setDimensions(Dimension dimension);
    
    
    void addElement(Element element);
    
    
    Stream<Object> getBallStream();
    
    
    Stream<Object> getBrickStream();
    
    
    void getPad();
    
    
}
