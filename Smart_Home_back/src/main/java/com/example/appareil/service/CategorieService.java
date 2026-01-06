package com.example.appareil.service;

import com.example.appareil.entity.Appareil;
import com.example.appareil.entity.Categorie;
import com.example.appareil.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service métier pour la gestion des catégories d'appareils.
 * Contient la logique métier pour les opérations CRUD sur les catégories.
 * @author Ilyas MICHICH
 * @version 1.0
 */
@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    /**
     * Récupère la liste de toutes les catégories.
     * @return la liste complète des catégories
     */
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    /**
     * Enregistre une nouvelle catégorie dans la base de données.
     * @param categorie la catégorie à enregistrer
     * @return la catégorie enregistrée avec son identifiant généré
     */
    public Categorie  save (Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    /**
     * Recherche une catégorie par son identifiant.
     * @param id l'identifiant de la catégorie recherchée
     * @return un Optional contenant la catégorie si elle existe
     */
    public Optional<Categorie> findById(Long id) {
        return categorieRepository.findById(id);
    }

    /**
     * Supprime une catégorie par son identifiant.
     * @param id l'identifiant de la catégorie à supprimer
     */
    public void deleteById(Long id) {
        categorieRepository.deleteById(id);
    }

    /**
     * Met à jour le libellé d'une catégorie existante.
     * @param id l'identifiant de la catégorie à mettre à jour
     * @param catInfo les nouvelles informations de la catégorie
     * @throws ResourceNotFoundException si la catégorie n'existe pas
     */
    public void update(Long id, Categorie catInfo) {
        // Recherche de la catégorie existante
        Categorie categorie=categorieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("cat not found with id " + id));
        categorie.setLabel(catInfo.getLabel());
        categorieRepository.save(categorie);
    }

}
