package model.character;

import model.place.Place;

/**
* The FantasticCreaturesLycanthropes class, extends the Character class and implements the Fight interface.s.
* <p>
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class FantasticCreaturesLycanthropes  extends Character implements Fight{

	public FantasticCreaturesLycanthropes(String name, String sexe, double height, Integer age, Integer strength,
			Integer stamina, Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion, Place placeOfOrigin) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion, placeOfOrigin);
		// TODO Auto-generated constructor stub
	}

}
