package co.edu.unac.integradorI.colegio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Miguel
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador implements Serializable {

    public String nombre;
    public Long id;
    public Integer grado;
    public Long telefono;
    public String contra;
    public static List<Administrador> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        usuarios = cargarUsuarios();
        Crearusuario(usuarios);
        guardarUsuarios(usuarios);
    }

    public Administrador() {
    }

    public static void Crearusuario(List<Administrador> usuarios) {
        int opcion = 1;

        Scanner scanner = new Scanner(System.in);
        while (opcion != 0) {
            System.out.println("Ingresa 1 para crear nombre usuario");
            System.out.println("Ingresa 2 para ver los usuarios nuevos");
            System.out.println("Ingresa 3 para guardar y cerrar");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Administrador usuario1 = new Administrador();
                    System.out.println("Ingrese el nombre completo del estudiante (solo letras y espacios)");
                    String nombre = scanner.nextLine();
                    if (!nombre.matches("[a-zA-Z ]+")) {
                        System.out.println("Nombre inválido. Debe contener solo letras y espacios.");
                        break;
                    }
                    usuario1.setNombre(nombre);

                    System.out.println("Ingrese la identificación del estudiante");
                    usuario1.setId(scanner.nextLong());

                    System.out.println("Ingrese el grado que cursa el estudiante");
                    usuario1.setGrado(scanner.nextInt());

                    System.out.println("Ingresa el número telefónico del estudiante (debe comenzar con +57)");
                    String telefono = scanner.next();
                    if (!telefono.matches("\\+57\\d{10}")) {
                        System.out.println("Número telefónico inválido. Debe comenzar con +57 y tener 10 dígitos.");
                        break;
                    }
                    usuario1.setTelefono(Long.parseLong(telefono));

                    scanner.nextLine();
                    System.out.println("Crea la contraseña del estudiante");
                    usuario1.setContra(scanner.nextLine());

                    usuarios.add(usuario1);
                    System.out.println("Usuario creado exitosamente!");
                    break;
                case 2:
                    usuarios.forEach(usuarioActual -> System.out.println("ID: " + usuarioActual.getId() + " Contraseña: " + usuarioActual.getContra()));
                    break;
                case 3:
                    System.out.println("Guardando y cerrando...");
                    opcion = 0;
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
        scanner.close();
    }

    public static void guardarUsuarios(List<Administrador> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Error al guardar los usuarios: " + e.getMessage());
        }
    }

    public static List<Administrador> cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            return (List<Administrador>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los usuarios: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static boolean verificarUsuario(Long id, String contrasena) {
        for (Administrador usuario : usuarios) {
            if (usuario.getId().equals(id) && usuario.getContra().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getContra() {
        return contra;
    }
}
