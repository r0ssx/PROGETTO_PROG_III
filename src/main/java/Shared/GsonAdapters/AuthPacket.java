package Shared.GsonAdapters;

public class AuthPacket {
    public String id;
    public String password;

    public AuthPacket() {}

    public AuthPacket(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
