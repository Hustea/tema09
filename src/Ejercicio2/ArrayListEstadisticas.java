package Ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArrayListEstadisticas implements IEstadisticas {
    private ArrayList<Double> datos;

    public ArrayListEstadisticas(ArrayList<Double> datos) {
        this.datos = datos;
    }

    @Override
    public double minimo() {
        return Collections.min(datos);
    }

    @Override
    public double maximo() {
        return Collections.max(datos);
    }

    @Override
    public double sumatorio() {
        double suma = 0;
        for (double num : datos) {
            suma += num;
        }
        return suma;
    }

    @Override
    public double media() {
        if (datos.isEmpty()) return 0;
        return sumatorio() / datos.size();
    }

    @Override
    public double moda() {
        if (datos.isEmpty()) return Double.NaN;

        Map<Double, Integer> frecuencia = new HashMap<>();
        for (double num : datos) {
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
        }

        double moda = datos.get(0);
        int maxFrecuencia = 0;
        for (Map.Entry<Double, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }

        return moda;
    }
}
