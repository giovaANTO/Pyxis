package it.unibo.pyxis.view.drawer.binder;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;

public final class CanvasRatioBinder implements Binder {

    private final ReadOnlyDoubleProperty widthPane;
    private final ReadOnlyDoubleProperty heightPane;
    private final DoubleProperty widthCanvas;
    private final DoubleProperty heightCanvas;
    private final Double aspectRatio;
    private final Double xScaleFactor;
    private final Double yScaleFactor;

    public CanvasRatioBinder(final Pane pane, final Canvas canvas) {
        this.widthPane = pane.widthProperty();
        this.heightPane = pane.heightProperty();
        this.widthCanvas = canvas.widthProperty();
        this.heightCanvas = canvas.heightProperty();
        this.aspectRatio = canvas.getWidth() / canvas.getHeight();
        this.xScaleFactor = canvas.getWidth() / pane.getPrefWidth();
        this.yScaleFactor = canvas.getHeight() / pane.getPrefHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void bind() {
        if (widthPane.get() * xScaleFactor > heightPane.get() * yScaleFactor * aspectRatio) {
            heightCanvas.bind(heightPane.multiply(yScaleFactor));
            widthCanvas.bind(heightCanvas.multiply(aspectRatio));
        } else {
            heightCanvas.bind(widthPane.multiply(xScaleFactor).divide(aspectRatio));
            widthCanvas.bind(widthPane.multiply(xScaleFactor));
        }
    }
}
