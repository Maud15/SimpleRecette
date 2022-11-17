package com.jpa.example.model.dao;

import com.jpa.example.domain.PersistenceManager;
import com.jpa.example.model.E_Recette;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
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
        List<E_Recette> recipeList = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        try {
            recipeList = em.createQuery("from E_Recette", E_Recette.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ( em != null ) em.close();
        }
        return recipeList;
    }

    @Override
    public Optional<E_Recette> findById(Long recipeId) {
        Optional<E_Recette> optRecipe = Optional.empty();
        EntityManager em = emf.createEntityManager();
        try {
            optRecipe = Optional.of(em.find(E_Recette.class, recipeId));
        } catch(EntityNotFoundException e) {
            System.out.println("Aucune recette trouvée avec l'ID " + recipeId);
            e.printStackTrace();
        }
        return optRecipe;
    }

    @Override
    public E_Recette update(E_Recette recipeChanged) {
        E_Recette recipeResult = null;
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            recipeResult = em.merge(recipeChanged);
            et.commit();
        } catch(Exception e) {
            et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return recipeResult;
    }

    @Override
    public boolean delete(Long idRecipe) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Optional<E_Recette> optRecipeToDelete = findById(idRecipe);
            E_Recette recipeToDelete;
            if (optRecipeToDelete.isPresent()){
                recipeToDelete = optRecipeToDelete.get();
            } else {
                throw new Exception("Impossible de trouver la recette d'id " + idRecipe);
            }
            em.remove(recipeToDelete);
            et.commit();
        } catch(Exception e) {
            e.printStackTrace();
            if (et.isActive()) { et.rollback(); }
        } finally {
            em.close();
        }
        return true;
    }


}
