package sqlite;

public class Provincia {

    int id;
    String nombre;
    String fase;

    public Provincia(String nombre,String fase){
        this.nombre=nombre;
        this.fase=fase;
    }

    @Override
    public String toString() {
        return "Provincia:" + this.nombre + " - Fase:" + this.fase;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFase() {
        return this.fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }
}
