package com.leila.HibernatePR.controller;

import com.leila.HibernatePR.model.Fornitori;
import com.leila.HibernatePR.service.FornitoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornitori")
@CrossOrigin
public class FornitoriController {
    @Autowired
    private final FornitoriService fornitoriService;

    public FornitoriController(FornitoriService fornitoriService) {
        this.fornitoriService = fornitoriService;
    }

    //getById
    @GetMapping("/{id}")
    public Fornitori findById(@PathVariable Integer id) {
        return fornitoriService.findById(id);
    }

    //getall
    @GetMapping("")
    public List<Fornitori> findAll() {
        return fornitoriService.findAll();
    }

    //post
    @PostMapping("")
    public void create(@RequestBody Fornitori fornitori) {
        fornitoriService.create(fornitori);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Fornitori fornitori, @PathVariable Integer id) {
        fornitoriService.updateById(fornitori, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        fornitoriService.deleteById(id);
    }
}

