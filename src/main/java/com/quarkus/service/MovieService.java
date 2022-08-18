package com.quarkus.service;

import com.quarkus.model.Movie;
import com.quarkus.repository.MovieRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MovieService {
    @Inject
    MovieRepository movieRepository;

    public long count() {
        return movieRepository.count();
    }

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Response getMovieByID(@PathParam("id") Long id) {
        var successful = false;
        var movie = movieRepository.findByIdOptional(id);
        if (movie.isPresent()) {
            successful = true;
        }
        return successful ? Response.ok(movie.get()).build() :
                Response.status(Response.Status.BAD_REQUEST).build();
    }

    public Response getMovieByTitle(@PathParam("title") String title) {
        return Movie.find("title", title)
                .singleResultOptional()
                .map(movie -> Response.ok(movie).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    public Response getMovieByDirector(@PathParam("director") String director) {
        return Movie.find("director", director)
                .singleResultOptional()
                .map(movie -> Response.ok(movie).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    public Response getMovieByCountry(@PathParam("country") String country) {
        return Movie.find("country", country)
                .singleResultOptional()
                .map(movie -> Response.ok(movie).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    public Response getMovieByYear(@PathParam("year") String year) {
        return Movie.find("year", year)
                .singleResultOptional()
                .map(movie -> Response.ok(movie).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    public Response getAllMovies() {
        List<Movie> all = movieRepository.listAll();
        return Response.ok(all).build();
    }

    @Transactional
    public Response createMovie(Movie movie) {
        Movie.persist(movie);
        if (movie.isPersistent()) {
            return Response.created(URI.create("/movies" + movie.id)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @Transactional
    public Response deleteMovieById(@QueryParam("id") Long id) {
        var successful = false;
        Optional<Movie> movie = movieRepository.findByIdOptional(id);
        if (movie.isPresent()) {
            successful = movieRepository.deleteById(id);
        }
        return successful ? Response.ok(movie.get()).build() :
                Response.status(Response.Status.BAD_REQUEST).build();
    }
}
