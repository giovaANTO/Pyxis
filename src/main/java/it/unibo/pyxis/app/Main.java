package it.unibo.pyxis.app;


import it.unibo.pyxis.controller.engine.GameLoopImpl;

public class Main {
    public static void main(final String[] args) {
        new GameLoopImpl().start();
    }
}
