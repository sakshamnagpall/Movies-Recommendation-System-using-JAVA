class RecommendationSystem {
    private List<User> users;
    private List<Movie> movies;

    public RecommendationSystem() {
        this.users = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // A simple recommendation based on user similarities (e.g., using average ratings)
    public List<Movie> recommendMovies(User user) {
        Map<String, Double> userRatings = user.getRatings();
        Map<String, Double> averageRatings = new HashMap<>();

        for (Movie movie : movies) {
            if (!userRatings.containsKey(movie.getMovieId())) {
                double sum = 0;
                int count = 0;
                for (User u : users) {
                    if (u.getRatings().containsKey(movie.getMovieId())) {
                        sum += u.getRatings().get(movie.getMovieId());
                        count++;
                    }
                }
                averageRatings.put(movie.getMovieId(), count > 0 ? sum / count : 0);
            }
        }

        // Sort movies by average rating and return recommendations
        List<Map.Entry<String, Double>> sorted = new ArrayList<>(averageRatings.entrySet());
        sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<Movie> recommendations = new ArrayList<>();
        for (Map.Entry<String, Double> entry : sorted) {
            for (Movie movie : movies) {
                if (movie.getMovieId().equals(entry.getKey())) {
                    recommendations.add(movie);
                    break;
                }
            }
        }

        return recommendations;
    }
}
