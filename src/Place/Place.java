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
		Iterator<Character> itchar = this.people.iterator();
		while (itchar.hasNext()) {
			if (this.food.size()!=0) {
				itchar.next().eat(this.food.get(0));
				this.food.remove(0);
			}
		}
	}
	
	public ArrayList<Character> getPeople(){
		return this.people;
	}
	
	public ArrayList<Food> getListFood(){
		return this.food;
	}
}



