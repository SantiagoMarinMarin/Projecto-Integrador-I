package co.edu.unac.integrador1.votacion;
  
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class VotingFrame extends javax.swing.JFrame {
    private Long idUsuario;



    public VotingFrame (Long idUsuario) {
        initComponents();
        this.idUsuario = idUsuario;
        cargarCandidatosPorCargo();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        cboPersonero = new javax.swing.JComboBox<co.edu.unac.integrador1.votacion.Candidato>()
        ;
        btnVotar = new javax.swing.JButton();
        cboRepresentante = new javax.swing.JComboBox<co.edu.unac.integrador1.votacion.Candidato>()
        ;
        cboContralor = new javax.swing.JComboBox<co.edu.unac.integrador1.votacion.Candidato>()
        ;
        cboMediador = new javax.swing.JComboBox<co.edu.unac.integrador1.votacion.Candidato>()
        ;

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboPersonero.setModel(new DefaultComboBoxModel<co.edu.unac.integrador1.votacion.Candidato>());

        btnVotar.setText("jButton1");
        btnVotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVotarActionPerformed(evt);
            }
        });

        cboRepresentante.setModel(new DefaultComboBoxModel<co.edu.unac.integrador1.votacion.Candidato>());

        cboContralor.setModel(new DefaultComboBoxModel<co.edu.unac.integrador1.votacion.Candidato>());

        cboMediador.setModel(new DefaultComboBoxModel<co.edu.unac.integrador1.votacion.Candidato>());
        cboMediador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMediadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnVotar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(cboPersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(cboContralor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(cboRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboMediador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPersonero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboContralor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMediador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnVotar)
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnVotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVotarActionPerformed
      Candidato elegidoPersonero = (Candidato) cboPersonero.getSelectedItem();
        Candidato elegidoRepresentante = (Candidato) cboRepresentante.getSelectedItem();
        Candidato elegidoContralor = (Candidato) cboContralor.getSelectedItem();
        Candidato elegidoMediador = (Candidato) cboMediador.getSelectedItem();

        if (elegidoPersonero == null || elegidoRepresentante == null || elegidoContralor == null || elegidoMediador == null) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un candidato en cada categoría.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Voto voto = new Voto(idUsuario);
        voto.registrarVoto("personero", elegidoPersonero);
        voto.registrarVoto("representante", elegidoRepresentante);
        voto.registrarVoto("contralor", elegidoContralor);
        voto.registrarVoto("mediador", elegidoMediador);

        String mensaje = String.format("""
            Tu voto ha sido registrado:
            - Personero: %s
            - Representante: %s
            - Contralor: %s
            - Mediador: %s
            """, elegidoPersonero, elegidoRepresentante, elegidoContralor, elegidoMediador);

        JOptionPane.showMessageDialog(this, mensaje, "Voto registrado", JOptionPane.INFORMATION_MESSAGE);
        
        
    }//GEN-LAST:event_btnVotarActionPerformed

    private void cargarCandidatosPorCargo() {
        if (ControladorVotacion.gruposCreados == null) {
            JOptionPane.showMessageDialog(this, "No hay grupos o candidatos disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultComboBoxModel<Candidato> modeloPersonero = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Candidato> modeloRepresentante = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Candidato> modeloContralor = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Candidato> modeloMediador = new DefaultComboBoxModel<>();

        for (Grupo grupo : ControladorVotacion.gruposCreados) {
            for (Candidato candidato : grupo.getCandidatos()) {
                switch (candidato.getCargo().toLowerCase()) {
                    case "personero" -> modeloPersonero.addElement(candidato);
                    case "representante" -> modeloRepresentante.addElement(candidato);
                    case "contralor" -> modeloContralor.addElement(candidato);
                    case "mediador" -> modeloMediador.addElement(candidato);
                }
            }
        }

        cboPersonero.setModel(modeloPersonero);
        cboRepresentante.setModel(modeloRepresentante);
        cboContralor.setModel(modeloContralor);
        cboMediador.setModel(modeloMediador);
        
    }
    
    
    private void cboMediadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMediadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMediadorActionPerformed

   
    
    public static void main(String[] args) {
       ControladorVotacion.inicializarGrupos();
        java.awt.EventQueue.invokeLater(() -> new VotingFrame(1L).setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVotar;
    private javax.swing.JComboBox<Candidato> cboContralor;
    private javax.swing.JComboBox<Candidato> cboMediador;
    private javax.swing.JComboBox<Candidato> cboPersonero;
    private javax.swing.JComboBox<Candidato> cboRepresentante;
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration//GEN-END:variables
}