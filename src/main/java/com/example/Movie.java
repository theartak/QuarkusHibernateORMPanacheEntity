package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table
public class Movie extends PanacheEntity {

    @Column(length = 100)
    public String title;

    @Column(length = 200)
    public String description;

    @Column
    public String director;

    @Column
    public String country;
}
