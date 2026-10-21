# Java Premium — Mini-proyectos de consola

Colección de pequeños programas desarrollados en Java para practicar la resolución de problemas, la programación orientada a objetos y el uso de colecciones.

Cada mini-proyecto es independiente y puede ejecutarse desde la terminal o desde IntelliJ IDEA.

## Mini-proyectos

### 1. Gestor de tareas

**Ubicación:** [`src/gestor_tareas/`](src/gestor_tareas/)

Aplicación de consola para organizar tareas y gestionar sus prioridades.

**Funcionalidades:**

- Registrar tareas mediante un identificador único.
- Asignar prioridades del 1 al 5.
- Consultar todas las tareas registradas.
- Buscar una tarea por su identificador.
- Eliminar tareas.
- Calcular la suma de prioridades de las tareas existentes.

**Implementación**

Las tareas se almacenan en un `HashMap<Integer, Tarea>` para facilitar su búsqueda mediante identificadores.

La estructura de clases utiliza una clase abstracta `Actividad`, de la que hereda `Tarea`, separando las propiedades comunes de su comportamiento específico.

**Ejecutar**

Desde la raíz del repositorio, con JDK 25:

```bash
mkdir -p out
javac -d out src/gestor_tareas/*.java
java -cp out gestor_tareas.GestorTareas
```

### 2. Calculadora de gastos

**Ubicación:** [`src/calculadora_gastos/`](src/calculadora_gastos/)

Programa para registrar movimientos económicos y consultar el balance acumulado.

**Funcionalidades:**

- Registrar ingresos.
- Registrar gastos.
- Consultar ingresos y gastos por separado.
- Buscar gastos por identificador.
- Calcular el balance general.

**Implementación**

Cada operación se representa mediante un objeto `Movimiento`, con importe, descripción y tipo.

El enumerado `TipoMovimiento` distingue entre ingresos y gastos, mientras que un `HashMap<Integer, Movimiento>` almacena los registros.

El balance se actualiza al añadir cada movimiento.

**Ejecutar**

Desde la raíz del repositorio, con JDK 25:

```bash
mkdir -p out
javac -d out src/calculadora_gastos/*.java
java -cp out calculadora_gastos.CalculadoraGastos
```

## Tecnologías y conceptos

- Java 25.
- Aplicaciones de consola.
- Colecciones (`HashMap`).
- Clases abstractas y herencia.
- Enumeraciones.
- Manejo de entrada por teclado y excepciones.

## Estructura del repositorio

```text
src/
├── calculadora_gastos/
│   ├── CalculadoraGastos.java
│   ├── Movimiento.java
│   └── TipoMovimiento.java
└── gestor_tareas/
    ├── Actividad.java
    ├── GestorTareas.java
    └── Tarea.java
```

## Notas

Los dos programas almacenan los datos en memoria. Al finalizar su ejecución, los registros no se guardan en archivos ni bases de datos.

Son mini-proyectos independientes, orientados a practicar distintas formas de organizar y manipular información en Java.
