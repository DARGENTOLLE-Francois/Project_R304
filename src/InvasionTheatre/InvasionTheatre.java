package InvasionTheatre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import Place.Battlefield;
import Place.Place;
import Food.Food;
public class InvasionTheatre {
	private String name;
	private static final Integer numberOfPlaces = 10;
	private ArrayList<Place> places;
	//private ArrayList<Chief> chief;
	
	
	public InvasionTheatre(String name, ArrayList<Place> places) {
		this.name = name;
		this.places = places;
	}
	
	
	// print all places in the theatre
	public String displayPlaces () {
		return this.places.toString();
	}
	
	// to complete
	public Integer displayNumberCharacter() {
		Iterator<Place> it = this.places.iterator();
		it.next().displaySpecifications();
		return null;
		
	}
	
	public void alterCharac() {
		Random rand = new Random();
		int randint = rand.nextInt(0,2);
		//Modify hunger by the value of randint
		//this.places.get(0).getPeople().get(0).modifyHunger(test);;
	}
	
	
	// Add boar and fairly fresh fish to all places except battlefield
	public void spawnFood() {
		Iterator<Place> it = this.places.iterator();
		Food boar = Food.BOAR;
		Food fairlyFreshFish = Food.FAIRLY_FRESH_FISH;
		while (it.hasNext()) {
			if (!(it.next().getClass().getName().equals(Battlefield.class.getName()))) {
				it.next().getListFood().add(boar);
				it.next().getListFood().add(fairlyFreshFish);
			}
		}
	}
	
	
	public void render() {
		
	}
	
	public static void main(String[] args) {
		InvasionTheatre i1 = new InvasionTheatre("test", null);
		i1.alterCharac();;
	}


}
