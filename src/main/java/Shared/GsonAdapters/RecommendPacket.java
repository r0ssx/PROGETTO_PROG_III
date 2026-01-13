package Shared.GsonAdapters;

public class RecommendPacket {
    public String email;
    public String nome_utente;

    public RecommendPacket(String email, String nome_utente) {
        this.email = email;
        this.nome_utente = nome_utente;
    }
}
