package com.leila.HibernatePR.repo;

import com.leila.HibernatePR.model.Associati;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAssociati extends ListCrudRepository<Associati, Integer> {
}
