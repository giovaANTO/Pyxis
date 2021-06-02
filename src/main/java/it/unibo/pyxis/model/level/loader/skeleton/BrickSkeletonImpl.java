package it.unibo.pyxis.model.level.loader.skeleton;

import it.unibo.pyxis.model.util.Coord;

public final class BrickSkeletonImpl implements BrickSkeleton {

    private Coord coord;
    private String type;

    @Override
    public Coord getCoord() {
        return this.coord;
    }

    @Override
    public void setCoord(final Coord coord) {
        this.coord = coord;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(final String type) {
        this.type = type;
    }
}
