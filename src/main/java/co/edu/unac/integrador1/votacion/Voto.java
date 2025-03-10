package co.edu.unac.integrador1.votacion;

import java.util.HashMap;
import java.util.Map;

public class Voto {
    private Long idVotante;
    private Map<String, Candidato> votos;

    public Voto(Long idVotante) {
        this.idVotante = idVotante;
        this.votos = new HashMap<>();
    }

    public void registrarVoto(String cargo, Candidato candidato) {
        if (candidato != null) {
            votos.put(cargo, candidato);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Votos del votante " + idVotante + ":\n");
        for (Map.Entry<String, Candidato> entry : votos.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue().getNombre()).append("\n");
        }
        return sb.toString();
    }
}
