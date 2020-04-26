package com.codewithmosh.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsDemo {
  public static void show() {

    List<Movie> movies = List.of(
            new Movie("a",1,Genre.ACTION),
            new Movie("b",10,Genre.ACTION),
            new Movie("c",8,Genre.ACTION),
            new Movie("d",15,Genre.ACTION),
            new Movie("e",22,Genre.ACTION),
            new Movie("f",7,Genre.ACTION)
    );


    var likedMovies = movies.stream().filter(getMoviePredicate(10));

    var infiniteRandoms = Stream.generate(Math::random);


    System.out.println("number of streams");
    var howMany = infiniteRandoms.limit(10).count();
    System.out.println(howMany);


    var randoms = Stream.generate(Math::random);
    var bigRandoms = randoms.filter(x -> x > 3);
    System.out.println("dnoe: " + bigRandoms.count());
    System.out.println("finished");

  }

  private static Predicate<Movie> getMoviePredicate(int greaterThan) {
    return x -> x.getLikes() > greaterThan;
  }

}
