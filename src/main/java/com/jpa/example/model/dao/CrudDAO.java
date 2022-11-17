package com.jpa.example.model.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDAO<E> {

    E create(E element);

    List<E> findAll();
    Optional<E> findById(Long id);

    E update(E element);

    boolean delete(Long id);


}
