package it.unibo.pyxis.view.drawer;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;

public class CanvasPropertyBinder {

    private final ReadOnlyDoubleProperty wC;
    private final ReadOnlyDoubleProperty hC;
    private final Double aspectRatio;
    private final Double xScaleFactor;
    private final Double yScaleFactor;

    public CanvasPropertyBinder(final ReadOnlyDoubleProperty containerWidthProperty, final ReadOnlyDoubleProperty containerHeightProperty,
                        final Double containerStartWidth, final Double containerStartHeight,
                        final Double nodeWidth, final Double nodeHeight) {
        this.wC = containerWidthProperty;
        this.hC = containerHeightProperty;
        this.aspectRatio = nodeWidth / nodeHeight;
        this.xScaleFactor = nodeWidth / containerStartWidth;
        this.yScaleFactor = nodeHeight / containerStartHeight;
    }

    public void bindWithRatioToContainer(final DoubleProperty wN, final DoubleProperty hN) {
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
