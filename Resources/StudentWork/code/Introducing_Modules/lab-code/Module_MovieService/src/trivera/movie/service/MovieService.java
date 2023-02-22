package trivera.movie.service;

import java.util.List;

import trivera.movie.data.Movie;
import trivera.movie.service.impl.MovieServiceImpl;

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
public interface MovieService {

	static MovieService getDefaultService() {
		return new MovieServiceImpl();
	}

	List<Movie> searchMoviesByTitle(String searchTitle);
}
