package model;

public interface Autenticable {
    boolean login(String email, String password);
    void logout();
}
