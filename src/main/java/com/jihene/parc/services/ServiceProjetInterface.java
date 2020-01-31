package com.jihene.parc.services;

import com.jihene.parc.model.entity.Projet;

import java.util.List;

public interface ServiceProjetInterface {
    List findAll();
    Projet findProject(String id);
    Projet updateProject(Projet projet);
    void deleteProject(String id) ; 
    Projet addProjet(Projet prj);
}
