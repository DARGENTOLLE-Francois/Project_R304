package model.character;

import java.util.ArrayList;
import java.util.List;

import model.food.Food;
import model.food.NutritionalValue;
import model.magicPotion.MagicPotion;
import model.place.Place;

abstract public class Character {

	private String name;
	private String sexe;
	private double height;
	private Integer age;
	private Integer strength;
	private Integer stamina;
	private Integer health;
	private Integer hunger;
	private Integer belligerence;
	private Integer levelOfPotion;
	private boolean isInvincible = false;
	private boolean isPetrified = false;
	private boolean isLycanthrope = false;
	private boolean hasSuperSpeed = false;
	private int dosesConsumed = 0;
    private Place placeOfOrigin; 
    private Place currentPlace;  
	

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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
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
	public boolean isInvincible() { return isInvincible; }
	public boolean isPetrified() { return isPetrified; }
	public boolean isLycanthrope() { return isLycanthrope; }
	public boolean hasSuperSpeed() { return hasSuperSpeed; }
	public int getDosesConsumed() { return dosesConsumed; }

	
	public Place getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	public Place getCurrentPlace() {
		return currentPlace;
	}
	
	
	public void setCurrentPlace(Place currentPlace) {
		this.currentPlace = currentPlace;
	}


	public Character(String name, String sexe, double height, Integer age, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion, Place placeOfOrigin) {
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
		this.placeOfOrigin = placeOfOrigin;
		this.currentPlace = placeOfOrigin;
	}
	
	public Integer strike(Character c1) {
		if (this.isPetrified) return 0; // statue donc cheh
		
		else {
			return (c1.health-this.strength)*c1.stamina;
		}
	}
	
	public void heal() {
		if (!this.isPetrified) { // statue donc cheh
			++this.health;
		}
	}
	
	public void eat() {
		if (!this.isPetrified) { // statue donc cheh
			--this.hunger;
		}
	}
	
	// ajout partie potion
	public List<String> drinkMagicPotion(MagicPotion potion) {
	    List<String> messages = new ArrayList<>();
	    if (isPetrified) {
	        messages.add(name + " est une statue !");
	        return messages;
	    }
	    if (potion.takeDose()) {
	        if (potion.isValid()) {
	            isInvincible = true;
	            strength += 50;
	            ++levelOfPotion;
	            dosesConsumed++;
	            
	            if (potion.isNourishing()) hunger = Math.max(0, hunger - 20);
	            if (potion.givesSuperSpeed()) hasSuperSpeed = true;
	            if (potion.causesLycanthropy()) isLycanthrope = true;

	            if (dosesConsumed >= 10) {
	                isPetrified = true;
	                strength = 0;
	                messages.add(name + " devient une statue de granit !");
	            } else if (dosesConsumed >= 5) {
	                messages.add("Effets permanents !");
	            }
	        } else {
	            messages.add("Potion ratée !");
	        }
	    } else {
	        messages.add("Marmite vide !");
	    }
	    return messages;
	}
	
	public void passAway() {
		if (!this.isPetrified && this.health<3) { // statue donc cheh
			System.out.println(this.name +" est mort !");
		}
	}

	public void eat(Food food) {
		if (this.isPetrified) return; // statue donc cheh
		
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
	
	public void modifyHunger(Integer hunger) {
		this.hunger += hunger;
	}

	public void modifyBelligerence(Integer belligerence) {
		this.belligerence += belligerence;
	}

	public void modifyLevelOfPotion(Integer levelOfPotion) {
		this.levelOfPotion += levelOfPotion;
	}
}
