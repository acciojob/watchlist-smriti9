package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> moviemap= new HashMap<>();
    HashMap<String,Director> directormap= new HashMap<>();
    HashMap<String, List<String>> movieDirectormap= new HashMap<>();
   void saveMovie(Movie movie)
   {
       moviemap.put(movie.getName(),movie);
   }

    void saveDirector(Director director)
    {
        directormap.put(director.getName(),director);
    }
    Movie getMovieByName(String movieName)
    {
        return moviemap.get(movieName);
    }
    Director getDirectorByName(String directorName)
    {
        return directormap.get(directorName);
    }

    List<String> getMoviesByDirectorName(String directorName)
    {
        return movieDirectormap.get(directorName);
    }
   void addMovieDirectorPair(String movieName,String directorName)
   {
       if(moviemap.containsKey(movieName) && directormap.containsKey(directorName)) {
           List<String> movies = new ArrayList<>();
           movies=movieDirectormap.get(directorName);
           movies.add(movieName);
           movieDirectormap.put(movieName,movies);
       }
   }
   List<String> findAllMovies()
    {
        List<String> allMovies = new ArrayList<>();
        for(String movie: moviemap.keySet())
            allMovies.add(movie);
        return allMovies;
    }

    void deleteDirectorByName(String directorName)
    {
        List<String> movies = new ArrayList<>();
        movies=movieDirectormap.get(directorName);
        for(String movie: movies)
        {
            moviemap.remove(movie);
        }
        if(movieDirectormap.containsKey(directorName))
        movieDirectormap.remove(directorName);
        if(directormap.containsKey(directorName))
        directormap.remove(directorName);
    }
    void deleteAllDirectors()
    {
        for(String directors: directormap.keySet())
        {
            deleteDirectorByName(directors);
        }

    }
}
