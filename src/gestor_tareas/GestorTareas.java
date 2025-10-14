package gestor_tareas;

import java.util.*;

public class GestorTareas {

    // Como las variables ya son de acceso global para la clase no se necesitan métodos que las usen como argumento

    private static final Scanner sc = new Scanner(System.in);
    // private static final List<Tarea> listaTareas = new ArrayList<>(); // No se usa
    private static final Map<Integer, Tarea> mapTareas = new HashMap<>();
    private static int totalPrioridad = 0;
    private static int opcion;

    static void main() {
        do {
            System.out.print(mostrarMenu());
            opcion = Integer.parseInt(sc.nextLine());
            ejecutarOpcion();
        } while (opcion != 6);

        sc.close();
    }

    public static String mostrarMenu() {
        return """
                == GESTOR DE TAREAS ==
                1. Agregar tarea
                2. Ver tareas
                3. Buscar tarea por ID
                4. Eliminar tareas por ID
                5. Ver total prioridades
                6. Salir
                Introduce una opción:\s""";
    }

    public static void ejecutarOpcion() {
        switch (opcion) {
            case 1 -> agregarTarea();
            case 2 -> verTareas();
            case 3 -> buscarTarea();
            case 4 ->  eliminarTarea();
            case 5 -> System.out.println("La prioridad total acumulada es de: " + totalPrioridad);
            case 6 -> System.out.println("Saliendo del gestor de tareas...");
            default -> System.out.println("Opción inválida.");
        }
    }

    public static void agregarTarea() {

        int idTarea;
        do {
            System.out.print("Introduce el ID de la tarea: ");
            idTarea = Integer.parseInt(sc.nextLine());
            if (mapTareas.containsKey(idTarea)) System.out.println("La tarea ya existe.");
        } while(mapTareas.containsKey(idTarea));

        System.out.print("Introduce nombre de la tarea: ");
        String nombreTarea = sc.nextLine();

        int prioridad;
        do {
            System.out.print("Prioridad (1-5): ");
            prioridad = Integer.parseInt(sc.nextLine());
            if (prioridad < 1 || prioridad > 5) System.out.println("Prioridad inválida.");
        } while (prioridad < 1 || prioridad > 5);

        Tarea tarea = new Tarea(nombreTarea, prioridad);
        // listaTareas.add(tarea);
        mapTareas.put(idTarea, tarea);
        totalPrioridad += prioridad;

        System.out.println("Nueva tarea agregada: " + nombreTarea + " (prioridad: " + prioridad + ")");
        System.out.println("Suma total de prioridades: " + totalPrioridad);
    }

    public static void verTareas() {

//        if (!listaTareas.isEmpty()) {
//            listaTareas.forEach(Tarea::ejecutar); // Lambda can be replaced with method reference (igual que php)
//        } else {
//            System.out.println("No hay tareas.");
//        }

        if (!mapTareas.isEmpty()) {
            mapTareas.forEach( (id, tarea) -> { // con esta lambda me ahorro el entrySet()
                System.out.print(id + ") ");
                tarea.ejecutar();
            } );
        }
        else System.out.println("No hay tareas.");
    }

    public static void buscarTarea() {
        System.out.print("Introduce el id de la tarea: ");
        int key = Integer.parseInt(sc.nextLine());
        if (mapTareas.containsKey(key)) {
            Tarea t = mapTareas.get(key); // Tatiana usa nombres + descriptivo Tarea encontrada, Tarea nueva, Tarea eliminada, etc.
            t.ejecutar();
        }
        else System.out.println("La tarea no está registrada.");
    }

    public static void eliminarTarea() {
        System.out.print("Introduce el id de la tarea: ");
        int key = Integer.parseInt(sc.nextLine());
        if (mapTareas.containsKey(key)) {
            Tarea t = mapTareas.get(key);
            totalPrioridad -= t.getPrioridad();
            mapTareas.remove(key);
            System.out.println("Tarea eliminada correctamente.");
            System.out.println("La prioridad total es de: " + totalPrioridad);
        }
        else System.out.println("La tarea no existe.");

    }
}
