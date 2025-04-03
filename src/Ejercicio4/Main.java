package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();

        cola.add(10);
        cola.add(20);
        cola.add(30);
        System.out.println("Cola después de añadir elementos: " + cola);

        System.out.println("Elemento eliminado: " + cola.remove());
        System.out.println("Cola después de eliminar: " + cola);

        System.out.println("Primer elemento (peek): " + cola.peek());

        System.out.println("¿La cola está vacía? " + cola.isEmpty());
    }
}