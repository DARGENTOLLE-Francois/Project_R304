package model.place;

import java.util.ArrayList;

import model.character.Character;
import model.food.Food;

/**
* The model class for the Battlefield object.
* Contains the properties relative to the battlefield, which is not much as most of the places properties are in the mother class Place.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class Battlefield extends Place{
	
	/**
	 * Creates a Battlefield object.
	 * 
	 * @param name
	 * @param surface
	 * @param people
	 * @param food
	 * 
	 * @return the newly created object
	 */
	public Battlefield(String name, double surface, ArrayList<Character> people,
			ArrayList<Food> food) {
		super(name, surface, people, food);
		
	}
	
	/**
	 * Returns the possibility of a fight amongst the people of the battlefield.
	 * Checks the presence of gallic and roman on the battlefield.
	 * 
	 * @return	boolean is there gallic and roman on the battlefield.
	 */
	public boolean canFight() {
		if (this.getGallic().size()>0 && this.getRoman().size()>0) {
			return true;
		}
		return false;
	}
    
	/**
	 * Returns the gallics on the battlefield
	 * 
	 * @return	ArrayList<Character> the gallics on the battlefield
	 */
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
    
    /**
	 * Returns the romans on the battlefield
	 * 
	 * @return	ArrayList<Character> the romans on the battlefield
	 */
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
