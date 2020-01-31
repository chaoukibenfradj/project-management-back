package com.jihene.parc.services;

import com.jihene.parc.model.dao.projetRepository;
import com.jihene.parc.model.entity.Projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceProjet implements ServiceProjetInterface {
    
	@Autowired
    private projetRepository projet;

    @Override
    public List findAll() {
        return projet.findAll();
    }

	@Override
	public Projet findProject(String id) {
		return projet.findById(Long.parseLong(id)).get() ;
	}

	@Override
	public Projet updateProject(Projet pr) {
		return projet.save(pr) ;
	}

	@Override
	public void deleteProject(String id) {
		projet.deleteById(Long.parseLong(id));
	}

	@Override
	public Projet addProjet(Projet prj) {
		return projet.save(prj); 
	}
    
    
}
