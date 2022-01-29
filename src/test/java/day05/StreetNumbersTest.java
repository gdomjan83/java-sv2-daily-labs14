package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StreetNumbersTest {

    StreetNumbers streetNumbers = new StreetNumbers();

    @Test
    void testFileReadError() {
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> streetNumbers.collectHouseNumbersFromFile(Paths.get("src/test/resources/stre111ets.txt")));
        assertEquals("Can not read file.", ise.getMessage());
    }

    @Test
    void testCollectHouseNumbersInMap() {
        Map<String, List<Integer>> expected = new HashMap<>();
        expected.put("Kossuth", new ArrayList<>(Arrays.asList(2, 4, 1, 3, 5, 7)));
        expected.put("Petofi", new ArrayList<>(Arrays.asList(1, 2, 4, 3, 6)));
        Map<String, List<Integer>> result = streetNumbers.collectHouseNumbersFromFile(Paths.get("src/test/resources/streets.txt"));
        assertEquals(expected, result);
    }

}