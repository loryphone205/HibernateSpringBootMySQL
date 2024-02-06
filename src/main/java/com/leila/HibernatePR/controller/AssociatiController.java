package com.leila.HibernatePR.controller;

import com.leila.HibernatePR.model.Associati;
import com.leila.HibernatePR.service.AssociatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/associati")
@CrossOrigin
public class AssociatiController {

    @Autowired
    private final AssociatiService associatiService;

    public AssociatiController(AssociatiService associatiService) {
        this.associatiService = associatiService;
    }

    //getById
    @GetMapping("/{id}")
    public Associati findById(@PathVariable Integer id) {
        return associatiService.findById(id);
    }

    //getall
    @GetMapping("")
    public List<Associati> findAll() {
        return associatiService.findAll();
    }

    //post
    @PostMapping("")
    public void create(@RequestBody Associati associati) {
        associatiService.create(associati);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Associati associati, @PathVariable Integer id) {
        associatiService.updateById(associati, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        associatiService.deleteById(id);
    }

}
