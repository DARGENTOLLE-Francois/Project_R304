package model.player;

import model.character.*;
import model.character.Character;
import model.place.Place;
import model.food.Food;

import java.util.Iterator;

public class ClanChief {

    private String name;
    private String sex;
    private Integer age;
    private Place place;

    public ClanChief(String name, String sex, Integer age, Place place) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.place = place;
    }

    // ---------- GETTERS ----------
    public String getName() { return name; }
    public String getSex() { return sex; }
    public Integer getAge() { return age; }
    public Place getPlace() { return place; }

    // ---------- LOGIC METHODS ----------
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
                return new Druid(name, sex, height, age, 10,40,30,0,0,0);
            case 2:
				return new Blacksmith(name, sex, height, age, 10,40,60,0,0,0);            
			case 3:
                return new Innkeeper(name, sex, height, age, 10,40,20,0,0,0);
            case 4:
                return new GallicMerchant(name, sex, height, age, 15,20,25,0,0,0);
            case 5:
                return new Legionnaire(name, sex, height, age, 20,30,25,0,0,0);
            case 6:
                return new Prefect(name, sex, height, age, 22,12,35,0,0,0);
            case 7:
                return new General(name, sex, height, age, 26,18,30,0,0,0);
            case 8:
                return new FantasticCreaturesLycanthropes(name,sex,height,age,34,50,40,0,0,0);
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

}
