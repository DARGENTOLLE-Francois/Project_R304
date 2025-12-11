package model.character;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FantasticCreaturesLycanthropesTest {

	private FantasticCreaturesLycanthropes wolfDominant;
	private FantasticCreaturesLycanthropes wolfSubmissive;

	@BeforeEach
	void setUp() {
		// Constructeur complet : Name, Sex, Height, AgeCat, Str, Sta, HP, Hunger, Bell, Pot, Dom, Imp, Sick, Rank, isMale

		// Loup dominant : Adulte, Fort (100), Impétueux (10), Rang Beta (9)
		wolfDominant = new FantasticCreaturesLycanthropes(
				"AlphaWannabe", Sex.MALE, 2.1, CategoryAge.ADULT,
				100, 50, 100, 0, 0, 0, 20, 10, false, Rank.BETA, true
		);

		// Loup dominé : Jeune, Faible (50), Peu impétueux (2), Rang Omega (0)
		wolfSubmissive = new FantasticCreaturesLycanthropes(
				"OmegaWolf", Sex.MALE, 1.8, CategoryAge.YOUNG,
				50, 50, 100, 0, 0, 0, 0, 2, false, Rank.OMEGA, true
		);
	}

	@Test
	void testCalculateLevel() {
		// Formule : (Strength + Domination + RankValue) * AgeValue
		// WolfDominant : (100 + 20 + 9) * 2 (ADULT) = 129 * 2 = 258.0
		assertEquals(258.0, wolfDominant.calculateLevel(), 0.01);

		// WolfSubmissive : (50 + 0 + 0) * 1 (YOUNG) = 50.0
		assertEquals(50.0, wolfSubmissive.calculateLevel(), 0.01);
	}

	@Test
	void testAttemptDominationByForce() {
		// Configuration : Hurlement de domination pour les deux
		wolfDominant.setHowl(TypeHowling.DOMINATION);
		wolfSubmissive.setHowl(TypeHowling.DOMINATION);

		// Avant domination
		assertEquals(Rank.BETA, wolfDominant.getRank());
		assertEquals(Rank.OMEGA, wolfSubmissive.getRank());
		int initialDom = wolfDominant.getDomination_factor();

		// Action : Le dominant attaque le dominé
		// myPower (100*10 = 1000) >= targetStrength (50) -> Vrai
		// Level (258) > TargetLevel (50) -> Vrai
		wolfDominant.attemptDomination(wolfSubmissive);

		// Vérification : Facteur domination augmente, échange de rangs (ici Omega <-> Beta)
		assertEquals(initialDom + 1, wolfDominant.getDomination_factor());

		// Note : Dans votre logique actuelle, les rangs sont échangés.
		// Donc le dominant prend le rang du dominé (Omega) et vice versa.
		// Ce comportement est un peu étrange ("Échange de rangs effectué"), mais c'est ce que le code fait.
		assertEquals(Rank.OMEGA, wolfDominant.getRank());
		assertEquals(Rank.BETA, wolfSubmissive.getRank());
	}

	@Test
	void testDominationBySubmission() {
		wolfDominant.setHowl(TypeHowling.DOMINATION);
		wolfSubmissive.setHowl(TypeHowling.SUBMISSION); // Se soumet directement

		int initialDom = wolfDominant.getDomination_factor();

		wolfDominant.attemptDomination(wolfSubmissive);

		// Pas d'échange de rang, juste gain de facteur domination
		assertEquals(initialDom + 1, wolfDominant.getDomination_factor());
		assertEquals(Rank.BETA, wolfDominant.getRank()); // Reste Beta
	}

	@Test
	void testTransformationHuman() {
		assertFalse(wolfDominant.isHuman());
		wolfDominant.transformationHuman();
		assertTrue(wolfDominant.isHuman());
	}
}