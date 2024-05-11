import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MovieRecommender {

    static class Movie {
        String title;
        String genre;
        int rating;

        public Movie(String title, String genre, int rating) {
            this.title = title;
            this.genre = genre;
            this.rating = rating;
        }
    }

    static class User {
        String name;
        String preferredGenre;
        ArrayList<Movie> watchedHistory;

        public User(String name, String preferredGenre) {
            this.name = name;
            this.preferredGenre = preferredGenre;
            this.watchedHistory = new ArrayList<>();
        }

        public void watchMovie(Movie movie) {
            watchedHistory.add(movie);
        }

        public void showWatchHistory() {
            if (watchedHistory.isEmpty()) {
                System.out.println("Your watch history is empty.");
            } else {
                System.out.println("Watch history for " + name + ":");
                for (Movie movie : watchedHistory) {
                    System.out.println("* " + movie.title + " (" + movie.genre + ")");
                }
            }
        }
    }
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, User> users = new HashMap<>();
    static ArrayList<Movie> movies = new ArrayList<>();

    public static void main(String[] args) {
        initializeMovieList();
        runMovieRecommender();
        scanner.close();
    }

    static void initializeMovieList() {
        movies.add(new Movie("12 Angry Men", "Drama", 5));
        movies.add(new Movie("2001: A Space Odyssey", "Science Fiction", 5));
        movies.add(new Movie("A Beautiful Mind", "Biography", 4));
        movies.add(new Movie("A Clockwork Orange", "Crime", 4));
        movies.add(new Movie("A Few Good Men", "Drama", 4));
        movies.add(new Movie("A Fistful of Dollars", "Western", 4));
        movies.add(new Movie("A Hard Day's Night", "Comedy", 4));
        movies.add(new Movie("A Nightmare on Elm Street", "Horror", 4));
        movies.add(new Movie("A Streetcar Named Desire", "Drama", 5));
        movies.add(new Movie("Alien", "Science Fiction", 5));
        movies.add(new Movie("American History X", "Drama", 5));
        movies.add(new Movie("Apocalypse Now", "War", 5));
        movies.add(new Movie("Avatar", "Science Fiction", 4));
        movies.add(new Movie("Back to the Future", "Science Fiction", 5));
        movies.add(new Movie("Blade Runner", "Science Fiction", 5));
        movies.add(new Movie("Braveheart", "History", 5));
        movies.add(new Movie("Casablanca", "Romance", 5));
        movies.add(new Movie("Catch Me If You Can", "Biography", 4));
        movies.add(new Movie("Chinatown", "Mystery", 5));
        movies.add(new Movie("City of God", "Crime", 5));
        movies.add(new Movie("Die Hard", "Action", 5));
        movies.add(new Movie("Django Unchained", "Western", 5));
        movies.add(new Movie("Doctor Zhivago", "Romance", 4));
        movies.add(new Movie("Donnie Darko", "Drama", 4));
        movies.add(new Movie("Dr. Strangelove", "Comedy", 5));
        movies.add(new Movie("E.T. the Extra-Terrestrial", "Science Fiction", 5));
        movies.add(new Movie("Fargo", "Crime", 5));
        movies.add(new Movie("Forrest Gump", "Drama", 4));
        movies.add(new Movie("Full Metal Jacket", "War", 5));
        movies.add(new Movie("Gone with the Wind", "Romance", 5));
        movies.add(new Movie("Goodfellas", "Crime", 4));
        movies.add(new Movie("Gravity", "Science Fiction", 4));
        movies.add(new Movie("Heat", "Crime", 4));
        movies.add(new Movie("Inception", "Science Fiction", 4));
        movies.add(new Movie("Indiana Jones and the Last Crusade", "Action", 5));
        movies.add(new Movie("Inglourious Basterds", "War", 5));
        movies.add(new Movie("Interstellar", "Science Fiction", 5));
        movies.add(new Movie("It's a Wonderful Life", "Drama", 5));
        movies.add(new Movie("Jaws", "Thriller", 5));
        movies.add(new Movie("Jurassic Park", "Science Fiction", 4));
        movies.add(new Movie("Kill Bill: Vol. 1", "Action", 4));
        movies.add(new Movie("La La Land", "Musical", 4));
        movies.add(new Movie("Lawrence of Arabia", "History", 5));
        movies.add(new Movie("Life is Beautiful", "Comedy", 5));
        movies.add(new Movie("Mad Max: Fury Road", "Action", 5));
        movies.add(new Movie("Memento", "Mystery", 5));
        movies.add(new Movie("No Country for Old Men", "Crime", 5));
        movies.add(new Movie("Once Upon a Time in the West", "Western", 5));
        movies.add(new Movie("One Flew Over the Cuckoo's Nest", "Drama", 5));
        movies.add(new Movie("Pan's Labyrinth", "Fantasy", 5));
        movies.add(new Movie("Parasite", "Thriller", 5));
        movies.add(new Movie("Pulp Fiction", "Crime", 4));
        movies.add(new Movie("Raiders of the Lost Ark", "Action", 5));
        movies.add(new Movie("Requiem for a Dream", "Drama", 5));
        movies.add(new Movie("Rocky", "Drama", 4));
        movies.add(new Movie("Saving Private Ryan", "War", 5));
        movies.add(new Movie("Schindler's List", "History", 5));
        movies.add(new Movie("Seven Samurai", "Adventure", 5));
        movies.add(new Movie("Shawshank Redemption", "Drama", 5));
        movies.add(new Movie("Singin' in the Rain", "Musical", 5));
        movies.add(new Movie("Snatch", "Crime", 4));
        movies.add(new Movie("Some Like It Hot", "Comedy", 5));
        movies.add(new Movie("Star Wars: Episode IV - A New Hope", "Science Fiction", 5));
        movies.add(new Movie("Terminator 2: Judgment Day", "Science Fiction", 5));
        movies.add(new Movie("The Dark Knight", "Action", 5));
        movies.add(new Movie("The Exorcist", "Horror", 5));
        movies.add(new Movie("The Godfather", "Crime", 5));
        movies.add(new Movie("Dune", "Science Fiction", 5));
        movies.add(new Movie("OPPENHEIMER", "History", 5));
        movies.add(new Movie("SPIDER-MAN: ACROSS THE SPIDER-VERSE", "Animation", 5));
        movies.add(new Movie("BARBIE", "Comedy", 5));
        movies.add(new Movie("GODZILLA MINUS ONE", "Action", 5));
        movies.add(new Movie("Train to Busian", "Thriller", 5));
        movies.add(new Movie("A Silent Voice", "Animation", 5));
        movies.add(new Movie("Jurassic Park", "Thriller", 5));
        movies.add(new Movie("La La Land", "Romance", 5));
        movies.add(new Movie("Avengers Infinity War", "War", 5));
        movies.add(new Movie("Ready Player One", "Science Fiction", 5));
        movies.add(new Movie("Inception", "Science Fiction", 5));
        movies.add(new Movie("Star Wars: The Phantom Menace", "Fantasy", 5));
        movies.add(new Movie("The Notebook", "Romance", 5));
        movies.add(new Movie("Crazy Rich Asians", "Romance", 5));
        movies.add(new Movie("The RM", "Romance", 5));
        movies.add(new Movie("Guardians of the Galaxy: Vol. 3", "Science Fiction", 5));
        movies.add(new Movie("Pride and Prejudice", "Romance", 5));
        movies.add(new Movie("Arthur and the Invisibles", "Fantasy", 5));
        movies.add(new Movie("Frozen", "Kids", 4));
        movies.add(new Movie("Cars", "Kids", 5));
        movies.add(new Movie("The Phantom Of The Opera", "Romance", 5));
     }

        static void runMovieRecommender() {
            while (true) {
                System.out.println("Are you a new user or a returning user? (new/returning)");     

                String userType = scanner.nextLine();
    
                if (userType.equalsIgnoreCase("new")) {
                    newUserRoutine();
                } else if (userType.equalsIgnoreCase("returning")) {
                    returningUserRoutine();
                } else {
                    System.out.println("Invalid input. Please enter 'new' or 'returning'.");
                }
        
                System.out.println("Do you want to go back to menu? (yes/no)");
                String continueChoice = scanner.nextLine();
                if (!continueChoice.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }
    
        static void newUserRoutine() {
            System.out.println("Enter your name:");
            String userName = scanner.nextLine();
            System.out.println("What genre do you prefer (Crime, Drama, Action, Fantasy, Science Fiction, Thriller, History, Animation, Biography, Mystery, Romance, War, Western, Comedy, Kids)?");
            String userInput = scanner.nextLine();
            String preferredGenre = null;
    
            String[] genres = {"Crime", "Drama", "Action", "Fantasy", "Science Fiction", "Thriller", "History", "Animation", "Biography", "Mystery", "Romance", "War", "Western", "Comedy", "Kids"};
    
            for (String genre : genres) {
                if (userInput.equalsIgnoreCase(genre)) {
                    preferredGenre = genre;
                    break;
                }
            }
    
            if (preferredGenre != null) {
                System.out.println("You entered: '" + userInput + "'. Recognized genre: " + preferredGenre);
            } else {
                System.out.println("Genre not recognized. Did you mean one of these? " + String.join(", ", genres));
            }
    
            User newUser = new User(userName, preferredGenre);
            users.put(userName, newUser);
    
            recommendAndWatchMovies(newUser);
        }
    
        static void returningUserRoutine() {
            System.out.println("Select your name:");
            for (String userName : users.keySet()) {
                System.out.println("* " + userName);
            }
            String userName = scanner.nextLine();
            if (users.containsKey(userName)) {
                User returningUser = users.get(userName);
                recommendAndWatchMovies(returningUser);
            } else {
                System.out.println("User not found. Please try again.");
            }
        }
    
        static ArrayList<Movie> recommendMovies(String genre) {
            ArrayList<Movie> recommendations = new ArrayList<>();
            int counter = 1;
            for (Movie movie : movies) {
                if (movie.genre.equalsIgnoreCase(genre)) {
                    recommendations.add(movie);
                    System.out.println(counter + ". " + movie.title + " (" + movie.genre + ")");
                    counter++;
                }
            }
            return recommendations;
        }
    
        static void recommendAndWatchMovies(User user) {
            while (true) {
                ArrayList<Movie> recommendedMovies = recommendMovies(user.preferredGenre);
    
                if (!recommendedMovies.isEmpty()) {
                    System.out.println("Here are some recommendations for you, " + user.name + ":");
    
                    for (Movie movie : recommendedMovies) {
                        System.out.println(recommendedMovies.indexOf(movie) + 1 + ". " + movie.title + " (" + movie.genre + ")");
                    }
    
                    System.out.println("Did you watch any movie from the recommendation? (yes/no)");
                    String watchedChoice = scanner.nextLine();
                    if (watchedChoice.equalsIgnoreCase("yes")) {
                        System.out.println("Enter the number or title of the movie you watched:");
                        String watchedMovie = scanner.nextLine();
                        boolean found = false;
                        for (Movie movie : recommendedMovies) {
                            if (watchedMovie.equalsIgnoreCase(movie.title) || watchedMovie.equals(String.valueOf(recommendedMovies.indexOf(movie) + 1))) {
                                user.watchMovie(movie);
                                System.out.println("Added " + movie.title + " to your watched history.");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Movie not found. Please enter a valid number or title.");
                        }
                    } else {
                        break;
                    }
                }
    
                System.out.println("Do you want to see your watch history? (yes/no)");
                String watchHistoryChoice = scanner.nextLine();
                if (watchHistoryChoice.equalsIgnoreCase("yes")) {
                    user.showWatchHistory();
                }
    
                System.out.println("Do you want new recommendations? (yes/no)");
                String newRecommendationChoice = scanner.nextLine();
                if (!newRecommendationChoice.equalsIgnoreCase("yes")) {
                    break;
                }
    
                System.out.println("What genre do you prefer (Crime, Drama, Action, Fantasy, Science Fiction, Thriller, History, Animation, Biography, Mystery, Romance, War, Western, Comedy)?");
                user.preferredGenre = scanner.nextLine();
            }
        }
    }
          