package espacio;

public class CruceroEstelar extends Nave {
    private int cantidadPasajeros;

    public CruceroEstelar(String nombre, int capacidadTripulacion, int anioLanzamiento, int cantidadPasajeros) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public void mostrarDatos() {
        System.out.println(" Crucero Estelar: " + nombre + " | Tripulación: " + capacidadTripulacion +
                " | Año: " + anioLanzamiento + " | Pasajeros: " + cantidadPasajeros);
    }

    public void iniciarExploracion() {
        System.out.println(nombre + " no participa en misiones de exploración.");
    }
}