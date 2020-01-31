package com.jihene.parc.model.dao;

import com.jihene.parc.model.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface projetRepository extends JpaRepository<Projet,Long> {
    List<Projet> findAll();
}
