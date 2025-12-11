package model.place;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.character.Character;
import model.character.Legionnaire;
import model.food.Food;

class PlaceTest {

	private Place place;
	private Character testChar;

	@BeforeEach
	void setUp() {
		// Place est abstrait, on utilise une implémentation concrète (RomanCity) pour tester
		place = new RomanCity("Lugdunum", 100, new ArrayList<>(), new ArrayList<>());

		// Création d'un personnage de test
		// Constructeur : Name, Sex, Height, Age, Str, Sta, HP, Hunger, Bell, Pot, Origin
		testChar = new Legionnaire("Caius", "M", 1.80, 30, 10, 10, 50, 20, 0, 0, place);
	}

	@Test
	void testPlaceConstructorAndGetters() {
		assertEquals("Lugdunum", place.getName());
		assertNotNull(place.getPeople(), "La liste de personnes ne doit pas être null");
		assertNotNull(place.getFood(), "La liste de nourriture ne doit pas être null");
		assertTrue(place.getPeople().isEmpty());
		assertTrue(place.getFood().isEmpty());
	}

	@Test
	void testAddPeople() {
		place.addPeople(testChar);

		assertEquals(1, place.getPeople().size());
		assertTrue(place.getPeople().contains(testChar));
		assertEquals(place, testChar.getCurrentPlace(), "Le lieu courant du personnage doit être mis à jour.");
	}

	@Test
	void testRemovePeople() {
		place.addPeople(testChar);
		place.removePeople(testChar);

		assertTrue(place.getPeople().isEmpty());
	}

	@Test
	void testHealPeople() {
		place.addPeople(testChar);

		// Santé initiale fixée à 50 dans le setUp
		int initialHealth = testChar.getHealth();

		place.healPeople();

		assertEquals(initialHealth + 1, testChar.getHealth(), "La méthode healPeople() doit soigner tous les personnages du lieu.");
	}

	@Test
	void testFeedPeople() {
		place.addPeople(testChar);

		// Ajout de nourriture
		place.getFood().add(Food.BOAR); // NutritionalValue.GOOD -> -20 faim

		int initialHunger = testChar.getHunger(); // 20
		int initialFoodSize = place.getFood().size();

		String result = place.feedPeople();

		// Vérifications
		assertTrue(result.contains("1 characters have eaten"));
		assertEquals(initialHunger - 20, testChar.getHunger(), "Le personnage doit avoir mangé (faim réduite).");
		assertEquals(initialFoodSize - 1, place.getFood().size(), "La nourriture consommée doit être retirée du lieu.");
	}

	@Test
	void testFeedPeopleNotEnoughFood() {
		Character c2 = new Legionnaire("Brutus", "M", 1.8, 30, 10, 10, 50, 50, 0, 0, place);

		place.addPeople(testChar);
		place.addPeople(c2);

		// Une seule portion de nourriture pour deux personnes
		place.getFood().add(Food.BOAR);

		String result = place.feedPeople();

		assertTrue(result.contains("1 characters have eaten"), "Seul un personnage devrait avoir mangé.");
		assertTrue(place.getFood().isEmpty(), "Plus de nourriture disponible.");

		// Le premier ajouté (testChar) mange
		assertEquals(0, testChar.getHunger());
		// Le deuxième (c2) reste affamé
		assertEquals(50, c2.getHunger());
	}

	@Test
	void testGetSpecifications() {
		place.addPeople(testChar);
		place.getFood().add(Food.WINE);

		String specs = place.getSpecifications();

		assertNotNull(specs);
		assertTrue(specs.contains("PEOPLE IN PLACE"));
		assertTrue(specs.contains("Caius")); // Nom du personnage
		assertTrue(specs.contains("FOOD IN PLACE"));
		assertTrue(specs.contains("Vin")); // Nom de la nourriture
	}
}