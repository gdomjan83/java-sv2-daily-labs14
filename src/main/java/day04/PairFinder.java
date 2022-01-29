package day04;

import java.util.HashMap;
import java.util.Map;

public class PairFinder {

    public int findPairs(int[] arr) {
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int actual : arr) {
            checkPairs(pairs, actual, arr);
        }
        return recordPairsToMap(pairs);
    }

    private void checkPairs(Map<Integer, Integer> pairs, int number, int[] arr) {
        int counter = 0;
        for (int actual : arr) {
            if (actual == number) {
                counter++;
                pairs.put(actual, counter);
            }
        }
    }

    private int recordPairsToMap(Map<Integer, Integer> pairs) {
        int pairCount = 0;
        for (Integer actual : pairs.values()) {
            pairCount += actual / 2;
        }
        return pairCount;
    }
}
