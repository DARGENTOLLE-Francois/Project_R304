package model.character;

import model.place.Place;

/**
* The Roman class, extends the Character class. All the Romans will be child of this class.
* <p>
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class Roman extends Character{

	public Roman(String name, String sexe, double height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion, Place placeOfOrigin) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion, placeOfOrigin);
		// TODO Auto-generated constructor stub
	}


}
