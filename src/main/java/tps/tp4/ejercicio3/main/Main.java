package tps.tp4.ejercicio3.main;

import tps.tp4.ejercicio3.data.ArchivoPersistenciaConcurso;
import tps.tp4.ejercicio3.data.ArchivoPersistenciaParticipante;
import tps.tp4.ejercicio3.model.ManejoConcurso;
import tps.tp4.ejercicio3.ui.RadioCompetitionView;

public class Main {
    public static void main(String[] args) {
        var persistenciaParticipante = new ArchivoPersistenciaParticipante("/home/tonhy/inscriptos.txt");
        var persistenciaConcurso = new ArchivoPersistenciaConcurso("/home/tonhy/concursos.txt");

        var manejoConcurso = new ManejoConcurso(persistenciaParticipante, persistenciaConcurso);
        manejoConcurso.cargarConcursos();

        new RadioCompetitionView(manejoConcurso);
    }
}
