package com.jpa.example.model.dao;

import com.jpa.example.domain.PersistenceManager;
import com.jpa.example.model.E_Recette;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class RecetteJPACrudDAO implements CrudDAO<E_Recette> {

    EntityManagerFactory emf = PersistenceManager.getEmfInstance("pu_simpleRecette");


    @Override
    public E_Recette create(E_Recette element) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(element);
            et.commit();
        } catch(Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return element;
    }

    @Override
    public List<E_Recette> findAll() {
        return null;
    }

    @Override
    public Optional<E_Recette> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public E_Recette update(E_Recette element) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }


}
