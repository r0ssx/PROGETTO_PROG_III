package Client;

/**
 * Singleton che gestisce la sessione dell'utente nell'applicazione.
 * Mantiene informazioni sull'utente attualmente connesso,
 * come l'identificativo dell'utente.
 */
public class SingletonSession {

    /**
     * Istanza unica del singleton.
     */
    private static SingletonSession instance;

    /**
     * Identificativo dell'utente attualmente loggato.
     */
    private String sessionUser;

    /**
     * Costruttore privato per implementare il pattern Singleton.
     */
    private SingletonSession() {}

    /**
     * Restituisce l'istanza unica del singleton.
     * @return istanza di {@link SingletonSession}
     */
    public static SingletonSession getInstance() {
        if (instance == null) {
            instance = new SingletonSession();
        }
        return instance;
    }

    /**
     * Restituisce l'identificativo dell'utente attualmente loggato.
     * @return identificativo dell'utente
     */
    public String getSessionUser() {
        return sessionUser;
    }

    /**
     * Imposta l'identificativo dell'utente attualmente loggato.
     * @param sessionUser identificativo dell'utente
     */
    public void setSessionUser(String sessionUser) {
        this.sessionUser = sessionUser;
    }
}
