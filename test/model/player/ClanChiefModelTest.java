package model.player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import includes.exception.ExceptionEmptyField;
import includes.exception.ExceptionValidationField;
import model.place.RomanCity;
import model.place.Place;
import model.food.Food;
import model.character.Character;

class ClanChiefModelTest {

	private ClanChiefModel chief;
	private RomanCity city;

	@BeforeEach
	void setUp() {
		city = new RomanCity("Lutèce", 100, new ArrayList<Character>(), new ArrayList<Food>());
		chief = new ClanChiefModel("Abraracourcix", "Homme", 50, city);
	}

	@Test
	void testCreateCharacterThrowsExceptionEmptyFieldWhenNameIsNull() {
		ExceptionEmptyField exception = assertThrows(ExceptionEmptyField.class, () -> {
			chief.createCharacter(null, "Homme", 1.80, 25, 1);
		});

		assertEquals("Le nom du personnage ne peut pas être vide !", exception.getMessage());
	}

	@Test
	void testCreateCharacterThrowsExceptionEmptyFieldWhenNameIsEmpty() {
		assertThrows(ExceptionEmptyField.class, () -> {
			chief.createCharacter(" ", "Homme", 1.80, 25, 1);
		});
	}


	@Test
	void testCreateCharacterThrowsExceptionValidationFieldInvalidType() {
		ExceptionValidationField exception = assertThrows(ExceptionValidationField.class, () -> {
			chief.createCharacter("Obélix", "Homme", 1.90, 30, 99);
		});

		assertTrue(exception.getMessage().contains("n'existe pas"));
	}

	@Test
	void testChooseCharacThrowsExceptionValidationFieldInvalidIndex() {
		assertThrows(ExceptionValidationField.class, () -> {
			chief.chooseCharac(0);
		});

		assertThrows(ExceptionValidationField.class, () -> {
			chief.chooseCharac(1);
		});
	}

	@Test
	void testChooseDestinationThrowsExceptionValidationFieldInvalidIndex() {
		ArrayList<Place> destinations = new ArrayList<>();
		destinations.add(new RomanCity("Rome", 500, new ArrayList<>(), new ArrayList<>()));

		assertThrows(ExceptionValidationField.class, () -> {
			chief.chooseDestination(destinations, 2);
		});
	}
}