package com.bmdb.web;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.Movie;

@RestController
@RequestMapping("/bmdb")
public class BmdbController {
	
	private List<Movie> movies = new ArrayList<>();
	
	// Get all movies (select * - no filter)
	@GetMapping("/")
	public List<Movie> testBmdb() {
		return movies;
	}
	
	// Gets a Movie object based on a movie id
	@GetMapping("{id}")
	public Movie getMovieById(@PathVariable int id) {
		Movie m = null;
		for (Movie movie: movies) {
			if(movie.getId() == id) {
				m = movie;
			}
		}
		return m;
	}
	
	// Creates a new movie and adds it to the movies arraylist
	@PostMapping("")
	public Movie createMovie(@RequestParam int id, @RequestParam String title, @RequestParam int year, @RequestParam String rating, @RequestParam String director) {
		Movie movie = new Movie(id, title, year, rating, director);
		movies.add(movie);
		return movie;
	}
	
	// Deletes a movie from the movies arraylist based on movie id
	@DeleteMapping("{id}")
	public Movie deleteMovie(@PathVariable int id) {
		Movie m = null;
		for (Movie movie: movies) {
			if(movie.getId() == id) {
				m = movie;
				movies.remove(movie);
			}
		}
		return m;
	}
	
}
