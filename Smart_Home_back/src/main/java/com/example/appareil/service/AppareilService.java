package com.example.appareil.service;

import com.example.appareil.entity.Appareil;
import com.example.appareil.entity.Categorie;
import com.example.appareil.repository.AppareilRepository;
import com.example.appareil.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service métier pour la gestion des appareils domestiques.
 * Contient la logique métier pour les opérations CRUD sur les appareils.
 * @author Ilyas MICHICH
 * @version 1.0
 */
@Service
public class AppareilService {


    @Autowired
    private AppareilRepository appareilRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    /**
     * Enregistre un nouvel appareil dans la base de données.
     * Vérifie que la catégorie associée existe avant l'enregistrement.
     * @param appareil l'appareil à enregistrer
     * @return l'appareil enregistré avec son identifiant généré
     * @throws RuntimeException si la catégorie n'existe pas
     */
    public Appareil save(Appareil appareil) {
        // Vérification de l'existence de la catégorie
        Optional<Categorie> categorie = categorieRepository.findById(appareil.getCategorie().getId());
        if (categorie.isEmpty()) {
            throw new RuntimeException("Category not found.");
        }
        appareil.setCategorie(categorie.get());
        return appareilRepository.save(appareil);
    }

    /**
     * Recherche un appareil par son identifiant.
     * @param id l'identifiant de l'appareil recherché
     * @return un Optional contenant l'appareil s'il existe
     */
    public Optional<Appareil> findById(Long id) {
        return appareilRepository.findById(id);
    }

    /**
     * Supprime un appareil par son identifiant.
     * @param id l'identifiant de l'appareil à supprimer
     */
    public void deleteById(Long id) {
        appareilRepository.deleteById(id);
    }

    /**
     * Récupère la liste de tous les appareils.
     * @return la liste complète des appareils
     */
    public List<Appareil> findAll() {
        return appareilRepository.findAll();
    }

    /**
     * Met à jour l'état d'un appareil existant.
     * @param id l'identifiant de l'appareil à mettre à jour
     * @param appInfo les nouvelles informations de l'appareil
     * @throws ResourceNotFoundException si l'appareil n'existe pas
     */
    public void update(Long id, Appareil appInfo) {
        // Recherche de l'appareil existant
        Appareil appareil = appareilRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("app not found with id " + id));
        appareil.setState(appInfo.isState());
        appareilRepository.save(appareil);
    }

    /**
     * Met à jour l'état de tous les appareils.
     * Permet d'allumer ou éteindre tous les appareils en une seule opération.
     * @param state le nouvel état à appliquer à tous les appareils
     */
    public void updateAll(boolean state) {
        // Récupération de tous les appareils
        List<Appareil> appareilList = appareilRepository.findAll();
        // Mise à jour de l'état de chaque appareil
        appareilList.forEach(s -> s.setState(state));
        appareilRepository.saveAll(appareilList);
    }
}
