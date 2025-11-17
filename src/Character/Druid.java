package Character;
import Potion.*;
//import places pour choper les ingrédients

public class Druid extends Gallic implements Work, Rule, Fight, CookMagicPotion{

	public Druid(String name, String sexe, String height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion);
		// TODO Auto-generated constructor stub
	}
	private boolean haveingredient = true; // variable de test
	// faudrait une fonction dans place du style : haveIngredientForPotion
	
	public void MakePotion() {
		if(haveingredient) {
			//retirer les ingrédients du lieux en question
			//créer une marmite de potion avec le nombre de dose maximum
			//MagicPotionCauldron cauldron = new MagicPotionCauldron(place.cauldron.getDose(), Place.getIngredient(), false, true);
			//cauldron.putPlace()			//Place la potion(et donc les x doses dans le lieux)
			
		}
	}
	
	
}
