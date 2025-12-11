package view.player;

import view.character.CharacterView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.character.Character;
import model.place.Place;

/**
* The view class for the ClanChief object .
* Is used to display the informations about the operator's interactions.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class ClanChiefView {
	private CharacterView viewCharac = new CharacterView();

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showPlaceInfo(String info) {
        System.out.println("=== PLACE INFORMATION ===");
        System.out.println(info);
    }

    public void showRank() {
        System.out.println("- ALPHA tapez 1" + "\n" + "- BETA tapez 2"+ "\n" + "- GAMMA tapez 3"+ "\n" + "- DELTA tapez 4" + "\n" + "- EPSILON tapez 5"+"\n" + "- ZETA tapez 6" + "\n"+ "- ETA tapez 7" + "\n"+ "- KAPPA tapez 8" 
                            + "\n"+ "- LAMBDA tapez 9" + "\n"+ "- SIGMA tapez 10" + "\n"+ "- OMEGA tapez 11" );
    }
    
    
    public void showType() {
		System.out.println("- 1 : druide" + "\n"
				+ "- 2 : forgerons"+ "\n" + "- 3 : aubergistes"+ "\n" + "- 4 : marchands"
				+ "\n" + "- 5 : légionnaires"+ "\n" + "- 6 : préfets"+ "\n" + "- 7: généraux"
				+ "\n" + "- 8 : lycantrophe");
    }
    
    public void showCharacter(Character character) {
        viewCharac.showCharacter(character);
    }
    
    public void showListCharacter(ArrayList<Character> people) {
    	int a=0;
        this.showMessage("\n=== Liste des personnages ===");
        for (Character c : people) {
        	++a;
        	this.showMessage(a+" :");
        	this.showCharacter(c);
        	
        }
        this.showMessage("\n=============================");
    }

    
    public void showDestinations(ArrayList<Place> destinations) {
        this.showMessage("\n=== Destinations disponibles ===");
        for (int i = 0; i < destinations.size(); i++) {
            Place place = destinations.get(i);
            this.showMessage((i + 1) + ". " + place.getName() + 
                            " (" + place.getClass().getSimpleName() + ")" +
                            " - Personnages: " + place.getPeople().size());
        }
        this.showMessage("================================\n");
    }
    

    public void showListString(List<String> results) {
        for (String i : results) {
            System.out.println("➤ " + i);
        }
    }

    

    
    
}
