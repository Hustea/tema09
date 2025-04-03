import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio1 {
    static Random random = new Random();
    public static void main(String[] args) {
        ArrayList<Integer> arrayOrdenado = new ArrayList<>();
        final int TAMANYO = 10;
        int[] array =new int[TAMANYO];

        rellenarArrayAleatorio(array);
        imprimirArray(array);
        System.out.println("Array ordenado:");
        arrayOrdenado = convertirArrayEnArrayListConParesOrdenados(array);
        imprimirList(arrayOrdenado);
    }

    public static ArrayList<Integer> convertirArrayEnArrayListConParesOrdenados(int[] array){
        ArrayList<Integer> arrayOrdenado = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                arrayOrdenado.add(array[i]);
            }
        }
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                arrayOrdenado.add(array[i]);
            }
        }
        return arrayOrdenado;
    }

    public static void rellenarArrayAleatorio(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(50);
        }
    }

    public static void imprimirArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void imprimirList(ArrayList<Integer> array){
        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }
    }
}
