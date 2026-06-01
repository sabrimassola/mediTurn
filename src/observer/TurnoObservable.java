package observer;

import model.Turno;

import java.util.ArrayList;
import java.util.List;

abstract public class TurnoObservable {
    private List<TurnoObserver> observers =  new ArrayList<>();

    public void agregarObserver(TurnoObserver observer){
        observers.add(observer);
    }
    public void eliminarObserver(TurnoObserver observer){
        observers.remove(observer);
    }
    protected void notificarObserver(Turno turno, String mensaje){
        for(TurnoObserver obs : observers){
            obs.actualizar(turno,mensaje);
        }
    }
}
