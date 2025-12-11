package model.place;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.character.GallicMerchant;
import model.character.Legionnaire;
import model.food.Food;

class BattlefieldTest {

	private Battlefield battlefield;
	private RomanCity rome;
	private GallicVillage village;

	@BeforeEach
	void setUp() {
		battlefield = new Battlefield("Gergovie", 500, new ArrayList<>(), new ArrayList<>());
		rome = new RomanCity("Rome", 1000, new ArrayList<>(), new ArrayList<>());
		village = new GallicVillage("Village d'Astérix", 100, new ArrayList<>(), new ArrayList<>());
	}

	@Test
	void testGetGallicAndRoman() {
		GallicMerchant gaulois = new GallicMerchant("Ordralfabétix", "M", 1.70, 50, 10, 10, 100, 0, 0, 0, village);
		Legionnaire romain = new Legionnaire("Caius Bonus", "M", 1.80, 40, 10, 10, 100, 0, 0, 0, rome);

		battlefield.addPeople(gaulois);
		battlefield.addPeople(romain);

		assertEquals(1, battlefield.getGallic().size(), "Devrait contenir 1 Gaulois");
		assertEquals(gaulois, battlefield.getGallic().get(0));

		assertEquals(1, battlefield.getRoman().size(), "Devrait contenir 1 Romain");
		assertEquals(romain, battlefield.getRoman().get(0));
	}

	@Test
	void testCanFight() {
		assertFalse(battlefield.canFight(), "Pas de combat si vide");

		GallicMerchant gaulois = new GallicMerchant("Astérix", "M", 1.60, 35, 10, 10, 100, 0, 0, 0, village);
		battlefield.addPeople(gaulois);
		assertFalse(battlefield.canFight(), "Pas de combat si seulement des Gaulois");

		Legionnaire romain = new Legionnaire("Romain", "M", 1.75, 30, 10, 10, 100, 0, 0, 0, rome);
		battlefield.addPeople(romain);
		assertTrue(battlefield.canFight(), "Combat possible si Gaulois ET Romains présents");
	}
}