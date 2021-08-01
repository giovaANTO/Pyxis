package it.unibo.pyxis.view.drawer;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelPropertyToContainerBinder extends NodePropertyToContainerBinder {

    private final Label label;
    private final double originalSize;
    private final double originalWidth;

    public LabelPropertyToContainerBinder(final ReadOnlyDoubleProperty containerWidthProperty, final ReadOnlyDoubleProperty containerHeightProperty,
            final Double containerStartWidth, final Double containerStartHeight,
            final Label label) {
        super(containerWidthProperty, containerHeightProperty,
                containerStartWidth, containerStartHeight,
                label.prefWidthProperty(), label.prefHeightProperty(),
                label.getPrefWidth(), label.getPrefHeight());
        this.label = label;
        this.originalSize = label.getFont().getSize();
        this.originalWidth = label.getPrefWidth();
    }

    @Override
    public void bindWithRatioToContainer() {
        super.bindWithRatioToContainer();
        this.label.setFont(new Font(this.originalSize * this.label.getPrefWidth() / this.originalWidth));
    }

}
