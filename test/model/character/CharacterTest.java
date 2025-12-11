package model.character;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.food.Food;
import model.place.RomanCity;

import model.character.CategoryAge;

class CharacterTest {
	private RomanCity place;
	private Blacksmith testCharacter;
	private Blacksmith testCharacter2;
	
	@BeforeEach
	void setUp() {
		this.place = new RomanCity("B", 9, new ArrayList<Character>(), new ArrayList<Food>());
		this.testCharacter = new Blacksmith("A", "male", 1, 2, 3, 4, 5, 6, 7, 8, place);
		this.testCharacter2 = new Blacksmith("A", "male", 1, 2, 3, 4, 13, 6, 7, 8, place);
	}


	@Test
	void testGetName() {
		assertEquals("A", this.testCharacter.getName());
	}

	@Test
	void testSetName() {
		testCharacter.setName("C");
		assertEquals("C", testCharacter.getName());
	}

	@Test
	void testGetSexe() {
		assertEquals("male", testCharacter.getSexe());
	}

	@Test
	void testSetSexe() {
		testCharacter.setSexe("notMale");
		assertEquals("notMale", testCharacter.getSexe());

	}

	@Test
	void testGetHeight() {
		assertEquals(1, testCharacter.getHeight());
	}

	@Test
	void testSetHeight() {
		testCharacter.setHeight(11);
		assertEquals(11, testCharacter.getHeight());
	}

	@Test
	void testGetAge() {
		assertEquals(2, testCharacter.getAge());
	}

	@Test
	void testSetAge() {
		testCharacter.setAge(22);
		assertEquals(22, testCharacter.getAge());
	}

	@Test
	void testGetStrength() {
		assertEquals(3, testCharacter.getStrength());
	}

	@Test
	void testSetStrength() {
		testCharacter.setStrength(33);
		assertEquals(33, testCharacter.getStrength());

	}

	@Test
	void testGetStamina() {
		assertEquals(4, testCharacter.getStamina());
	}

	@Test
	void testSetStamina() {
		testCharacter.setStamina(44);
		assertEquals(44, testCharacter.getStamina());
	}

	@Test
	void testGetHealth() {
		assertEquals(5, testCharacter.getHealth());
	}

	@Test
	void testSetHealth() {
		testCharacter.setHealth(55);
		assertEquals(55, testCharacter.getHealth());
	}

	@Test
	void testGetHunger() {
		assertEquals(6, testCharacter.getHunger());
	}

	@Test
	void testSetHunger() {
		testCharacter.setHunger(66);
		assertEquals(66, testCharacter.getHunger());
	}

	@Test
	void testGetBelligerence() {
		assertEquals(7, testCharacter.getBelligerence());
	}

	@Test
	void testSetBelligerence() {
		testCharacter.setBelligerence(77);
		assertEquals(77, testCharacter.getBelligerence());
	}

	@Test
	void testGetLevelOfPotion() {
		assertEquals(8, testCharacter.getLevelOfPotion());
	}

	@Test
	void testSetLevelOfPotion() {
		testCharacter.setLevelOfPotion(88);
		assertEquals(88, testCharacter.getLevelOfPotion());
	}

	@Test
	void testIsInvincible() {
		assertEquals(this.testCharacter.isInvincible(), false);
	}

	@Test
	void testIsPetrified() {
		assertEquals(this.testCharacter.isPetrified(), false);
	}

	@Test
	void testIsLycanthrope() {
		assertEquals(this.testCharacter.isLycanthrope(), false);
	}

	@Test
	void testHasSuperSpeed() {
		assertEquals(this.testCharacter.hasSuperSpeed(), false);
	}

	@Test
	void testGetDosesConsumed() {
		assertEquals(this.testCharacter.getDosesConsumed(), 0);
	}

	@Test
	void testGetPlaceOfOrigin() {
		assertEquals(place, testCharacter.getCurrentPlace());
	}

	@Test
	void testGetCurrentPlace() {
		assertEquals(place, testCharacter.getCurrentPlace());
	}

	@Test
	void testSetCurrentPlace() {
		testCharacter.setCurrentPlace(null);
		assertEquals(null, testCharacter.getCurrentPlace());
	}

	@Test
	void testCharacterStringStringDoubleIntegerIntegerIntegerIntegerIntegerIntegerIntegerPlace() {
		assertEquals("A", testCharacter.getName());
		assertEquals("male", testCharacter.getSexe());
		assertEquals(1, testCharacter.getHeight());
		assertEquals(2, testCharacter.getAge());
		assertEquals(3, testCharacter.getStrength());
		assertEquals(4, testCharacter.getStamina());
		assertEquals(5, testCharacter.getHealth());
		assertEquals(6, testCharacter.getHunger());
		assertEquals(7, testCharacter.getBelligerence());
		assertEquals(8, testCharacter.getLevelOfPotion());
		assertEquals(place, testCharacter.getPlaceOfOrigin());
		assertEquals(place, testCharacter.getCurrentPlace());
	}

	@Test
	void testStrike() {
		testCharacter.strike(testCharacter2);
		assertEquals(testCharacter2.getHealth(), 1);
	}

	@Test
	void testHeal() {
		testCharacter.heal();
		assertEquals(testCharacter.getHealth(), 6);
	}

	@Test
	void testEat() {
		testCharacter.eat();
		assertEquals(testCharacter.getHunger(), 5);
	}

	@Test
	void testPassAway() {
		assertEquals(testCharacter.passAway(), false);
		testCharacter.setHealth(0);
		assertEquals(testCharacter.passAway(), true);
	}

	@Test
	void testModifyHunger() {
		testCharacter.modifyHunger(2);
		assertEquals(testCharacter.getHunger(), 8);
		
	}

	@Test
	void testModifyBelligerence() {
		testCharacter.modifyBelligerence(2);
		assertEquals(testCharacter.getBelligerence(), 9);
	}

	@Test
	void testModifyLevelOfPotion() {
		testCharacter.modifyLevelOfPotion(2);
		assertEquals(testCharacter.getHunger(), 6);
	}

}
