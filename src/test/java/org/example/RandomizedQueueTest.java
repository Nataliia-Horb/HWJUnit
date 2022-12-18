package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedQueueTest<Item> {
    Item[] itemArray;
    RandomizedQueue queue = new RandomizedQueue<>();

    @BeforeEach
    public void init() {
        itemArray = (Item[]) new Object[0];
    }

    @Test
    void enqueue() {
        //проверка когда пытаемся положить null
        assertThrows(NullPointerException.class, () -> queue.enqueue(null));

        // проверка на наличие добавленных элементов в правильном количестве
        for (int i = 0; i < 10; i++) {
            queue.enqueue("new Element is: " + i);
        }
        assertEquals(10, queue.size());

        // проверка на наличие добавленных элементов в правильном количестве
        for (int i = 0; i < 5; i++) {
            queue.enqueue("new Element is: " + i);
        }
        queue.forEach(e -> System.out.println(e));
        assertEquals(15, queue.size());
    }

    @Test
    void sample() {
        // проверка на применение метода к пустой коллекции
        assertThrows(NoSuchElementException.class, () -> queue.sample());

        for (int i = 0; i < 10; i++) {
            queue.enqueue("new Element is: " + i);
        }

        // проверка, смотрим что елементы возвращаются рандомно
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.sample());
        }
        // проверяем, что размер коллекции не поменялся
        assertEquals(10, queue.size());
    }

    @Test
    void dequeue() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue("new Element is: " + i);
        }
        queue.dequeue();
        queue.dequeue();

        // проверяем длину коллекции после удаления элементов
        assertEquals(8, queue.size());
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            System.out.println(queue.dequeue());
        }

        // удаляем все елементы из коллекции и проверяем что длина очереди равна 0
        assertEquals(0, queue.size());

        // проверка, пытаемся достать елементы с пустой очереди
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }

    @Test
    void isEmpty() {

        queue.enqueue("new Element is: One");
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void size() {
        // проверка,что размер считается корректно при добавлении элементов
        for (int i = 0; i < 15; i++) {
            queue.enqueue("new " + i);
        }
        assertEquals(15, queue.size());

        // проверка, что размер считается корректно при удалении элементов
        for (int i = 0; i < 15; i++) {
            queue.dequeue();
        }
        assertEquals(0, queue.size());
    }

    @Test
    void iterator() {

        Iterator<Item> iterator = queue.iterator();
        assertThrows(NoSuchElementException.class, iterator::next);
        for (int i = 0; i < 5; i++) {
            queue.enqueue("new " + i);
        }
        int count = 0;


        // проверка, что итератор отработал  по всем элементам
        iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            count++;
        }
        assertEquals(5, count);

        // проверка работы метода hasNext
        assertFalse(iterator.hasNext());
    }
}
