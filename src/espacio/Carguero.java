package espacio;

public class Carguero extends Nave {
    private int capacidadCarga;

    public Carguero(String nombre, int capacidadTripulacion, int anioLanzamiento, int capacidadCarga) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.capacidadCarga = Math.max(100, Math.min(5000, capacidadCarga));
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Carguero: " + nombre + " | Tripulacion: " + capacidadTripulacion +
                " | Anio: " + anioLanzamiento + " | Carga: " + capacidadCarga + " toneladas");
    }

    public void iniciarExploracion() {
        System.out.println(nombre + " está iniciando mision de transporte de suministros.");
    }
}