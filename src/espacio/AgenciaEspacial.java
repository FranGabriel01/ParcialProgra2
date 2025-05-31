package espacio;

import java.util.*;

public class AgenciaEspacial {

    private final List<Nave> listaNaves = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AgenciaEspacial app = new AgenciaEspacial();
        app.menu();
    }

    public void menu() {
        int opcion;

        do {
            System.out.println("\n=== Menu de Gestipn de Expediciones ===");
            System.out.println("1. Agregar nave");
            System.out.println("2. Mostrar todas las naves");
            System.out.println("3. Iniciar misión de exploracioan");
            System.out.println("4. Mostrar naves ordenadas por nombre");
            System.out.println("5. Mostrar naves ordenadas por anio de lanzamiento");
            System.out.println("6. Mostrar naves ordenadas por capacidad de tripulacin");
            System.out.println("7. Salir");

            System.out.print("Elija una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> agregarNave();
                case 2 -> mostrarNaves();
                case 3 -> iniciarExploracion();
                case 4 -> ordenarPorNombre();
//                case 5 -> ordenarPorAnio();
//                case 6 -> ordenarPorTripulacion();
                case 7 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 7);
    }

    private void agregarNave() {
        System.out.println("Tipo de nave: 1=Exploracion, 2=Carguero, 3=crucero Estelar");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        if (nombre.isBlank()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Capacidad de tripulacinn: ");
        int tripulacion = Integer.parseInt(scanner.nextLine());

        System.out.print("Año de lanzamiento: ");
        int anio = Integer.parseInt(scanner.nextLine());
        if (anio <= 0) {
            System.out.println("El año debe ser positivo.");
            return;
        }

        Nave naveTemporal = new Carguero(nombre, tripulacion, anio, 100);
        if (listaNaves.contains(naveTemporal)) {
            System.out.println("️ Ya existe una nave con ese nombre y año de lanzamiento.");
            return;
        }

        switch (tipo) {
            case 1 -> {
                System.out.print("Tipo de misión (carrtografica, Investigacion, contacto): ");
                String mision = scanner.nextLine().toUpperCase();
                listaNaves.add(new NaveExploracion(nombre, tripulacion, anio, mision));
            }
            case 2 -> {
                System.out.print("Capacidad de carga (100-500): ");
                int carga = Integer.parseInt(scanner.nextLine());
                listaNaves.add(new Carguero(nombre, tripulacion, anio, carga));
            }
            case 3 -> {
                System.out.print("Cantidad de pasajeros: ");
                int pasajeros = Integer.parseInt(scanner.nextLine());
                listaNaves.add(new CruceroEstelar(nombre, tripulacion, anio, pasajeros));
            }
            default -> System.out.println("Tipo inválido.");
        }
    }

    private void mostrarNaves() {
        if (listaNaves.isEmpty()) {
            System.out.println("No hay naves registradas.");
            return;
        }
        for (Nave nave : listaNaves) {
            nave.mostrarDatos();
        }
    }

    private void iniciarExploracion() {
        for (Nave nave : listaNaves) {
            if (nave instanceof NaveExploracion exploradora) {
                exploradora.iniciarExploracion();
            } else if (nave instanceof Carguero carguero) {
                carguero.iniciarExploracion();
            } else {
                System.out.println(nave.getNombre() + " no puede participar en misiones de exploración.");
            }
        }
    }

   private void ordenarPorNombre() {
       List<Nave> copia = new ArrayList<>(listaNaves);
      copia.sort(Comparator.comparing(Nave::getNombre));
       copia.forEach(Nave::mostrarDatos);   
   }
   
   private void ordenarPorAnio() {
       List<Nave> copia = new ArrayList<>(listaNaves);
      copia.sort((a, b) -> Integer.compare(b.getAnioLanzamiento(), a.getAnioLanzamiento()));
       copia.forEach(Nave::mostrarDatos);
   }

   private void ordenarPorTripulacion() {
       List<Nave> copia = new ArrayList<>(listaNaves);
       copia.sort((a, b) -> Integer.compare(b.getCapacidadTripulacion(), a.getCapacidadTripulacion()));
       copia.forEach(Nave::mostrarDatos);
    } 
}