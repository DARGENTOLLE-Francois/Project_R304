package controller.player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.character.Character;
import model.character.Legionnaire;
import model.food.Food;
import model.place.RomanCity;
import model.player.ClanChiefModel;
import view.player.ClanChiefView;

class ClanChiefControllerTest {

	private ClanChiefController controller;
	private ClanChiefModel model;
	private RomanCity city;
	private ClanChiefView view;

	@BeforeEach
	void setUp() {
		city = new RomanCity("Lutèce", 200, new ArrayList<>(), new ArrayList<>());
		model = new ClanChiefModel("Chef", "M", 40, city);
		view = new ClanChiefView();
		controller = new ClanChiefController(model, view);
	}

	@Test
	void testHealAllCharacters() {
		// Ajout de personnages blessés
		Legionnaire c1 = new Legionnaire("A", "M", 1.8, 20, 10, 10, 10, 0, 0, 0, city);
		Legionnaire c2 = new Legionnaire("B", "M", 1.8, 20, 10, 10, 10, 0, 0, 0, city);
		city.addPeople(c1);
		city.addPeople(c2);

		// Action
		controller.healAllCharacters();

		// Vérification (+1 PV)
		assertEquals(11, c1.getHealth());
		assertEquals(11, c2.getHealth());
	}

	@Test
	void testCharactersEat() {
		// Personnage affamé
		Legionnaire c1 = new Legionnaire("A", "M", 1.8, 20, 10, 10, 10, 50, 0, 0, city);
		city.addPeople(c1);

		// Nourriture disponible
		city.getFood().add(Food.BOAR);

		// Action
		controller.charactersEat();

		// Vérification (Sanglier réduit la faim de 20)
		assertEquals(30, c1.getHunger());
		assertTrue(city.getFood().isEmpty(), "La nourriture doit avoir été consommée.");
	}

	@Test
	void testIsNotEmptyPlace() {
		assertFalse(controller.isNotEmptyPlace(), "Devrait être faux si le lieu est vide.");

		city.addPeople(new Legionnaire("A", "M", 1.8, 20, 10, 10, 10, 50, 0, 0, city));

		assertTrue(controller.isNotEmptyPlace(), "Devrait être vrai si le lieu contient des gens.");
	}
}