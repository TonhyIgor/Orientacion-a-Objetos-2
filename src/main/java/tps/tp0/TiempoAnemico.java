package tps.tp0;

import java.time.LocalDateTime;

public class TiempoAnemico {
    private LocalDateTime actual;

    public TiempoAnemico(LocalDateTime actual) {
        this.actual = actual;
    }

    public LocalDateTime getActual() {
        return actual;
    }

    public void setActual(LocalDateTime actual) {
        this.actual = actual;
    }
}
