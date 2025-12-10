package model.character;

import model.food.Food;
import model.magicPotion.MagicPotion;
import model.place.Place;

import java.util.List;

/**
* The Druid class, extends the Gallic class and implements the Work, Rule, Fight, CookMagicPotion interface.s.
* 
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class Druid extends Gallic implements Work, Rule, Fight, CookMagicPotion {

	/** 
     * Creates an instance with the given parameters
     *
     *
     * @param name		    The name of the character
     * @param sexe		    The gender of the character
     * @param height	    The height of the character
     * @param age		    The age of the character
     * @param strength	    The strength stat of the character
     * @param stamina	    The stamina stat of the character
     * @param health	    The health stat of the character
     * @param hunger	    The hunger of the character
     * @param belligerence  The belligerence of the character
     * @param levelOfPotion The levelOfPotion of the character
     * @param placeOfOrigin The placeOfOrigin of the character
     * 
     * @return             The newly created object
     */
	public Druid(String name, String sexe, double height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion, Place placeOfOrigin) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion, placeOfOrigin);
	}

	/** 
	 * Does the druid have enough ingredients to cook.
	 * Say my name.
     */
	private boolean haveingredient = true; // test variable
	
	/** 
	 * The druid will cook the potion, hopefully his name will be said...
	 * Returns the potion to be stored in the place.
	 * 
	 * @param			   ingredientsAvailable The ingredients the druid has
     * @return             MagicPotion the magic potion that was made.
     */
	public MagicPotion MakePotion(List<Food> ingredientsAvailable) {
		if(haveingredient && ingredientsAvailable != null) {
			
			MagicPotion cauldron = new MagicPotion(ingredientsAvailable);
			
			// The potion is return so it can be stored in the place.
			return cauldron;
			
		} else {
			return null;
		}
	}
}