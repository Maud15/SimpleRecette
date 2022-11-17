package com.jpa.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ingredient")
public class E_Ingredient {

    @Id
    @Column(name = "id_ingredient")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ingredientId;

    @Column(name = "nom_ingredient", nullable = false)
    private String ingredientName;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "recette_ingredient",
            joinColumns = @JoinColumn(name = "id_ingredient"),
            inverseJoinColumns = @JoinColumn(name = "id_recette")
    )
    private List<E_Recette> recettes;

    public E_Ingredient() {
    }

    public Long getIngredientId() {
        return ingredientId;
    }
    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public List<E_Recette> getRecettes() {
        return recettes;
    }
    public void setRecettes(List<E_Recette> recettes) {
        this.recettes = recettes;
    }

}
