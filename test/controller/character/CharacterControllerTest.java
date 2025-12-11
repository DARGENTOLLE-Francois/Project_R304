package controller.character;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.character.GallicMerchant;
import model.food.Food;
import model.magicpotion.MagicPotion;
import model.place.GallicVillage;
import view.character.CharacterView;

class CharacterControllerTest {

	private CharacterController controller;
	private GallicMerchant character;
	private CharacterView view;
	private GallicVillage village;

	@BeforeEach
	void setUp() {
		village = new GallicVillage("Village", 100, new ArrayList<>(), new ArrayList<>());
		character = new GallicMerchant("Astérix", "M", 1.60, 35, 10, 10, 50, 20, 0, 0, village);
		view = new CharacterView(); // Utilisation de la vue réelle (affiche dans la console)
		controller = new CharacterController(character, view);
	}

	@Test
	void testHeal() {
		int initialHealth = character.getHealth();
		controller.heal();
		assertEquals(initialHealth + 1, character.getHealth(), "Le contrôleur doit déclencher le soin du modèle.");
	}

	@Test
	void testEatFood() {
		int initialHunger = character.getHunger();
		controller.eatFood(Food.BOAR); // Sanglier (NutritionalValue.GOOD -> -20 faim)

		// 20 - 20 = 0
		assertEquals(0, character.getHunger(), "Le contrôleur doit faire manger le personnage.");
	}

	@Test
	void testModifyHunger() {
		int initialHunger = character.getHunger();
		controller.modifyHunger(5);
		assertEquals(initialHunger + 5, character.getHunger());
	}

	@Test
	void testDrinkPotion() {
		// Préparation d'une potion valide
		ArrayList<Food> ingredients = new ArrayList<>();
		ingredients.add(Food.MISTLETOE);
		ingredients.add(Food.CARROTS);
		ingredients.add(Food.SALT);
		ingredients.add(Food.FOURLEAF_CLOVER);
		ingredients.add(Food.FAIRLY_FRESH_FISH);
		ingredients.add(Food.HONEY);
		ingredients.add(Food.MEAD);
		ingredients.add(Food.SECRET_INGREDIENT);
		ingredients.add(Food.ROCK_OIL);

		MagicPotion potion = new MagicPotion(ingredients);

		// Action via le contrôleur
		controller.drinkPotion(potion);

		// Vérification des effets sur le modèle
		assertTrue(character.isInvincible(), "Le personnage doit devenir invincible après avoir bu via le contrôleur.");
		assertEquals(1, character.getDosesConsumed());
	}
}