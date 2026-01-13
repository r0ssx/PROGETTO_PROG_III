package Client;

import javafx.application.Application;

import java.io.IOException;

public class MainAppLauncher {
    public static void main(String[] args) {
        try {
            SingletonServerFacade server = SingletonServerFacade.getInstance();
            server.config("localhost", 9000);
            server.connect();
            Application.launch(MainApp.class, args);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
}