package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest {

    // Test para verificar que dos contactos con el mismo nombre y teléfono son considerados iguales
    @Test
    public void testContactosIguales() {
        Contacto contacto1 = new Contacto("Juan Pérez", "JP", "Calle 123", "555-1234", "juan@example.com");
        Contacto contacto2 = new Contacto("Juan Pérez", "JP", "Calle 123", "555-1234", "juan@example.com");
        
        assertEquals(contacto1, contacto2, "Los contactos con el mismo nombre y teléfono deberían ser iguales.");
    }

    // Test para verificar que dos contactos con diferentes atributos no son iguales
    @Test
    public void testContactosNoIguales() {
        Contacto contacto1 = new Contacto("Juan Pérez", "JP", "Calle 123", "555-1234", "juan@example.com");
        Contacto contacto2 = new Contacto("Ana Gómez", "AG", "Calle 456", "555-5678", "ana@example.com");
        
        assertNotEquals(contacto1, contacto2, "Los contactos con diferentes nombres o teléfonos no deberían ser iguales.");
    }

    // Test para verificar que no se pueden agregar más de 5 contactos a un grupo
    @Test
    public void testAgregarMasDeCincoContactos() {
        Grupo grupo = new Grupo("Amigos", Grupo.Categoria.AMIGOS);
        for (int i = 0; i < 6; i++) {
            Contacto contacto = new Contacto("Contacto " + i, "", "", "555-000" + i, "");
            grupo.agregarContacto(contacto);
        }

        assertEquals(5, grupo.getContactos().size(), "El grupo no debería permitir más de 5 contactos.");
    }

    // Test para agregar y eliminar asistentes en una reunión
    @Test
    public void testAgregarYEliminarAsistentes() {
        Reunion reunion = new Reunion("Reunión de prueba", "2024-09-15", "10:00");
        Contacto contacto = new Contacto("Juan Pérez", "JP", "Calle 123", "555-1234", "juan@example.com");

        assertTrue(reunion.agregarAsistente(contacto), "Debería permitir agregar el contacto a la reunión.");
        assertTrue(reunion.getAsistentes().contains(contacto), "El contacto debería estar en la lista de asistentes.");

        assertTrue(reunion.eliminarAsistente(contacto), "Debería permitir eliminar el contacto de la reunión.");
        assertFalse(reunion.getAsistentes().contains(contacto), "El contacto no debería estar en la lista de asistentes.");
    }
}