package espacio;

public class NaveExploracion extends Nave {
    private String tipoMision;

    public NaveExploracion(String nombre, int capacidadTripulacion, int anioLanzamiento, String tipoMision) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.tipoMision = tipoMision;
    }

    @Override
    public void mostrarDatos() {
        System.out.println(" Exploradora: " + nombre + " | Tripulación: " + capacidadTripulacion +
                " | Año: " + anioLanzamiento + " | Misión: " + tipoMision);
    }

    public void iniciarExploracion() {
        System.out.println(nombre + " está iniciando la misión de " + tipoMision + ".");
    }
}