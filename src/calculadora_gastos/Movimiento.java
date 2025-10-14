package calculadora_gastos;

public class Movimiento {
    String nombre;
    float precio;
    TipoMovimiento tipo;

    Movimiento(String nombre, float precio, TipoMovimiento tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String toString() {
        return String.format("Nombre: %s - Cantidad: %.2f€", nombre, precio);
    }

}
