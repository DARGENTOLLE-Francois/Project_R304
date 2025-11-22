package InvasionTheatre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import Place.Battlefield;
import Place.Place;
import Food.Food;
import Food.FreshnessLevel;
import Character.Character;

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
	
	
	public void fightBelligerents() {
		//TODO
	}
	
	public void alterCharacRandomly() {
		//Modify hunger by the value of randint
		//this.places.get(0).getPeople().get(0).modifyHunger(test);;
		for (int i=0; i<this.places.size(); ++i) {
			Place currentPlace = this.places.get(i);
			
			Random rand = new Random();
			Iterator<Character> it = currentPlace.getPeople().iterator();
			while (it.hasNext()) {
				int randint = rand.nextInt(0,2);
				Character currentChar = it.next();
				currentChar.modifyHunger(randint);
				currentChar.modifyLevelOfPotion(-randint);
			}
		}
	}
	
	
	// Add boar and fairly fresh fish to all places except battlefield
	public void spawnFood() {
		Iterator<Place> it = this.places.iterator();
		Place currentPlace = it.next();
		if (!(currentPlace.getClass().getName().equals(Battlefield.class.getName()))) {
			currentPlace.getListFood().add(Food.BOAR);
			currentPlace.getListFood().add(Food.FAIRLY_FRESH_FISH);
		}
	}
	
	
	public void decreaseFreshness() {
		for (int i=0; i<this.places.size(); ++i) {
			//Get current place
			Place currentPlace = this.places.get(i);
			//Iterate on ArrayList food of the current place
			
			//Use setFreshnessLevel
			Iterator<Food> it = currentPlace.getListFood().iterator();
			
			while (it.hasNext()) {
				Food currentFood = it.next();
				FreshnessLevel currentFreshnessOfFood = currentFood.getFreshnessLevel();
				switch(currentFreshnessOfFood) {
				case FRESH:
					currentFood.setFreshnessLevel(FreshnessLevel.FAIRLY_FRESH);
					System.out.println("Changement d'état des aliments de fresh vers Fairly Fresh");
					break;
				case FAIRLY_FRESH:
					currentFood.setFreshnessLevel(FreshnessLevel.STALE);
					System.out.println("Changement d'état des aliments de fairly fresh vers Stale");
					break;
				default:
					System.out.println("Changement d'état non nécessaire");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		InvasionTheatre i1 = new InvasionTheatre("test", null);
		i1.alterCharacRandomly();
	}


}
