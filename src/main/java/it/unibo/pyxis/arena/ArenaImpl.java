package it.unibo.pyxis.arena;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

import it.unibo.pyxis.element.Element;
import it.unibo.pyxis.element.ball.Ball;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.element.powerup.Powerup;
import it.unibo.pyxis.element.powerup.PowerupImpl;
import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.DimensionImpl;
import it.unibo.pyxis.element.powerup.PowerupType;

public class ArenaImpl implements Arena {
    
    static private int RNG_POWERUP_SPAWN = 10;
    private Random rand = new Random();
    
    private Dimension dimension;
    
    private Map<Coord, Brick> brickMap;
    private Set<Ball> ballCollection;
    private Set<Powerup> powerupCollection;
    private Pad pad;
    
    
    
    public ArenaImpl(/*String configFiles*/) {
        loadConfigurationFile(/*configFiles*/);
    }


    public void loadConfigurationFile() {

    }


    public void update() {
        getBallStream().forEach(x -> x.update());
        getBrickStream().forEach(x -> x.update());
        getPowerupStream().forEach(x -> x.update());
    }


    public void movePad() {

    }


    public void handleBrickDestruction(Coord brickCoord) {
        brickMap.remove(brickCoord);
        if (rand.nextInt(RNG_POWERUP_SPAWN) == 0) {
            spawnPowerup(brickCoord);
        }
    }


    public void spawnPowerup(Coord spawnCoord) {
        addElement(new PowerupImpl(PowerupType.values()[rand.nextInt(PowerupType.values().length)], new DimensionImpl(1, 1), spawnCoord));
    }


    public boolean isArenaClear() {
//        return !getBrickStream().anyMatch(x -> x.isDestructable());
        return false;
    }

    
    private void addElement(Element element) {
        if(element instanceof Brick) {
            brickMap.put(element.getPosition(), (Brick) element);
        }
        else if(element instanceof Ball) {
            ballCollection.add((Ball) element);
        }
        else if(element instanceof Powerup) {
            powerupCollection.add((Powerup) element);
        }
        else if (pad == null) {
            pad = (Pad) element;
        }
    }


    public void getLevel() {

    }


    public Dimension getDimensions() {
        return dimension;
    }


    public void setHeight(double height) {
        dimension.setHeight(height);
    }
    
    public void setWidth(double width) {
        dimension.setHeight(width);
    }


    public Stream<Ball> getBallStream() {
        return ballCollection.stream();
    }


    public Stream<Brick> getBrickStream() {
        return brickMap.values().stream();
    }

    
    public Stream<Powerup> getPowerupStream() {
        return powerupCollection.stream();
    }



    public Pad getPad() {
        return pad;

    }

}
