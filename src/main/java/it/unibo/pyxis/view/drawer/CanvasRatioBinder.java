package it.unibo.pyxis.view.drawer;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;

public class CanvasRatioBinder {

    private final ReadOnlyDoubleProperty wC;
    private final ReadOnlyDoubleProperty hC;
    private final DoubleProperty wN;
    private final DoubleProperty hN;
    private final Double aspectRatio;
    private final Double xScaleFactor;
    private final Double yScaleFactor;

    public CanvasRatioBinder(final ReadOnlyDoubleProperty containerWidthProperty, final ReadOnlyDoubleProperty containerHeightProperty,
                        final Double containerStartWidth, final Double containerStartHeight,
                        final DoubleProperty canvasWidthProperty, final DoubleProperty canvasHeightProperty,
                        final Double canvasWidth, final Double canvasHeight) {
        this.wC = containerWidthProperty;
        this.hC = containerHeightProperty;
        this.wN = canvasWidthProperty;
        this.hN = canvasHeightProperty;
        this.aspectRatio = canvasWidth / canvasHeight;
        this.xScaleFactor = canvasWidth / containerStartWidth;
        this.yScaleFactor = canvasHeight / containerStartHeight;
    }

    public void bindWithRatioToContainer() {
        if (wC.get() * xScaleFactor > hC.get() * yScaleFactor * aspectRatio) {
            hN.bind(hC.multiply(yScaleFactor));
            wN.bind(hN.multiply(aspectRatio));
        }
        else {
            hN.bind(wC.multiply(xScaleFactor).divide(aspectRatio));
            wN.bind(wC.multiply(xScaleFactor));
        }
    }

}
