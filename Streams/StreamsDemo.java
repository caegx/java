package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Streams are used to process collections of objects or data in a declarative way 
public class StreamsDemo {
    public static void main(String[] args) {
        List<Movie> movies = List.of(new Movie("The Matrix", 100, Genre.ACTION), 
        new Movie("The Matrix Reloaded", 100, Genre.ACTION), 
        new Movie("The Matrix Revolutions", 100, Genre.ACTION));

        // Imperative programming
        int count = 0;
        for (var movie : movies) {
            if (movie.getLikes() > 100) {
                count++;
            }
        }
        System.out.println(count);

        // Declarative (Functional) Programming
        System.out.println(movies.stream()
        .filter(movie -> movie.getLikes() > 100)
        .count());

        creatingStreams();
        mappingElements();
        filteringElements();
        slicingStreams();
        gettingDistinctElements();
        peekingElements();
        simpleReducers();
        reducingStreams();
        collectors();
        partitioningStreams();

    }

    //Partitioning Streams
    public static void partitioningStreams() {
        var movies = List.of(new Movie("The Matrix", 500, Genre.ACTION), 
        new Movie("The Matrix Reloaded", 100, Genre.ACTION), 
        new Movie("The Matrix Revolutions", 220, Genre.ACTION));

        var partitioningResult = movies.stream()
        .collect(Collectors.partitioningBy(movie -> movie.getLikes() > 100,
        Collectors.mapping(Movie::getTitle, Collectors.joining(", "))));

        System.out.println(partitioningResult);

        //Primitive type streams
        var intStream = IntStream.range(1, 10); // creates an IntStream from 1 to 9
        intStream.forEach(System.out::println);

        var intStream2 = IntStream.rangeClosed(1, 10); // creates an IntStream from 1 to 10
        intStream2.forEach(System.out::println);

        var intStream3 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // creates an IntStream from an array
        intStream3.forEach(System.out::println);
        
        
    }

