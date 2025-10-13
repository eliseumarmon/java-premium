package javaprofesional;

public class Tarea extends Actividad {
    private final int prioridad;

    public Tarea(String nombre, int prioridad) {
        super(nombre);
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void ejecutar() {
        System.out.println(getNombre() + ". Prioridad: " + prioridad + ".");
    }
}
