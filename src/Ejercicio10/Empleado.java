package Ejercicio10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona {
    private String nif;
    private double sueldo;
    private List<Hijo> hijos;

    public Empleado(String nif, String nombre, String apellidos, LocalDate fechaNacimiento, double sueldo) {
        super(nombre, apellidos, fechaNacimiento);
        this.nif = nif;
        this.sueldo = sueldo;
        this.hijos = new ArrayList<>();
    }

    public String getNif() {
        return nif;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public List<Hijo> getHijos() {
        return hijos;
    }

    public void anadirHijo(Hijo hijo) {
        hijos.add(hijo);
    }

    public boolean eliminarHijo(String nombreHijo) {
        return hijos.removeIf(h -> h.getNombre().equalsIgnoreCase(nombreHijo));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NIF: ").append(nif).append("\n");
        sb.append("Nombre: ").append(super.toString()).append("\n");
        sb.append("Sueldo: ").append(sueldo).append("\n");
        sb.append("Hijos: ").append(hijos.isEmpty() ? "Ninguno" : "").append("\n");
        for (Hijo h : hijos) {
            sb.append("   - ").append(h).append("\n");
        }
        return sb.toString();
    }
}
