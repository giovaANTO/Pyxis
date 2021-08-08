package it.unibo.pyxis.model.level.loader.skeleton.ball;

public final class BallSkeletonImpl implements BallSkeleton {

    private int x;
    private int y;
    private int paceX;
    private int paceY;
    private String ballType;
    private int id;
    /**
     * {@inheritDoc}
     */
    @Override
    public int getX() {
        return this.x;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(final int inputX) {
        this.x = inputX;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getY() {
        return this.y;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(final int inputY) {
        this.y = inputY;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getBallType() {
        return this.ballType;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setBallType(final String inputBallType) {
        this.ballType = inputBallType;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return this.id;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(final int inputId) {
        this.id = inputId;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getPaceX() {
        return this.paceX;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPaceX(final int inputPaceX) {
        this.paceX = inputPaceX;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getPaceY() {
        return this.paceY;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPaceY(final int inputPaceY) {
        this.paceY = inputPaceY;
    }
}
