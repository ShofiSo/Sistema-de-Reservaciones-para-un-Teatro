import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
class GestorBoletos {
    private List<Reservacion> reservaciones;

    public GestorBoletos() {
        reservaciones = new ArrayList<>();
    }

    public void registrarReservacion(String nombre, int numeroAsiento) {
        if (!estaOcupado(numeroAsiento)) {
            reservaciones.add(new Reservacion(nombre, numeroAsiento));
            System.out.println("Reservación registrada: " + nombre + " en asiento " + numeroAsiento);
        } else {
            System.out.println("El asiento " + numeroAsiento + " ya está ocupado.");
        }
    }
    public void cancelarReservacion(int numeroAsiento) {
        for (int i = 0; i < reservaciones.size(); i++) {
            if (reservaciones.get(i).numeroAsiento == numeroAsiento) {
                reservaciones.remove(i);
                System.out.println("Reservación cancelada para el asiento " + numeroAsiento);
                return;
            }
        }
        System.out.println("No se encontró la reservación para el asiento " + numeroAsiento);
    }

    public boolean estaOcupado(int numeroAsiento) {
        for (Reservacion r : reservaciones) {
            if (r.numeroAsiento == numeroAsiento) {
                return true;
            }
        }
        return false;
    }
}