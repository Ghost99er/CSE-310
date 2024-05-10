# Movie Recommender System

This is a Java program that recommends movies to users based on their preferred genre. Users can watch recommended movies and view their watch history.

## Implementation Details

### Variables
- The program uses variables to store user information such as name and preferred genre, as well as movie information such as title, genre, and rating.

### Expressions
- Expressions are used throughout the program for various purposes, such as checking conditions and generating recommendations.

### Conditionals
- Conditionals are used to handle different scenarios, such as determining whether a user is new or returning, and whether to continue recommending movies.

### Loops
- Loops are used for iterating over movie lists, checking for duplicates, and providing a continuous user interface loop.

### Functions
- Functions are used to encapsulate behavior such as watching movies, showing watch history, and recommending movies.

### Classes
- The program defines two classes: `Movie` and `User`, to represent movies and users, respectively.

### Data Structure (Java Collection Framework)
- The program utilizes ArrayList and HashMap from the Java Collection Framework to store movies and user information.


Import Statements: The code starts with importing necessary classes from the java.util package, including ArrayList, HashMap, and Scanner.
Movie Class: Inside the MovieRecommender class, there's a static inner class Movie. This class represents a movie and contains fields for title, genre, and rating.
User Class: Another static inner class User is defined to represent a user of the movie recommender system. It contains fields for name, preferredGenre, and watchedHistory (an ArrayList of movies).
Static Variables: The MovieRecommender class defines static variables scanner (for user input) and users (to store user information).
Main Method: The main method is the entry point of the program. It initializes the movie list, runs the movie recommender system, and closes the scanner.
Initialization: The initializeMovieList method populates the movies ArrayList with movie objects. It adds various movies along with their titles, genres, and ratings.
Run Movie Recommender: The runMovieRecommender method is the core of the program. It's an infinite loop that prompts users to choose between new or returning user options and handles user input accordingly.
New User Routine: The newUserRoutine method is called when a new user wants to use the system. It prompts the user to enter their name and preferred movie genre, creates a new user object, and adds it to the users HashMap.
Returning User Routine: The returningUserRoutine method is called when a returning user wants to use the system. It prompts the user to select their name from the existing users and retrieves the user object from the users HashMap.
Recommend Movies: The recommendMovies method takes a genre as input and returns a list of movies of that genre from the movies ArrayList.
Recommend and Watch Movies: The recommendAndWatchMovies method is responsible for recommending movies to the user based on their preferred genre and handling their interactions with the system. It displays movie recommendations, allows the user to mark movies as watched, and prompts for new recommendations or viewing watch history.
Create Movie List: The createMovieList method is a placeholder for adding movies to the movies ArrayList. It's currently empty as movies are directly added in the initializeMovieList method.
Overall, the code implements a simple movie recommender system where users can specify their preferred genre and receive recommendations based on that genre. Users can also mark movies as watched and view their watch history.






