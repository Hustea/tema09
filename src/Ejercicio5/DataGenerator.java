package Ejercicio5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    static Random random = new Random();
    static String[] array = {"Pepe", "Pepa", "Manolo", "Manola", "Alex"};

    public static String generarNombre(){
        return array[random.nextInt(array.length)];
    }

    public static Date generarFecha(){
        return fechaAleatoria();
    }

    public static Sexo generarSexo(){
        return Sexo.values()[random.nextInt(Sexo.values().length)];
    }

    public static int generarAltura(){
        return random.nextInt(140, 200);
    }

    public static float generarPeso(){
        return random.nextFloat(40, 120);
    }

    public static Date fechaAleatoria() {
        long startMillis = new Date(0, 0, 1).getTime();
        long endMillis = new Date().getTime();
        long randomMillis = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
        return new Date(randomMillis);
    }
}
