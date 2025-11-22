package Place;

import java.util.ArrayList;
import java.util.Iterator;

import Character.Character;
import Food.Food;

abstract public class Place {
	
	public Place(String name, double surface, Integer numberOfPeople, ArrayList<Character> people,
			ArrayList<Food> food) {
		this.name = name;
		this.surface = surface;
		this.numberOfPeople = numberOfPeople;
		this.people = people;
		this.food = food;
	}


	private String name;
	private double surface;
	//private ClanChief clanchief;
	private Integer numberOfPeople;
	private ArrayList<Character> people;
	private ArrayList<Food> food;
	
	// Print specifications of characters and food in the current place
	public void displaySpecifications() {
		Iterator<Food> itfood = this.food.iterator();
		while (itfood.hasNext()) {
			System.out.println(itfood.next().toString());
		}
		Iterator<Character> itchar = this.people.iterator();
		while(itchar.hasNext()) {
			System.out.println(itchar.next().toString());
		}
	}
	
	public void addPeople(Character charac) {
		people.add(charac);
	}
	
	public void removePeople(Character charac) {
		people.remove(charac);
	}
	
	
	public void healPeople() {
		Iterator<Character> itchar = this.people.iterator();
		while (itchar.hasNext()) {
			itchar.next().heal();
		}
	}
	
	
	public void feedPeople() {
		int foodIndex = 0;
		Iterator<Character> itchar = this.people.iterator();
		while (itchar.hasNext() && foodIndex < this.food.size()) {
			Character person = itchar.next();
			person.eat(this.food.get(foodIndex));
			foodIndex++;
		}
		// Remove the food items that have been consumed
		for (int i = 0; i < foodIndex; i++) {
			this.food.remove(0);
		}
	}
	
	public ArrayList<Character> getPeople(){
		return this.people;
	}
	
	public ArrayList<Food> getListFood(){
		return this.food;
	}
}



