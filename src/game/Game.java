package game;

import controller.invasionTheatre.InvasionTheatreController;
import model.player.ClanChief;
import model.place.Place;
import model.place.RomanCity;
import model.InvasionTheatre.InvasionTheatreModel;
import model.character.Legionnaire;
import model.food.Food;
import view.InvasionTheatreView.InvasionTheatreView;

import java.util.ArrayList;

public class Game {

    private InvasionTheatreController controller;
    private InvasionTheatreModel model;
    private InvasionTheatreView view;

    public Game() {
		RomanCity romanCity = new RomanCity("base", 10, 5, new ArrayList<>(), new ArrayList<>());
		romanCity.getFood().add(Food.WINE);
		romanCity.getFood().add(Food.MEAD); 
		Legionnaire furkanus = new Legionnaire("Marcus Furkanus", "Homme", 1.25,
	            28,
	            18, 28, 45, 0, 0, 0 );
		romanCity.addPeople(furkanus);

		
        ArrayList<Place> places = new ArrayList<>();
        places.add(romanCity);
		
		
		ArrayList<ClanChief> lc1 = new ArrayList<>();
		ClanChief c1 = new ClanChief("César", "Homme", 19, romanCity);
        lc1.add(c1);
        
       
        model = new InvasionTheatreModel("Simulation 50av JC", 10,places, lc1);
        
        view= new InvasionTheatreView();
        controller = new InvasionTheatreController(model, view);
		
        
    }

    public void start() {
    	controller.showMainMenu();
    }
}
