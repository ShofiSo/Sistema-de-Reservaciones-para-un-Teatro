import java.util.ArrayList;
//import java.util.List;
class Reservacion {
    String nombre;
    int numeroAsiento;

    public Reservacion(String nombre, int numeroAsiento) {
        this.nombre = nombre;
        this.numeroAsiento = numeroAsiento;
    }

    public String toString() {
        return "Cliente: " + nombre + ", Asiento: " + numeroAsiento;
    }
}
