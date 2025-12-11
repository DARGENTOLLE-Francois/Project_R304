package model.character;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RankTest {

	@Test
	void testValues() {
		// Vérification des valeurs numériques
		assertEquals(10, Rank.ALPHA.getValue());
		assertEquals(0, Rank.OMEGA.getValue());
	}

	@Test
	void testNext() {

		// Cas normal : Beta (9) -> Alpha (10)
		assertEquals(Rank.ALPHA, Rank.BETA.next());

		// Cas normal : Omega (0) -> Sigma (1)
		assertEquals(Rank.SIGMA, Rank.OMEGA.next());

		// Cas limite : Alpha (10) -> Pas de 11 -> Reste Alpha
		assertEquals(Rank.ALPHA, Rank.ALPHA.next());
	}

	@Test
	void testPrevious() {
		// La méthode previous() cherche value - 1 (Descendre en grade)

		// Cas normal : Alpha (10) -> Beta (9)
		assertEquals(Rank.BETA, Rank.ALPHA.previous());

		// Cas normal : Sigma (1) -> Omega (0)
		assertEquals(Rank.OMEGA, Rank.SIGMA.previous());

		// Cas limite : Omega (0) -> Pas de -1 -> Reste Omega
		assertEquals(Rank.OMEGA, Rank.OMEGA.previous());
	}
}