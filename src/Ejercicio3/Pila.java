package Ejercicio3;

import java.util.ArrayList;

class Pila<T> implements IPila<T> {
    private ArrayList<T> data;

    public Pila() {
        data = new ArrayList<>();
    }

    @Override
    public T push(T e) {
        data.add(e);
        return e;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return data.get(data.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

