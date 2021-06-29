package it.unibo.pyxis.model.level.loader.skeleton.ball;

public final class BallSkeletonImpl implements BallSkeleton {

    private int x;
    private int y;
    private int paceX;
    private int paceY;
    private String ballType;
    private int id;

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(final int inputX) {
        this.x = inputX;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(final int inputY) {
        this.y = inputY;
    }

    @Override
    public String getBallType() {
        return this.ballType;
    }

    @Override
    public void setBallType(final String inputBallType) {
        this.ballType = inputBallType;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void setID(final int inputId) {
        this.id = inputId;
    }

    @Override
    public int getPaceX() {
        return this.paceX;
    }

    @Override
    public void setPaceX(final int inputPaceX) {
        this.paceX = inputPaceX;
    }

    @Override
    public int getPaceY() {
        return this.paceY;
    }

    @Override
    public void setPaceY(final int inputPaceY) {
        this.paceY = inputPaceY;
    }
}
