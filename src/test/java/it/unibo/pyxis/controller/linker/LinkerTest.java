package it.unibo.pyxis.controller.linker;

import it.unibo.pyxis.controller.GameController;
import it.unibo.pyxis.controller.MenuController;
import it.unibo.pyxis.controller.PauseController;
import it.unibo.pyxis.model.state.StateEnum;
import it.unibo.pyxis.view.input.InputHandler;
import it.unibo.pyxis.view.input.InputHandlerImpl;
import it.unibo.pyxis.view.scene.SceneHandler;
import it.unibo.pyxis.view.scene.SceneHandlerImpl;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkerTest {

    private Linker linker1;
    private Stage stage;
    private InputHandler inputHandler;
    private SceneHandler sceneHandler;

    @BeforeEach
    private void setUp() {
        this.linker1 = new LinkerImpl();
        this.inputHandler = new InputHandlerImpl();
        this.stage = new Stage();
        inputHandler.bindCommands(this.linker1, this.stage);
        this.sceneHandler = new SceneHandlerImpl(this.stage, this.linker1);
        this.linker1.setSceneHandler(this.sceneHandler);
        this.linker1.menu();
    }

    @Test
    private void testSwitchScene() {
        System.out.println("testSwitchScene");
        assertEquals(this.sceneHandler.getCurrentController(), new MenuController());
        assertEquals(this.linker1.getGameState().getState(), StateEnum.WAITING_FOR_NEW_GAME);
        this.linker1.run();
        assertEquals(this.sceneHandler.getCurrentController(), new GameController());
        assertNotEquals(this.linker1.getGameState().getState(), StateEnum.WAITING_FOR_NEW_GAME);
        this.linker1.pause();
        assertEquals(this.sceneHandler.getCurrentController(), new PauseController());
        assertEquals(this.linker1.getGameState().getState(), StateEnum.PAUSE);
        this.linker1.quit();
    }

    @Test
    private void testCommands() {
        System.out.println("testCommands");
        this.linker1.run();
        assertEquals(this.linker1.getGameState().getState(), StateEnum.WAITING_FOR_STARTING_COMMAND);
        double xPosition = this.linker1.getGameState().getCurrentLevel().getArena().getPad().getPosition().getX();
        this.linker1.insertGameCommand(level -> level.getArena().movePadLeft());
        this.linker1.insertGameCommand(level -> level.getArena().movePadLeft());
        assertEquals(this.linker1.getGameState().getState(), StateEnum.WAITING_FOR_STARTING_COMMAND);
        assertEquals(xPosition, this.linker1.getGameState().getCurrentLevel().getArena().getPad().getPosition().getX());
        this.linker1.insertCommand(gameState -> {
            if (gameState.getState() != StateEnum.RUN) {
                gameState.setState(StateEnum.RUN);
            }
        });
        assertNotEquals(this.linker1.getGameState().getState(), StateEnum.WAITING_FOR_STARTING_COMMAND);
        assertEquals(this.linker1.getGameState().getState(), StateEnum.RUN);
        xPosition = this.linker1.getGameState().getCurrentLevel().getArena().getPad().getPosition().getX();
        this.linker1.insertGameCommand(level -> level.getArena().movePadLeft());
        assertNotEquals(xPosition, this.linker1.getGameState().getCurrentLevel().getArena().getPad().getPosition().getX());
    }
}
