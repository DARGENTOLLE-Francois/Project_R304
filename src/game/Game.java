package game;

import model.player.ClanChiefModel;
import model.place.*;
import model.invasiontheatre.InvasionTheatreModel;
import model.character.*;
import model.food.Food;
import view.invasiontheatreview.InvasionTheatreView;

import java.util.ArrayList;

import controller.invasiontheatre.InvasionTheatreController;

/**
* The Game class.
* This class is the starter component of the game, it will give a link between the three Invasion Theatre MVC elements.
* From this class, the game can run.
* 
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class Game {
	/** 
     * The InvasionTheaterController for the game
     */
    private InvasionTheatreController controller;
    /** 
     * The InvasionTheatreModel for the game
     */
    private InvasionTheatreModel model;
    /** 
     * The InvasionTheatreView for the game
     */
    private InvasionTheatreView view;

    /** 
     * Creates a game with static parameters chosen by us (the gods).
     *
     * @return             The newly created object
     */
    public Game() {
    	
    	// Definition of Places
		RomanCity romanCity = new RomanCity("base", 10, new ArrayList<>(), new ArrayList<>());
		romanCity.getFood().add(Food.WINE);
		romanCity.getFood().add(Food.MEAD); 
		
		Legionnaire furkanus = new Legionnaire("Marcus Furkanus", "Homme", 1.25,
	            28,
	            18, 28, 45, 0, 0, 0 , romanCity);
		romanCity.addPeople(furkanus);

		Battlefield battlefield = new Battlefield("Champ de bataille 1", 10, new ArrayList<>(), new ArrayList<>());

		GallicVillage gallicVillage = new GallicVillage("Village Gaulois", 500, new ArrayList<>(), new ArrayList<>());
		
		General general1 = new General("François", "Jte dis pas", 0.55, 30, 5, 10, 10, 0,0,0, romanCity);
		General general2 = new General("Enzo", "Obscur", 2.80, 20, 40, 10, 10, 0,0,0, romanCity);
		GallicMerchant gallic1 = new GallicMerchant("Dinesh", "Indien", 0.25, 10,5,1,1,0,0,0, gallicVillage);
		Gallic gallic2 = new GallicMerchant("Samuel", "Renoi", 0.40, 18,10,1,20,0,0,0, gallicVillage);
		
        FantasticCreaturesLycanthropes alphaM = new FantasticCreaturesLycanthropes(
                "AlphaWolf_M", Sex.MALE, 2.1, CategoryAge.ADULT, 
                90, 100, 100, 0, 0, 0, 50, 80, false, Rank.ALPHA, true
            );
            
        FantasticCreaturesLycanthropes alphaF = new FantasticCreaturesLycanthropes(
                "AlphaWolf_F", Sex.FEMALE, 1.9, CategoryAge.ADULT, 
                85, 100, 100, 0, 0, 0, 50, 80, false, Rank.ALPHA, false
            );

        FantasticCreaturesLycanthropes beta = new FantasticCreaturesLycanthropes(
                "BetaWolf", Sex.MALE, 2.0, CategoryAge.ADULT, 
                70, 100, 100, 0, 0, 0, 20, 60, false, Rank.BETA, true
            );
            
        FantasticCreaturesLycanthropes omega = new FantasticCreaturesLycanthropes(
                "OmegaWolf", Sex.FEMALE, 1.8, CategoryAge.ADULT, 
                30, 100, 100, 0, 0, 0, 0, 20, false, Rank.OMEGA, true
            );
        FantasticCreaturesLycanthropes kappa = new FantasticCreaturesLycanthropes(
                "BetaWolf", Sex.MALE, 2.0, CategoryAge.ADULT, 
                70, 100, 100, 0, 0, 0, 20, 60, false, Rank.KAPPA, true
            );
            
        FantasticCreaturesLycanthropes delta = new FantasticCreaturesLycanthropes(
                "OmegaWolf", Sex.FEMALE, 1.8, CategoryAge.ADULT, 
                30, 100, 100, 0, 0, 0, 0, 20, false, Rank.DELTA, true
            );
		Enclosure enclosure = new Enclosure("Enclos des Loups", 100, new ArrayList<>(), new ArrayList<>());
		enclosure.addPeople(alphaM);
		enclosure.addPeople(alphaF);
		enclosure.addPeople(beta);
		enclosure.addPeople(omega);
		enclosure.addPeople(kappa);
		enclosure.addPeople(delta);
		enclosure.getFood().add(Food.BOAR);
		
		battlefield.addPeople(gallic1);
		battlefield.addPeople(general1);
		battlefield.addPeople(general2);
		battlefield.addPeople(gallic2);
		
		// Add Places into array of Places
        ArrayList<Place> places = new ArrayList<>();
        places.add(romanCity);
		places.add(battlefield);
		places.add(gallicVillage);
		places.add(enclosure);
		
		
		// Definition of Chiefs
		ClanChiefModel c1 = new ClanChiefModel("César", "Homme", 19, romanCity);
		ClanChiefModel c2 = new ClanChiefModel("Versingetorix", "Homme", 25, gallicVillage);
		
		ArrayList<ClanChiefModel> lc1 = new ArrayList<>();
        lc1.add(c1);
        lc1.add(c2);
        
       
        model = new InvasionTheatreModel("Simulation 50av JC", 10,places, lc1);
        view= new InvasionTheatreView();
        controller = new InvasionTheatreController(model, view);
        
    }
    
    /** 
     * Starts the game by starting the loops in the InvasionTheaterController.
     *
     * @return             void
     */
    public void start() {
    	controller.showMainMenu();
    }
}
