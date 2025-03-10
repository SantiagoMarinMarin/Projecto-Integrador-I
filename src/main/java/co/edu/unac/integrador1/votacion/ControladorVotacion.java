package co.edu.unac.integrador1.votacion;

import java.util.ArrayList;
import java.util.List;

public class ControladorVotacion {
    public static List<Grupo> gruposCreados = new ArrayList<>();

    public static void inicializarGrupos() {
        Grupo grupo1 = new Grupo("Grupo A");
        grupo1.agregarCandidato(new Candidato("Juan Pérez", "personero"));
        grupo1.agregarCandidato(new Candidato("María Gómez", "representante"));

        Grupo grupo2 = new Grupo("Grupo B");
        grupo2.agregarCandidato(new Candidato("Carlos López", "contralor"));
        grupo2.agregarCandidato(new Candidato("Ana Rodríguez", "mediador"));

        gruposCreados.add(grupo1);
        gruposCreados.add(grupo2);
    }
}
