package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreetNumbers {

    public Map<String, List<Integer>> collectHouseNumbersFromFile(Path path) {
        List<String> input = readFile(path);
        Map<String, List<Integer>> result = createStreetsInMap(input);
        fillHouseNumbers(input, result);
        return result;
    }

    private void fillHouseNumbers(List<String> input, Map<String, List<Integer>> result) {
        for (String line : input) {
            int num = Integer.parseInt(line.split(" ")[1]);
            String key = line.split(" ")[0];
            List<Integer> values = result.get(line.split(" ")[0]);
            if (num == 0) {
                result.get(key).add(2 + (countEvens(values) * 2));
            }
            if (num == 1) {
                result.get(key).add(1 + (countOdds(values) * 2));
            }
        }
    }

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private Map<String, List<Integer>> createStreetsInMap(List<String> input) {
        Map<String, List<Integer>> result = new HashMap<>();
        for (String line : input) {
            result.put(line.split(" ")[0], new ArrayList<>());
        }
        return result;
    }

    private int countOdds(List<Integer> input) {
        return (int) input.stream()
                .filter(l -> l % 2 != 0)
                .count();
    }
    private int countEvens(List<Integer> input) {
        return (int) input.stream()
                .filter(l -> l % 2 == 0)
                .count();
    }
}
