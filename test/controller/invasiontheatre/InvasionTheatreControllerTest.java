package controller.invasiontheatre;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.character.Legionnaire;
import model.invasiontheatre.InvasionTheatreModel;
import model.place.Place;
import model.place.RomanCity;
import model.player.ClanChiefModel;
import view.invasiontheatreview.InvasionTheatreView;

class InvasionTheatreControllerTest {

	private InvasionTheatreController controller;
	private InvasionTheatreModel model;
	private InvasionTheatreView view;

	// Flux pour capturer la sortie console (System.out)
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	void setUp() {
		// Redirection de la sortie standard vers notre flux pour l'analyser
		System.setOut(new PrintStream(outContent));

		// 1. Initialisation du modèle avec des données contrôlées
		ArrayList<Place> places = new ArrayList<>();
		RomanCity rome = new RomanCity("Rome", 1000, new ArrayList<>(), new ArrayList<>());

		// Ajout d'un personnage pour avoir de la donnée à afficher
		rome.addPeople(new Legionnaire("Caius", "M", 1.80, 30, 10, 10, 100, 0, 0, 0, rome));
		places.add(rome);

		ArrayList<ClanChiefModel> chiefs = new ArrayList<>();
		chiefs.add(new ClanChiefModel("César", "M", 50, rome));

		model = new InvasionTheatreModel("Empire Romain Test", 5, places, chiefs);
		view = new InvasionTheatreView();

		// 2. Création du contrôleur
		controller = new InvasionTheatreController(model, view);
	}

	@AfterEach
	void restoreStreams() {
		// Rétablissement de la sortie standard normale après chaque test
		System.setOut(originalOut);
	}

	@Test
	void testDisplayPlaces() {
		// Exécution
		controller.displayPlaces();

		// Vérification
		String output = outContent.toString();

		// On vérifie que le titre du théâtre et le nom du lieu apparaissent bien
		assertTrue(output.contains("LIEUX DU THÉÂTRE : Empire Romain Test"), "Le titre doit contenir le nom du théâtre.");
		assertTrue(output.contains("Rome"), "La liste doit contenir le nom du lieu 'Rome'.");
	}

	@Test
	void testDisplayTotalCharacters() {
		// Exécution
		controller.displayTotalCharacters();

		// Vérification
		String output = outContent.toString();

		assertTrue(output.contains("POPULATION DU THÉÂTRE"), "Doit afficher le titre de section.");
		// On a ajouté 1 légionnaire dans le setUp, donc le total doit être 1
		assertTrue(output.contains("Nombre total de personnages : 1"), "Le total affiché doit être de 1.");
	}

	@Test
	void testDisplayAllCharacters() {
		// Exécution
		controller.displayAllCharacters();

		// Vérification
		String output = outContent.toString();

		assertTrue(output.contains("TOUS LES PERSONNAGES DU THÉÂTRE"));
		// Vérifie les détails du personnage
		assertTrue(output.contains("Rome"), "Doit mentionner le lieu.");
		assertTrue(output.contains("Caius"), "Doit afficher le nom du personnage.");
		assertTrue(output.contains("Legionnaire"), "Doit afficher la classe du personnage.");
	}
}