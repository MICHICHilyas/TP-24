package com.example.appareil.cotroller;

import com.example.appareil.entity.Categorie;
import com.example.appareil.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour la gestion des catégories d'appareils.
 * Expose les endpoints API pour les opérations CRUD sur les catégories.
 * @author Ilyas MICHICH
 * @version 1.0
 */
@RestController
@RequestMapping("/api/controller/categorie")
@CrossOrigin
public class CategorieController {


    @Autowired
    private CategorieService categorieService;

    /**
     * Récupère la liste de toutes les catégories.
     * @return la liste complète des catégories
     */
    @GetMapping("/")
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }

    /**
     * Crée une nouvelle catégorie.
     * @param categorie la catégorie à créer
     * @return la catégorie créée avec son identifiant
     */
    @PostMapping("/")
    public Categorie save(@RequestBody Categorie categorie) {
        return categorieService.save(categorie);
    }


    /**
     * Récupère une catégorie par son identifiant.
     * @param id l'identifiant de la catégorie
     * @return la catégorie correspondante si elle existe
     */
    @GetMapping("/id/{id}")
    public Optional<Categorie> findById(@PathVariable Long id) {
        return categorieService.findById(id);
    }

    /**
     * Supprime une catégorie par son identifiant.
     * @param id l'identifiant de la catégorie à supprimer
     */
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        categorieService.deleteById(id);
    }


    /**
     * Met à jour le libellé d'une catégorie.
     * @param id l'identifiant de la catégorie à mettre à jour
     * @param catInfo les nouvelles informations de la catégorie
     */
    @PutMapping("/id/{id}")
    public void update(@PathVariable Long id,@RequestBody Categorie catInfo) {
        categorieService.update(id, catInfo);
    }


}
