package model.character;

import model.food.Food;
import model.magicpotion.MagicPotion;
import model.place.Place;

import java.util.ArrayList;
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
	private MagicPotion magicPotion;


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
	
	public MagicPotion MakePotion(List<Food> ingredientsAvailable) {
		if(ingredientsAvailable != null) {
			
			MagicPotion cauldron = new MagicPotion(ingredientsAvailable);
			
			return cauldron;
			
		} else {
			return null;
		}
	}

	public void setMagicPotion(MagicPotion magicPotion) {
		this.magicPotion=magicPotion;
	}

	public MagicPotion getMagicPotion() {
		return this.magicPotion;
	}

	public List<Food> prepareIngredients(){
        List<Food> ingredientList = new ArrayList<>();

	    ingredientList.add(Food.MISTLETOE);
	    ingredientList.add(Food.CARROTS);
	    ingredientList.add(Food.SALT);
	    ingredientList.add(Food.FOURLEAF_CLOVER);
	    ingredientList.add(Food.FAIRLY_FRESH_FISH);
	    ingredientList.add(Food.HONEY);
	    ingredientList.add(Food.MEAD);
	    ingredientList.add(Food.SECRET_INGREDIENT);
	    ingredientList.add(Food.ROCK_OIL);

		return ingredientList;
	}
}