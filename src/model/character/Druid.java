package model.character;

import model.food.Food;
import model.magicPotion.MagicPotion;
import model.place.Place;

import java.util.ArrayList;
import java.util.List;

public class Druid extends Gallic implements Work, Rule, Fight, CookMagicPotion {
	private MagicPotion magicPotion;
	
	public Druid(String name, String sexe, double height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion, Place placeOfOrigin) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion, placeOfOrigin);
		
	}
	
	public MagicPotion MakePotion(List<Food> ingredientsAvailable) {
		if(ingredientsAvailable != null) {
			
			MagicPotion cauldron = new MagicPotion(ingredientsAvailable);
			
			// On retourne potion pour qu'il puisse être stocker dans le lieu
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
		
        // Potion Normale
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