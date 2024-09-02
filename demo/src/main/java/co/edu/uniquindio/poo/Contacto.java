package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Contacto {
    private String nombre;
    private String alias;
    private String direccion;
    private String telefono;
    private String email;
    private ArrayList<Grupo> grupos; // Lista de grupos a los que pertenece el contacto

    // Constructor
    public Contacto(String nombre, String alias, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.alias = alias;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.grupos = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    // Método para agregar un grupo al contacto
    public void agregarGrupo(Grupo grupo) {
        if (!grupos.contains(grupo)) {
            grupos.add(grupo);
        }
    }

    // Sobreescribir equals y hashCode para la igualdad por nombre y teléfono
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return nombre.equals(contacto.nombre) && telefono.equals(contacto.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono);
    }

    // Método para crear un nuevo contacto
    public static Contacto crearContacto(Scanner scanner) {
        System.out.println("Ingresa el nombre del contacto:");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el alias del contacto:");
        String alias = scanner.nextLine();

        System.out.println("Ingresa la dirección del contacto:");
        String direccion = scanner.nextLine();

        System.out.println("Ingresa el teléfono del contacto:");
        String telefono = scanner.nextLine();

        System.out.println("Ingresa el email del contacto:");
        String email = scanner.nextLine();

        return new Contacto(nombre, alias, direccion, telefono, email);
    }

    @Override
    public String toString() {
        return "Contacto [nombre= " + nombre + ", alias= " + alias + ", direccion= " + direccion + ", telefono= " + telefono + ", email= " + email + "]";
    }
}
