import java.util.Scanner;

public class GestorTareas {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int totalPrioridad = 0;

        do {
            System.out.print(mostrarMenu());
            opcion = leerOpcion(sc);
            totalPrioridad = ejecutarOpcion(opcion, sc, totalPrioridad);
        } while(opcion != 3);

        sc.close();
    }

    public static String mostrarMenu() {
        return """
                == GESTOR DE TAREAS ==
                1. Agregar tarea
                2. Ver tareas
                3. Salir
                Introduce una opción:\s""";
    }

    public static int leerOpcion(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }

    public static int ejecutarOpcion(int opcion, Scanner sc, int totalPrioridad) {
        switch (opcion) {
            case 1 -> totalPrioridad = agregarTarea(sc, totalPrioridad);
            case 2 -> System.out.println("Ver tareas.");
            case 3 -> System.out.println("Saliendo del gestor de tareas...");
            default -> System.out.println("Opción inválida.");
        }
        return totalPrioridad;
    }
    public static int agregarTarea(Scanner sc, int totalPrioridad) {
        System.out.print("Introduce nombre de la tarea: ");
        String nombreTarea = sc.nextLine();

        int prioridad;
        do {
            System.out.print("Prioridad (1-5): ");
            prioridad = Integer.parseInt(sc.nextLine());
            if (prioridad < 1 || prioridad > 5) System.out.println("Prioridad inválida.");
        } while (prioridad < 1 || prioridad > 5);

        totalPrioridad += prioridad;

        System.out.println("Tarea agredada: " + nombreTarea + " (prioridad: " + prioridad + ")");
        System.out.println("Suma total de prioridades: " + totalPrioridad);
        return totalPrioridad;
    }
}
