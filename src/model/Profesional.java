package model;

import java.util.ArrayList;
import java.util.List;

public class Profesional extends Usuario {

    private String matricula;
    private Especialidad especialidad;
    private List<Turno> turnos;
    private List<Disponibilidad> disponibilidad;


    public Profesional(String nombre, String apellido, String email,
                       String password, String matricula,
                       Especialidad especialidad) {
        super(nombre, apellido, email, password, Roles.PROFESIONAL);
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.turnos = new ArrayList<>();
        this.disponibilidad = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }


    public void agregarTurno(Turno turno) {
        if (!this.turnos.contains(turno)) {
            this.turnos.add(turno);
        }
    }

    public void agregarDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad.add(disponibilidad);
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public List<Disponibilidad> getDisponibilidad() {
        return disponibilidad;
    }

    @Override
    public String getDatos() {
        return "Profesional{" +
                "id= " + getId() +
                ", nombre= '" + getNombre() + "'" +
                ", apellido= '" + getApellido() + "'" +
                ", email= '" + getEmail() + "'" +
                ", rol= " + getRol() +
                ", matricula= '" + matricula + "'" +
                ", especialidad= " + especialidad.getNombre() +
                ", descripcion= " + especialidad.getDescripcion() +
                ", duracion de consulta (minutos)= " + especialidad.getDuracionMinutos() +
                "}";
    }
}
