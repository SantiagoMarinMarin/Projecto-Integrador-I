
package co.edu.unac.integrador1.login;
import co.edu.unac.integrador1.votacion.Candidato;
import javax.swing.JFileChooser;  // Para usar JFileChooser
import javax.swing.ImageIcon;      // Para usar ImageIcon
import java.io.File;       // Para trabajar con objetos File
import javax.swing.JOptionPane;
import java.awt.Image;


/**
 *
 * @author Nicol Alejandra
 */
public class AgregarCandidatoFrame extends javax.swing.JFrame {
private Candidato candidato;

    /**
     * Creates new form AgregarCandidatoFrame
     */
    public AgregarCandidatoFrame() {
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreCandidato = new javax.swing.JTextField();
        cboCargo = new javax.swing.JComboBox<>();
        btnCargarImagen = new javax.swing.JButton();
        lblFotoCandidato = new javax.swing.JLabel();
        btnAgregarCandidato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombreCandidato.setText("Nombre del candidato");
        txtNombreCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCandidatoActionPerformed(evt);
            }
        });

        cboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Personero", "Representante", "Contralor", "Mediador", "(Agrega otros cargos si es necesario)" }));

        btnCargarImagen.setText("Cargar imagen");
        btnCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImagenActionPerformed(evt);
            }
        });

        lblFotoCandidato.setText("jLabelFotoCandidato");

        btnAgregarCandidato.setText("Agregar Candidato");
        btnAgregarCandidato.setHideActionText(true);
        btnAgregarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCandidatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarCandidato)
                    .addComponent(lblFotoCandidato)
                    .addComponent(btnCargarImagen)
                    .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtNombreCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCargarImagen)
                .addGap(12, 12, 12)
                .addComponent(lblFotoCandidato)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarCandidato)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenActionPerformed
     JFileChooser fileChooser = new JFileChooser();
    // Opcional: agregar filtro de imágenes
    // fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));
    
    int resultado = fileChooser.showOpenDialog(this);
    
    if (resultado == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = fileChooser.getSelectedFile();
        ImageIcon iconoOriginal = new ImageIcon(archivoSeleccionado.getAbsolutePath());
        
        // Define el tamaño deseado. Puedes ajustar estos valores según tu diseño.
        int anchoDeseado = 100;  // por ejemplo, 100 píxeles de ancho
        int altoDeseado = 100;   // 100 píxeles de alto
        
        // Redimensionar la imagen
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        
        // Asigna la imagen redimensionada al JLabel
        lblFotoCandidato.setIcon(iconoRedimensionado);
    } else {
        JOptionPane.showMessageDialog(this, "No se seleccionó ninguna imagen.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }   
    }//GEN-LAST:event_btnCargarImagenActionPerformed

    private void txtNombreCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCandidatoActionPerformed
  
    }//GEN-LAST:event_txtNombreCandidatoActionPerformed

    private void btnAgregarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCandidatoActionPerformed
     // 1. Obtener el nombre del candidato desde txtNombreCandidato
        String nombreCandidato = txtNombreCandidato.getText().trim();
        if (nombreCandidato.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debes ingresar el nombre del candidato.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // 2. Obtener el cargo seleccionado desde cboCargo
        String cargo = (String)cboCargo.getSelectedItem();
        if (cargo == null || cargo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un cargo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // 3. Verificar que se haya cargado una imagen en lblFotoCandidato
        if (lblFotoCandidato.getIcon() == null){
            JOptionPane.showMessageDialog(this, "Debes cargar una imagen.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ImageIcon foto = (ImageIcon) lblFotoCandidato.getIcon();
    
        // 4. Crear el objeto candidato y asignarle la imagen usando el setter
        candidato = new Candidato(nombreCandidato, cargo);
        candidato.setFoto(foto);
    
        // 5. Mostrar mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Candidato agregado:\n" + candidato.toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
    
        // 6. (Opcional) Limpiar los campos para agregar otro candidato
        txtNombreCandidato.setText("");
        cboCargo.setSelectedIndex(0);
        lblFotoCandidato.setIcon(null);
        
        // Cierra el formulario (si ese es el flujo deseado)
        this.dispose();
    }//GEN-LAST:event_btnAgregarCandidatoActionPerformed
public Candidato getCandidato() {
        return candidato;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(AgregarCandidatoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCandidatoFrame().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCandidato;
    private javax.swing.JButton btnCargarImagen;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JLabel lblFotoCandidato;
    private javax.swing.JTextField txtNombreCandidato;
    // End of variables declaration//GEN-END:variables
}
