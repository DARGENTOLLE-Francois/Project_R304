package model.place;

import java.util.ArrayList;

import model.character.Character;
import model.food.Food;

public class GallicVillage extends Place {

    public GallicVillage(String name, double surface, Integer numberOfPeople,
                         ArrayList<Character> people, ArrayList<Food> food) {
        super(name, surface, numberOfPeople, people, food);
    }
    
    public GallicVillage(String name, double surface, Integer numberOfPeople,
            ArrayList<Character> people, ArrayList<Food> food, Integer belongsTo) {
super(name, surface, numberOfPeople, people, food, belongsTo);
}
}
