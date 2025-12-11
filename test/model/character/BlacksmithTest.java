package model.character;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.food.Food;
import model.place.RomanCity;

class BlacksmithTest {
	
	@Test
	void testBlacksmith() {
		RomanCity place = new RomanCity("B", 9, new ArrayList<Character>(), new ArrayList<Food>());
		Blacksmith blacksmith = new Blacksmith("A", "male", 1, 2, 3, 4, 5, 6, 7, 8, place);
		
		assertEquals("A", blacksmith.getName());
		assertEquals("male", blacksmith.getSexe());
		assertEquals(1, blacksmith.getHeight());
		assertEquals(2, blacksmith.getAge());
		assertEquals(3, blacksmith.getStrength());
		assertEquals(4, blacksmith.getStamina());
		assertEquals(5, blacksmith.getHealth());
		assertEquals(6, blacksmith.getHunger());
		assertEquals(7, blacksmith.getBelligerence());
		assertEquals(8, blacksmith.getLevelOfPotion());
		assertEquals(place, blacksmith.getPlaceOfOrigin());
		assertEquals(place, blacksmith.getCurrentPlace());
	}
}
