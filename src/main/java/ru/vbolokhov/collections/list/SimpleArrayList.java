package ru.vbolokhov.collections.list;

import ru.vbolokhov.collections.NotImplementedException;




/**
 * @author Vadim Bolokhov
 */
public class SimpleArrayList<T> {
    private Object[] array;
    private int size;

    public SimpleArrayList (int size) {
        this.array = new Object[size];
        this.size = 0;
    }

    public SimpleArrayList() {
        this.size = 0;
        this.array = new Object[8];
    }

    public boolean add(T element) {
        if (size == array.length) {
            Object[] newArray = new Object[(int) (array.length*1.5 +1)];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = element;
        size++;
        return true;
    }

    public void add(int index, T element) {
        if(index > size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newArray = new Object[array.length + 1];
        for (int i = 0; i < index ; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = element;
        for (int i = index + 1; i < array.length + 1 ; i++) {
            newArray[i] = array[i-1];
        }
        array = newArray;
        size++;
    }

    public T get(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public int size() {
        return this.size;
    }

    public boolean remove(T element) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    public T remove(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T element = (T) array[index];
        Object[] newArray = new Object[array.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            if(i < index) {
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i+1];
            }
        }
        array = newArray;
        size--;
        return element;
    }
}
