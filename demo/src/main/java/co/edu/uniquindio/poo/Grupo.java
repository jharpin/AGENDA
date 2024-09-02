package co.edu.uniquindio.poo;

import java.util.ArrayList;

public class Grupo {
    private String nombre;
    private Categoria categoria;
    private ArrayList<Contacto> contactos;

    public enum Categoria {
        OFICINA, FIESTA, AMIGOS, FAMILIA
    }

    // Constructor
    public Grupo(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.contactos = new ArrayList<>();
    }

    // Getters y Setters
    // (Métodos omitidos por brevedad)

    // Método para agregar un contacto al grupo
    public boolean agregarContacto(Contacto contacto) {
        if (contactos.size() < 5 && !contactos.contains(contacto)) {
            contactos.add(contacto);
            contacto.agregarGrupo(this); // Agregar grupo al contacto
            return true;
        } else {
            System.out.println("No se puede agregar el contacto al grupo.");
            return false;
        }
    }

    // Método para eliminar un contacto del grupo
    public boolean eliminarContacto(Contacto contacto) {
        if (contactos.contains(contacto)) {
            contactos.remove(contacto);
            return true;
        } else {
            System.out.println("El contacto no está en el grupo.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Grupo [nombre= " + nombre + ", categoria= " + categoria + ", contactos= " + contactos + "]";
    }
}
