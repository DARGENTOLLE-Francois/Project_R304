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

    private String name;
    private String sex;
    private Integer age;
    private Place place;

    public ClanChiefModel(String name, String sex, Integer age, Place place) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.place = place;
    }

    public String getName() { return name; }
    public String getSex() { return sex; }
    public Integer getAge() { return age; }
    public Place getPlace() { return place; }


    public String examinePlace() {
        StringBuilder sb = new StringBuilder();
        sb.append(place.getSpecifications());
        sb.append("\nPeople in place: ").append(place.getPeople().size());
        sb.append("\nFood available: ").append(place.getFood());
        return sb.toString();
    }

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

    public void healAllCharacters() {
        for (Character c : place.getPeople()) {
            c.heal();
        }
    }

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
    
    public void askMagicPotion() {
    	//TODO
    }
    
    public void drinkMagicPotion() {
    	//TODO
    }
    
    public boolean checkValidIndex(int index) {
    	if (index>place.getPeople().size()) {
    		return false;
    	}
		return true;
    }
    
    
    public Character chooseCharac(int index) {
    	--index;
    	int i=0;
    	for (Character c : place.getPeople()) {
    		if (i==index) {
    			return c; 
    		}
    		++i;
    	}
    	// à changer avec exception ?
		return null;
    }
    
    public Place chooseDestination(ArrayList<Place> destinations, int index) {
    	--index;
    	int i=0;
    	for (Place p : destinations) {
    		if (i==index) {
    			return p; 
    		}
    		++i;
    	}
    	// à changer avec exception ?
		return null;
    }
    
    
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
