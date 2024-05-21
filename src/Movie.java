/**

 * File: Movie.java

 * Author: Kaloyan Dimitrov

 * Date: 11/28/2023

 */

public class Movie {
    private String title;
    private String shotPath;

    // Constructor initializing the title and shotPath
    public Movie(String title, String shotPath) {
        setTitle(title);
        setShotPath(shotPath);
    }

    // Getters and Setters for title and shotPath
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShotPath() {
        return shotPath;
    }

    public void setShotPath(String shotPath) {
        this.shotPath = shotPath;
    }
}
