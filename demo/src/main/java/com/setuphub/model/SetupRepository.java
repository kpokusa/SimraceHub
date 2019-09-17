package com.setuphub.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface SetupRepository extends CrudRepository <Setup, Long> {

   /* @Override
    List <Setup> findAll();

    @Override
    Optional <Setup> findById(Long id);

    @Override
    Setup save(Setup setup);

    @Override
    void deleteById(Long id);*/
}
