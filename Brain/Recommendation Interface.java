import java.util.*;

public class RecommendationInterface {
    private CollaborativeFiltering collaborativeFiltering;
    private ContentBasedFiltering contentBasedFiltering;
    private HybridRecommendation hybridRecommendation;

    public RecommendationInterface() {
        // Initialize your recommendation components here
        collaborativeFiltering = new CollaborativeFiltering();
        contentBasedFiltering = new ContentBasedFiltering();
        hybridRecommendation = new HybridRecommendation(collaborativeFiltering, contentBasedFiltering);
        // You would typically load data, initialize the recommendation systems, etc.
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter user ID (or 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Assuming user IDs are used for recommendation
            User user = /* Fetch user data from the database using UserDAO or other methods */;
            
            // Get recommendations for the user
            List<Movie> recommendations = hybridRecommendation.recommendMovies(user);

            // Display the recommendations
            System.out.println("Recommended movies for user " + user.getUserId() + ": ");
            for (Movie movie : recommendations) {
                System.out.println(movie.getTitle());
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        RecommendationInterface interfaceInstance = new RecommendationInterface();
        interfaceInstance.run();
    }
}
