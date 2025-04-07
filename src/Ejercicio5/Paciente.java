package Ejercicio5;

import java.time.LocalDate;
import java.util.Date;

public class Paciente {
    private static int ultimoId = 0;
    private final int id;
    private final LocalDate fechaNacimiento;
    private final Sexo sexo;
    private final double altura;
    private final double peso;

    public Paciente(LocalDate fechaNacimiento, Sexo sexo, double altura, double peso) {
        this.id = ++ultimoId;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    /**
     * Calcula la edad actual del paciente.
     * @return Devuelve la edad actual del paciente.
     */
    public int getEdad(){
        LocalDate fechaActual = LocalDate.now();
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if (fechaNacimiento.getMonthValue()>fechaActual.getMonthValue()){
            edad--;
        }
        return edad;
    }

    /**
     * Calcula el Ã­ndice de masa corporal actual del paciente.
     * @return Devuelve el indice de masa corporal actual del paciente.
     */
    public double getIMC(){
        return peso/(altura*altura);
    }

    public Ejercicio5.IMC comprobarTipoIMC(){
        double imc = getIMC();
        if (imc< Ejercicio5.IMC.PI.getMax()){
            return Ejercicio5.IMC.PI;
        } else if (imc<Ejercicio5.IMC.PN.getMax()) {
            return Ejercicio5.IMC.PN;
        } else if (imc<Ejercicio5.IMC.SG1.getMax()) {
            return Ejercicio5.IMC.SG1;
        } else if (imc<Ejercicio5.IMC.SG2.getMax()) {
            return Ejercicio5.IMC.SG2;
        } else {
            return Ejercicio5.IMC.SG3;
        }
    }
}
