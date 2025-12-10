package model.player;

import model.character.*;
import model.character.Character;
import model.place.Place;
import model.food.Food;

import java.util.ArrayList;
import java.util.Iterator;

/**
* The model class for the ClanChiefModel object and game logic.
* Contains all the properties used by the operator to interact with it's environement, as examinePlace() or healAllCharacters().
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class ClanChiefModel {

	/**
	* The name of the chief
	*/
    private String name;
    /**
	* The gender of the chief
	*/
    private String sex;
    /**
	* The age of the chief
	*/
    private Integer age;
    /**
	* The current place of the chief
	*/
    private Place place;

    /**
	 * Creates a Place object.
	 * 
	 * @param name
	 * @param sex
	 * @param age
	 * @param place
	 * 
	 * @return the newly created object
	 */
    public ClanChiefModel(String name, String sex, Integer age, Place place) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.place = place;
    }

    /**
	* Returns the name of the clan chief
	* 
	* @return String the name of the clan chief
	*/
    public String getName() { return name; }
    /**
	* Returns the gender of the clan chief
	* 
	* @return String the gender of the clan chief
	*/
    public String getSex() { return sex; }
    /**
	* Returns the age of the clan chief
	* 
	* @return String the age of the clan chief
	*/
    public Integer getAge() { return age; }
    /**
	* Returns the current place of the clan chief
	* 
	* @return Place the current place of the clan chief
	*/
    public Place getPlace() { return place; }

    /**
	* Returns the specifications of the place + the amount of people and food
	* 
	* @return String all the info to be displayed by the view.
	*/
    public String examinePlace() {
        StringBuilder sb = new StringBuilder();
        sb.append(place.getSpecifications());
        sb.append("\nPeople in place: ").append(place.getPeople().size());
        sb.append("\nFood available: ").append(place.getFood());
        return sb.toString();
    }

    /**
     * Creates a character following the instructions prompted in the controller.
     * 
     * @param  name
     * @param  sex
     * @param  height
     * @param  age
     * @param  type
     * @return the created character
     */
    public Character createCharacter(String name, String sex, double height, int age, int type) {
    	
        switch(type) {
            case 1:
                return new Druid(name, sex, height, age, 10,40,30,0,0,0, this.place);
            case 2:
				return new Blacksmith(name, sex, height, age, 10,40,60,0,0,0, this.place);          
			case 3:
                return new Innkeeper(name, sex, height, age, 10,40,20,0,0,0, this.place);   
            case 4:
                return new GallicMerchant(name, sex, height, age, 15,20,25,0,0,0, this.place);  
            case 5:
                return new Legionnaire(name, sex, height, age, 20,30,25,0,0,0, this.place);    
            case 6:
                return new Prefect(name, sex, height, age, 22,12,35,0,0,0, this.place);  
            case 7:
                return new General(name, sex, height, age, 26,18,30,0,0,0, this.place);    
            case 8:
                return new FantasticCreaturesLycanthropes(name,sex,height,age,34,50,40,0,0,0, this.place);    
            default:
                return null;
        }
    }

    /**
	* Heals all the characters.
	* 
	* @return void
	*/
    public void healAllCharacters() {
        for (Character c : place.getPeople()) {
            c.heal();
        }
    }

    /**
	* Makes all the characters eat. Limited by the amount of food available.
	* 
	* @return String the informations that might have to be displayed by the view.
	*/
    public String charactersEat() {
        Iterator<Character> it = place.getPeople().iterator();
        int fed = 0;

        while (it.hasNext()) {
            if (place.getFood().isEmpty()) {
                return "No more food available. " + fed + " characters have eaten.";
            }
            Character c = it.next();
            Food food = place.getFood().remove(0);
            c.eat(food);
            fed++;
        }

        return fed + " characters have eaten.";
    }
    
    /**
	* TODO
	* 
	* @return void
	*/
    public void askMagicPotion() {
    	//TODO
    }
    
    /**
	* TODO
	* 
	* @return void
	*/
    public void drinkMagicPotion() {
    	//TODO
    }
    
    /**
	* Checks if the index in parameters is valid . if it is not more that the amount of people.
	* 
	* @param int index to test.
	* @return boolean 
	*/
    public boolean checkValidIndex(int index) {
    	if (index>place.getPeople().size()) {
    		return false;
    	}
		return true;
    }
    
    /**
	* Gets the character relative to the index given in parameters and returns it.
	* 
	* @param int index to get the character of.
	* @return Character 
	*/
    public Character chooseCharac(int index) {
    	--index;
    	int i=0;
    	for (Character c : place.getPeople()) {
    		if (i==index) {
    			return c; 
    		}
    		++i;
    	}
    	// To change with exceptions?
		return null;
    }
    
    /**
	* Gets a place from the destinations array given in parameters and an index.
	* 
	* @param  int index to get the place of.
	* @param  ArrayList<Place> the destinations array
	* @return Character 
	*/
    public Place chooseDestination(ArrayList<Place> destinations, int index) {
    	--index;
    	int i=0;
    	for (Place p : destinations) {
    		if (i==index) {
    			return p; 
    		}
    		++i;
    	}
    	// To change with exceptions?
		return null;
    }
    
    /**
	* Moves a chosen character to a chosen place.
	* 
	* @param  Character the character to move
	* @param  Place the destination
	* @return boolean the place doesn't already contains the character. 
	*/
    public boolean moveCharac(Character chosenCharacter, Place destination) {

    	if (!place.getPeople().contains(chosenCharacter)) {
            return false;
        }
        
        place.removePeople(chosenCharacter);
        destination.addPeople(chosenCharacter);
        chosenCharacter.setCurrentPlace(destination);
		return true;
    }

}
