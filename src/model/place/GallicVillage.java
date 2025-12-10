package model.place;

import java.util.ArrayList;

import model.character.Character;
import model.food.Food;

/**
* The model class for the GallicVillage object.
* Contains the properties relative to the battlefield, which is not much as most of the places properties are in the mother class Place.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class GallicVillage extends Place {

    public GallicVillage(String name, double surface,
                         ArrayList<Character> people, ArrayList<Food> food) {
        super(name, surface, people, food);
    }
}
