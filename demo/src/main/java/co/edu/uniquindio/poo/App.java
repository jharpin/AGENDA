package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Grupo> grupos = new ArrayList<>();
    private static ArrayList<Reunion> reuniones = new ArrayList<>();
    private static ArrayList<Contacto> contactos = new ArrayList<>();

    public static void main(String[] args) {
        // Crear algunos grupos y reuniones para pruebas
        Grupo grupoAmigos = new Grupo("Amigos", Grupo.Categoria.AMIGOS);
        grupos.add(grupoAmigos);
        
        Reunion reunion = new Reunion("Reunión de proyecto", "2024-09-15", "14:00");
        reuniones.add(reunion);
        
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    eliminarContacto();
                    break;
                case 3:
                    agregarContactoAGrupo(grupoAmigos);
                    break;
                case 4:
                    mostrarGrupo(grupoAmigos);
                    break;
                case 5:
                    agregarContactoAReunion(reunion);
                    break;
                case 6:
                    mostrarReunion(reunion);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    return; // Termina el bucle y sale del programa
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Eliminar contacto");
        System.out.println("3. Agregar contacto a un grupo");
        System.out.println("4. Mostrar contactos del grupo");
        System.out.println("5. Agregar contacto a una reunión");
        System.out.println("6. Mostrar detalles de la reunión");
        System.out.println("0. Salir");
    }

    private static void agregarContacto() {
        Contacto nuevoContacto = Contacto.crearContacto(scanner);
        if (!contactos.contains(nuevoContacto)) {
            contactos.add(nuevoContacto);
            System.out.println("Contacto agregado: " + nuevoContacto);
        } else {
            System.out.println("El contacto ya existe.");
        }
    }

    private static void eliminarContacto() {
        System.out.println("Ingrese el nombre del contacto a eliminar:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el teléfono del contacto a eliminar:");
        String telefono = scanner.nextLine();
        
        Contacto contactoAEliminar = new Contacto(nombre, "", "", telefono, "");
        if (contactos.remove(contactoAEliminar)) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static void agregarContactoAGrupo(Grupo grupo) {
        System.out.println("Ingrese el nombre del contacto a agregar al grupo:");
        String nombre = scanner.nextLine();
        
        Contacto contacto = buscarContacto(nombre);
        
        if (contacto != null && grupo.agregarContacto(contacto)) {
            System.out.println("Contacto agregado al grupo.");
        } else {
            System.out.println("No se pudo agregar el contacto al grupo.");
        }
    }

    private static void mostrarGrupo(Grupo grupo) {
        System.out.println("Información del grupo:");
        System.out.println(grupo);
    }

    private static void agregarContactoAReunion(Reunion reunion) {
        System.out.println("Ingrese el nombre del contacto a agregar a la reunión:");
        String nombre = scanner.nextLine();
        
        Contacto contacto = buscarContacto(nombre);
        
        if (contacto != null && reunion.agregarAsistente(contacto)) {
            System.out.println("Contacto agregado a la reunión.");
        } else {
            System.out.println("No se pudo agregar el contacto a la reunión.");
        }
    }

    private static void mostrarReunion(Reunion reunion) {
        System.out.println("Información de la reunión:");
        System.out.println(reunion);
    }

    private static Contacto buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        System.out.println("Contacto no encontrado.");
        return null;
    }
}
