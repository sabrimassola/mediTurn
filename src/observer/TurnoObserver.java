package observer;
import model.Turno;

public interface TurnoObserver {
    void actualizar(Turno turno,String mensaje);

}
