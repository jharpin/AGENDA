package co.edu.uniquindio.poo;

public class Contacto {
    String nombre;
    String alias;
    String direccion;
    String telefono;
    String email;
    public Contacto(String nombre,String alias,String direccion,String telefono,String email){
        this.nombre=nombre;
        this.alias=alias;
        this.direccion=direccion;
        this.telefono=telefono;
        this.email=email;
    }

    public String getnombre(){
        return nombre;
    }
    public void setnombre(String nombre){
        this.nombre=nombre;
    }

    public String getalias(){
        return alias;
    }
    public void setalias(String alias){
        this.alias=alias;
    }

    public String getdireccion(){
        return direccion;
    }
    public void setdireccion(String direccion){
        this.direccion=direccion;
    }


    public String gettelefono(){
        return telefono;
    }
    public void settelefono(String telefono){
        this.telefono=telefono;
    }

    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email=email;
    }

    public String Contactorepetido(String nombre,String telefono){
        if(this.nombre.equals(nombre)&& this.telefono.equals(telefono)){
            return "el contacto ya existe";
        }else{
            return "contacto valido";
        }
    }

    @Override
    public String toString(){
        return "contacto[nombre= "+ nombre + ", alias= " + alias + ", direccion= "+ direccion +", telefono=" + telefono + ", email= "+ email +"]";
    }
    
}
