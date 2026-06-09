package com.sabrimassola.mediturn.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Disponibilidad {
    private long id;
    private DayOfWeek dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Disponibilidad(long id, DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public long getId() {
        return id;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Disponibilidad:" + dia +
                " hora inicio: " + horaInicio +
                " hora fin: " + horaFin;
    }
}
