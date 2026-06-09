package com.sabrimassola.mediturn.model;

import com.sabrimassola.mediturn.exception.DatosInvalidosException;
import com.sabrimassola.mediturn.observer.TurnoObservable;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class GestorDeTurnos extends TurnoObservable {

    private Map<Integer, Turno> turnos;

    public GestorDeTurnos() {
        this.turnos = new HashMap<>();
    }

    public void agregarTurno(Turno turno){
        if(turno == null ){
            throw new DatosInvalidosException("El turno no puede ser nulo.");
        }
        this.turnos.put(turno.getId(), turno);
        notificarObserver(turno,"Nuevo turno registrado");
    }

    public Turno buscarTurnoPorId (int id){
        Turno turno = this.turnos.get(id);
        if(turno == null){
            throw new DatosInvalidosException("No existe un turno con el id: "+ id);
        }
        return turno;
    }

    public void cancelarTurno(int id){
        Turno turno = buscarTurnoPorId(id);
        turno.cancelar();
        notificarObserver(turno,"Turno cancelado");
    }

    public void confirmarTurno(int id){
        Turno turno = buscarTurnoPorId(id);
        turno.confirmar();
        notificarObserver(turno,"Turno confirmado");
    }
    public void reprogramarTurno(int id, LocalDateTime nuevaFecha){
        Turno turno = buscarTurnoPorId(id);
        turno.reprogramar(nuevaFecha);
        notificarObserver(turno,"Turno reprogramado");

    }

    public Collection<Turno> listarTurnos(){
        return this.turnos.values();
    }


}
