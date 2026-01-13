package Client;

import Client.Controllers.Controller;
import Client.Controllers.HomeController;

import java.io.IOException;

public class SingletonStage {
    private static SingletonStage instance;

    private static StageFacade stageFacade;

    private SingletonStage() throws IOException {
        stageFacade = new StageFacade("Home.fxml", "Home", new HomeController());
    }

    public static SingletonStage getInstance() throws IOException {
        if (instance == null)
            instance = new SingletonStage();
        return instance;
    }

    public static StageFacade getStageFacade() {
        return stageFacade;
    }

    public static void fastChangeScene(String fxmlName, String windowName, Controller controller) throws IOException {
        stageFacade.changeScene(fxmlName, windowName, controller);
    }
}
