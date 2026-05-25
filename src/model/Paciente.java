package model;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {

    private String dni;
    private String obraSocial;
    private List<Turno> turnos;

    public Paciente(String nombre, String apellido, String email, String password, String dni, String obraSocial) {
        super(nombre, apellido, email, password, Roles.PACIENTE);
        this.dni = dni;
        this.obraSocial = obraSocial;
        this.turnos = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public void reservarTurno(Turno turno) {
        if (!this.turnos.contains(turno)) {
            this.turnos.add(turno);
            turno.setEstado(EstadoTurno.RESERVADO);
            turno.getProfesional().agregarTurno(turno);
        }
    }

    public void cancelarTurno(Turno turno) {
        turno.cancelarTurno();
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    @Override
    public String getDatos() {
        return "Paciente{" +
                "id= " + getId() +
                ", nombre= '" + getNombre() + "'" +
                ", apellido= '" + getApellido() + "'" +
                ", dni= " + getDni() + "'" +
                ", obra social= " + getObraSocial() + "'" +
                ", email= '" + getEmail() + "'" +
                ", rol= " + getRol() +
                "}";
    }


}
