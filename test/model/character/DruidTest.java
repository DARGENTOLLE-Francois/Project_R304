package model.character;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.food.Food;
import model.magicpotion.MagicPotion;
import model.place.GallicVillage;

class DruidTest {

	private Druid panoramix;
	private GallicVillage village;

	@BeforeEach
	void setUp() {
		village = new GallicVillage("Village", 100, new ArrayList<>(), new ArrayList<>());
		panoramix = new Druid("Panoramix", "M", 1.6, 90, 10, 10, 100, 0, 0, 0, village);
	}

	@Test
	void testPrepareIngredients() {
		List<Food> ingredients = panoramix.prepareIngredients();

		assertNotNull(ingredients);
		assertTrue(ingredients.contains(Food.MISTLETOE));
		assertTrue(ingredients.contains(Food.ROCK_OIL));
		// Vérifie que la liste contient bien les ingrédients de base
		assertTrue(ingredients.size() >= 8);
	}

	@Test
	void testMakePotion() {
		List<Food> ingredients = panoramix.prepareIngredients();

		// Création de la potion
		MagicPotion potion = panoramix.MakePotion(ingredients);

		assertNotNull(potion);
		assertTrue(potion.isValid(), "Le druide doit créer une potion valide avec ses ingrédients par défaut.");
		assertEquals(5, potion.getDoses());
	}

	@Test
	void testMakePotionNull() {
		MagicPotion potion = panoramix.MakePotion(null);
		assertNull(potion, "Si pas d'ingrédients, pas de potion.");
	}
}