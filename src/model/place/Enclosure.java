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

    private Colony colony;

    public Enclosure(String name, double surface, ArrayList<Character> people, ArrayList<Food> food) {
        super(name, surface, people, food);
        this.colony = new Colony();
        this.colony.addPack(new Pack());
    }

    @Override
    public void addPeople(Character charac) {
        super.addPeople(charac);
        
        if (charac instanceof FantasticCreaturesLycanthropes) {
            FantasticCreaturesLycanthropes wolf = (FantasticCreaturesLycanthropes) charac;
            if (!colony.getPacks().isEmpty()) {
                colony.getPacks().get(0).addMember(wolf);
            }
        }
    }
    
    public ArrayList<String> updateLycanthropes() {
        ArrayList<String> messages = new ArrayList<>();
        messages = colony.fastForwardTime(1);
        return messages;
    }
    
    public Colony getColony() {
        return colony;
    }
}
