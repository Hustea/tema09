package Ejercicio10;

import java.time.LocalDate;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        int opcion;
        do {
            System.out.println("\n*********************");
            System.out.println("* GESTIÓN EMPLEADOS *");
            System.out.println("*********************");
            System.out.println("1. Nuevo empleado");
            System.out.println("2. Nuevo hijo");
            System.out.println("3. Modificar sueldo");
            System.out.println("4. Borrar empleado");
            System.out.println("5. Borrar hijo");
            System.out.println("6. Consultas");
            System.out.println("0. Salir");
            opcion = Validaciones.leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> {
                    String nif = Validaciones.leerTexto("NIF: ");
                    String nombre = Validaciones.leerTexto("Nombre: ");
                    String apellidos = Validaciones.leerTexto("Apellidos: ");
                    LocalDate fecha = Validaciones.leerFecha("Fecha de nacimiento");
                    double sueldo = Validaciones.leerDouble("Sueldo: ");
                    Empleado emp = new Empleado(nif, nombre, apellidos, fecha, sueldo);
                    empresa.anadirEmpleado(emp);
                }
                case 2 -> {
                    String nif = Validaciones.leerTexto("NIF del empleado: ");
                    String nombre = Validaciones.leerTexto("Nombre del hijo: ");
                    String apellidos = Validaciones.leerTexto("Apellidos del hijo: ");
                    LocalDate fecha = Validaciones.leerFecha("Fecha de nacimiento del hijo");
                    empresa.anadirHijo(nif, new Hijo(nombre, apellidos, fecha));
                }
                case 3 -> {
                    String nif = Validaciones.leerTexto("NIF del empleado: ");
                    double nuevoSueldo = Validaciones.leerDouble("Nuevo sueldo: ");
                    empresa.modificarSueldo(nif, nuevoSueldo);
                }
                case 4 -> empresa.borrarEmpleado(Validaciones.leerTexto("NIF del empleado a borrar: "));
                case 5 -> {
                    String nif = Validaciones.leerTexto("NIF del empleado: ");
                    String nombreHijo = Validaciones.leerTexto("Nombre del hijo a borrar: ");
                    empresa.borrarHijo(nif, nombreHijo);
                }
                case 6 -> mostrarSubmenuConsultas(empresa);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarSubmenuConsultas(Empresa empresa) {
        int opcion;
        do {
            System.out.println("\n***********************");
            System.out.println("* CONSULTAS EMPLEADOS *");
            System.out.println("***********************");
            System.out.println("1. Buscar por NIF");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Buscar por rango de edad");
            System.out.println("4. Buscar por rango de sueldo");
            System.out.println("5. Buscar por hijos menores de edad");
            System.out.println("0. Volver al menú principal");
            opcion = Validaciones.leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> {
                    Empleado e = empresa.buscarPorNif(Validaciones.leerTexto("Introduce el NIF: "));
                    if (e != null) System.out.println(e);
                    else System.out.println("Empleado no encontrado.");
                }
                case 2 -> {
                    List<Empleado> lista = empresa.buscarPorNombre(Validaciones.leerTexto("Nombre o parte del nombre: "));
                    lista.forEach(System.out::println);
                }
                case 3 -> {
                    int min = Validaciones.leerEntero("Edad mínima: ");
                    int max = Validaciones.leerEntero("Edad máxima: ");
                    empresa.buscarPorEdad(min, max).forEach(System.out::println);
                }
                case 4 -> {
                    double min = Validaciones.leerDouble("Sueldo mínimo: ");
                    double max = Validaciones.leerDouble("Sueldo máximo: ");
                    empresa.buscarPorSueldo(min, max).forEach(System.out::println);
                }
                case 5 -> empresa.empleadosConHijosMenores().forEach(System.out::println);
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}