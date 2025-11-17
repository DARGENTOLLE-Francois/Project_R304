package Place;

import java.util.ArrayList;
import java.util.Iterator;

import Character.Character;
import Food.Food;

abstract public class Place {
	public Place(String name, double surface) {
		this.name = name;
		this.surface = surface;
	}

	private String name;
	private double surface;
	//private ClanChief clanchief;
	private Integer numberOfPeople;
	private ArrayList<Character> people;
	private ArrayList<Food> food;
	
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
}
