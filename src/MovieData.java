/**

 * File: MovieData.java

 * Author: Kaloyan Dimitrov

 * Date: 11/28/2023

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class MovieData {
    private static List<MovieAnswer> movies = new ArrayList<>();
    private static List<MovieAnswer> usedMovies = new ArrayList<>();

    // Static block to initialize the movies list
    static {
        initializeMovies();
    }

    // Method to initialize the movies list with movie data
    private static void initializeMovies() {
        String filePath = "MovieData.csv";
        movies.addAll(MovieDataLoader.loadMoviesFromCSV(filePath));
    }

    // Method to get a set of random movies
    public static List<MovieAnswer> getRandomMovies() {
        List<MovieAnswer> selectedMovies = new ArrayList<>(movies);

        if (selectedMovies.size() - usedMovies.size() < 4) {
            throw new IllegalArgumentException("Not enough unused movies in the database.");
        }

        Random random = new Random();

        // Exclude already used movies
        selectedMovies.removeAll(usedMovies);

        // Shuffle the remaining movies
        Collections.shuffle(selectedMovies);

        List<MovieAnswer> chosenMovies = selectedMovies.subList(0, 4);

        int correctIndex = random.nextInt(4);
        chosenMovies.get(correctIndex).setCorrect(true);

        // Add chosen movies to the usedMovies list
        usedMovies.addAll(chosenMovies);

        return chosenMovies;
    }
}