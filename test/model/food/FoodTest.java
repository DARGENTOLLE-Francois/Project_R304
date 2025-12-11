package model.food;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.character.Blacksmith;
import model.character.Character;
import model.place.RomanCity;

class FoodTest {
	private Food testFood;

	@BeforeEach
	void setUp() {
		this.testFood = Food.values()[0];
	}
	
	@Test
	void testGetName() {
		assertEquals("Sanglier", this.testFood.getName());
	}

	@Test
	void testGetFreshnessLevel() {
		assertEquals(FreshnessLevel.FRESH, this.testFood.getFreshnessLevel());
	}

	@Test
	void testSetFreshnessLevel() {
		this.testFood.setFreshnessLevel(FreshnessLevel.FAIRLY_FRESH);
		assertEquals(FreshnessLevel.FAIRLY_FRESH, this.testFood.getFreshnessLevel());
		this.testFood.setFreshnessLevel(FreshnessLevel.FRESH);
	}

	@Test
	void testGetCategory() {
		assertEquals(Category.MEAT, this.testFood.getCategory());
	}

	@Test
	void testGetNutritionalValue() {
		assertEquals(NutritionalValue.GOOD, this.testFood.getNutritionalValue());
	}

}
