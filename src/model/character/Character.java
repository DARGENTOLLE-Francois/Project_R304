package model.character;

import java.util.ArrayList;
import java.util.List;

import model.food.Food;
import model.food.NutritionalValue;
import model.magicPotion.MagicPotion;
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

	/**
	* Sets the name of the character
	* 
	* @param name
	* @return void
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Returns the gender of the character
	* 
	* @return the gender of the character
	*/
	public String getSexe() {
		return sexe;
	}

	/**
	* Sets the gender of the character
	* 
	* @param sexe the gender
	* @return void
	*/
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	/**
	* Returns the height of the character
	* 
	* @return the height of the character
	*/
	public double getHeight() {
		return height;
	}

	/**
	* Sets the height of the character
	* 
	* @param height 
	* @return void
	*/
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	* Returns the age of the character
	* 
	* @return the age of the character
	*/
	public Integer getAge() {
		return age;
	}

	/**
	* Sets the age of the character
	* 
	* @param age 
	* @return void
	*/
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	* Returns the strength of the character
	* 
	* @return the strength of the character
	*/
	public Integer getStrength() {
		return strength;
	}

	/**
	* Sets the strength of the character
	* 
	* @param strength 
	* @return void
	*/
	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	/**
	* Returns the stamina of the character
	* 
	* @return the stamina of the character
	*/
	public Integer getStamina() {
		return stamina;
	}

	/**
	* Sets the stamina of the character
	* 
	* @param stamina 
	* @return void
	*/
	public void setStamina(Integer stamina) {
		this.stamina = stamina;
	}

	/**
	* Returns the health of the character
	* 
	* @return the health of the character
	*/
	public Integer getHealth() {
		return health;
	}

	/**
	* Sets the health of the character
	* 
	* @param health 
	* @return void
	*/
	public void setHealth(Integer health) {
		this.health = health;
	}

	/**
	* Returns the hunger of the character
	* 
	* @return the hunger of the character
	*/
	public Integer getHunger() {
		return hunger;
	}

	/**
	* Sets the hunger of the character
	* 
	* @param hunger 
	* @return void
	*/
	public void setHunger(Integer hunger) {
		this.hunger = hunger;
	}

	/**
	* Returns the belligerence of the character
	* 
	* @return the belligerence of the character
	*/
	public Integer getBelligerence() {
		return belligerence;
	}

	/**
	* Sets the belligerence of the character
	* 
	* @param belligerence 
	* @return void
	*/
	public void setBelligerence(Integer belligerence) {
		this.belligerence = belligerence;
	}

	/**
	* Returns the levelOfPotion of the character
	* 
	* @return the levelOfPotion of the character
	*/
	public Integer getLevelOfPotion() {
		return levelOfPotion;
	}

	/**
	* Sets the levelOfPotion of the character
	* 
	* @param levelOfPotion 
	* @return void
	*/
	public void setLevelOfPotion(Integer levelOfPotion) {
		this.levelOfPotion = levelOfPotion;
	}
	/**
	* Returns the isInvincible property of the character
	* 
	* @return isInvincible is the character invincible
	*/
	public boolean isInvincible() { return isInvincible; }
	/**
	* Returns the isPetrified property of the character
	* 
	* @return isPetrified is the character petrified
	*/
	public boolean isPetrified() { return isPetrified; }
	/**
	* Returns the isLycanthrope property of the character
	* 
	* @return isLycanthrope is the character a lycanthrope
	*/
	public boolean isLycanthrope() { return isLycanthrope; }
	/**
	* Returns the hasSuperSpeed property of the character
	* 
	* @return hasSuperSpeed does the character have super speed
	*/
	public boolean hasSuperSpeed() { return hasSuperSpeed; }
	/**
	* Returns the dosesConsumed property of the character
	* 
	* @return dosesConsumed the amount of doses consumed
	*/
	public int getDosesConsumed() { return dosesConsumed; }

	/**
	* Returns the placeOfOrigin of the character
	* 
	* @return the placeOfOrigin of the character
	*/
	public Place getPlaceOfOrigin() {
		return placeOfOrigin;
	}
	
	/**
	* Returns the currentPlace of the character
	* 
	* @return the currentPlace of the character
	*/
	public Place getCurrentPlace() {
		return currentPlace;
	}
	
	/**
	* Sets the currentPlace of the character
	* 
	* @param currentPlace 
	* @return void
	*/
	public void setCurrentPlace(Place currentPlace) {
		this.currentPlace = currentPlace;
	}

	/** 
     * Creates an instance with the given parameters
     *
     *
     * @param name		    The name of the character
     * @param sexe		    The gender of the character
     * @param height	    The height of the character
     * @param age		    The age of the character
     * @param strength	    The strength stat of the character
     * @param stamina	    The stamina stat of the character
     * @param health	    The health stat of the character
     * @param hunger	    The hunger of the character
     * @param belligerence  The belligerence of the character
     * @param levelOfPotion The levelOfPotion of the character
     * @param placeOfOrigin The placeOfOrigin of the character
     * 
     * @return             The newly created object
     */
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
	
	/** 
     * Decreases the health of the character given in parameters by strength * stamina.
     *
     * @param 			   Character the character to strike
     * @return             void
     */
	public void strike(Character c1) {
		if (!this.isPetrified) 
			c1.setHealth(c1.health-this.strength*this.stamina);
	}
	
	/** 
	 * Heals the character by 1
	 * 
     * @return             void
     */
	public void heal() {
		if (!this.isPetrified) { // petrified
			++this.health;
		}
	}
	
	/** 
	 * Decreases the hunger of the character by 1
	 * 
     * @return             void
     */
	public void eat() {
		if (!this.isPetrified) { // petrified
			--this.hunger;
		}
	}
	
	/** 
	 * Makes the character drink a dose of magic potion from the potion given in parametters.
	 * Will check if the potion exists, has doses left and if the character should get petrified.
	 * 
     * @return             List<String> the potential message that will be sent to the view.
     */
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
	
	/** 
	 * Checks if the character is dead.
	 * 
     * @return             boolean is the character dead?
     */
	public boolean passAway() {
		if (!this.isPetrified && this.health<0) { // petrified
			return true;
		}
		return false;
	}

	/** 
	 * Gives the food in parametters to the character, decreases the hunger based on the quality of that food.
	 * 
	 * @param			   food the food to feed the character of.
     * @return             void
     */
	public void eat(Food food) {
		if (this.isPetrified) return; // petrified
		
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
	
	/** 
	 * Modifies the hunger value by the integer given in parametters.
	 * 
	 * @param			   hunger the hunger to vary of
     * @return             void
     */
	public void modifyHunger(Integer hunger) {
		this.hunger += hunger;
	}

	/** 
	 * Modifies the hunger value by the integer given in parametters.
	 * 
	 * @param			   hunger the hunger to vary of
     * @return             void
     */
	public void modifyBelligerence(Integer belligerence) {
		this.belligerence += belligerence;
	}

	/** 
	 * Modifies the level of Potion value by the integer given in parametters.
	 * 
	 * @param			   levelOfPotion the level of Potion to vary of
     * @return             void
     */
	public void modifyLevelOfPotion(Integer levelOfPotion) {
		this.levelOfPotion += levelOfPotion;
	}
}
