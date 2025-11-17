package Character;

import Food.Food;
import Food.NutritionalValue;

abstract public class Character {
	private String name;
	private String sexe;
	private String height;
	private Integer age;
	private Integer strength;
	private Integer stamina;
	private Integer health;
	private Integer hunger;
	private Integer belligerence;
	private Integer levelOfPotion;
	
	

	public Character(String name, String sexe, String height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion) {
		this.name = name;
		this.sexe = sexe;
		this.height = height;
		this.age = age;
		this.strength = strength;
		this.stamina = stamina;
		this.health = health;
		this.hunger = hunger;
		this.belligerence = belligerence;
		this.levelOfPotion = levelOfPotion;
	}
	
	// Turn of this to strike
	public Integer strike(Character c1, Integer turn) {
		if (turn%2==0) {
			return (c1.health-this.strength)*c1.stamina;
		} else {
			return (this.health-c1.strength)*this.stamina;
		}
	}
	
	public void heal() {
		++this.health;
	}
	
	public void eat() {
		--this.hunger;
	}
	
	public void drinkMagicPotion() {
		++this.levelOfPotion;
	}
	
	public void passAway() {
		if (this.health<3) {
			System.out.println(this.name +" passed away !");
		}
	}

	public void eat(Food food) {
		if (food.getNutritionalValue()==NutritionalValue.GOOD) {
			this.hunger=this.hunger-20;
		} else if (food.getNutritionalValue()==NutritionalValue.MID) {
			this.hunger=this.hunger-15;
		} else if (food.getNutritionalValue()==NutritionalValue.BAD) {
			this.hunger=this.hunger-10;
		}else {
			eat();
		}
	}
}
