package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table
public class Movie extends PanacheEntity {

    @Column
    public String title;

    @Column
    public String description;

    @Column
    public String director;

    @Column
    public String country;
}
