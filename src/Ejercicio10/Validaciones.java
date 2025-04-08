package Ejercicio10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validaciones {
    private static final Scanner scanner = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public static double leerDouble(String mensaje) {
        double valor = -1;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor no válido. Intenta de nuevo.");
            }
        }
        return valor;
    }

    public static int leerEntero(String mensaje) {
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número válido.");
            }
        }
    }

    public static LocalDate leerFecha(String mensaje) {
        LocalDate fecha = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (fecha == null) {
            try {
                System.out.print(mensaje + " (formato yyyy-MM-dd): ");
                fecha = LocalDate.parse(scanner.nextLine(), formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Intenta de nuevo.");
            }
        }
        return fecha;
    }
}