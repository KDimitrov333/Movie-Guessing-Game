/**

 * File: MovieDataLoader.java

 * Author: Kaloyan Dimitrov

 * Date: 11/28/2023

 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieDataLoader {
    public static List<MovieAnswer> loadMoviesFromCSV(String filePath) {
        List<MovieAnswer> movies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Splitting each line of the CSV file into title and image path
                String[] data = line.split(",");
                if (data.length == 2) {
                    String title = data[0];
                    String imagePath = data[1];

                    // Adding a movie to the list with default false correctness
                    movies.add(new MovieAnswer(title, imagePath, false));
                }
            }
        } catch (IOException e) {
            // Printing the stack trace in case of an IOException
            e.printStackTrace();
        }
        return movies;
    }
}
