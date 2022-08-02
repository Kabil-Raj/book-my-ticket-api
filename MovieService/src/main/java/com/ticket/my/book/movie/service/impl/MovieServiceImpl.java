package com.ticket.my.book.movie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.my.book.movie.service.model.Movie;
import com.ticket.my.book.movie.service.repository.MovieServiceRespository;

@Service
public class MovieServiceImpl {
	
	@Autowired
	private MovieServiceRespository movieServiceRepo;

	public List<Movie> trendingMovieLists() {
		return movieServiceRepo.findTrendingMovies();
	}

	public Movie getMovie(long movieId) {
		return movieServiceRepo.findById(movieId).get();
	}

	public void bookTicket(String userName, String movieName, int noOfTickets) {
		
	}

	public List<Movie> getMovieListsByGenre(String movieGenre) {
		return movieServiceRepo.findByMovieGenere(movieGenre);
	}

	public void addMovieData() {
		List<Movie> movie = new ArrayList<Movie>();
		movie.add(Movie.builder().name("Avenger: End Game").description("After Thanos, an intergalactic warlord, "
				+ "disintegrates half of the universe, the Avengers must reunite and assemble again to "
				+ "reinvigorate their trounced allies and restore balance.").year(2019)
				.rating(8.6).genre("Action & Adventure").build());
		movie.add(Movie.builder().name("Gargi").description("Gargi is a 2022 Indian Tamil-language legal drama film written by "
				+ "Hariharan Raju and Gautham Ramachandran, directed by Gautham Ramachandran and "
				+ "produced by Blacky, Genie & My Left Foot Productions with Sai Pallavi and Kaali "
				+ "Venkat in the lead role")
				.rating(9.5).year(2022).genre("Drama").build());
		movie.add(Movie.builder().name("Rocketry").description("East Indian aerospace engineer Nambi Narayanan "
				+ "makes enemies due to his genius and obsession, "
				+ "and he faces charges of espionage.")
				.rating(9.5).year(2022).genre("Drama").build());
		movie.add(Movie.builder().name("Thor: Love & Thunder").description("Thor embarks on a journey unlike "
				+ "anything he's ever faced -- a quest for inner peace. However, his retirement gets "
				+ "interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods")
				.rating(7.2).year(2022).genre("Action & Adventure").build());
		movie.add(Movie.builder().name("Interstellar").description("When Earth becomes uninhabitable in the future, "
				+ "a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.")
				.rating(8.5).year(2014).genre("Sci-fi").build());
		movie.add(Movie.builder().name("Twilight").description("When Bella Swan relocates to Forks, Washington, "
				+ "to live with her father, she meets a mysterious boy, Edward Cullen, and gets drawn to him. Later, she discovers that he is a vampire.")
				.rating(6.5).year(2009).genre("Romance").build());
		
		movie.add(Movie.builder().name("Avenger: Ultron").description("After Thanos, an intergalactic warlord, "
				+ "disintegrates half of the universe, the Avengers must reunite and assemble again to "
				+ "reinvigorate their trounced allies and restore balance.").year(2016)
				.rating(7.7).genre("Action").build());
		movie.add(Movie.builder().name("Jai Bhim").description("Gargi is a 2022 Indian Tamil-language legal drama film written by "
				+ "Hariharan Raju and Gautham Ramachandran, directed by Gautham Ramachandran and "
				+ "produced by Blacky, Genie & My Left Foot Productions with Sai Pallavi and Kaali "
				+ "Venkat in the lead role")
				.rating(9.5).year(2021).genre("Drama").build());
		movie.add(Movie.builder().name("Oh my Kadavulae").description("East Indian aerospace engineer Nambi Narayanan "
				+ "makes enemies due to his genius and obsession, "
				+ "and he faces charges of espionage.")
				.rating(7.1).year(2019).genre("Romance").build());
		movie.add(Movie.builder().name("Spiderman - No Way Home").description("Thor embarks on a journey unlike "
				+ "anything he's ever faced -- a quest for inner peace. However, his retirement gets "
				+ "interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods")
				.rating(7.6).year(2021).genre("Action").build());
		movie.add(Movie.builder().name("Tenet").description("When Earth becomes uninhabitable in the future, "
				+ "a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.")
				.rating(8.5).year(2020).genre("Sci-fi").build());
		movie.add(Movie.builder().name("Benjamin Button").description("When Bella Swan relocates to Forks, Washington, "
				+ "to live with her father, she meets a mysterious boy, Edward Cullen, and gets drawn to him. Later, she discovers that he is a vampire.")
				.rating(8.6).year(2008).genre("Romance & Drama").build());
		
		for (Movie mov : movie) {
			movieServiceRepo.save(mov);
		}
		
		
	}
	
	
	
	


}
