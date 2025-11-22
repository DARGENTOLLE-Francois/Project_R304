package Character;

import Potion.MagicPotion;
import Food.Food;
import java.util.List;

public class Druid extends Gallic implements Work, Rule, Fight, CookMagicPotion {

	public Druid(String name, String sexe, double height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion);
	}

	private boolean haveingredient = true; // variable de test(a changer quand on aura les lieux)
	
	public MagicPotion MakePotion(List<Food> ingredientsAvailable) {
		if(haveingredient && ingredientsAvailable != null) {
			
			MagicPotion cauldron = new MagicPotion(ingredientsAvailable);
			
			System.out.println(this.getName() + " a préparé une marmite !");
			
			// On retourne potion pour qu'il puisse être stocker dans le lieu
			return cauldron;
			
		} else {
			System.out.println("flm ou pas ce qu'il faut");
			return null;
		}
	}
}