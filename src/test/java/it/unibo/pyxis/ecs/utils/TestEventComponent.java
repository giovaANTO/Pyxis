package it.unibo.pyxis.ecs.utils;
import it.unibo.pyxis.ecs.component.event.AbstractEventComponent;
import it.unibo.pyxis.model.event.Event;
import org.greenrobot.eventbus.Subscribe;

public class TestEventComponent extends AbstractEventComponent<TestEntity> {
    public TestEventComponent(TestEntity entity) {
        super(entity);
    }

    @Subscribe
    public void handleGenericEvent(Event event) {
        System.out.println("Hello");
    }
}
