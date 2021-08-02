package it.unibo.pyxis.view.drawer;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelSizeBinder {

    private final Label label;
    private final double originalSize;
    private final double originalWidth;

    public LabelSizeBinder(final ReadOnlyDoubleProperty containerWidthProperty, final ReadOnlyDoubleProperty containerHeightProperty,
            final Double containerStartWidth, final Double containerStartHeight,
            final Label label) {
        this.label = label;
        this.originalSize = label.getFont().getSize();
        this.originalWidth = label.getPrefWidth();
        System.out.println(containerStartWidth);
        this.label.prefWidthProperty().bind(containerWidthProperty.multiply(label.getPrefWidth() / containerStartWidth));
        this.label.prefHeightProperty().bind(containerHeightProperty.multiply(label.getPrefHeight() / containerStartHeight));
    }

    public void bindWithSize() {
        this.label.setFont(new Font(this.originalSize * this.label.getPrefWidth() / this.originalWidth));
    }

}
