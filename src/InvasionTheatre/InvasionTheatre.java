package InvasionTheatre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import Player.ClanChief;
import model.character.Character;
import model.food.Food;
import model.food.FreshnessLevel;
import model.place.Battlefield;
import model.place.Place;

public class InvasionTheatre {
	private String name;
	private static final Integer numberOfPlaces = 10;
	private ArrayList<Place> places;
	private ArrayList<ClanChief> chiefs;
	private Scanner scanner;
	
	
	public InvasionTheatre(String name, ArrayList<Place> places, ArrayList<ClanChief> chiefs) {
		this.name = name;
		this.places = places;
		this.chiefs = chiefs;
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
			System.out.println("Modifications Aléatoires des personnages sur le lieu courant.");
			while (it.hasNext()) {
				int randint = rand.nextInt(0,2);
				Character currentChar = it.next();

				currentChar.modifyHunger(randint);
				currentChar.modifyLevelOfPotion(-randint);
			}
		}
	}
	
	
	// Add boar and fairly fresh fish to all places except battlefield
	// Pas sur que ça marche à vérifier
	public void spawnFood() {
		System.out.println("Apparition d'aliments sur les lieux autres que champ de bataille.");
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
			System.out.println("Changement fraicheur des aliments présents sur le lieu courant :");
			while (it.hasNext()) {
				Food currentFood = it.next();
				FreshnessLevel currentFreshnessOfFood = currentFood.getFreshnessLevel();
				switch(currentFreshnessOfFood) {
				case FRESH:
					currentFood.setFreshnessLevel(FreshnessLevel.FAIRLY_FRESH);
					System.out.println("Changement d'état des aliments de fresh vers Fairly Fresh : "+currentFood.getName());
					break;
				case FAIRLY_FRESH:
					currentFood.setFreshnessLevel(FreshnessLevel.STALE);
					System.out.println("Changement d'état des aliments de fairly fresh vers Stale : "+currentFood.getName());
					break;
				default:
					System.out.println("Changement d'état non nécessaire : " + currentFood.getName());
				}
			}
		}
	}

	
	
	public void execClanChief(int turn) {
		int maxActions = 3;
		int choice;
		scanner = new Scanner(System.in);
		ClanChief currentChief = chiefs.get(turn);
		for (int i=0; i<maxActions; ++i) {
			System.out.println("Nombre d'actions restantes disponibles : "+ (maxActions-i));
			System.out.println(
					"1 : Examiner son lieu"
					+"\n"+
					"2 : Créer un nouveau personnage dans son lieu."
					+"\n"+
					"3 : Soigner les personnages de son lieu."
					+"\n"+
					"4 : Nourrir les personnages de son lieu."
					+"\n"
					+"Choisissez l'option que vous voulez effecuer en tant que chef "+ chiefs.get(turn).getName()+" :"
					);
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Examination du lieu !");
				currentChief.examinatePlace();
				break;
			case 2:
				System.out.println("Création d'un nouveau personnage !");
				currentChief.createACharacter();
				break;
			case 3:
				System.out.println("Soin des personnages !");
				currentChief.HealTheirCharacter();
				break;
			case 4:
				System.out.println("Rationnement des personnages !");
				currentChief.CharacterWillEat();
				break;
			}
			
		}
	}
	
	public ArrayList<ClanChief> getChiefs(){
		return this.chiefs;
	}

}
