package Character;

import Food.Food;

public class General extends Roman implements Fight, Rule{

	public General(String name, String sexe, String height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void eat(Food food) {
		
	}
}
