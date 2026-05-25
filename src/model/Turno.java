package model;

import java.time.LocalDateTime;

public class Turno {
    private int id;
    private Paciente paciente;
    private Profesional profesional;
    private LocalDateTime fechaHora;
    private EstadoTurno estado;
    private String observaciones;

    private static int contadorId;

    public Turno(Paciente paciente, Profesional profesional, LocalDateTime fechaHora, String observaciones) {
        this.id = ++contadorId;
        this.paciente = paciente;
        this.profesional = profesional;
        this.fechaHora = fechaHora;
        this.estado = EstadoTurno.RESERVADO;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public String getObservaciones() {
        return observaciones;
    }


    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void confirmarTurno() {
        this.estado = EstadoTurno.CONFIRMADO;
    }

    public void cancelarTurno() {
        this.estado = EstadoTurno.CANCELADO;
    }

    public void reprogramarTurno(LocalDateTime fechaNueva) {
        this.fechaHora = fechaNueva;
        this.estado = EstadoTurno.REPROGRAMADO;
    }

    @Override
    public String toString() {
        return "Turno de paciente: " + paciente.getNombre() +
                " con el profesional: " + profesional.getNombre() +
                " fecha: " + getFechaHora() +
                " estado de turno: " + getEstado();
    }
}