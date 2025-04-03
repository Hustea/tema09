package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();

        // Añadiendo valores aleatorios
        cola.add(10);
        cola.add(20);
        cola.add(30);
        System.out.println("Cola después de añadir elementos: " + cola);

        // Eliminando elementos
        System.out.println("Elemento eliminado: " + cola.remove());
        System.out.println("Cola después de eliminar: " + cola);

        // Consultando el primer elemento
        System.out.println("Primer elemento (peek): " + cola.peek());

        // Verificando si está vacía
        System.out.println("¿La cola está vacía? " + cola.isEmpty());
    }
}