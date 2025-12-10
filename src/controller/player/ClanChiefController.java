package controller.player;

import model.player.ClanChiefModel;
import model.character.Character;
import model.place.Place;
import view.player.ClanChiefView;
import view.utils.Input;

import java.util.ArrayList;


/**
* The controller class for the ClanChief object.
* It is used to manage the actions relative to the chiefClan (representation of the operator).
* It can:
* - Create a character
* - Heal the characters
* - Make the characters eat
* - Manage the characters position though the board.
* As it is a controller it will only gather the user's input and send the informations to the model and the view to be used...
* 
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class ClanChiefController {
	/** 
     * The clanChief to control.
     */
    private ClanChiefModel clanChief;
    /** 
     * The clanChief view.
     */
    private ClanChiefView view;
    
    /** 
     * Creates a InvasionTheatreController object. will make a relation with it's model and view.
     *  
     * @param model        The ClanChief to control.
     * @param view         The view that will show the ClanChief info.
     * @return             the newly created object
     */
    public ClanChiefController(ClanChiefModel clanChief, ClanChiefView view) {
        this.clanChief = clanChief;
        this.view = view;
    }

    /** 
     * Asks the model for the place's informations and sends them to the view.
     *
     * @return             void
     */
    public void examinePlace() {
    	String info = clanChief.getPlace().getSpecifications();
        view.showPlaceInfo(info);
    }

    /** 
     * Prompts the operator for the new character's informations and if they're valid creates it through the model.
     *
     * @return             void
     */
    public Character createCharacter() {
        view.showMessage("Entrer le nom du personnage: ");
        String name = Input.getStringInput();

        view.showMessage("Entrer le sexe du personnage: ");
        String sex = Input.getStringInput();

        view.showMessage("Entrer la taille du personnage: ");
        double height = Input.getDoubleInput();

        view.showMessage("Entrer l'âge du personnage: ");
        int age = Input.getIntInput();

        view.showMessage("Entrer le type du personnage: ");
        view.showType();
        int type = Input.getIntInput();

        Character character = clanChief.createCharacter(name, sex, height, age, type);
        
        

        if (character == null) {
            view.showMessage("Type invalide. Erreur lors de la création du personnage");
        } else {
            view.showMessage("Personnage crée avec succès! \n");
            view.showCharacter(character);
        }

        return character;
    }

    /** 
     * Heals all the character through the model.
     *
     * @return             void
     */
    public void healAllCharacters() {
        clanChief.healAllCharacters();
        view.showMessage("Tous les personnages sur le terrain ont été soignés!");
    }

    /** 
     * Make all the characters eat.
     *
     * @return             void
     */
    public void charactersEat() {
        String result = clanChief.getPlace().feedPeople();
        view.showMessage(result);
    }
    
    /** 
     * Checks if the current place is empty
     *
     * @return             boolean is the place empty?
     */
    public boolean isNotEmptyPlace() {
    	ArrayList<Character> people = clanChief.getPlace().getPeople();
    	if (people.size()!=0) {
    		return true;
    	}
    	return false;
    }
    
    /** 
     * Prompts the operator to choose a character and returns it.
     *
     * @return             Character the chosen one.
     */
    public Character chooseCharac() {
    	view.showListCharacter(clanChief.getPlace().getPeople());
    	view.showMessage("Choisissez le numéro du personnage que vous voulez déplacer :");

    	int choice = Input.getIntInput();
    	while (!clanChief.checkValidIndex(choice)) {
    		 view.showMessage("Choix invalide. \nVeuillez réessayer :");
    		 choice = Input.getIntInput();
    	}
    	Character chosenCharac = clanChief.chooseCharac(choice);
    	return chosenCharac;
    }
    
    /** 
     * Prompts the operator to choose a destination and returns it.
     *
     * @return             Place the chosen one.
     */
    public Place chooseDestination(ArrayList<Place> destinations) {
    	view.showDestinations(destinations);
    	view.showMessage("Choisissez le numéro du lieu dans lequel vous voulez déplacer votre personnage :");
    	int choice = Input.getIntInput();
    	while (choice <= 0 || choice > destinations.size()) {
    		 view.showMessage("Choix invalide. \nVeuillez réessayer :");
    		 choice = Input.getIntInput();
    	}
    	Place chosenPlace = clanChief.chooseDestination(destinations, choice);
    	return chosenPlace;
    }
    
    /** 
     * Prompts the operator to choose a character to transfer and the destination.
     * Will use the chooseCharac and ChooseDestination functions.
     *
     * @return             void
     */
    public void moveCharac(ArrayList<Place> destinations) {
    	Character chosenCharac= this.chooseCharac();
    	Place chosenPlace = this.chooseDestination(destinations);
    	if (clanChief.moveCharac(chosenCharac, chosenPlace)) {
    		view.showMessage("Personnage transféré vers" + chosenPlace.getName());
    		view.showCharacter(chosenCharac);
    	} else {
    		view.showMessage("Erreur lors du transfert");
    	}
    	
    }
    
}
