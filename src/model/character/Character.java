package model.character;

import java.util.ArrayList;
import java.util.List;

import model.food.Food;
import model.food.NutritionalValue;
import model.magicpotion.MagicPotion;
import model.place.Place;

/**
* The abstract model for the characters.
* Every characters will extend this class at some degree.
* It contains the basics properties for the characters in our game which is:
* - Their name
* - Their age
* - Their gender
* - Their height
* - Their strength
* - Their stamina
* - Their hunger level
* - Their belligerence
* - Their level of magic potion
* - Their current lace
* - Their original place
* - Their invincibility (boolean)
* - Their petrification status (boolean)
* - Their lycanthrope status (boolean)
* - Their super speed status (boolean)
* - Their amount of potion doses consumed
* 
* They also can:
* - Die
* - Strike another character
* - Modify the properties above through getters, setters and methods like "heal()".
* 
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
abstract public class Character {
	/**
	* The name of the character
	*/
	private String name;
	/**
	* The gender of the character
	*/
	private String sexe;
	/**
	* The height of the character
	*/
	private double height;
	/**
	* The age of the character
	*/
	private Integer age;
	/**
	* The strength of the character
	*/
	private Integer strength;
	/**
	* The stamina of the character
	*/
	private Integer stamina;
	/**
	* The health of the character
	*/
	private Integer health;
	/**
	* The hunger of the character
	*/
	private Integer hunger;
	/**
	* The belligerence of the character
	*/
	private Integer belligerence;
	/**
	* The levelOfPotion of the character
	*/
	private Integer levelOfPotion;
	/**
	* The Invincibility of the character
	*/
	private boolean isInvincible = false;
	/**
	* The Petrification of the character
	*/
	private boolean isPetrified = false;
	/**
	* The Lycanthropy of the character
	*/
	private boolean isLycanthrope = false;
	/**
	* The super speed of the character
	*/
	private boolean hasSuperSpeed = false;
	/**
	* The amount of doses consumed of the character
	*/
	private int dosesConsumed = 0;
	/**
	* The place of origin of the character
	*/
    private Place placeOfOrigin; 
    /**
	* The current place of the character
	*/
    private Place currentPlace;  
	
    /**
	* Returns the name of the character
	* 
	* @return the name of the character
	*/
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
	public CategoryAge getCategoryAge() {
		return categoryAge;
	}
	public void setCategoryAge(CategoryAge categoryAge) {
		this.categoryAge = categoryAge;
	}
	public Sex getSexenum() {
		return sexenum;
	}
	public void setSexenum(Sex sexenum) {
		this.sexenum = sexenum;
	}
	public boolean isInvincible() { return isInvincible; }
	public boolean isPetrified() { return isPetrified; }
	public boolean isLycanthrope() { return isLycanthrope; }
	public boolean hasSuperSpeed() { return hasSuperSpeed; }
	public int getDosesConsumed() { return dosesConsumed; }

	
	public Place getPlaceOfOrigin() {
		return placeOfOrigin;
	}


	private CategoryAge categoryAge;
	private Sex sexenum;
	
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

	public Character(String name, Sex sexenum, double height, CategoryAge categoryAge, Integer strength, Integer stamina,
			Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion) {
		this.name = name;
		this.sexenum = sexenum;
		this.height = height;
		this.categoryAge = categoryAge;
		this.strength = strength;
		this.stamina = stamina;
		this.health = health;
		this.hunger = hunger;
		this.belligerence = belligerence;
		this.levelOfPotion = levelOfPotion;
	}
	
	public void strike(Character c1) {
		if (!this.isPetrified) 
			c1.setHealth(c1.health-this.strength*this.stamina);
	}
	
	public void heal() {
		if (!this.isPetrified) { 
			++this.health;
		}
	}
	
	public void eat() {
		if (!this.isPetrified) { 
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
	
	public boolean passAway() {
		if (!this.isPetrified && this.health<0) {
			return true;
		}
		return false;
	}

	public void eat(Food food) {
		if (this.isPetrified) return; 
		
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
