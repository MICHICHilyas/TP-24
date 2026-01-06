package com.example.appareil.cotroller;

import com.example.appareil.entity.Appareil;
import com.example.appareil.service.AppareilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Contrôleur REST pour la gestion des appareils domestiques.
 * Expose les endpoints API pour les opérations CRUD sur les appareils.
 * @author Ilyas MICHICH
 * @version 1.0
 */
@RestController
@RequestMapping("/api/controller/appareil")
@CrossOrigin
public class AppareilController {


    @Autowired
    private AppareilService appareilService;

    /**
     * Crée un nouvel appareil.
     * @param appareil l'appareil à créer
     * @return l'appareil créé avec son identifiant
     */
    @PostMapping("/")
    public Appareil save(@RequestBody Appareil appareil) {
        return appareilService.save(appareil);
    }

    /**
     * Récupère un appareil par son identifiant.
     * @param id l'identifiant de l'appareil
     * @return l'appareil correspondant s'il existe
     */
    @GetMapping("/id/{id}")
    public Optional<Appareil> findById(@PathVariable Long id) {
        return appareilService.findById(id);
    }

    /**
     * Supprime un appareil par son identifiant.
     * @param id l'identifiant de l'appareil à supprimer
     */
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        appareilService.deleteById(id);
    }

    /**
     * Récupère la liste de tous les appareils.
     * @return la liste complète des appareils
     */
    @GetMapping("/")
    public List<Appareil> findAll() {
        return appareilService.findAll();
    }


    /**
     * Met à jour l'état d'un appareil.
     * @param id l'identifiant de l'appareil à mettre à jour
     * @param appInfo les nouvelles informations de l'appareil
     */
    @PutMapping("/id/{id}")
    public void update(@PathVariable Long id, @RequestBody Appareil appInfo) {
        appareilService.update(id, appInfo);
    }


    /**
     * Met à jour l'état de tous les appareils.
     * Permet d'allumer ou éteindre tous les appareils simultanément.
     * @param state le nouvel état (true=allumé, false=éteint)
     */
    @GetMapping("/update/state/{state}")
    public void updateAll(@PathVariable boolean state) {
        appareilService.updateAll(state);
    }

}
