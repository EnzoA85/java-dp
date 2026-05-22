package org.sebsy.strategy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TriTest {

    @Test
    public void testBubbleSortStrategy() {
        Integer[] input = {5, 1, 4, 2, 3};
        Integer[] expected = {1, 2, 3, 4, 5};

        new Tri().exec(TriStrategyType.BUBBLE, input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testInsertionSortStrategy() {
        Integer[] input = {5, 1, 4, 2, 3};
        Integer[] expected = {1, 2, 3, 4, 5};

        new Tri().exec(TriStrategyType.INSERTION, input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testSelectionSortStrategy() {
        Integer[] input = {5, 1, 4, 2, 3};
        Integer[] expected = {1, 2, 3, 4, 5};

        new Tri().exec(TriStrategyType.SELECTION, input);

        assertArrayEquals(expected, input);
    }
}
