package it.unibo.pyxis.controller.command;

@FunctionalInterface
public interface Command<T> {
    /**
     * Executes the command action in the target.
     *
     * @param target The target where the action should be executed.
     */
    void execute(T target);
}
