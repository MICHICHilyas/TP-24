package com.example.appareil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de l'application Smart Home.
 * Point d'entrée de l'application Spring Boot pour la gestion des appareils domestiques.
 * @author Ilyas MICHICH
 * @version 1.0
 */
@SpringBootApplication
public class AppareilApplication {

    /**
     * Méthode principale qui démarre l'application Spring Boot.
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {
        SpringApplication.run(AppareilApplication.class, args);
    }

}
