package controller.player;

import includes.exception.ExceptionEmptyField;
import includes.exception.ExceptionValidationField;
import model.player.ClanChiefModel;
import model.character.Character;
import model.character.Rank;
import model.magicpotion.MagicPotion;
import model.place.Place;
import view.player.ClanChiefView;
import view.utils.Input;

import java.util.ArrayList;
import java.util.List;


/**
* The controller class for the ClanChief object.
* It is used to manage the actions relative to the chiefClan (representation of the operator).
* It can:
* - Create a character
* - Heal the characters
* - Make the characters eat
* - Manage the character position though the board.
* As it is a controller, it will only gather the user's input and send the informations to the model and the view to be used...
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
     * Creates an InvasionTheatreController object. will make a relation with it's model and view.
     *
     * @param clanChief        The ClanChief to control.
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

        if(type == 8){
            view.showMessage("Entrer le rang du personnage: ");
            view.showRank();
            Input.getIntInput();
        }

        Character character = null;

        try {
            character = clanChief.createCharacter(name, sex, height, age, type);

            view.showMessage("Personnage crée avec succès! \n");
            view.showCharacter(character);
            clanChief.addPeople(character);

        } catch (ExceptionEmptyField | ExceptionValidationField e) {
            view.showMessage("ERREUR : " + e.getMessage());
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
    
    
    public boolean askMagicPotion() {
        if (!clanChief.hasDruidInPlace()) {
            view.showMessage("Il n'y a pas de druide ici pour faire de la potion !");
            return false;
        }

        MagicPotion existingPotion = clanChief.getDruidPotion();

        if (existingPotion != null) {
            view.showMessage("\n--- POTION DÉJÀ PRÊTE ---");
            view.showMessage("Le druide sort une marmite qui était déjà prête.");
            view.showMessage(existingPotion.toString());
            return false;

        } else {
            view.showMessage("\n--- PRÉPARATION DE LA POTION ---");
            view.showMessage("Le druide commence à mélanger les ingrédients...");

            MagicPotion newPotion = clanChief.askMagicPotion();

            if (newPotion != null) {
                view.showMessage("La potion est terminée !");
                view.showMessage(newPotion.toString());
                return true;
            } else {
                view.showMessage("Erreur lors de la création.");
                return true;
            }
        }
    }


    public boolean drinkMagicPotion() throws ExceptionValidationField {
        if (!clanChief.hasDruidInPlace()) {
            view.showMessage("Il n'y a pas de druide ici pour faire de la potion !");
            return false;
        }

    	if (clanChief.getDruidPotion()!=null) {
        	Character charac = this.chooseCharac();
        	MagicPotion magicPotion = clanChief.askMagicPotion();
        	List<String> results = clanChief.drinkMagicPotion(magicPotion, charac);
        	view.showMessage(clanChief.getDruidPotion().toString());
        	view.showListString(results);
        	return true;
    	}
    	view.showMessage("On doit d'abord créer une potion avant de l'utiliser");
    	return false;
    }

    
    /**
     * Prompts the operator to choose a character and returns it.
     *
     * @return             Character the chosen one.
     */
    public Character chooseCharac() {
        view.showListCharacter(clanChief.getPlace().getPeople());

        Character chosenCharac = null;
        boolean validChoice = false;

        while (!validChoice) {
            view.showMessage("Choisissez le numéro du personnage que vous voulez sélectionner :");
            int choice = Input.getIntInput();

            try {
                chosenCharac = clanChief.chooseCharac(choice);
                validChoice = true;
            } catch (ExceptionValidationField e) {
                view.showMessage("Erreur de saisie : " + e.getMessage());
                view.showMessage("Veuillez réessayer.");
            }
        }
        return chosenCharac;
    }
    
    /**
     * Prompts the operator to choose a destination and returns it.
     *
     * @return             Place the chosen one.
     */
    public Place chooseDestination(ArrayList<Place> destinations) {
        view.showDestinations(destinations);

        Place chosenPlace = null;
        boolean validChoice = false;

        while (!validChoice) {
            view.showMessage("Choisissez le numéro du lieu dans lequel vous voulez déplacer votre personnage :");
            int choice = Input.getIntInput();

            try {
                chosenPlace = clanChief.chooseDestination(destinations, choice);
                validChoice = true;
            } catch (ExceptionValidationField e) {
                view.showMessage("Erreur de saisie : " + e.getMessage());
                view.showMessage("Veuillez réessayer.");
            }
        }
        return chosenPlace;
    }
    
    /**
     * Prompts the operator to choose a character to transfer and the destination.
     * Will use the chooseCharac and ChooseDestination functions.
     *
     * @return             void
     */
    public void moveCharac(ArrayList<Place> destinations) throws ExceptionValidationField {
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
