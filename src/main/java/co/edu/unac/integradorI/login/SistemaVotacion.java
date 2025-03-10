
package co.edu.unac.integradorI.login;

import co.edu.unac.integrador1.votacion.ControladorVotacion;
import co.edu.unac.integrador1.votacion.Grupo;
import co.edu.unac.integrador1.votacion.Voto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Nicol Alejandra
 */
public class SistemaVotacion extends javax.swing.JFrame {

   
    private JComboBox<String> cboPersonero, cboContralor, cboMediador, cboRepresentante;
    private JButton btnVotar;
    private Map<String, Candidato> mapaPersoneros = new HashMap<>();
    private Map<String, Candidato> mapaContralores = new HashMap<>();
    private Map<String, Candidato> mapaMediadores = new HashMap<>();
    private Map<String, Candidato> mapaRepresentantes = new HashMap<>();
    
    public SistemaVotacion() {
        initComponents();
        setTitle("Sistema de Votación Escolar");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Etiquetas
        add(new JLabel("Elige tu Personero:"));
        cboPersonero = new JComboBox<>();
        add(cboPersonero);

        add(new JLabel("Elige tu Contralor:"));
        cboContralor = new JComboBox<>();
        add(cboContralor);

        add(new JLabel("Elige tu Mediador:"));
        cboMediador = new JComboBox<>();
        add(cboMediador);

        add(new JLabel("Elige tu Representante:"));
        cboRepresentante = new JComboBox<>();
        add(cboRepresentante);

        // Botón de votar
        btnVotar = new JButton("Votar");
        add(btnVotar);

        // Cargar candidatos
        cargarCandidatos();

        // Acción del botón votar
        btnVotar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarVoto();
            }
        });    
        
        
    }
    
    private void cargarCandidatos() {
        List<Candidato> listaPersoneros = List.of(new Candidato("Ana"), new Candidato("Luis"), new Candidato("María"));
        List<Candidato> listaContralores = List.of(new Candidato("Juan"), new Candidato("Sofía"), new Candidato("Pedro"));
        List<Candidato> listaMediadores = List.of(new Candidato("Laura"), new Candidato("Diego"), new Candidato("Marta"));
        List<Candidato> listaRepresentantes = List.of(new Candidato("Carlos"), new Candidato("Elena"), new Candidato("José"));

        cargarComboBox(cboPersonero, listaPersoneros, mapaPersoneros);
        cargarComboBox(cboContralor, listaContralores, mapaContralores);
        cargarComboBox(cboMediador, listaMediadores, mapaMediadores);
        cargarComboBox(cboRepresentante, listaRepresentantes, mapaRepresentantes);
    }

    private void cargarComboBox(JComboBox<String> comboBox, List<Candidato> listaCandidatos, Map<String, Candidato> mapaCandidatos) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Candidato candidato : listaCandidatos) {
            model.addElement(candidato.getNombre());
            mapaCandidatos.put(candidato.getNombre(), candidato);
        }
        comboBox.setModel(model);
    }

    private void registrarVoto() {
        Candidato personero = mapaPersoneros.get((String) cboPersonero.getSelectedItem());
        Candidato contralor = mapaContralores.get((String) cboContralor.getSelectedItem());
        Candidato mediador = mapaMediadores.get((String) cboMediador.getSelectedItem());
        Candidato representante = mapaRepresentantes.get((String) cboRepresentante.getSelectedItem());

        if (personero != null && contralor != null && mediador != null && representante != null) {
            JOptionPane.showMessageDialog(this, "Voto registrado con éxito:\nPersonero: " + personero.getNombre() +
                    "\nContralor: " + contralor.getNombre() +
                    "\nMediador: " + mediador.getNombre() +
                    "\nRepresentante: " + representante.getNombre());
        } else {
            JOptionPane.showMessageDialog(this, "Por favor selecciona todos los candidatos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

}
class Candidato {
    private String nombre;

    public Candidato(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

