package it.unibo.pyxis.view.drawer.binder;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public final class LabelSizeBinder implements Binder {

    private final Label label;
    private final double originalSize;
    private final double originalWidth;

    public LabelSizeBinder(final Pane mainPane, final Label label) {
        this.label = label;
        this.originalSize = label.getFont().getSize();
        this.originalWidth = label.getPrefWidth();
        final ReadOnlyDoubleProperty mainPaneWidthProperty = mainPane.widthProperty();
        final ReadOnlyDoubleProperty mainPaneHeigthProperty = mainPane.heightProperty();
        final double mainPaneStartWidth = mainPane.getPrefWidth();
        final double mainPaneStartHeight = mainPane.getPrefHeight();
        this.label.prefWidthProperty().bind(mainPaneWidthProperty.multiply(label.getPrefWidth() / mainPaneStartWidth));
        this.label.prefHeightProperty().bind(mainPaneHeigthProperty.multiply(label.getPrefHeight() / mainPaneStartHeight));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void bind() {
        this.label.setFont(new Font(this.originalSize * this.label.getPrefWidth() / this.originalWidth));
    }
}
