package Potion;
import Character.Character;

public class Potion {
	
	public void drinkpotion(Character character) {
		//si il ya au moins une potion dans la place
		// on boost
		character.setStrength(character.getStrength() * 3);
		character.setHealth(character.getHealth() * 3);
		character.setStamina(character.getStamina() * 3);
		
	}
}
