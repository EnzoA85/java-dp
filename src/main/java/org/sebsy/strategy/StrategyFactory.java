package org.sebsy.strategy;

public class StrategyFactory {

    public static Strategy getStrategy(TriStrategyType type) {
        switch (type) {
            case BUBBLE:
                return new BubbleSortStrategy();
            case INSERTION:
                return new InsertionSortStrategy();
            case SELECTION:
                return new SelectionSortStrategy();
            default:
                throw new IllegalArgumentException("Type de tri non pris en charge : " + type);
        }
    }
}
