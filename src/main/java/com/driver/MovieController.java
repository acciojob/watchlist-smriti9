package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
 @Autowired
 MovieService movieService;

 @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
 {
     movieService.addMovie(movie);
     return new ResponseEntity<>("New movie added Successfully", HttpStatus.CREATED);
 }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added Successfully", HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-Pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName)
    {
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("New director and movie pair added Successfully", HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
    {
        Movie movie=movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
    {
        Director director=movieService.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name)
    {
        List<String> movies=movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String> allMovies=movieService.findAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.CREATED);
    }
    @DeleteMapping("delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName)
    {
        deleteDirectorByName(directorName);
        return new ResponseEntity<>("deleted successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        deleteAllDirectors();
        return new ResponseEntity<>("deleted all directors successfully",HttpStatus.CREATED);
    }
}
