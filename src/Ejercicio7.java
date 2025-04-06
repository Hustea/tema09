import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Diccionario con las tasas de cambio respecto al euro
        Map<String, Double> tasasCambio = new HashMap<>();
        tasasCambio.put("USD", 1.08);
        tasasCambio.put("GBP", 0.86);
        tasasCambio.put("INR", 89.64);
        tasasCambio.put("AUD", 1.65);
        tasasCambio.put("CAD", 1.47);
        tasasCambio.put("ARS", 915.00);
        tasasCambio.put("BOB", 7.45);
        tasasCambio.put("CLP", 974.50);
        tasasCambio.put("VEZ", 39.05);
        tasasCambio.put("CRC", 552.13);
        tasasCambio.put("CUP", 25.00);
        tasasCambio.put("DOP", 64.70);
        tasasCambio.put("MXN", 17.95);

        System.out.println("=== CONVERSOR DE MONEDAS ===");

        boolean continuar = true;
        while (continuar) {
            double euros = leerDouble(scanner, "Introduce la cantidad en euros: ");

            // Validar código de moneda
            String codigo = leerCodigoMoneda(scanner, tasasCambio);

            // Calcular y mostrar resultado
            double tasa = tasasCambio.get(codigo);
            double resultado = euros * tasa;
            System.out.printf("%.2f EUR = %.2f %s\n", euros, resultado, codigo);

            // Preguntar si desea continuar
            continuar = leerConfirmacion(scanner, "¿Quieres realizar otra conversión? (s/n): ");
        }

        scanner.close();
        System.out.println("¡Gracias por usar el conversor!");
    }

    // Leer número decimal con validación
    private static double leerDouble(Scanner scanner, String mensaje) {
        double numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = scanner.nextDouble();
                scanner.nextLine(); // limpiar buffer
                if (numero < 0) {
                    System.out.println("Por favor, introduce un número positivo.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debes introducir un número.");
                scanner.nextLine(); // limpiar buffer
            }
        }

        return numero;
    }

    // Leer y validar código de moneda
    private static String leerCodigoMoneda(Scanner scanner, Map<String, Double> tasasCambio) {
        String codigo = "";
        boolean valido = false;

        while (!valido) {
            System.out.print("Introduce el código de la moneda (ej: USD, GBP, MXN...): ");
            codigo = scanner.nextLine().toUpperCase().trim();

            if (tasasCambio.containsKey(codigo)) {
                valido = true;
            } else {
                System.out.println("Código de moneda no válido.");
                System.out.println("Monedas disponibles: " + tasasCambio.keySet());
            }
        }

        return codigo;
    }

    // Leer confirmación s/n con validación
    private static boolean leerConfirmacion(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                return true;
            } else if (respuesta.equals("n")) {
                return false;
            } else {
                System.out.println("Respuesta no válida. Escribe 's' para sí o 'n' para no.");
            }
        }
    }
}