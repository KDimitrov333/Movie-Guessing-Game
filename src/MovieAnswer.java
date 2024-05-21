/**

 * File: MovieAnswer.java

 * Author: Kaloyan Dimitrov

 * Date: 11/28/2023

 */

public class MovieAnswer extends Movie {
    private boolean correct;

    // Constructor initializing MovieAnswer with title, shotPath, and correctness
    public MovieAnswer(String title, String shotPath, boolean correct) {
        super(title, shotPath); // Call the parent class constructor (Movie) to initialize title and shotPath
        setCorrect(correct); // Set the correctness of the movie
    }

    // Getter method for correctness
    public boolean isCorrect() {
        return correct;
    }

    // Setter method for correctness
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}