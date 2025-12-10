package model.place;

import java.util.ArrayList;
import java.util.Iterator;

import model.character.Character;
import model.food.Food;

/**
* The abstract mother class of all the places, Place.
* Contains the properties and methods relative to all the places.
* Can also manage the people in it as it is a propertie of it.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public abstract class Place {
	/**
	* The name of the place
	*/
    private String name;
    /**
	* The surface of the place
	*/
    private double surface;
    /**
	* The list of the people in the place.
	*/
    private ArrayList<Character> people;
    /**
	* The list of the food in the place
	*/
    private ArrayList<Food> food;
    /**
	* Which faction this place is conquered by
	*/
    private int belongsTo; // Ideally 0 for Gallic, 1 for Roman and 2 for neutral.

    /**
	 * Creates a Place object.
	 * 
	 * @param name
	 * @param surface
	 * @param people
	 * @param food
	 * 
	 * @return the newly created object
	 */
    public Place(String name, double surface, ArrayList<Character> people,
                 ArrayList<Food> food) {
        this.name = name;
        this.surface = surface;
        this.people = people;
        this.food = food;
    }

    /**
	* Returns a string of the specification of the place to be shown by the view.
	* Will get the food and the characters from the place.
	* 
	* @return String
	*/
    public String getSpecifications() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== Nourriture dans l'endroit ===\n");
        for (Food f : food) {
            sb.append(f.toString()).append("\n");
        }

        sb.append("\n=== Personnes présentes ===\n");
        for (Character c : people) {
            sb.append(c.toString()).append("\n");
        }

        return sb.toString();
    }

    /**
	* Adds a character to the current place.
	* 
	* @param charac
	* @return void
	*/
    public void addPeople(Character charac) {
        people.add(charac);
        charac.setCurrentPlace(this);
    }

    /**
	* Removes a character to the current place.
	* 
	* @param charac
	* @return void
	*/
    public void removePeople(Character charac) {
        people.remove(charac);
    }

    /**
	* Heals all the character of the place by 1.
	* 
	* @param charac
	* @return void
	*/
    public void healPeople() {
        for (Character c : people) {
            c.heal();
        }
    }

    /**
	* Feeds all the characters of the place.
	* Returns the amount characters that has eaten.
	* 
	* @return String
	*/
    public String feedPeople() {
        int count = 0;

        Iterator<Character> it = people.iterator();
        Iterator<Food> foodIt = food.iterator();

        while (it.hasNext() && foodIt.hasNext()) {
            Character c = it.next();
            Food f = foodIt.next();

            c.eat(f);
            count++;
        }

        // Remove consumed food
        for (int i = 0; i < count; i++) {
            food.remove(0);
        }

        return count + " characters have eaten.";
    }

    /**
	* Returns the list of characters in the place.
	* 
	* @return ArrayList<Character> the characters in the place.
	*/
    public ArrayList<Character> getPeople() {
        return people; 
    }

    /**
	* Returns the list of food in the place.
	* 
	* @return ArrayList<Food> the characters in the place.
	*/
    public ArrayList<Food> getFood() {
        return food;
    }

    /**
	* Returns the name of the place.
	* 
	* @return String name of the place.
	*/
    public String getName() { return name; }
    
    /**
	* Returns amount of people from the place.
	* 
	* @return int the amount of people in the place.
	*/
    public int getNumberOfPeople() {
        return people.size();
    }
    
    /**
	* Returns the conqueror of the place
	* 
	* @return int the code of the conqueror of the place. Ideally 0 for Gallic, 1 for Roman and 2 for neutral.
	*/
    public int getBelongsTo() { return belongsTo; }
    
    /**
	* Sets the conqueror of the place
	* 
	* @param int the conqueror of the place 
	* @return void
	*/
    public void setBelongsTo(int belongsTo) { this.belongsTo = belongsTo;}
    
    /**
	* Converts the code of the conqueror to a string and returns it.
	* 
	* @return String the conqueror name.
	*/
    public String getBelongsToName() {
    	
    	if(this.belongsTo == 2) {
    		return "neutre";
    	}
    	else if(this.belongsTo == 1) {
    		return "romains";
    	}
    	return "gaulois";
    }    
}
