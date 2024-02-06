package com.leila.HibernatePR.service;

import com.leila.HibernatePR.model.Associati;
import com.leila.HibernatePR.repo.RepositoryAssociati;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AssociatiService {

    @Autowired
    private final RepositoryAssociati associatiRepository;

    public AssociatiService(RepositoryAssociati associatiRepository) {
        this.associatiRepository = associatiRepository;
    }

    //getall
    public List<Associati> findAll() {
        return associatiRepository.findAll();
    }

    //getById
    public Associati findById(Integer id) {
        return associatiRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento non trovato"));
    }

    //post
    public void create(Associati associati) {
        associatiRepository.save(associati);
    }

    //putById ovviamente
    public void updateById(Associati associati, Integer id) {
        if(associatiRepository.existsById(id)) {
            associati.setId(id);
            associatiRepository.save(associati);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento non trovato");
        }
    }

    //deleteById
    public void deleteById(Integer id) {
        if(associatiRepository.existsById(id)) {
            associatiRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento non trovato");
        }
    }

}
