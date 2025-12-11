package model.lycanthrope;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.character.CategoryAge;
import model.character.FantasticCreaturesLycanthropes;
import model.character.Rank;
import model.character.Sex;

class ColonyTest {

	private Colony colony;
	private Pack pack;

	@BeforeEach
	void setUp() {
		colony = new Colony();
		pack = new Pack();

		// Ajout d'un couple Alpha pour que la meute soit viable
		FantasticCreaturesLycanthropes alphaM = new FantasticCreaturesLycanthropes(
				"AlphaM", Sex.MALE, 2.0, CategoryAge.ADULT, 100, 100, 100, 0, 0, 0, 50, 10, false, Rank.ALPHA, true);
		FantasticCreaturesLycanthropes alphaF = new FantasticCreaturesLycanthropes(
				"AlphaF", Sex.FEMALE, 1.9, CategoryAge.ADULT, 100, 100, 100, 0, 0, 0, 50, 10, false, Rank.ALPHA, false);

		pack.addMember(alphaM);
		pack.addMember(alphaF);

		colony.addPack(pack);
	}

	@Test
	void testAddPack() {
		assertEquals(1, colony.getPacks().size());
		assertEquals(pack, colony.getPacks().get(0));
	}

	@Test
	void testFastForwardTimeAging() {
		// Ajout d'un jeune loup
		FantasticCreaturesLycanthropes jeune = new FantasticCreaturesLycanthropes(
				"Jeune", Sex.MALE, 1.5, CategoryAge.YOUNG, 50, 50, 100, 0, 0, 0, 0, 10, false, Rank.GAMMA, true);
		pack.addMember(jeune);

		// Simulation du temps (boucle pour forcer le hasard ou vérifier l'état après N tours)
		// Note : fastForwardTime utilise de l'aléatoire (Random), ce qui rend le test unitaire strict difficile sans Mock.
		// Ici, on vérifie au moins que la méthode s'exécute sans erreur et retourne des messages.

		List<String> messages = colony.fastForwardTime(1);
		assertNotNull(messages);

		// On ne peut pas garantir qu'il vieillisse en 1 tour (probabilité),
		// mais on vérifie que la structure est intègre.
		assertTrue(colony.getPacks().contains(pack));
	}

	@Test
	void testSolitaryToPackCreation() {
		// Création de deux solitaires (Mâle et Femelle)
		FantasticCreaturesLycanthropes loupSolitaireM = new FantasticCreaturesLycanthropes(
				"SolitaireM", Sex.MALE, 2.0, CategoryAge.ADULT, 80, 80, 100, 0, 0, 0, 10, 10, false, Rank.OMEGA, true);
		FantasticCreaturesLycanthropes loupSolitaireF = new FantasticCreaturesLycanthropes(
				"SolitaireF", Sex.FEMALE, 1.8, CategoryAge.ADULT, 80, 80, 100, 0, 0, 0, 10, 10, false, Rank.OMEGA, false);

		colony.getSolitaries().add(loupSolitaireM);
		colony.getSolitaries().add(loupSolitaireF);

		// Au prochain tour, ils devraient former une nouvelle meute
		colony.fastForwardTime(1);

		// Vérification
		boolean newPackFound = false;
		for (Pack p : colony.getPacks()) {
			if (p.getMembers().contains(loupSolitaireM) && p.getMembers().contains(loupSolitaireF)) {
				newPackFound = true;
				break;
			}
		}

		// Note : Comme c'est appelé par fastForwardTime qui fait plein de Random,
		// il est possible que attemptCreatePackFromSolitaries soit appelé.
		// Dans votre code, attemptCreatePackFromSolitaries est appelé systématiquement au début de fastForwardTime.
		// Donc cela devrait passer à coup sûr.

		assertTrue(newPackFound, "Les solitaires auraient dû former une nouvelle meute.");
		assertFalse(colony.getSolitaries().contains(loupSolitaireM));
	}
}