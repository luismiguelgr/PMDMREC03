package sqlite;

public class Usuario {

    int id;
    String usuario;
    String contrasena;

    public Usuario(int id,String usuario,String contrasena){
        this.id=id;
        this.usuario=usuario;
        this.contrasena=contrasena;
    }

    @Override
    public String toString() {
        return this.usuario;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}