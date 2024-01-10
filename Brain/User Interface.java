class RecommendationUI {
    private RecommendationSystem recommendationSystem;

    public RecommendationUI(RecommendationSystem recommendationSystem) {
        this.recommendationSystem = recommendationSystem;
    }

    public void displayRecommendedMovies(String userId) {
        User user = /* Fetch user data from the database using UserDAO */;
        List<Movie> recommendations = recommendationSystem.recommendMovies(user);
        // Display recommended movies to the user
    }
}
