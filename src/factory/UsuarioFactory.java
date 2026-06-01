package factory;

import model.*;

public class UsuarioFactory {
    public static Paciente crearPaciente(String nombre, String apellido, String email, String password,
                                        String dni, String obrasSocial) {
        return new Paciente(nombre, apellido, email, password, dni, obrasSocial);
    }

    public static Profesional crearProfesional(String nombre, String apellido, String email,
                                           String password, String matricula,
                                           Especialidad especialidad) {
        return new Profesional(nombre, apellido, email, password, matricula, especialidad);
    }

    public static Administrador crearAdministrador(String nombre, String apellido, String email, String password) {
        return new Administrador(nombre, apellido, email, password);
    }
}
