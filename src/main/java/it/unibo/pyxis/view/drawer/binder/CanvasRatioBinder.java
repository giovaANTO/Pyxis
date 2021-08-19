package it.unibo.pyxis.view.drawer.binder;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;

public final class CanvasRatioBinder implements Binder {

    private final ReadOnlyDoubleProperty wC;
    private final ReadOnlyDoubleProperty hC;
    private final DoubleProperty wN;
    private final DoubleProperty hN;
    private final Double aspectRatio;
    private final Double xScaleFactor;
    private final Double yScaleFactor;

    public CanvasRatioBinder(final Pane pane, final Canvas canvas) {
        this.wC = pane.widthProperty();
        this.hC = pane.heightProperty();
        this.wN = canvas.widthProperty();
        this.hN = canvas.heightProperty();
        this.aspectRatio = canvas.getWidth() / canvas.getHeight();
        this.xScaleFactor = canvas.getWidth() / pane.getPrefWidth();
        this.yScaleFactor = canvas.getHeight() / pane.getPrefHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void bind() {
        if (wC.get() * xScaleFactor > hC.get() * yScaleFactor * aspectRatio) {
            hN.bind(hC.multiply(yScaleFactor));
            wN.bind(hN.multiply(aspectRatio));
        } else {
            hN.bind(wC.multiply(xScaleFactor).divide(aspectRatio));
            wN.bind(wC.multiply(xScaleFactor));
        }
    }
}
