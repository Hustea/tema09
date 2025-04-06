import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> diccionario = new HashMap<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEnteroConValidacion(scanner, "Elige una opción: ");

            switch (opcion) {
                case 1:
                    añadirPalabra(scanner, diccionario);
                    break;
                case 2:
                    modificarPalabra(scanner, diccionario);
                    break;
                case 3:
                    eliminarPalabra(scanner, diccionario);
                    break;
                case 4:
                    consultarPalabra(scanner, diccionario);
                    break;
                case 5:
                    mostrarDiccionario(diccionario);
                    break;
                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Método para mostrar el menú principal
    private static void mostrarMenu() {
        System.out.println("***********************");
        System.out.println("* GESTIÓN DICCIONARIO *");
        System.out.println("***********************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Modificar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Consultar palabra");
        System.out.println("5. Mostrar diccionario");
        System.out.println("---------------------");
        System.out.println("0. Salir");
    }

    // Leer opción numérica con validación
    private static int leerEnteroConValidacion(Scanner scanner, String mensaje) {
        int numero = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Introduce un número.");
                scanner.nextLine(); // limpiar buffer
            }
        }

        return numero;
    }

    // Añadir nueva palabra al diccionario
    private static void añadirPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Error: la palabra ya existe en el diccionario.");
        } else {
            System.out.print("Introduce su definición: ");
            String definicion = scanner.nextLine().trim();
            diccionario.put(palabra, definicion);
            System.out.println("Palabra añadida correctamente.");
        }
    }

    // Modificar definición de una palabra
    private static void modificarPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra a modificar: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Definición actual: " + diccionario.get(palabra));
            System.out.print("Introduce la nueva definición: ");
            String nuevaDefinicion = scanner.nextLine().trim();
            diccionario.put(palabra, nuevaDefinicion);
            System.out.println("Palabra modificada correctamente.");
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }

    // Eliminar palabra del diccionario
    private static void eliminarPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra a eliminar: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            diccionario.remove(palabra);
            System.out.println("Palabra eliminada correctamente.");
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }

    // Consultar definición de una palabra
    private static void consultarPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra a consultar: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Definición: " + diccionario.get(palabra));
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }

    // Mostrar todas las palabras del diccionario
    private static void mostrarDiccionario(Map<String, String> diccionario) {
        if (diccionario.isEmpty()) {
            System.out.println("El diccionario está vacío.");
        } else {
            System.out.println("=== CONTENIDO DEL DICCIONARIO ===");
            for (Map.Entry<String, String> entrada : diccionario.entrySet()) {
                System.out.println("- " + entrada.getKey() + ": " + entrada.getValue());
            }
        }
    }
}
