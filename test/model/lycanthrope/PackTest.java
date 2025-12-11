package model.lycanthrope;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.character.CategoryAge;
import model.character.FantasticCreaturesLycanthropes;
import model.character.Rank;
import model.character.Sex;

class PackTest {

	private Pack pack;
	private FantasticCreaturesLycanthropes maleFort;
	private FantasticCreaturesLycanthropes maleFaible;
	private FantasticCreaturesLycanthropes femelleAlpha;

	@BeforeEach
	void setUp() {
		pack = new Pack();

		// Initialisation des loups
		// Constructeur : Name, SexEnum, Height, AgeCat, Str, Sta, HP, Hunger, Bell, Pot, Dom, Imp, Sick, Rank, isMale

		// Mâle fort (Force 100 + Dom 50)
		maleFort = new FantasticCreaturesLycanthropes(
				"AlphaMale", Sex.MALE, 2.0, CategoryAge.ADULT,
				100, 50, 100, 0, 0, 0, 50, 10, false, Rank.BETA, true
		);

		// Mâle faible (Force 10 + Dom 0)
		maleFaible = new FantasticCreaturesLycanthropes(
				"OmegaMale", Sex.MALE, 1.8, CategoryAge.ADULT,
				10, 50, 100, 0, 0, 0, 0, 10, false, Rank.OMEGA, true
		);

		// Femelle (Force 80)
		femelleAlpha = new FantasticCreaturesLycanthropes(
				"AlphaFemale", Sex.FEMALE, 1.9, CategoryAge.ADULT,
				80, 50, 100, 0, 0, 0, 40, 10, false, Rank.BETA, false
		);
	}

	@Test
	void testAddMemberAndHierarchyCalculation() {
		// Ajout du mâle faible -> Il devrait être Alpha car seul
		pack.addMember(maleFaible);
		assertEquals(Rank.ALPHA, maleFaible.getRank(), "Le premier mâle doit passer Alpha");
		assertEquals(maleFaible, pack.getAlphaMale());

		// Ajout du mâle fort -> Il doit prendre la place d'Alpha
		pack.addMember(maleFort);
		assertEquals(Rank.ALPHA, maleFort.getRank(), "Le mâle le plus fort doit devenir Alpha");
		assertEquals(Rank.BETA, maleFaible.getRank(), "L'ancien Alpha doit être rétrogradé (BETA)");
		assertEquals(maleFort, pack.getAlphaMale());
	}

	@Test
	void testCoupleAlpha() {
		pack.addMember(maleFort);
		pack.addMember(femelleAlpha);

		assertEquals(maleFort, pack.getAlphaMale());
		assertEquals(femelleAlpha, pack.getAlphaFemale());

		assertEquals(Rank.ALPHA, maleFort.getRank());
		assertEquals(Rank.ALPHA, femelleAlpha.getRank());
	}

	@Test
	void testReproduction() {
		pack.addMember(maleFort);
		pack.addMember(femelleAlpha);

		int initialSize = pack.getMembers().size();

		// Reproduction
		ArrayList<String> messages = pack.reproduce();

		assertTrue(pack.getMembers().size() > initialSize, "La meute doit s'agrandir après reproduction");
		assertFalse(messages.isEmpty(), "Il doit y avoir des messages de naissance");

		// Vérifier que les enfants sont bien liés à la meute
		FantasticCreaturesLycanthropes child = pack.getMembers().get(initialSize); // Premier enfant
		assertEquals(pack, child.getPack(), "L'enfant doit appartenir à la meute");
		assertEquals(CategoryAge.YOUNG, child.getCage(), "L'enfant doit être jeune");
	}

	@Test
	void testRemoveMember() {
		pack.addMember(maleFort);
		pack.addMember(maleFaible);

		// maleFort est Alpha. On le retire.
		pack.removeMember(maleFort);

		assertFalse(pack.getMembers().contains(maleFort));
		assertNull(maleFort.getPack());

		// maleFaible doit devenir le nouvel Alpha
		assertEquals(maleFaible, pack.getAlphaMale(), "Le mâle restant doit devenir Alpha");
		assertEquals(Rank.ALPHA, maleFaible.getRank());
	}
}