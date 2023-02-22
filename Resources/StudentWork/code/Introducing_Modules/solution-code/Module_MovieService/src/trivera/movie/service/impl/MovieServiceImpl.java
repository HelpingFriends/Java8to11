package trivera.movie.service.impl;

import java.util.Comparator;
import java.util.List;

import trivera.movie.data.Movie;
import trivera.movie.data.MovieDataSource;
import trivera.movie.service.MovieService;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Group, Inc.
 *
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 * 
 * </p>
 * 
 * 
 */
public class MovieServiceImpl implements MovieService {

	private MovieDataSource dataSource = MovieDataSource.getInstance();

	@Override
	public List<Movie> searchMoviesByTitle(String searchTitle) {
		List<Movie> allMoviesByTitle = dataSource.getAllMoviesByTitle(searchTitle);

		Comparator<Movie> studioComparator = Comparator.comparing(Movie::getStudio);
		Comparator<Movie> titleComparator = Comparator.comparing(Movie::getTitle);
		Comparator<Movie> combined = studioComparator.thenComparing(titleComparator);
		allMoviesByTitle.sort(combined);

		return allMoviesByTitle;
	}

}
