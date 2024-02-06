package com.leila.HibernatePR.repo;

import com.leila.HibernatePR.model.Clienti;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClienti extends ListCrudRepository<Clienti, Integer> {
}
