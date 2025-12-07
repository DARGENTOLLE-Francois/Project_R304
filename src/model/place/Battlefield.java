package model.place;

import java.util.ArrayList;

import model.character.Character;
import model.food.Food;

public class Battlefield extends Place{
	
	public Battlefield(String name, double surface, ArrayList<Character> people,
			ArrayList<Food> food) {
		super(name, surface, people, food);
		
	}
	
	
	public boolean canFight() {
		if (this.getGallic().size()>0 && this.getRoman().size()>0) {
			return true;
		}
		return false;
	}
    
    public ArrayList<Character> getGallic() {
    	ArrayList<Character> gallicPeople = new ArrayList<>();
    	for (Character c: this.getPeople()) {
    		// à changer quand loup
    		if (c.getPlaceOfOrigin() instanceof GallicVillage) {
    			gallicPeople.add(c);
    		}
    	}
		return gallicPeople;
    }
    
    public ArrayList<Character> getRoman() {
    	ArrayList<Character> romanPeople = new ArrayList<>();
    	for (Character c: this.getPeople()) {
    		// à changer quand loup
    		if (c.getPlaceOfOrigin() instanceof GalloRomanSettlement || 
    			c.getPlaceOfOrigin() instanceof RomanCity ||
    			c.getPlaceOfOrigin() instanceof RomanFortifiedCamp) {
    			romanPeople.add(c);
    		}
    	}
		return romanPeople;
    }
    
}
