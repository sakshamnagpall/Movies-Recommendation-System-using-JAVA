class HybridRecommendation {
    private CollaborativeFiltering collaborativeFiltering;
    private ContentBasedFiltering contentBasedFiltering;

    public List<Movie> recommendMovies(User user) {
        List<Movie> collaborativeRecommendations = collaborativeFiltering.recommendMovies(user);
        List<Movie> contentBasedRecommendations = contentBasedFiltering.recommendMovies(user);

        // Combine and prioritize recommendations from both methods
        // Implementation of combination and prioritization logic

        // Return the final list of recommendations
    }
}
