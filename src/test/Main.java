package test;

import model.Especialidad;
import model.Paciente;
import model.Profesional;
import model.Turno;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Especialidad cardiologia = new Especialidad("Cardiologia","Sistema circulatorio",45);
        Profesional profesional1 = new Profesional("Federico","Bonatti","fede@gmail.com","1f2e3d4e",
                "m152c0",cardiologia);
        Paciente paciente1 = new Paciente("Sabrina","Massola","sabri@gmail.com","1s2a3b4r5i",
                "42468723","osde");
        Turno turno = new Turno(paciente1,profesional1, LocalDateTime.now(),"control");
        paciente1.reservarTurno(turno);
        System.out.println(turno);
        turno.confirmar();
        System.out.println(turno);
        System.out.println(paciente1.login("sabri@gmail.com","1s2a3b4r5i"));
    }
}
