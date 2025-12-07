package model.place;

import java.util.ArrayList;

import model.character.Character;
import model.food.Food;

public class Enclosure extends Place{

	public Enclosure(String name, double surface, Integer numberOfPeople, ArrayList<Character> people,
			ArrayList<Food> food) {
		super(name, surface, numberOfPeople, people, food);
		// TODO Auto-generated constructor stub
	}
	
	public Enclosure(String name, double surface, Integer numberOfPeople, ArrayList<Character> people,
			ArrayList<Food> food, Integer belongsTo) {
		super(name, surface, numberOfPeople, people, food, belongsTo);
		// TODO Auto-generated constructor stub
	}
	
}
