package game;

import model.player.ClanChiefModel;
import model.place.*;
import model.InvasionTheatre.InvasionTheatreModel;
import model.character.*;
import model.food.Food;
import view.InvasionTheatreView.InvasionTheatreView;

import java.util.ArrayList;

import controller.InvasionTheatre.InvasionTheatreController;

public class Game {

    private InvasionTheatreController controller;
    private InvasionTheatreModel model;
    private InvasionTheatreView view;

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
		
		battlefield.addPeople(gallic1);
		battlefield.addPeople(general1);
		battlefield.addPeople(general2);
		
		
		// Add Places into array of Places
        ArrayList<Place> places = new ArrayList<>();
        places.add(romanCity);
		places.add(battlefield);
		places.add(gallicVillage);
		
		// Definition of Chiefs
		ClanChiefModel c1 = new ClanChiefModel("César", "Homme", 19, romanCity);
		
		ArrayList<ClanChiefModel> lc1 = new ArrayList<>();
        lc1.add(c1);
        
       
        model = new InvasionTheatreModel("Simulation 50av JC", 10,places, lc1);
        view= new InvasionTheatreView();
        controller = new InvasionTheatreController(model, view);
        
    }
    
    public void start() {
    	controller.showMainMenu();
    }
}
