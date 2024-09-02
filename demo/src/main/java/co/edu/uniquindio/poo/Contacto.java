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
    private ArrayList<Grupo> grupos; // Lista de grupos a los que pertenece el contacto fray

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    // Método para agregar un grupo al contacto
    public void agregarGrupo(Grupo grupo) {
        if (!grupos.contains(grupo)) {
            grupos.add(grupo);
        }
    }

    // Sobreescribir equals y hashCode para la igualdad por nombre y teléfono
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto contacto = (Contacto) obj;
        return nombre.equals(contacto.nombre) && telefono.equals(contacto.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono);
    }

    public static Contacto crearContacto(Scanner scanner) {
        System.out.println("Ingresa el nombre del contacto:");
        String nombre = scanner.nextLine().trim();
    
        System.out.println("Ingresa el alias del contacto:");
        String alias = scanner.nextLine().trim();
    
        System.out.println("Ingresa la dirección del contacto:");
        String direccion = scanner.nextLine().trim();
    
        System.out.println("Ingresa el teléfono del contacto:");
        String telefono = scanner.nextLine().trim();
        if (telefono.isEmpty()) {
            System.out.println("El teléfono no puede estar vacío.");
            return null;
        }
    
        System.out.println("Ingresa el email del contacto:");
        String email = scanner.nextLine().trim();
        if (!email.contains("@")) {
            System.out.println("Email inválido.");
            return null;
        }
    
        return new Contacto(nombre, alias, direccion, telefono, email);
    }

    @Override
    public String toString() {
        return "Contacto [nombre= " + nombre + ", alias= " + alias + ", direccion= " + direccion + ", telefono= " + telefono + ", email= " + email + "]";
    }
}
