package Ejercicio5;

import java.util.ArrayList;
import java.util.Date;

public class Hospital {

    public static Paciente generarPaciente(){
        String nombre = DataGenerator.generarNombre();
        Date fechaNac = DataGenerator.generarFecha();
        Sexo sexo = DataGenerator.generarSexo();
        int alturaCm = DataGenerator.generarAltura();
        Float pesoKg = DataGenerator.generarPeso();
        Paciente paciente = new Paciente(nombre, fechaNac, sexo, alturaCm, pesoKg);
        return paciente;
    }

    public static int[] mayorMenor(ArrayList<Paciente> pacientes){
        final int numeroPacientes = 2;
        int[] posicion = new int[numeroPacientes];

        Date auxMayor = pacientes.get(0).getFechaNac();
        Date auxMenor = pacientes.get(0).getFechaNac();
        for(int i = 0; i < pacientes.size(); i++){
            auxMayor = (auxMayor.compareTo(pacientes.get(i).getFechaNac()) >= 0) ? auxMayor : pacientes.get(i).getFechaNac();
            auxMenor = (auxMenor.compareTo(pacientes.get(i).getFechaNac()) <= 0) ? auxMenor : pacientes.get(i).getFechaNac();
        }
        return posicion;
    }
}
