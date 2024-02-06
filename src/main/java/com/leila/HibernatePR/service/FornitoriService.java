package com.leila.HibernatePR.service;

import com.leila.HibernatePR.model.Fornitori;
import com.leila.HibernatePR.repo.RepositoryFornitori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FornitoriService {

    @Autowired
    private final RepositoryFornitori fornitoriRepository;

    public FornitoriService(RepositoryFornitori fornitoriRepository) {
        this.fornitoriRepository = fornitoriRepository;
    }

    //getall
    public List<Fornitori> findAll() {
        return fornitoriRepository.findAll();
    }

    //getById
    public Fornitori findById(Integer id) {
        return fornitoriRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento non trovato"));
    }

    //post
    public void create(Fornitori fornitori) {
        fornitoriRepository.save(fornitori);
    }

    //putById ovviamente
    public void updateById(Fornitori fornitori, Integer id) {
        if (fornitoriRepository.existsById(id)) {
            fornitori.setId(id);
            fornitoriRepository.save(fornitori);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento non trovato");
        }
    }

    //deleteById
    public void deleteById(Integer id) {
        if (fornitoriRepository.existsById(id)) {
            fornitoriRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento non trovato");
        }
    }

}
