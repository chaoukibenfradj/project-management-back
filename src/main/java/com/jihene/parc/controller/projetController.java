package com.jihene.parc.controller;

import com.jihene.parc.model.entity.Projet;
import com.jihene.parc.modele.security.User;
import com.jihene.parc.security.repository.UserRepository;
import com.jihene.parc.services.ServiceProjet;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/admin")
@CrossOrigin(origins = "*")
public class projetController {
    @Autowired
    private ServiceProjet sp;
    
    @Autowired
    private UserRepository userRepo ;
    
    
    
    List<Projet> list;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    //List
    @RequestMapping(value = "/projet", method = RequestMethod.GET)
    List<Projet> listeProjet() {
        logger.info("processing authentication for '{}'", "list articles");
        list = sp.findAll();
        if(list!=null) {
            return list;
        }
        else
        {
            logger.info("processing authentication for '{}'", "null list  articles ");
            return null;
        }
    }
    
    
    @RequestMapping(value = "/user/dev", method = RequestMethod.GET)
    List<User> listeUsers() {
        logger.info("Getting list of developers");
        return userRepo.findAll().stream().filter(element-> element.getPoste()!=null && element.getPoste().equals("dev")).collect(Collectors.toList());   
    }
    
    @RequestMapping(value = "/projet/{id}", method = RequestMethod.GET)
    Projet getProjetById(@PathVariable String id) {
        return sp.findProject(id) ;
    }
    
    @RequestMapping(value = "/projet", method = RequestMethod.PUT)
    Projet updateProject(@RequestBody Projet projet) {
        return sp.updateProject(projet); 
    }
    
    @RequestMapping(value = "/projet", method = RequestMethod.POST)
    Projet addProject(@RequestBody Projet projet) {
        return sp.addProjet(projet); 
    }
    
    @RequestMapping(value = "/projet/{id}", method = RequestMethod.DELETE)
    void deleteProject(@PathVariable String id) {
        sp.deleteProject(id);
    }
    
    
}
