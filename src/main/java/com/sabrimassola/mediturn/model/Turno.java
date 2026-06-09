package com.sabrimassola.mediturn.model;

import com.sabrimassola.mediturn.exception.DatosInvalidosException;
import com.sabrimassola.mediturn.exception.TurnoNoDisponibleException;

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
        if (paciente == null) {
            throw new DatosInvalidosException("El paciente no puede ser nulo");
        }
        if (profesional == null) {
            throw new DatosInvalidosException("El profesional no puede ser nulo");
        }
        if (fechaHora == null) {
            throw new DatosInvalidosException("La fecha y hora no puede ser nula");
        }
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

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void confirmar() {
        if(estado == EstadoTurno.CANCELADO){
            throw new TurnoNoDisponibleException("No se puede confirmar un turno cancelado");
        }
        this.estado = EstadoTurno.CONFIRMADO;
    }

    public void cancelar() {
        if(estado == EstadoTurno.CANCELADO){
            throw new TurnoNoDisponibleException("El turno ya esta cancelado");
        }
        this.estado = EstadoTurno.CANCELADO;

    }

    public void reprogramar(LocalDateTime fechaNueva) {
        if(estado == EstadoTurno.CANCELADO){
            throw new TurnoNoDisponibleException("No se puede reprogramar un turno cancelado");
        }
        if(fechaNueva == null){
            throw new DatosInvalidosException("La nueva fecha no puede ser nula");
        }
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