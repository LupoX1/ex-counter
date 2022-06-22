package com.codersdungeon.ex0;

import org.junit.Test;

import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void createCounter4DigitsBase10() {
        Counter counter = Counter.createCounter(10, 4);

        assertNotNull(counter);
        assertEquals(10, counter.getBase());
        assertEquals(4, counter.getDigits());
        assertEquals("0000", counter.current());
        assertEquals("9999", counter.maxValue());
    }

    @Test
    public void createCounter4DigitsBase2() {
        Counter counter = Counter.createCounter(2, 4);

        assertNotNull(counter);
        assertEquals(2, counter.getBase());
        assertEquals(4, counter.getDigits());
        assertEquals("0000", counter.current());
        assertEquals("1111", counter.maxValue());
    }

    @Test
    public void createCounter3DigitsBase8() {
        Counter counter = Counter.createCounter(8, 3);

        assertNotNull(counter);
        assertEquals(2, counter.getBase());
        assertEquals(4, counter.getDigits());
        assertEquals("000", counter.current());
        assertEquals("777", counter.maxValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCounterNegativeBase() {
        Counter.createCounter(-10, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCounterBaseZero() {
        Counter.createCounter(0, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCounterBaseOne() {
        Counter.createCounter(1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCounterNegativeDigits() {
        Counter.createCounter(10, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCounterZeroDigits() {
        Counter.createCounter(10, 0);
    }

    @Test
    public void count1DigitsBase10() {
        int maxValues = 10;

        String[] expectedValues = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int[] expectedDecimalValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        String[] actualValues = new String[maxValues];
        int[] actualDecimalValues = new int[maxValues];

        Counter counter = Counter.createCounter(10, 1);
        assertEquals("9", counter.maxValue());
        assertEquals("0", counter.current());

        for (int i = 0; i < maxValues; i++) {
            actualValues[i] = counter.next();
            actualDecimalValues[i] = counter.getDecimalValue();
        }

        assertEquals("9", counter.current());
        assertArrayEquals(expectedValues, actualValues);
        assertEquals(9, counter.getDecimalValue());
        assertArrayEquals(expectedDecimalValues, actualDecimalValues);

        assertEquals("0", counter.next());
        assertEquals("0", counter.current());
        assertEquals(0, counter.getDecimalValue());
    }

    @Test
    public void count3DigitsBase2() {
        String[] expectedValues = {"000", "001", "010", "011", "100", "101", "110", "111"};
        int[] expectedDecimalValues = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        int maxValues = expectedValues.length;

        String[] actualValues = new String[maxValues];
        int[] actualDecimalValues = new int[maxValues];

        Counter counter = Counter.createCounter(2, 3);
        assertEquals("111", counter.maxValue());
        assertEquals("000", counter.current());

        for (int i = 0; i < maxValues; i++) {
            actualValues[i] = counter.next();
            actualDecimalValues[i] = counter.getDecimalValue();
        }

        assertEquals("111", counter.current());
        assertArrayEquals(expectedValues, actualValues);
        assertEquals(8, counter.getDecimalValue());
        assertArrayEquals(expectedDecimalValues, actualDecimalValues);

        assertEquals("000", counter.next());
        assertEquals("000", counter.current());
        assertEquals(0, counter.getDecimalValue());
    }
}