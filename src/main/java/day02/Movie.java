package day02;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String name;
    private int length;
    private List<String> cast;

    public Movie(String name, int length, List<String> cast) {
        this.name = name;
        this.length = length;
        this.cast = cast;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public List<String> getCast() {
        return new ArrayList<>(cast);
    }
}
