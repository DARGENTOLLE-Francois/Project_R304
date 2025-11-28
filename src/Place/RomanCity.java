package Place;

import java.util.ArrayList;
import Character.Character;
import Food.Food;

public class RomanCity extends Place {

    public RomanCity(String name, double surface, Integer numberOfPeople, ArrayList<Character> people,
            ArrayList<Food> food) {
        super(name, surface, numberOfPeople, people, food);
    }

    public RomanCity(String name, double surface) {
        super(name, surface, 0, new ArrayList<Character>(), new ArrayList<Food>());
    }
    
}