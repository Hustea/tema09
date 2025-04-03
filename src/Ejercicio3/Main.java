package Ejercicio3;

class Main {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        // Añadir valores aleatorios
        pila.push(10);
        pila.push(20);
        pila.push(30);
        System.out.println("Pila después de añadir elementos: " + pila);

        // Borrar un elemento
        System.out.println("Elemento eliminado: " + pila.pop());
        System.out.println("Pila después de eliminar un elemento: " + pila);

        // Consultar el elemento superior
        System.out.println("Elemento en la cima: " + pila.top());
    }
}
