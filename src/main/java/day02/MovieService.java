package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
    public List<Movie> getMoviesFromActor(String actor) {
        return movies.stream()
                .filter(o -> o.getCast().contains(actor))
                .toList();
    }

    public int getLongestLength() {
        return movies.stream()
                .mapToInt(o -> o.getLength())
                .max()
                .orElseThrow(() -> new IllegalArgumentException("No movie in the list."));
    }
}
