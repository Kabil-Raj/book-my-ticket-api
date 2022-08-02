package com.ticket.my.book.movie.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ticket.my.book.movie.service.model.Movie;

public interface MovieServiceRespository extends JpaRepository<Movie, Long>{

	@Query(value = "select * from movie where movie_name like %?1%", nativeQuery = true)
	Movie findByMovieName(String movieName);

	@Query(value = "select * from movie  ",nativeQuery = true)
	List<Movie> findByMovieGenere(String movieGenere);

	@Query(value = "select * from movie order by rating desc limit 8 ",nativeQuery = true)
	List<Movie> findTrendingMovies();
	
//	where genre like %?1%

}
