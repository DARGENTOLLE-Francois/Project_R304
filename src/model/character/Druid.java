package model.character;

import model.food.Food;
import model.magicPotion.MagicPotion;
import model.place.Place;

import java.util.List;

/**
* The Druid class, extends the Gallic class and implements the Work, Rule, Fight, CookMagicPotion interface.s.
* <p>
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class Druid extends Gallic implements Work, Rule, Fight, CookMagicPotion {

	public Druid(String name, String sexe, double height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion, Place placeOfOrigin) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion, placeOfOrigin);
	}

	private boolean haveingredient = true; // variable de test(a changer quand on aura les lieux)
	
	public MagicPotion MakePotion(List<Food> ingredientsAvailable) {
		if(haveingredient && ingredientsAvailable != null) {
			
			MagicPotion cauldron = new MagicPotion(ingredientsAvailable);
			
			// On retourne potion pour qu'il puisse être stocker dans le lieu
			return cauldron;
			
		} else {
			return null;
		}
	}
}