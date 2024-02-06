package com.leila.HibernatePR.repo;

import com.leila.HibernatePR.model.Fornitori;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFornitori extends ListCrudRepository<Fornitori, Integer> {
}
