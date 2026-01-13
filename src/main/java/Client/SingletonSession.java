package Client;

public class SingletonSession {
    private static SingletonSession instance;

    private String sessionUser;


    private SingletonSession() {}

    public static SingletonSession getInstance() {
        if (instance == null) {
            instance = new SingletonSession();
        }
        return instance;
    }

    public String getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(String sessionUser) {
        this.sessionUser = sessionUser;
    }
}
