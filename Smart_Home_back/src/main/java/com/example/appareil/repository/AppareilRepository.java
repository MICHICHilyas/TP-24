package com.example.appareil.repository;

import com.example.appareil.entity.Appareil;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour la gestion de la persistance des appareils.
 * Fournit les opérations CRUD de base via JpaRepository.
 * @author Ilyas MICHICH
 * @version 1.0
 */
public interface AppareilRepository extends JpaRepository<Appareil,Long> {
}
