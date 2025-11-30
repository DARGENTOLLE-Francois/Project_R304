package Menu;

import java.util.ArrayList;
import java.util.Iterator;

import InvasionTheatre.InvasionTheatre;
import model.character.Character;
import model.character.Druid;
import model.food.Food;
import model.place.Place;
import model.place.RomanCity;
import model.player.ClanChief;
import Place.*;


public class Main {
	public static void main(String[] args) {
		ArrayList<Food> lfood1 = new ArrayList<>();
		lfood1.add(Food.BOAR);
		lfood1.add(Food.CARROTS);
		lfood1.add(Food.BOAR);

		ArrayList<Character> lpeople1 = new ArrayList<>();
        Druid panoramix = new Druid(
                "Panoramix", "Homme", 1.80, 90, // Nom, Sexe, Taille, Age
                10, 50, 100, 0, 0, // Force, Endu, Vie, Faim, Belligerance
                10 // Niveau de potion
        );
		lpeople1.add(panoramix);
		
		
		RomanCity p1 = new RomanCity("base", 10, 5, lpeople1, lfood1);
		ArrayList<Place> lplace1 = new ArrayList<>();
		lplace1.add(p1);
		
		ArrayList<ClanChief> lc1 = new ArrayList<>();
		ClanChief c1 = new ClanChief("Nathan", "Homme", 19, p1);
		ClanChief c2 = new ClanChief("Furkan", "Hélicoptère de combat", 128, p1);

		lc1.add(c1);
		lc1.add(c2);
		InvasionTheatre i1 = new InvasionTheatre("test", lplace1, lc1);
		int turn=0;
		while (true) {
			turn=turn%i1.getChiefs().size();
			System.out.println("TOUR DU CHEF : "+ i1.getChiefs().get(turn).getName());
			i1.alterCharacRandomly();
			i1.spawnFood();
			i1.decreaseFreshness();
			i1.execClanChief(turn);
			turn++;
		}
	}
}
