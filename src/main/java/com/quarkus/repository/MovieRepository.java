package com.quarkus.repository;

import com.quarkus.entity.Movie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {
//    public entity.Movie findByTitle(String title) {
//        return find("title", title).firstResult();
//    }
//
//    public List<entity.Movie> findByDirector(String director) {
//        return list("director", director);
//    }
//
//    public List<entity.Movie> findByCountry(String country) {
//        return list("country", country);
//    }
//
//    public List<entity.Movie> findByYear(Year year) {
//        return list(String.valueOf(year), year);
//    }
}
