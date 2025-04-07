import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> diccionario = new HashMap<>();
        int opcion;

        do {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("==============");
            System.out.println("1. Introducir parejas de palabras.");
            System.out.println("2. Traducir palabras.");
            System.out.println("0. Salir de la aplicación.");

            opcion = leerEnteroConValidación(scanner, "Elige una opción: ");

            switch (opcion) {
                case 1:
                    int cantidad = leerEnteroConValidación(scanner, "¿Cuántas parejas deseas introducir? ");

                    for (int i = 0; i < cantidad; i++) {
                        System.out.print("Introduce palabra en inglés: ");
                        String ingles = scanner.nextLine().toLowerCase();

                        System.out.print("Introduce traducción al valenciano: ");
                        String valenciano = scanner.nextLine();

                        diccionario.put(ingles, valenciano);
                    }
                    break;

                case 2:
                    System.out.print("Palabra a buscar: ");
                    String buscar = scanner.nextLine().toLowerCase();

                    if (diccionario.containsKey(buscar)) {
                        System.out.println(diccionario.get(buscar));
                    } else {
                        System.out.println("La palabra no existe.");
                    }
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

    /**
     * Metodo para leer enteros acon validacion
     * @param scanner
     * @param mensaje
     * @return numero validado
     */
    private static int leerEnteroConValidación(Scanner scanner, String mensaje) {
        int numero = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = scanner.nextInt();
                scanner.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Por favor, introduce un número.");
                scanner.nextLine();
            }
        }

        return numero;
    }
}