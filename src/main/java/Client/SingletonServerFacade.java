package Client;

import Shared.DataIO;

import java.io.IOException;
import java.net.Socket;

public class SingletonServerFacade {
    private static SingletonServerFacade instance;
    private Socket socket;

    private String hostname;
    private int port;

    private SingletonServerFacade(){}

    public static SingletonServerFacade getInstance() {
        if (instance == null) {
            instance = new SingletonServerFacade();
        }
        return instance;
    }

    public void config(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws IOException {
        this.socket = new Socket(this.hostname, this.port);
        System.out.println("Connected to " + hostname + ":" + port);
    }

    public void disconnect() throws IOException {
        socket.close();
        System.out.println("Disconnected by the client.");
    }

    public void sendData(Object data) throws IOException {
        DataIO dataIO = new DataIO(socket);
        dataIO.sendData(data);
    }

    public <T> T getData(Class<T> classType) throws IOException {
        DataIO dataIO = new DataIO(socket);
        return dataIO.getData(classType);
    }

    public String getRawData() throws IOException {
        DataIO dataIO = new DataIO(socket);
        return dataIO.getRawData();
    }
}
