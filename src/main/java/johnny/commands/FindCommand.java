package johnny.commands;

import johnny.exceptions.JohnnyException;
import johnny.storage.Storage;
import johnny.tasks.TaskList;
import johnny.ui.Ui;

import java.util.jar.JarException;

/**
 * Controls what happens user tries to find Tasks.
 */
public class FindCommand extends Command {

    /** String to be matched to Task name. */
    private String keyword;

    /**
     * Constructor for FindCommand.
     *
     * @param keyword SString to be matched to Task name.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the process of a FindCommand.
     * Finds Task, appends to a new TaskList and Ui shows appropriate response.
     *
     * @param tasks TaskList of tasks.
     * @param ui Ui to print responses.
     * @param storage Storage for data.
     * @throws JohnnyException Ignore as error will not be thrown.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JohnnyException {
        TaskList foundTasks = tasks.find(keyword);
        ui.showFoundTasks(foundTasks);
    }

    /**
     * Does not exit so chatbot can continue running.
     *
     * @return False so the loop keeps running.
     */
    @Override
    public boolean isExit() {
        return false;
    }

}
