package it.unibo.pyxis.controller.command;

@FunctionalInterface
public interface Command<T> {
    /**
     * Execute the command action in the target.
     * @param target
     *             Target where the action should be executed.
     */
    void execute(T target);
}
