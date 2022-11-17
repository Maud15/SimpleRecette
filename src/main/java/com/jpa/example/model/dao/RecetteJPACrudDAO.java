package com.jpa.example.model.dao;

import com.jpa.example.model.E_Recette;

import java.util.List;
import java.util.Optional;

public class RecetteJPACrudDAO implements CrudDAO<E_Recette> {


    @Override
    public List<E_Recette> findAll() {
        return null;
    }

    @Override
    public Optional<E_Recette> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public E_Recette update(E_Recette element) {
        return null;
    }

    @Override
    public E_Recette create(E_Recette element) {
        return null;
    }
}
