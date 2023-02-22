package trivera.movie.data.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import trivera.movie.data.Movie;
import trivera.movie.data.MovieDataSource;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of Trivera
 * Technologies, LLC
 *
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 * 
 * 
 */
public class MovieDataSourceImpl implements MovieDataSource {
	private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("MM-dd-yyyy");

	private static MovieDataSourceImpl currentInstance;

	private List<Movie> movieData = new ArrayList<>();

	public static MovieDataSourceImpl getInstance() {
		if (currentInstance == null) {
			currentInstance = new MovieDataSourceImpl();

		}
		return currentInstance;
	}

	public List<Movie> getAllMoviesByTitle(String movieTitle) {
		return movieData.stream().filter(
				movie -> movie.getTitle() != null && movie.getTitle().toLowerCase().contains(movieTitle.toLowerCase()))
				.collect(Collectors.toList());
	}

	private Movie createObject(String data) {
		String[] fields = data.split(";");
		Movie movie = new Movie();
		movie.setId(Integer.parseInt(fields[0]));
		movie.setTitle(fields[1]);
		movie.setStudio(fields[2]);
		movie.setPrice(Double.parseDouble(fields[3]));
		movie.setRating(fields[4]);
		movie.setGenre(fields[5]);

		try {
			movie.setReleaseDate(DATE_TIME_FORMATTER.parse(fields[6]));
		} catch (ParseException e) {
			// ignore
		}

		return movie;

	}

	private MovieDataSourceImpl() {
		try (Stream<String> stream = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("movies.dat"))).lines();) {
			stream.forEach(line -> movieData.add(createObject(line)));
		}
	}
}
