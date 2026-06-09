package com.sabrimassola.mediturn.observer;

import com.sabrimassola.mediturn.model.Turno;

public interface TurnoObserver {
    void actualizar(Turno turno, String mensaje);
}
