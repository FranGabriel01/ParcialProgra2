package espacio;

public abstract class Nave implements Comparable<Nave> {
    protected String nombre;
    protected int capacidadTripulacion;
    protected int anioLanzamiento;

    public Nave(String nombre, int capacidadTripulacion, int anioLanzamiento) {
        this.nombre = nombre;
        this.capacidadTripulacion = capacidadTripulacion;
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadTripulacion() {
        return capacidadTripulacion;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public abstract void mostrarDatos();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Nave) {
            Nave otra = (Nave) obj;
            return this.nombre.equalsIgnoreCase(otra.nombre)
                && this.anioLanzamiento == otra.anioLanzamiento;
        }
        return false;
    }

    @Override
    public int compareTo(Nave otra) {
        if (this.anioLanzamiento != otra.anioLanzamiento) {
            return Integer.compare(otra.anioLanzamiento, this.anioLanzamiento);
        } else {
            return Integer.compare(otra.capacidadTripulacion, this.capacidadTripulacion);
        }
    }
}























