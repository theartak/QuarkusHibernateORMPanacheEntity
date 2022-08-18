package com.quarkus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie extends PanacheEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column
//    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String director;

    @Column
    private String country;

    @Column
    private String year;

    public Movie(Long id, String title, String description, String director, String country, String year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.director = director;
        this.country = country;
        this.year = year;
    }

    public Movie() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "entity.Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", country='" + country + '\'' +
                ", year=" + year +
                '}';
    }
}
