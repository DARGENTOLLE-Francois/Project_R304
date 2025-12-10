package view.player;

import view.character.CharacterView;

import java.util.ArrayList;
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

	/**
	 * Prints the message given in parameter as a string
	 * 
	 * @param msg String the message to display
	 */
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    /**
	 * formats a message as the places info 
	 * 
	 * @param info String the place info.
	 */
    public void showPlaceInfo(String info) {
        System.out.println("=== PLACE INFORMATION ===");
        System.out.println(info);
    }
    
    /**
	 * shows all the types of characters for the operator to prompt in the next scanner.
	 * 
	 * @param info String the place info.
	 */
    public void showType() {
		System.out.println("- 1 : druide" + "\n"
				+ "- 2 : forgerons"+ "\n" + "- 3 : aubergistes"+ "\n" + "- 4 : marchands"
				+ "\n" + "- 5 : légionnaires"+ "\n" + "- 6 : préfets"+ "\n" + "- 7: généraux"
				+ "\n" + "- 8 : lycantrophe");
    }
    
    /**
	 * shows a character's info.
	 * 
	 * @param character Character the character to show.
	 */
    public void showCharacter(Character character) {
        viewCharac.showCharacter(character);
    }
    
    /**
	 * shows a list of people given in parameters.
	 * 
	 * @param people ArrayList<Character> the characters to show.
	 */
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

    /**
	 * shows a list of destinations given in parameters.
	 * 
	 * @param destinations ArrayList<Place> the destinations to show.
	 */
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
    
    

    

    
    
}
