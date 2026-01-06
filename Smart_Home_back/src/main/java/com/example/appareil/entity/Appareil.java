package com.example.appareil.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entité représentant un appareil domestique intelligent.
 * Contient les informations de base d'un appareil (nom, description, état, photo).
 * @author Ilyas MICHICH
 * @version 1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appareil {

    /** Identifiant unique de l'appareil */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    
    /** Libellé de l'appareil */
    private String label;
    
    /** Description détaillée de l'appareil */
    private String description;
    
    /** État de l'appareil (allumé/éteint) */
    private boolean state;
    
    /** Photo de l'appareil en base64 */
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String photo;

    /** Catégorie à laquelle appartient l'appareil */
    @ManyToOne
    private Categorie categorie;


}
