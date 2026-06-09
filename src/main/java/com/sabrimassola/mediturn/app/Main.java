package com.sabrimassola.mediturn.app;

import com.sabrimassola.mediturn.model.*;
import com.sabrimassola.mediturn.factory.*;
import com.sabrimassola.mediturn.exception.*;
import com.sabrimassola.mediturn.observer.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        GestorDeTurnos gestor = new GestorDeTurnos();
        Especialidad cardiologia = new Especialidad("Cardiologia","Sistema circulatorio",45);
        Paciente paciente = UsuarioFactory.crearPaciente("Sabrina","Massola","sabri@gmail.com",
                "1a2b3c4d","42468723","osde");
        Profesional profesional = UsuarioFactory.crearProfesional("Federico","Ramos","fede@gmail.com",
                "feche5230","MOFC210",cardiologia);

        gestor.agregarObserver((turno,mensaje)->{
            System.out.println("Notificacion para paciente: " + turno.getPaciente().getNombre()+":"+ mensaje);
        });
        gestor.agregarObserver((turno,mensaje)->{
            System.out.println("Notificacion para profesional: " + turno.getProfesional().getNombre()+":"+ mensaje);
        });
        gestor.agregarObserver((turno, mensaje) -> {
            System.out.println("LOG Turno " + turno.getId() + ": " + mensaje);
        });

        Turno turno = new Turno(paciente,profesional, LocalDateTime.now(),"control");
        paciente.reservarTurno(turno);
        gestor.agregarTurno(turno);
        System.out.println(turno);

        gestor.confirmarTurno(turno.getId());

        System.out.println(turno);
        //System.out.println(paciente.login("sabri@gmail.com","1s2a3b4r5i"));

        Turno turnoEncontrado = gestor.buscarTurnoPorId(turno.getId());
        System.out.println("El turno encontrado por el gestor es = " + turnoEncontrado);
    }
}
