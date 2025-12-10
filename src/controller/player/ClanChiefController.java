package controller.player;

import model.player.ClanChiefModel;
import model.character.Character;
import model.magicPotion.MagicPotion;
import model.place.Place;
import view.player.ClanChiefView;
import view.utils.Input;

import java.util.ArrayList;
import java.util.List;

public class ClanChiefController {
	
    private ClanChiefModel clanChief;
    private ClanChiefView view;
    
    public ClanChiefController(ClanChiefModel clanChief, ClanChiefView view) {
        this.clanChief = clanChief;
        this.view = view;
    }

    // Examine place
    public void examinePlace() {
    	String info = clanChief.getPlace().getSpecifications();
        view.showPlaceInfo(info);
    }

    // Create character
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

    // Heal all characters
    public void healAllCharacters() {
        clanChief.healAllCharacters();
        view.showMessage("Tous les personnages sur le terrain ont été soignés!");
    }

    // Characters eat
    public void charactersEat() {
        String result = clanChief.getPlace().feedPeople();
        view.showMessage(result);
    }
    
    
    public boolean isNotEmptyPlace() {
    	ArrayList<Character> people = clanChief.getPlace().getPeople();
    	if (people.size()!=0) {
    		return true;
    	}
    	return false;
    }
    
    
    public void askMagicPotion() {
        // 1. Vérification de sécurité : Y a-t-il un druide ?
        if (!clanChief.hasDruidInPlace()) {
            view.showMessage("Il n'y a pas de druide ici pour faire de la potion !");
            return;
        }

        // 2. LOGIQUE SINGLETON : On vérifie d'abord si une potion existe
        MagicPotion existingPotion = clanChief.getDruidPotion();

        if (existingPotion != null) {
            // CAS A : Potion déjà existante
            view.showMessage("\n--- POTION DÉJÀ PRÊTE ---");
            view.showMessage("Le druide sort une marmite qui était déjà prête.");
            view.showMessage(existingPotion.toString());
            
        } else {
            // CAS B : Création d'une nouvelle potion
            view.showMessage("\n--- PRÉPARATION DE LA POTION ---");
            view.showMessage("Le druide commence à mélanger les ingrédients...");
            
            MagicPotion newPotion = clanChief.askMagicPotion();
            
            if (newPotion != null) {
                view.showMessage("La potion est terminée !");
                view.showMessage(newPotion.toString());
            } else {
                view.showMessage("Erreur lors de la création.");
            }
        }
    }
    
    
    public void drinkMagicPotion() {
    	if (clanChief.getDruidPotion()!=null) {
        	Character charac = this.chooseCharac();
        	MagicPotion magicPotion = clanChief.askMagicPotion();
        	List<String> results = clanChief.drinkMagicPotion(magicPotion, charac);
        	view.showMessage(clanChief.getDruidPotion().toString());
        	view.showListString(results);
    	}
    	view.showMessage("On doit d'abord créer une potion avant de l'utiliser");
    	
    }
   
    
    public Character chooseCharac() {
    	view.showListCharacter(clanChief.getPlace().getPeople());
    	view.showMessage("Choisissez le numéro du personnage que vous voulez sélectionner :");

    	int choice = Input.getIntInput();
    	while (!clanChief.checkValidIndex(choice)) {
    		 view.showMessage("Choix invalide. \nVeuillez réessayer :");
    		 choice = Input.getIntInput();
    	}
    	Character chosenCharac = clanChief.chooseCharac(choice);
    	return chosenCharac;
    }
    
    
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
