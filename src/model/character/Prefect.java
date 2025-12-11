package model.character;

import model.place.Place;

/**
* The Prefect class, extends the Character class and implements the Rule interface.s.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class Prefect extends Character implements Rule{

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
	public Prefect(String name, String sexe, double height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion, Place placeOfOrigin) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion, placeOfOrigin);
	}
}
