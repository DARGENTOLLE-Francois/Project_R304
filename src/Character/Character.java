package Character;

import Food.Food;
import Food.NutritionalValue;

abstract public class Character {
	private String name;
	private String sexe;
	private String height;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getStamina() {
		return stamina;
	}

	public void setStamina(Integer stamina) {
		this.stamina = stamina;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getHunger() {
		return hunger;
	}

	public void setHunger(Integer hunger) {
		this.hunger = hunger;
	}

	public Integer getBelligerence() {
		return belligerence;
	}

	public void setBelligerence(Integer belligerence) {
		this.belligerence = belligerence;
	}

	public Integer getLevelOfPotion() {
		return levelOfPotion;
	}

	public void setLevelOfPotion(Integer levelOfPotion) {
		this.levelOfPotion = levelOfPotion;
	}

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
