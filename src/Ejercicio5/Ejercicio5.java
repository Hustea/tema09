package Ejercicio5;

import java.time.LocalDate;

public class Ejercicio5 {
    public enum IMC {
        PI("Peso insuficiente",Double.MIN_VALUE, 18.45),
        PN("Peso normal",18.5,25),
        SG1("Sobrepeso grado I",25, 27),
        SG2("Sobrepeso grado II",27, 30),
        SG3("Sobrepeso grado III",30, Double.MAX_VALUE);

        private final String texto;
        private final double min;
        private final double max;

        IMC(String texto, double min, double max) {
            this.texto = texto;
            this.min = min;
            this.max = max;
        }

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }

        @Override
        public String toString() {
            return texto;
        }
    }


    /**
     * Verifica cual es el paciente más joven y el más mayor que contiene un array de pacientes 'Paciente[]'.
     * @param pacientes Array de pacientes para verificar.
     * @return Devuelve un array int[] de dos posiciones con la siguiente lógica:
     *      array[0] == índice del paciente más jóven
     *      array[1] == índice del paciente más mayor
     */
    public static int[] majorMenor(Paciente[] pacientes){
        int posicionMayor=0;
        int edadMenor = pacientes[0].getEdad();
        int posicionMenor=0;
        int edadMayor = pacientes[0].getEdad();
        int aux;
        for (int i = 1; i < pacientes.length; i++) {
            aux = pacientes[i].getEdad();
            if (edadMenor > aux) {
                posicionMenor = i;
                edadMenor = aux;
            }
            if (edadMayor < aux) {
                posicionMayor = i;
                edadMayor = aux;
            }
        }
        return new int[]{posicionMenor, posicionMayor};
    }


    /**
     * Cuenta la cantidad de pacientes de cada sexo que contiene un array de pacientes 'Paciente[]'.
     * @param pacientes Array de pacientes para verificar.
     * @return Devuelve un array int[] de dos posiciones con la siguiente lógica:
     *      array[0] == Cantidad de pacientes hombres 'M'
     *      array[1] == Cantidad de pacientes mujeres 'F'
     */
    public static int[] pacientsPerSexe(Paciente[] pacientes) {
        int contadorHombres = 0;
        int contadorMujeres = 0;

        for (Paciente paciente : pacientes) {
            if (paciente.getSexo() == Sexo.M) {
                contadorHombres++;
            } else {
                contadorMujeres++;
            }
        }

        return new int[]{contadorHombres, contadorMujeres};
    }

    public static void main(String[] args) {
        Paciente[] registroPacientes = new Paciente[5];
        registroPacientes[0] = (new Paciente(LocalDate.of(1967,1,1),Sexo.M,1.8,65));
        registroPacientes[1] = (new Paciente(LocalDate.of(1997,1,1),Sexo.F,1.8,65));
        registroPacientes[2] = (new Paciente(LocalDate.of(1980,1,1),Sexo.F,1.8,65));
        registroPacientes[3] = (new Paciente(LocalDate.of(1980,1,1),Sexo.F,1.8,65));
        registroPacientes[4] = (new Paciente(LocalDate.of(1980,1,1),Sexo.M,1.8,85));

        int[] aux = majorMenor(registroPacientes);
        System.out.printf("PACIENTE MAYOR Edad: %d Sexo: %s\n",registroPacientes[aux[1]].getEdad(),registroPacientes[aux[1]].getSexo().toString());
        System.out.printf("PACIENTE MENOR Edad: %d Sexo: %s\n\n",registroPacientes[aux[0]].getEdad(),registroPacientes[aux[0]].getSexo().toString());

        aux = pacientsPerSexe(registroPacientes);
        System.out.printf("Cantidad de pacientes por sexos:\nHombres: %d    Mujeres: %d\n\n",aux[0],aux[1]);

        for (int i = 0; i < 5; i++) {
            System.out.printf("Paciente número %d: %s.\n",i,registroPacientes[i].comprobarTipoIMC().toString());
        }
    }
}