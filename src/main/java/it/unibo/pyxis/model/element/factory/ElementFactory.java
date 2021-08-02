package it.unibo.pyxis.model.element.factory;

import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.util.Coord;

public interface ElementFactory {
    
    Brick createRedBrick(Coord position);

    Brick createOrangeBrick(Coord position);

    Brick createYellowBrick(Coord position);

    Brick createGreenBrick(Coord position);

    Brick createBlueBrick(Coord position);

    Brick createPurpleBrick(Coord position);

    Brick createIndestructibleBrick(Coord position);
}
