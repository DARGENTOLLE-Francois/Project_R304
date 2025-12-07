package model.map;

import java.util.ArrayList;
import java.util.Arrays;

import model.InvasionTheatre.InvasionTheatreModel;
import model.character.Character;
import model.food.Food;
import model.place.*;

public class mapModel {
	ArrayList<PlaceData> thePlaces = new ArrayList<PlaceData>();
	static boolean isInstanciated = false;
	static mapModel instance;
	
	private mapModel() {
	}
	
	public static mapModel getInstance() {
		if(isInstanciated) {
		return mapModel.instance;
		}
		mapModel.isInstanciated = true;
		mapModel.instance = new mapModel();
		instance.generateMap();
		return mapModel.instance;
	}
	
	//Creates a static way the map.
	public void generateMap() {
		this.thePlaces = new ArrayList<PlaceData>();
		
		this.thePlaces.add(new PlaceData(
				new GallicVillage("Village Gaulois", 0, 1, new ArrayList<Character>(), new ArrayList<Food>(), 0), 
				1, 
				new ArrayList<Integer>(Arrays.asList(2, 3))));
		
		this.thePlaces.add(new PlaceData(
				new Enclosure("Enclot", 0, 1, new ArrayList<Character>(), new ArrayList<Food>(), 0), 
				2, 
				new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5))));
		
		this.thePlaces.add(new PlaceData(
				new GalloRomanSettlement("Camps Galo-Romain", 0, 1, new ArrayList<Character>(), new ArrayList<Food>(), 0), 
				3, 
				new ArrayList<Integer>(Arrays.asList(1, 2, 4, 6))));
		
		this.thePlaces.add(new PlaceData(
				new Battlefield("Champ de bataille", 0, 1, new ArrayList<Character>(), new ArrayList<Food>(), 2), 
				4, 
				new ArrayList<Integer>(Arrays.asList(2, 3, 5, 6))));
		
		this.thePlaces.add(new PlaceData(
				new RomanFortifiedCamp("Camp de romains", 0, 1, new ArrayList<Character>(), new ArrayList<Food>(), 1), 
				5, 
				new ArrayList<Integer>(Arrays.asList(2, 4, 6, 7))));
		
		this.thePlaces.add(new PlaceData(
				new RomanFortifiedCamp("Camp de romains", 0, 1, new ArrayList<Character>(), new ArrayList<Food>(), 1), 
				6, 
				new ArrayList<Integer>(Arrays.asList(3, 4, 5, 7))));
		
		this.thePlaces.add(new PlaceData(
				new RomanCity("Village Romain", 0, 1, new ArrayList<Character>(), new ArrayList<Food>(), 1), 
				7, 
				new ArrayList<Integer>(Arrays.asList(5, 6))));
		
	}
	
	public ArrayList<PlaceData> getThePlaces() {
	    return thePlaces;
	}

	public void setThePlaces(ArrayList<PlaceData> thePlaces) {
	    this.thePlaces = thePlaces;
	}
}
