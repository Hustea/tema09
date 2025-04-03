package Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> numeros = new ArrayList<>(Arrays.asList(1.0, 2.0, 2.0, 3.0, 4.0, 4.0, 4.0, 5.0));
        ArrayListEstadisticas estadisticas = new ArrayListEstadisticas(numeros);

        System.out.println("Mínimo: " + estadisticas.minimo());
        System.out.println("Máximo: " + estadisticas.maximo());
        System.out.println("Sumatorio: " + estadisticas.sumatorio());
        System.out.println("Media: " + estadisticas.media());
        System.out.println("Moda: " + estadisticas.moda());
    }
}
