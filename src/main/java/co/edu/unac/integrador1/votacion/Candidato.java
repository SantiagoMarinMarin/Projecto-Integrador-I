package co.edu.unac.integrador1.votacion;

import javax.swing.ImageIcon;

/**
 *
 * @author Nicol Alejandra
 */
public class Candidato {
    private String nombre;
    private String cargo;
    private ImageIcon foto;
    
    public Candidato(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.foto = null; // Inicialmente, sin foto
    }
 // Getter para el nombre
    public String getNombre() {
        return nombre;
    }
    
    // Setter para el nombre (opcional)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Getter para el cargo
    public String getCargo() {
        return cargo;
    }
    
    // Setter para el cargo (opcional)
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    // Getter para la foto
    public ImageIcon getFoto() {
        return foto;
    }
    
    // Setter para la foto
    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
   
    @Override
    public String toString() {
        return nombre; // Esto hace que el JComboBox solo muestre el nombre
    }

}
