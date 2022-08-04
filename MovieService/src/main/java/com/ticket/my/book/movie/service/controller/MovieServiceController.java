package com.ticket.my.book.movie.service.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.my.book.movie.service.impl.MovieServiceImpl;
import com.ticket.my.book.movie.service.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieServiceController {
	
	@Autowired
	private MovieServiceImpl movieServiceImpl;
	
	@GetMapping("/trending/movies")
	public List<Movie> trendingMovieLists() {
		return movieServiceImpl.trendingMovieLists();
	}
	
	@GetMapping("/{movieId}")
	public Movie getMovieDescription(@PathVariable("movieId") long movieId) {
		return movieServiceImpl.getMovie(movieId);
	}
	
	@GetMapping("/genre/{genre}")
	public List<Movie> getMovieByGenre(@PathVariable("genre") String movieGenre) {
		return movieServiceImpl.getMovieListsByGenre(movieGenre);
	}
	
	@PostConstruct
	public void addData() {
		movieServiceImpl.addMovieData();
	}

}
