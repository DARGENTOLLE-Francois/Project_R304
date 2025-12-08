package model.place;

import java.util.ArrayList;
import java.util.Iterator;

import model.character.Character;
import model.food.Food;

public abstract class Place {

    private String name;
    private double surface;
    private ArrayList<Character> people;
    private ArrayList<Food> food;
    private Boolean belongsTo; // Ideally 0 for Gallic, 1 for Roman and null for neutral.

    public Place(String name, double surface, ArrayList<Character> people,
                 ArrayList<Food> food) {
        this.name = name;
        this.surface = surface;
        this.people = people;
        this.food = food;
    }

    public String getSpecifications() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== FOOD IN PLACE ===\n");
        for (Food f : food) {
            sb.append(f.toString()).append("\n");
        }

        sb.append("\n=== PEOPLE IN PLACE ===\n");
        for (Character c : people) {
            sb.append(c.toString()).append("\n");
        }

        return sb.toString();
    }

    public void addPeople(Character charac) {
        people.add(charac);
        charac.setCurrentPlace(this);
    }

    public void removePeople(Character charac) {
        people.remove(charac);
        charac.setCurrentPlace(null);
    }

    public void healPeople() {
        for (Character c : people) {
            c.heal();
        }
    }

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

    
    public ArrayList<Character> getPeople() {
        return people; 
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    public String getName() { return name; }
    
    
    public int getNumberOfPeople() {
        return people.size();
    }
    
    
    public Boolean getBelongsTo() { return belongsTo; }
    
    public void setBelongsTo(Boolean belongsTo) { this.belongsTo = belongsTo;}
    
    public String getBelongsToName() {
    	
    	if(this.belongsTo == null) {
    		return "neutre";
    	}
    	else if(this.belongsTo) {
    		return "romains";
    	}
    	return "gaulois";
    }    
}
