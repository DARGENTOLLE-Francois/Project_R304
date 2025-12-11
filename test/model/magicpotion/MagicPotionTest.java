package model.magicpotion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.food.Food;

class MagicPotionTest {

	private List<Food> validIngredients;

	@BeforeEach
	void setUp() {
		validIngredients = new ArrayList<>();
		validIngredients.add(Food.MISTLETOE);
		validIngredients.add(Food.CARROTS);
		validIngredients.add(Food.SALT);
		validIngredients.add(Food.FOURLEAF_CLOVER);
		validIngredients.add(Food.FAIRLY_FRESH_FISH);
		validIngredients.add(Food.HONEY);
		validIngredients.add(Food.MEAD);
		validIngredients.add(Food.SECRET_INGREDIENT);
		// Ajout d'un liant (obligatoire)
		validIngredients.add(Food.ROCK_OIL);
	}

	@Test
	void testMagicPotionValidity() {
		MagicPotion potion = new MagicPotion(validIngredients);
		assertTrue(potion.isValid(), "La potion devrait être valide avec tous les ingrédients de base + liant.");
		assertEquals(5, potion.getDoses(), "Une potion fraîche doit avoir 5 doses.");

		validIngredients.remove(Food.SECRET_INGREDIENT);
		MagicPotion badPotion = new MagicPotion(validIngredients);
		assertFalse(badPotion.isValid(), "La potion ne devrait pas être valide sans l'ingrédient secret.");
	}

	@Test
	void testIsNourishing() {
		MagicPotion potion = new MagicPotion(validIngredients);
		assertFalse(potion.isNourishing());

		validIngredients.add(Food.LOBSTER);
		MagicPotion tastyPotion = new MagicPotion(validIngredients);
		assertTrue(tastyPotion.isValid());
		assertTrue(tastyPotion.isNourishing(), "La potion devrait être nourrissante avec du Homard.");
	}

	@Test
	void testGivesSuperSpeed() {
		validIngredients.add(Food.MILK_FROM_A_TWOHEADED_UNICORN);
		MagicPotion speedPotion = new MagicPotion(validIngredients);

		assertTrue(speedPotion.isValid());
		assertTrue(speedPotion.givesSuperSpeed(), "La potion devrait donner la super vitesse avec du lait de licorne.");
	}

	@Test
	void testCausesLycanthropy() {
		validIngredients.add(Food.IDEFIX_HAIR);
		MagicPotion wolfPotion = new MagicPotion(validIngredients);

		assertTrue(wolfPotion.isValid());
		assertTrue(wolfPotion.causesLycanthropy(), "La potion devrait causer la lycanthropie avec un poil d'Idéfix.");
	}

	@Test
	void testTakeDose() {
		MagicPotion potion = new MagicPotion(validIngredients);

		for (int i = 0; i < 5; i++) {
			assertTrue(potion.takeDose(), "Devrait pouvoir prendre une dose tant qu'il en reste.");
		}

		assertFalse(potion.takeDose(), "Ne devrait pas pouvoir prendre de dose d'une marmite vide.");
		assertEquals(0, potion.getDoses());
	}

	@Test
	void testToString() {
		MagicPotion potion = new MagicPotion(validIngredients);
		assertNotNull(potion.toString());
		assertTrue(potion.toString().contains("Dose de potion magique"));

		validIngredients.clear();
		MagicPotion badPotion = new MagicPotion(validIngredients);
		assertTrue(badPotion.toString().contains("Potion invalide"));
	}
}