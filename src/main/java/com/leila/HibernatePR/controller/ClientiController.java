package com.leila.HibernatePR.controller;

import com.leila.HibernatePR.model.Clienti;
import com.leila.HibernatePR.service.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clienti")
@CrossOrigin
public class ClientiController {
    @Autowired
    private final ClientiService clientiService;

    public ClientiController(ClientiService clientiService) {
        this.clientiService = clientiService;
    }

    //getById
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}")
    public Clienti findById(@PathVariable Integer id) {
        return clientiService.findById(id);
    }

    //getall
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("")
    public List<Clienti> findAll() {
        return clientiService.findAll();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Clienti clienti) {
        clientiService.create(clienti);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public void update(@RequestBody Clienti clienti, @PathVariable Integer id) {
        clientiService.updateById(clienti, id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        clientiService.deleteById(id);
    }
}
