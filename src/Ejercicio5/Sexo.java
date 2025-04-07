package Ejercicio5;

public enum Sexo {
    M ("M"), F ("F");

    private final String texto;
    Sexo(String sexo) {
        texto=sexo;
    }

    @Override
    public String toString() {
        return texto;
    }
}