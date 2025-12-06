package game;

import model.player.ClanChiefModel;
import model.place.*;
import model.InvasionTheatre.InvasionTheatreModel;
import model.character.Legionnaire;
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
		RomanCity romanCity = new RomanCity("base", 10, 5, new ArrayList<>(), new ArrayList<>());
		romanCity.getFood().add(Food.WINE);
		romanCity.getFood().add(Food.MEAD); 
		Legionnaire furkanus = new Legionnaire("Marcus Furkanus", "Homme", 1.25,
	            28,
	            18, 28, 45, 0, 0, 0 , romanCity);
		romanCity.addPeople(furkanus);

		Battlefield battlefield = new Battlefield("Champ de bataille", 10, 5, new ArrayList<>(), new ArrayList<>());
		
		// Add Places into array of Places
        ArrayList<Place> places = new ArrayList<>();
        places.add(romanCity);
		places.add(battlefield);
		
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
