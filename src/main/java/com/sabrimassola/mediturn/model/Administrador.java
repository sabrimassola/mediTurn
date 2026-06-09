package com.sabrimassola.mediturn.model;

public class Administrador extends Usuario {

    public Administrador(String nombre, String apellido, String email, String password) {
        super(nombre, apellido, email, password, Roles.ADMINISTRADOR);
    }


    @Override
    public String getDatos() {
        return "Administrador{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + "'" +
                ", apellido='" + getApellido() + "'" +
                ", email='" + getEmail() + "'" +
                ", rol=" + getRol() +
                "}";
    }
}
