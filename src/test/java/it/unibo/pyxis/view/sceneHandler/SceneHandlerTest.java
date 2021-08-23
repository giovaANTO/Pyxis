package it.unibo.pyxis.view.sceneHandler;

import it.unibo.pyxis.controller.EndLevelController;
import it.unibo.pyxis.controller.GameController;
import it.unibo.pyxis.controller.MenuController;
import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.controller.linker.LinkerImpl;
import it.unibo.pyxis.view.input.InputHandler;
import it.unibo.pyxis.view.input.InputHandlerImpl;
import it.unibo.pyxis.view.scene.SceneHandler;
import it.unibo.pyxis.view.scene.SceneHandlerImpl;
import it.unibo.pyxis.view.scene.SceneType;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SceneHandlerTest {

    private Linker linker1;
    private Stage stage;
    private InputHandler inputHandler;
    private SceneHandler sceneHandler;

    @BeforeEach
    public void setUp() {
        this.linker1 = new LinkerImpl();
        this.inputHandler = new InputHandlerImpl();
        this.stage = new Stage();
        this.inputHandler.bindCommands(this.linker1, this.stage);
        this.sceneHandler = new SceneHandlerImpl(this.stage, this.linker1);
        this.linker1.setSceneHandler(this.sceneHandler);
    }

    @Test
    public void testSwitchScene() {
        System.out.println("testSwitchScene");
        this.sceneHandler.switchScene(SceneType.MENU_SCENE);
        assertEquals(this.sceneHandler.getCurrentController(), new MenuController());
        this.sceneHandler.switchScene(SceneType.GAME_SCENE);
        assertEquals(this.sceneHandler.getCurrentController(), new GameController());
        this.sceneHandler.switchScene(SceneType.END_LEVEL_SCENE);
        assertEquals(this.sceneHandler.getCurrentController(), new EndLevelController());
        this.sceneHandler.switchScene(SceneType.MENU_SCENE);
        assertEquals(this.sceneHandler.getCurrentController(), new MenuController());
    }
}
