package model.place;

import java.util.ArrayList;

import model.character.Character;
import model.character.FantasticCreaturesLycanthropes;
import model.food.Food;
import model.lycanthrope.Colony;
import model.lycanthrope.Pack;

/**
* The model class for the Enclosure object.
* Contains the properties relative to the battlefield, which is not much as most of the places properties are in the mother class Place.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class Enclosure extends Place {

    private Colony colony; // Lier la colonie à l'enclos

    public Enclosure(String name, double surface, ArrayList<Character> people, ArrayList<Food> food) {
        super(name, surface, people, food);
        this.colony = new Colony();
        // Créer une meute par défaut pour accueillir les nouveaux arrivants
        this.colony.addPack(new Pack());
    }

    // Surcharge de addPeople pour gérer l'ajout spécifique des Lycanthropes
    @Override
    public void addPeople(Character charac) {
        super.addPeople(charac); // Ajout à la liste générique 'people' de Place
        
        if (charac instanceof FantasticCreaturesLycanthropes) {
            FantasticCreaturesLycanthropes wolf = (FantasticCreaturesLycanthropes) charac;
            // Ajout du loup à la première meute de la colonie par défaut
            if (!colony.getPacks().isEmpty()) {
                colony.getPacks().get(0).addMember(wolf);
            }
        }
    }
    
    // Méthode pour déclencher le vieillissement/logique des loups à chaque tour
    public void updateLycanthropes() {
        // On avance le temps de 1 an par tour (ou selon votre choix)
        colony.fastForwardTime(1); 
    }
    
    public Colony getColony() {
        return colony;
    }
}
