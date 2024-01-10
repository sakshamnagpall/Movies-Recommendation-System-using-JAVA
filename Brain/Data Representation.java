import java.util.*;

class User {
    private String userId;
    private Map<String, Double> ratings; // MovieId -> Rating

    public User(String userId) {
        this.userId = userId;
        this.ratings = new HashMap<>();
    }

    public String getUserId() {
        return userId;
    }

    public void addRating(String movieId, double rating) {
        ratings.put(movieId, rating);
    }

    public Map<String, Double> getRatings() {
        return ratings;
    }
}

class Movie {
    private String movieId;
    private String title;

    public Movie(String movieId, String title) {
        this.movieId = movieId;
        this.title = title;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }
}
