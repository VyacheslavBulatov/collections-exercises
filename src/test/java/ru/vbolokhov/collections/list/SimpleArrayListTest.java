package ru.vbolokhov.collections.list;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListTest {

    private SimpleArrayList<Integer> list = new SimpleArrayList<>();

    @Test
    public void testAddMethod() {
        int element = 10;

        boolean added = list.add(element);
        int result = list.get(0);

        assertTrue(added);
        assertEquals(1, list.size());
        assertEquals(element, result);
        ArrayList<Object> objects = new ArrayList<>();
    }

    @Test
    public void testAddByIndex() {
        int element1 = 10;
        int element2 = 20;

        list.add(0, element1);
        list.add(0, element2);

        assertEquals(element2, list.get(0));
        assertEquals(element1, list.get(1));
    }

    @Test
    public void whenAddByWrongIndexThenShouldThrowException() {
        int element = 10;

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, element));
    }

    @Test
    public void testRemoveElement() {
        Integer element = 10;
        list.add(element);

        assertEquals(1, list.size());
        assertTrue(list.remove(element));
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveByIndex() {
        Integer element = 10;
        list.add(element);

        assertEquals(1, list.size());
        Integer removedElement = list.remove(0);
        assertEquals(element, removedElement);
        assertEquals(0, list.size());
    }
}