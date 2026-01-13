package Client;

import Client.Controllers.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A FACADE class that provides easier access to Stage creation.
 */
public class StageFacade {
    protected final Stage STAGE;
    protected FXMLLoader loader;

    /**
     * Automatically creates a new Stage ready to be shown.
     * @param fxmlName the fxml name (without .fxml) of the stage gui file.
     * @param windowName the new stage window name.
     * @throws IOException when a fxml with fxmlName name can't be found.
     */
    public StageFacade(String fxmlName, String windowName) throws IOException {
        System.out.println("Trying to load fxml: " + fxmlName);

        loader = new FXMLLoader(getClass().getResource(fxmlName));

        STAGE = new Stage();

        STAGE.setTitle(windowName);
        STAGE.setScene(new Scene(loader.load()));
    }

    /**
     * Automatically creates a new Stage ready to be shown after setting a controller for it's handling.
     * @param fxmlName the fxml name (without .fxml) of the stage gui file.
     * @param windowName the new stage window name.
     * @param controller the controller that will be used for fxml handling.
     * @throws IOException when a fxml with fxmlName can't be found.
     */
    public StageFacade(String fxmlName, String windowName, Controller controller) throws IOException {
        System.out.println("Trying to load fxml: " + fxmlName);

        loader = new FXMLLoader(MainApp.class.getResource(fxmlName));

        setController(controller);
        Parent root = loader.load();

        STAGE = new Stage();

        STAGE.setTitle(windowName);
        STAGE.setScene(new Scene(root));
    }

    /**
     * Shows the stage.
     */
    public void show() {
        STAGE.show();
    }

    /**
     * Set at runtime a controller for the stage.
     * @param controller the controller that will be used.
     */
    public void setController(Controller controller) {
        loader.setController(controller);
    }

    /**
     * Closes the current stage getting its reference from a button in the GUI.
     * @param button a button in the stage that will be closed.
     */
    public static void closeStageFromBtn(Button button) {
        ((Stage) button.getScene().getWindow()).close();
    }

    public void changeScene(String fxmlName, String windowName, Controller controller) throws IOException {
        loader = new FXMLLoader(MainApp.class.getResource(fxmlName));

        setController(controller);
        Parent root = loader.load();

        STAGE.setTitle(windowName);
        STAGE.setScene(new Scene(root));
    }
}
