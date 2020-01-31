package com.jihene.parc.model.entity;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="PROJET")
public class Projet {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="NAME",length = 50)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
