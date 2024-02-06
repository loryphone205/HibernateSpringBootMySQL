package com.leila.HibernatePR.service;

import com.leila.HibernatePR.model.Clienti;
import com.leila.HibernatePR.repo.RepositoryClienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientiService {

    @Autowired
    private final RepositoryClienti clientiRepository;

    public ClientiService(RepositoryClienti clientiRepository) {
        this.clientiRepository = clientiRepository;
    }

    //getall
    public List<Clienti> findAll() {
        return clientiRepository.findAll();
    }

    //getById
    public Clienti findById(Integer id) {
        return clientiRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento non trovato"));
    }

    //post
    public void create(Clienti clienti) {
        clientiRepository.save(clienti);
    }

    //putById ovviamente
    public void updateById(Clienti clienti, Integer id) {
        if (clientiRepository.existsById(id)) {
            clienti.setId(id);
            clientiRepository.save(clienti);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento non trovato");
        }
    }

    //deleteById
    public void deleteById(Integer id) {
        if (clientiRepository.existsById(id)) {
            clientiRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento non trovato");
        }
    }

}
