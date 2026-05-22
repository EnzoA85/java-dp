package org.sebsy.strategy;

public class Tri {

    public void exec(TriStrategyType typeTri, Integer[] arr) {
        Strategy strategy = StrategyFactory.getStrategy(typeTri);
        strategy.trier(arr);
    }

    public void exec(int typeTri, Integer[] arr) {
        exec(TriStrategyType.fromCode(typeTri), arr);
    }
}
