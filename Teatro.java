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
    public void mostrarReservaciones() {
        if (reservaciones.isEmpty()) {
            System.out.println("No hay reservaciones.");
        } else {
            System.out.println("Lista de reservaciones:");
            for (Reservacion r : reservaciones) {
                System.out.println(r);
            }
        }
    }
}

public class Teatro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorBoletos gestor = new GestorBoletos();
        
        while (true) {
            System.out.println("---Menú de opciones---");
            System.out.println("1. Registrar reservación");
            System.out.println("2. Cancelar reservación");
            System.out.println("3. Verificar si un asiento está ocupado");
            System.out.println("4. Mostrar reservaciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el número de asiento: ");
                    int asiento = scanner.nextInt();
                    gestor.registrarReservacion(nombre, asiento);
                    break;
                case 2:
                    System.out.print("Ingrese el número de asiento a cancelar: ");
                    int asientoCancelar = scanner.nextInt();
                    gestor.cancelarReservacion(asientoCancelar);
                    break;
                case 3:
                    System.out.print("Ingrese el número de asiento a verificar: ");
                    int asientoVerificar = scanner.nextInt();
                    if (gestor.estaOcupado(asientoVerificar)) {
                        System.out.println("El asiento " + asientoVerificar + " está ocupado.");
                    } else {
                        System.out.println("El asiento " + asientoVerificar + " está disponible.");
                    }
                    break;
                case 4:
                    gestor.mostrarReservaciones();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
