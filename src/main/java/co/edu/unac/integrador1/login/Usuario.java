package co.edu.unac.integrador1.login;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Miguel
 */
import java.util.Scanner;
public class Usuario {
    public Long id;
    public String contrasena;
    public static void main(String[] args) {
        Administrador.usuarios = Administrador.cargarUsuarios();
        Iniciarsesion();
    }
    public Usuario() {
    }
    public static void Iniciarsesion() {
        Scanner scanner = new Scanner(System.in);
        int intento = 1;
        while (intento != 0) {
            System.out.println("Presiona 1 para iniciar sesión");
            System.out.println("Presiona 2 para salir ");
            intento = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            switch (intento) {
                case 1:
                    Usuario usuario1 = new Usuario();
                    System.out.println("Ingresa tu identificación");
                    usuario1.setId(scanner.nextLong());
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingresa tu contraseña");
                    usuario1.setContrasena(scanner.nextLine());
                    if (Administrador.verificarUsuario(usuario1.getId(), usuario1.getContrasena())) {
                        System.out.println("Inicio de sesión exitoso!");
                    } else {
                        System.out.println("Identificación o contraseña incorrecta.");
                    }
                    break;
                    
                case 2:
                    System.out.println("saliendo ");
                    intento= 0;
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
        scanner.close();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
