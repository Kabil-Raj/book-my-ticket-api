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
	

	public List<Movie> getMovieListsByGenre(String movieGenre) {
		return movieServiceRepo.findByMovieGenere(movieGenre);
	}

	public void addMovieData() {
		List<Movie> movie = new ArrayList<Movie>();
		movie.add(Movie.builder().name("Avenger: End Game").description("After Thanos, an intergalactic warlord, "
				+ "disintegrates half of the universe, the Avengers must reunite and assemble again to "
				+ "reinvigorate their trounced allies and restore balance.").year(2019).image("https://terrigen-cdn-dev.marvel.com/content/prod/1x/ae_digital_packshot.jpg")
				.rating(8.6).genre("Action & Adventure").build());
		movie.add(Movie.builder().name("Gargi").description("Gargi is a 2022 Indian Tamil-language legal drama film written by "
				+ "Hariharan Raju and Gautham Ramachandran, directed by Gautham Ramachandran and "
				+ "produced by Blacky, Genie & My Left Foot Productions with Sai Pallavi and Kaali "
				+ "Venkat in the lead role").image("https://m.media-amazon.com/images/M/MV5BYTc2YmQwYzctNDNkMy00ZWNhLWJjODktOWM4YWRhMDZhMmI1XkEyXkFqcGdeQXVyMjYwMjMwMzk@._V1_.jpg")
				.rating(9.5).year(2022).genre("Drama").build());
		movie.add(Movie.builder().name("Rocketry").description("East Indian aerospace engineer Nambi Narayanan "
				+ "makes enemies due to his genius and obsession, "
				+ "and he faces charges of espionage.").image("https://m.media-amazon.com/images/M/MV5BMjNjNWUxMjUtMTBkMC00NTNlLTg0NTctZmJmMDYzMTMwMWQwXkEyXkFqcGdeQXVyOTI3MzI4MzA@._V1_.jpg")
				.rating(9.5).year(2022).genre("Drama").build());
		movie.add(Movie.builder().name("Thor: Love & Thunder").description("Thor embarks on a journey unlike "
				+ "anything he's ever faced -- a quest for inner peace. However, his retirement gets "
				+ "interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods").image("https://pbs.twimg.com/media/FTe6Z_MVEAArAVK?format=jpg&name=medium")
				.rating(7.2).year(2022).genre("Action & Adventure").build());
		movie.add(Movie.builder().name("Interstellar").description("When Earth becomes uninhabitable in the future, "
				+ "a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.").image("https://i.pinimg.com/550x/f5/e0/dc/f5e0dcdce40a6a2d516112a6048b2f44.jpg")
				.rating(8.5).year(2014).genre("Sci-fi").build());
		movie.add(Movie.builder().name("Twilight").description("When Bella Swan relocates to Forks, Washington, "
				+ "to live with her father, she meets a mysterious boy, Edward Cullen, and gets drawn to him. Later, she discovers that he is a vampire.").image("https://www.moviehdwallpapers.com/wp-content/uploads/2013/02/Twilight-2008-Poster.jpg")
				.rating(6.5).year(2009).genre("Romance").build());
		
		movie.add(Movie.builder().name("Avenger: Ultron").description("After Thanos, an intergalactic warlord, "
				+ "disintegrates half of the universe, the Avengers must reunite and assemble again to "
				+ "reinvigorate their trounced allies and restore balance.").year(2016).image("https://terrigen-cdn-dev.marvel.com/content/prod/1x/avengersageofultron_lob_crd_03.jpg")
				.rating(7.7).genre("Action").build());
		movie.add(Movie.builder().name("Jai Bhim").description("Gargi is a 2022 Indian Tamil-language legal drama film written by "
				+ "Hariharan Raju and Gautham Ramachandran, directed by Gautham Ramachandran and "
				+ "produced by Blacky, Genie & My Left Foot Productions with Sai Pallavi and Kaali "
				+ "Venkat in the lead role").image("https://moviegalleri.net/wp-content/gallery/jai-bhim-first-look/Hero-Suriya-Jai-Bhim-Movie-HD-First-Look-HD-Poster.jpg")
				.rating(9.5).year(2021).genre("Drama").build());
		movie.add(Movie.builder().name("Oh my Kadavulae").description("East Indian aerospace engineer Nambi Narayanan "
				+ "makes enemies due to his genius and obsession, "
				+ "and he faces charges of espionage.").image("https://m.media-amazon.com/images/M/MV5BMWNiMGI4ZmUtNDYzYi00Nzc0LWIzNDUtNDQ0NDYwNzM5NmIwXkEyXkFqcGdeQXVyMTEwNjA3NjE1._V1_.jpg")
				.rating(7.1).year(2019).genre("Romance").build());
		movie.add(Movie.builder().name("Spiderman - No Way Home").description("Thor embarks on a journey unlike "
				+ "anything he's ever faced -- a quest for inner peace. However, his retirement gets "
				+ "interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods").image("https://juet.in/wp-content/uploads/2021/12/spiderman3.jpg")
				.rating(7.6).year(2021).genre("Action").build());
		movie.add(Movie.builder().name("Tenet").description("When Earth becomes uninhabitable in the future, "
				+ "a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.").image("https://picfiles.alphacoders.com/327/thumb-327263.jpg")
				.rating(8.5).year(2020).genre("Sci-fi").build());
		movie.add(Movie.builder().name("Benjamin Button").description("When Bella Swan relocates to Forks, Washington, "
				+ "to live with her father, she meets a mysterious boy, Edward Cullen, and gets drawn to him. Later, she discovers that he is a vampire.").image("https://i.pinimg.com/originals/54/c1/c8/54c1c8c01bb29ec853b7da853baf6e1f.jpg")
				.rating(8.6).year(2008).genre("Romance & Drama").build());
		
		for (Movie mov : movie) {
			movieServiceRepo.save(mov);
		}
		
	}
	
	
	
	


}
