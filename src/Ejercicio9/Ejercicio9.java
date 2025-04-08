package Ejercicio9;

import java.util.*;

public class Ejercicio9 {
    static List<Puntuacion> puntuaciones = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> diccionario = new HashMap<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEnteroConValidacion(scanner, "Elige una opción: ");

            switch (opcion) {
                case 1:
                    anadirPalabra(scanner, diccionario);
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
                case 6:
                    jugar(diccionario, scanner, puntuaciones);
                    break;
                case 7:
                    mostrarMejoresPuntuaciones(puntuaciones);
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

    private static void mostrarMenu() {
        System.out.println("*********************");
        System.out.println("* JUEGO DICCIONARIO *");
        System.out.println("*********************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Modificar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Consultar palabra");
        System.out.println("5. Mostrar diccionario");
        System.out.println("6. Jugar");
        System.out.println("7. Mejores puntuaciones");
        System.out.println("---------------------");
        System.out.println("0. Salir");
    }

    private static int leerEnteroConValidacion(Scanner scanner, String mensaje) {
        int numero = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = scanner.nextInt();
                scanner.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Introduce un número.");
                scanner.nextLine();
            }
        }

        return numero;
    }

    private static void anadirPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (palabra.isEmpty()) {
            System.out.println("Error: la palabra no puede estar vacía.");
            return;
        }

        if (diccionario.containsKey(palabra)) {
            System.out.println("Error: la palabra ya existe en el diccionario.");
        } else {
            System.out.print("Introduce su definición: ");
            String definicion = scanner.nextLine().trim();
            if (definicion.isEmpty()) {
                System.out.println("Error: la definición no puede estar vacía.");
                return;
            }
            diccionario.put(palabra, definicion);
            System.out.println("Palabra añadida correctamente.");
        }
    }

    private static void modificarPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra a modificar: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Definición actual: " + diccionario.get(palabra));
            System.out.print("Introduce la nueva definición: ");
            String nuevaDefinicion = scanner.nextLine().trim();
            if (nuevaDefinicion.isEmpty()) {
                System.out.println("Error: la definición no puede estar vacía.");
                return;
            }
            diccionario.put(palabra, nuevaDefinicion);
            System.out.println("Palabra modificada correctamente.");
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }

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

    private static void consultarPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra a consultar: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Definición: " + diccionario.get(palabra));
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }

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

    private static void jugar(Map<String, String> diccionario, Scanner scanner, List<Puntuacion> puntuaciones) {
        if (diccionario.isEmpty()) {
            System.out.println("El diccionario está vacío. Añade palabras antes de jugar.");

        }else{
            List<Map.Entry<String, String>> lista = new ArrayList<>(diccionario.entrySet());
            Collections.shuffle(lista);

            int puntos = 0;
            for (Map.Entry<String, String> entrada : lista) {
                System.out.println("¿Qué palabra corresponde a esta definición?");
                System.out.println("Definición: " + entrada.getValue());
                System.out.print("Tu respuesta: ");
                String respuesta = scanner.nextLine().trim().toLowerCase();

                if (respuesta.equals(entrada.getKey())) {
                    System.out.println("¡Correcto!");
                    puntos++;
                } else {
                    System.out.println("¡Incorrecto! Era: " + entrada.getKey());
                    break;
                }
            }

            System.out.println("Fin del juego. Tu puntuación: " + puntos);

            if (esMejorPuntuacion(puntos, puntuaciones)) {
                System.out.print("¡Nueva puntuación destacada! Introduce tu nombre: ");
                String nombre = scanner.nextLine().trim();
                puntuaciones.add(new Puntuacion(nombre, puntos));
                ordenarYLimitarPuntuaciones(puntuaciones);
            }
        }
    }

    private static void mostrarMejoresPuntuaciones(List<Puntuacion> puntuaciones) {
        if (puntuaciones.isEmpty()) {
            System.out.println("Aún no hay puntuaciones registradas.");
            return;
        }

        System.out.println("=== MEJORES PUNTUACIONES ===");
        int puesto = 1;
        for (Puntuacion p : puntuaciones) {
            System.out.println(puesto + ". " + p.getNombre() + " - " + p.getPuntos() + " puntos");
            puesto++;
        }
    }

    private static boolean esMejorPuntuacion(int puntos, List<Puntuacion> puntuaciones) {
        if (puntuaciones.size() < 5) return true;

        for (Puntuacion p : puntuaciones) {
            if (puntos > p.getPuntos()) return true;
        }
        return false;
    }

    private static void ordenarYLimitarPuntuaciones(List<Puntuacion> puntuaciones) {
        puntuaciones.sort((a, b) -> Integer.compare(b.getPuntos(), a.getPuntos()));
        if (puntuaciones.size() > 5) {
            puntuaciones.remove(puntuaciones.size() - 1);
        }
    }
}