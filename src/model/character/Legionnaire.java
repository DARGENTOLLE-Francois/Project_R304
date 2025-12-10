package model.character;

import model.place.Place;

public class Legionnaire extends Roman implements Fight{

	public Legionnaire(String name, String sexe, double height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion, Place placeOfOrigin){
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion, placeOfOrigin);
		// TODO Auto-generated constructor stub
	}


}
