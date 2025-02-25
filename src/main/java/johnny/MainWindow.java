package johnny;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    private Johnny johnny;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/Slave.png"));
    private final Image johnnyImage = new Image(this.getClass().getResourceAsStream("/images/Johnny.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setJohnny(Johnny j) {
        johnny = j;
        dialogContainer.getChildren().addAll(
                DialogBox.getJohnnyDialog(johnny.getWelcome(), johnnyImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = johnny.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getJohnnyDialog(response, johnnyImage)
        );
        userInput.clear();
    }

}
