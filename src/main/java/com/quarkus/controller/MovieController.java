package com.quarkus.controller;

import com.quarkus.service.MovieService;
import com.quarkus.model.Movie;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/movies")
public class MovieController {
    @Inject
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public long count() {
        return movieService.count();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    @Transactional
    public Response getMovieByID(@PathParam("id") Long id) {
        return movieService.getMovieByID(id);
    }

    @GET
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMovieByTitle(@PathParam("title") String title) {
        return movieService.getMovieByTitle(title);
    }

    @GET
    @Path("/{director}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMovieByDirector(@PathParam("director") String director) {
        return movieService.getMovieByDirector(director);
    }

    @GET
    @Path("/{country}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMovieByCountry(@PathParam("country") String country) {
        return movieService.getMovieByCountry(country);
    }

    @GET
    @Path("/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getMovieByYear(@PathParam("year") String year) {
        return movieService.getMovieByYear(year);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllMovies() {
        return movieService.getAllMovies();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMovie(Movie movie) {
        return movieService.createMovie(movie);
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMovieByID(@QueryParam("id") Long id) {
        return movieService.deleteMovieById(id);
    }
}