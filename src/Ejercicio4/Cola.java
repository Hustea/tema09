package Ejercicio4;

import java.util.ArrayList;

class Cola<T> implements ICola<T> {
    private final ArrayList<T> data;

    public Cola() {
        data = new ArrayList<>();
    }

    @Override
    public boolean add(T e) {
        return data.add(e);
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return data.remove(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        return "Cola " + data;
    }
}
