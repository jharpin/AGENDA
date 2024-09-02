package co.edu.uniquindio.poo;

import java.util.ArrayList;

public class Reunion {
    private String descripcion;
    private String fecha; 
    private String hora;
    private ArrayList<Contacto> asistentes;

    public Reunion(String descripcion, String fecha, String hora) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.asistentes = new ArrayList<>();
    }

 
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ArrayList<Contacto> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(ArrayList<Contacto> asistentes) {
        this.asistentes = asistentes;
    }


    public boolean agregarAsistente(Contacto contacto) {
        if (!asistentes.contains(contacto)) {
            asistentes.add(contacto);
            return true;
        } else {
            System.out.println("El contacto ya está en la reunión.");
            return false;
        }
    }

 
    public boolean eliminarAsistente(Contacto contacto) {
        if (asistentes.contains(contacto)) {
            asistentes.remove(contacto);
            return true;
        } else {
            System.out.println("El contacto no está en la reunión.");
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reunion [descripcion= ").append(descripcion)
          .append(", fecha= ").append(fecha)
          .append(", hora= ").append(hora)
          .append(", asistentes= [");

        for (Contacto contacto : asistentes) {
            sb.append("\n\t").append(contacto.toString());
        }
        sb.append("\n]]");
        return sb.toString();
    }
}
