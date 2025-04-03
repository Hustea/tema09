import javax.swing.text.html.parser.Entity;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainInterfaces {
    public static void main(String[] args) {
        GenericDynamicArray<Integer> datos = new GenericDynamicArray<>(100);
        Set<Entity> numeros = new HashSet<>();
/*
        System.out.println(numeros.add(new Entity(1, 2, "pepe")));
        System.out.println(numeros.add(new Entity(1, 3, "Juan")));
        System.out.println(numeros.add(new Entity(1, 4, "pedro")));
        System.out.println(numeros.add(new Entity(1, 5, "manolo")));

*/
        /*
        for(int i = 0; i < 50; i++){
            datos.add(i);
        }

        for(int numero : datos){
            System.out.println(numero);
        }
        datos.set(10, null);

        for(int numero : datos){
            System.out.println(numero);
        }
*/
    }
}
