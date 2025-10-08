import java.util.Scanner;

public class GestorTareas {
    public static void main() {

        Scanner sc = new Scanner(System.in);
        int opcion;
        int totalPrioridad = 0;
        Actividad ultimaTarea = null;

        do {
            System.out.print(mostrarMenu());
            opcion = leerOpcion(sc);
            Resultado resultado = ejecutarOpcion(opcion, sc, totalPrioridad, ultimaTarea);
            totalPrioridad = resultado.totalPrioridad;
            ultimaTarea = resultado.tarea;
        } while(opcion != 3);

        sc.close();
    }

    public static String mostrarMenu() {
        return """
                == GESTOR DE TAREAS ==
                1. Agregar tarea
                2. Ver última tarea
                3. Salir
                Introduce una opción:\s""";
    }

    public static int leerOpcion(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }

    public static Resultado ejecutarOpcion(int opcion, Scanner sc, int totalPrioridad, Actividad tarea) {
        switch (opcion) {
            case 1:
                return agregarTarea(sc, totalPrioridad);
            case 2:
                if (tarea != null) {
                    tarea.ejecutar();
                } else {
                    System.out.println("No hay tareas.");
                }
                break;
            case 3:
                System.out.println("Saliendo del gestor de tareas...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
        return new Resultado(tarea, totalPrioridad);
    }
    public static Resultado agregarTarea(Scanner sc, int totalPrioridad) {
        System.out.print("Introduce nombre de la tarea: ");
        String nombreTarea = sc.nextLine();

        int prioridad;
        do {
            System.out.print("Prioridad (1-5): ");
            prioridad = Integer.parseInt(sc.nextLine());
            if (prioridad < 1 || prioridad > 5) System.out.println("Prioridad inválida.");
        } while (prioridad < 1 || prioridad > 5);

        Tarea tarea = new Tarea(nombreTarea, prioridad);

        totalPrioridad += prioridad;

        System.out.println("Tarea agregada: " + nombreTarea + " (prioridad: " + prioridad + ")");
        System.out.println("Suma total de prioridades: " + totalPrioridad);

        return new Resultado(tarea, totalPrioridad);
    }

    public static class Resultado {
        private Actividad tarea;
        private int totalPrioridad;

        public Resultado(Actividad tarea, int totalPrioridad) {
            this.tarea=tarea;
            this.totalPrioridad = totalPrioridad;
        }
    }
}
