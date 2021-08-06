package it.unibo.pyxis.controller.input;

import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.model.state.StateEnum;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class InputHandlerImpl implements InputHandler {
    @Override
    public final void bindCommands(final Linker inputLinker, final Stage inputStage) {
        final EventHandler<KeyEvent> keyEventEventHandler = keyEvent -> {
            switch (keyEvent.getCode()) {
                case A:
                    inputLinker.insertCommand(gameState -> {
                        if (gameState.getState() == StateEnum.RUN) {
                            gameState.getCurrentLevel().getArena().movePadLeft();
                        }
                    });
                    break;
                case D:
                    inputLinker.insertCommand(gameState -> {
                        if (gameState.getState() == StateEnum.RUN) {
                            gameState.getCurrentLevel().getArena().movePadRight();
                        }
                    });
                    break;
                case S:
                    inputLinker.insertCommand(gameState -> {
                        if (gameState.getState() != StateEnum.RUN) {
                            gameState.setState(StateEnum.RUN);
                        }
                    });
                    break;
                case ESCAPE:
                    inputLinker.insertCommand(gameState -> {
                        inputLinker.pause();
                    });
                    break;
                default:
                    break;
            }
        };
        inputStage.addEventHandler(KeyEvent.KEY_PRESSED, keyEventEventHandler);
    }
}
