package calculadora_gastos;
import java.util.*;

public class CalculadoraGastos {
    static Scanner sc = new Scanner(System.in);
    static int opcion;
    static Map<Integer, Movimiento> mapMovimientos = new HashMap<>();
    static float dineroTotal = 0;
    static int siguienteId = 1;

    static void main() {
        do {
            System.out.print(mostrarMenu());
            try {
                opcion = Integer.parseInt(sc.nextLine());
                ejecutarOpcion();
            } catch (NumberFormatException e) {
                System.out.println("Error. Introduce un número.");
            }
        } while(opcion != 7);
    }

    static String mostrarMenu() {
        return """
        --- MENU ---
        1. Registrar ingreso
        2. Registrar gasto
        3. Ver ingresos
        4. Ver gastos
        5. Buscar un gasto
        6. Balance general
        7. Salir
        Opción:\s""";
    }

    static void ejecutarOpcion() {
        switch (opcion) {
            case 1 -> registrarIngreso();
            case 2 -> registrarGasto();
            case 3 -> verIngresos();
            case 4 -> verGastos();
            case 5 -> buscarGasto();
            case 6 -> balanceGeneral();
            case 7 -> System.out.println("Finalizando programa...");
            default -> System.out.println("Opción no válida.");
        }
    }

    static void registrarIngreso() {
        System.out.print("Introduce el nombre del ingreso: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el importe del ingreso (€): ");
        float precio = Float.parseFloat(sc.nextLine());
        Movimiento nuevoIngreso = new Movimiento(nombre, precio, TipoMovimiento.INGRESO);
        mapMovimientos.put(siguienteId++, nuevoIngreso);
        dineroTotal += nuevoIngreso.precio;
    }

    static void registrarGasto() {
        System.out.print("Introduce el nombre del gasto: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el importe del ingreso (€): ");
        float precio = Float.parseFloat(sc.nextLine());
        Movimiento nuevoGasto = new Movimiento(nombre, precio, TipoMovimiento.GASTO);
        mapMovimientos.put(siguienteId++, nuevoGasto);
        dineroTotal -= nuevoGasto.precio;
    }

    static void verIngresos() {
        mapMovimientos.forEach((Integer id, Movimiento mov) -> {
            if (mov.tipo == TipoMovimiento.INGRESO) {
                System.out.printf("%d - %s.%n", id, mov);
            }
        });
    }

    static void verGastos() {
        mapMovimientos.forEach((Integer id, Movimiento mov) -> {
            if (mov.tipo == TipoMovimiento.GASTO) {
                System.out.printf("%d - %s.%n", id, mov);
            }
        });
    }

    static void buscarGasto() {
        System.out.print("Introduce el ID del gasto que quieras buscar: ");
        int idGasto = Integer.parseInt(sc.nextLine());
        if (!mapMovimientos.isEmpty() && mapMovimientos.containsKey(idGasto) && mapMovimientos.get(idGasto).tipo==TipoMovimiento.GASTO) {
            System.out.println(mapMovimientos.get(idGasto));
        }
        else System.out.println("El gasto no existe.");
    }

    static void balanceGeneral() {
        System.out.printf("Total de dinero en la cuenta: %.2f€.%n", dineroTotal);
    }
}
