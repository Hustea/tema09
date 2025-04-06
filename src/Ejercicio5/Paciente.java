package Ejercicio5;

import java.util.Date;

public class Paciente {
    private final int id;
    private String nombre;
    private final Date fechaNac;
    private Sexo sexo;
    private int alturaCm;
    private float pesoKg;
    private static int contador = 1;

    public Paciente(String nombre, Date fechaNac, Sexo sexo, int alturaCm, float pesoKg){
        this.id = idAutoIncremental();
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.alturaCm = alturaCm;
        this.pesoKg = pesoKg;
    }

    public Paciente(String nombre, Date fechaNac, int alturaCm, float pesoKg){
        this.id = idAutoIncremental();
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.sexo = Sexo.M;
        this.alturaCm = alturaCm;
        this.pesoKg = pesoKg;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getAlturaCm() {
        return alturaCm;
    }

    public float getPesoKg() {
        return pesoKg;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setAlturaCm(int alturaCm) {
        this.alturaCm = alturaCm;
    }

    public void setPesoKg(float pesoKg) {
        this.pesoKg = pesoKg;
    }

    private static int idAutoIncremental(){
        return contador++;
    }
}
