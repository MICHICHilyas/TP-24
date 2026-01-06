package com.example.appareil.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entité représentant une catégorie d'appareils domestiques.
 * Permet de regrouper les appareils par type (éclairage, chauffage, etc.).
 * @author Ilyas MICHICH
 * @version 1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {

    /** Identifiant unique de la catégorie */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** Libellé de la catégorie */
    private String label;

    /** Liste des appareils appartenant à cette catégorie */
    @OneToMany(targetEntity = Appareil.class , mappedBy = "categorie", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"categorie"})
    List<Appareil> appareilList;
}
