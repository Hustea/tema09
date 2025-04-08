package Ejercicio10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Empresa {
    private Map<String, Empleado> empleados = new HashMap<>();

    public boolean anadirEmpleado(Empleado emp) {
        if (empleados.containsKey(emp.getNif())) {
            System.out.println("Ya existe un empleado con ese NIF.");
            return false;
        }
        empleados.put(emp.getNif(), emp);
        System.out.println("Empleado añadido correctamente.");
        return true;
    }

    public Empleado buscarPorNif(String nif) {
        return empleados.get(nif);
    }

    public List<Empleado> buscarPorNombre(String nombreParcial) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado e : empleados.values()) {
            if (e.getNombre().toLowerCase().contains(nombreParcial.toLowerCase())) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public List<Empleado> buscarPorEdad(int min, int max) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado e : empleados.values()) {
            int edad = e.getEdad();
            if (edad >= min && edad <= max) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public List<Empleado> buscarPorSueldo(double min, double max) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado e : empleados.values()) {
            double sueldo = e.getSueldo();
            if (sueldo >= min && sueldo <= max) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public List<Empleado> empleadosConHijosMenores() {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado e : empleados.values()) {
            for (Hijo h : e.getHijos()) {
                if (h.getEdad() < 18) {
                    resultado.add(e);
                    break;
                }
            }
        }
        return resultado;
    }

    public boolean borrarEmpleado(String nif) {
        if (empleados.remove(nif) != null) {
            System.out.println("Empleado eliminado correctamente.");
            return true;
        } else {
            System.out.println("Empleado no encontrado.");
            return false;
        }
    }

    public boolean anadirHijo(String nif, Hijo hijo) {
        Empleado e = empleados.get(nif);
        if (e != null) {
            e.anadirHijo(hijo);
            System.out.println("Hijo añadido correctamente.");
            return true;
        }
        System.out.println("Empleado no encontrado.");
        return false;
    }

    public boolean borrarHijo(String nif, String nombreHijo) {
        Empleado e = empleados.get(nif);
        if (e != null) {
            boolean borrado = e.eliminarHijo(nombreHijo);
            if (borrado) System.out.println("Hijo eliminado correctamente.");
            else System.out.println("Hijo no encontrado.");
            return borrado;
        }
        System.out.println("Empleado no encontrado.");
        return false;
    }

    public boolean modificarSueldo(String nif, double nuevoSueldo) {
        Empleado e = empleados.get(nif);
        if (e != null) {
            e.setSueldo(nuevoSueldo);
            System.out.println("Sueldo actualizado correctamente.");
            return true;
        }
        System.out.println("Empleado no encontrado.");
        return false;
    }

    public void mostrarTodos() {
        for (Empleado e : empleados.values()) {
            System.out.println(e);
        }
    }
}

