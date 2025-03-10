package co.edu.unac.integrador1.votacion;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nombre;
    private List<Candidato> candidatos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.candidatos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void agregarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    @Override
    public String toString() {
        return "Grupo: " + nombre + "\nCandidatos: " + candidatos.toString();
    }
}