    //Collectors 
    public static void collectors() {
        var movies = List.of(new Movie("c", 10, Genre.COMEDY), 
        new Movie("a", 20, Genre.ACTION), 
        new Movie("b", 30, Genre.ACTION));

        var listResult = movies.stream()
        .filter(movie -> movie.getLikes() > 10)
        .collect(Collectors.toList());

        System.out.println(listResult);

        var mapResult = movies.stream()
        .filter(movie -> movie.getLikes() > 10)
        .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));

        System.out.println(mapResult);

        var sumResult = movies.stream()
        .filter(movie -> movie.getLikes() > 10)
        .collect(Collectors.summingInt(Movie::getLikes)); // same as reducing

        System.out.println(sumResult);

        var summarizingResult = movies.stream()
        .filter(movie -> movie.getLikes() > 10)
        .collect(Collectors.summarizingInt(Movie::getLikes));

        System.out.println(summarizingResult);
        
        var joiningResult = movies.stream()
        .filter(movie -> movie.getLikes() > 10)
        .map(Movie::getTitle)
        .collect(Collectors.joining(", ")); // concatenates the titles of the movies

        System.out.println(joiningResult);

        var groupingResult = movies.stream()
        .collect(Collectors.groupingBy(
            Movie::getGenre, 
            Collectors.mapping(
                Movie::getTitle,
                Collectors.joining(", "))));

        System.out.println(groupingResult);
    }

    // Reducing Streams
    public static void reducingStreams() {
        var movies = List.of(new Movie("c", 10, Genre.COMEDY), 
        new Movie("a", 20, Genre.ACTION), 
        new Movie("b", 30, Genre.THRILLER));

        var sum = movies.stream()
        .map(Movie::getLikes)
        .reduce(0, Integer::sum);

        System.out.println(sum);
    }

    //Reducers
    public static void simpleReducers() {
        var movies = List.of(new Movie("c", 10, Genre.COMEDY), 
        new Movie("a", 20, Genre.ACTION), 
        new Movie("b", 30, Genre.THRILLER));

        System.out.println(movies.stream().allMatch(m -> m.getLikes() > 10));

        System.out.println(movies.stream().anyMatch(m -> m.getLikes() > 10));

        System.out.println(movies.stream().noneMatch(m -> m.getLikes() > 10));

        var result = movies.stream().
        max(Comparator.comparing(Movie::getLikes))
        .get();
        System.out.println(result.getTitle());
        

        // terminal operations anyMatch, allMatch, noneMatch, findFirst, findAny, max, min, count, sum, average, collect
    }

    //Peeking Elements
    public static void peekingElements() {
        var movies = List.of(new Movie("c", 10, Genre.COMEDY), 
        new Movie("a", 20, Genre.ACTION), 
        new Movie("b", 30, Genre.THRILLER));

        movies.stream()
        .filter(movie -> movie.getLikes() > 10) // filter out the movies that are not popular
        .peek(movie -> System.out.println("Filtered: " + movie.getTitle())) // print the title of the filtered movies
        .map(Movie::getTitle) // map the title of the movies
        .peek(title -> System.out.println("Mapped: " + title)) // print the title of the mapped movies
        .forEach(System.out::println);
    }

    //Getting distinct elements
    public static void gettingDistinctElements() {
        var movies = List.of(new Movie("c", 10, Genre.COMEDY), 
        new Movie("a", 20, Genre.ACTION), 
        new Movie("b", 30, Genre.THRILLER),
        new Movie("a", 20, Genre.ACTION));

        movies.stream()
        .map(Movie::getLikes) // map to the likes
        .distinct() // get distinct elements
        .forEach(System.out::println); // print each distinct like
    }

    //Slicing Streams
    public static void slicingStreams() {
        var movies = List.of(new Movie("c", 10, Genre.COMEDY), 
        new Movie("a", 30, Genre.ACTION), 
        new Movie("b", 20, Genre.THRILLER));

        movies.stream()
        .sorted(Comparator.comparing(Movie::getTitle).reversed()) 
        .forEach(movie -> System.out.println(movie.getTitle()));



        movies.stream()
        .dropWhile(movie -> movie.getLikes() < 30) // takes elements until the condition is false
        .forEach(movie -> System.out.println(movie.getTitle()));


        movies.stream()
        .limit(2)
        .forEach(movie -> System.out.println(movie.getTitle()));

        movies.stream()
        .skip(2)
        .forEach(movie -> System.out.println(movie.getTitle()));
    }

    //Filtering Elements
    public static void filteringElements() {
        var movies = List.of(new Movie("The Matrix", 100, Genre.ACTION), 
        new Movie("The Matrix Reloaded", 1000, Genre.ACTION), 
        new Movie("The Matrix Revolutions", 100, Genre.ACTION));

        Predicate<Movie> isPopular = movie -> movie.getLikes() > 100;
        movies.stream()
        .filter(isPopular) // iterate over the entire list and filter out the movies that are not popular
        .forEach(movie -> System.out.println(movie.getTitle()));

       // the stream methods fall into two categories:
       // Intermediate operations: return a stream so we can continue transforming our data to get what we want. -> filter, map, sorted, distinct
       // Terminal operations: return a result. -> forEach, reduce, collect, anyMatch, allMatch, noneMatch
    }

    //Mapping Elements
    public static void mappingElements() {
        var movies = List.of(new Movie("The Matrix", 100, Genre.ACTION), 
        new Movie("The Matrix Reloaded", 100, Genre.ACTION), 
        new Movie("The Matrix Revolutions", 100, Genre.ACTION));

        movies.stream()
        .mapToInt(Movie::getLikes)
        .forEach(System.out::println);

        movies.stream()
        .map(movie -> movie.getTitle())
        .forEach(name -> System.out.println(name));

        var stream =Stream.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
        /* stream
        .forEach(list -> System.out.println(list)); prints the list */

        // we can flatmap a stream of list of objects Stream<List<x>> to a stream of objects Stream<x>.
        stream.flatMap(list -> list.stream())
        .forEach(number -> System.out.println(number));
    }

    //Creating streams
    public static void creatingStreams() {
        var stream = Stream.generate(() -> Math.random());
        stream
        .limit(3)
        .forEach(System.out::println);

        Stream.iterate(1, n -> n + 1)
        .limit(10)
        .forEach(System.out::println);
    }

}
