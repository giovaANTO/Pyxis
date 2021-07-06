package it.unibo.pyxis.view;

public interface View {

    Controller getController();

    void setController(Controller controller);

    void init();
}
