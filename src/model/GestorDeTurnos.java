package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import exception.DatosInvalidosException;

public class GestorDeTurnos {
    private Map<Integer, Turno> turnos;

    public GestorDeTurnos() {
        this.turnos = new HashMap<>();
    }

    public void agregarTurno(Turno turno){
        if(turno == null ){
            throw new DatosInvalidosException("El turno no puede ser nulo.");
        }
        this.turnos.put(turno.getId(), turno);
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
    }

    public Collection<Turno> listarTurnos(){
        return this.turnos.values();
    }


}
