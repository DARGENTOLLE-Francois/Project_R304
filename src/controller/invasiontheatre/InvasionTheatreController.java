package controller.invasiontheatre;

import controller.player.ClanChiefController;
import model.player.ClanChiefModel;
import model.invasiontheatre.*;
import model.place.Place;
import view.player.ClanChiefView;
import view.utils.Input;
import view.invasiontheatreview.InvasionTheatreView;
import java.util.ArrayList;

/**
* The controller class for the InvasionTheater object.
* It is used as the main board of the game and the controller will be sort of the main axis between the programm and the operator.
* It can execute the main functions of the simulation as such as:
* - Start the simulation
* - Send the simulation state to the view to be shown
* - Listen to the operator's inputs to make the simulation go on.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein
* @author      Nathan Griguer
*/
public class InvasionTheatreController {
	/**
     * The InvasionTheatre to control.
     */
    private InvasionTheatreModel model;
    /**
     * The InvasionTheatre view.
     */
    private InvasionTheatreView view;

    /**
     * Creates a InvasionTheatreController object. will make a relation with it's model and view.
     *
     * @param model        InvasionTheatreController to control.
     * @param view         The view that will show the InvasionTheatreController info.
     * @return             the newly created object
     */
    public InvasionTheatreController(InvasionTheatreModel model, InvasionTheatreView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Gets all the places that exists from the model and sends them to the view in order to be shown.
     *
     * @return             void
     */
    public void displayPlaces() {
        view.showPlaces(model.getName(), model.getPlaceNames());
    }

    /**
     * Gets the amount of characters that exists and sends it to the view in order to be shown.
     *
     * @return             void
     */
    public void displayTotalCharacters() {
        int total = model.getTotalNumberOfCharacters();
        view.showTotalCharacters(total);
    }

    /**
     * Gets the all the characters that exists and sends them to the view in order to be shown.
     *
     * @return             void
     */
    public void displayAllCharacters() {
        view.showAllCharacters(model.getAllCharactersInfo());
    }

    /**
     * Randomly alter the game state. to be used with threads and timers.
     * Spawns food in some places, ages the ones that exists, give random status to characters.
     *
     * @return             void
     */
    private void executeAutomaticEvents() {

        // 1. Random character's alteration
        view.showMessage("Modifications aléatoires des personnages...");
        model.alterCharacRandomly();

        // 2. Food's spawn
        view.showMessage("Apparition de nourriture dans les lieux...");
        model.spawnFood();

        // 3. Freshness reduction
        view.showMessage("Vieillissement de la nourriture...");
        model.decreaseFoodFreshness();

        // 4. Combats

        if (!model.isBattlefieldPresent()) {
        	view.showMessage("Il doit y avoir un champ de bataille dans le théatre d'envahissement");
        } else {
            ArrayList<String> combatResults = model.fightBelligerents();
            if (combatResults.size()==0) {
            	view.showMessage("Aucun combat sur les champs de bataille");
            }else {
                view.showCombatResults(combatResults);
            }

        }

        view.showMessage("Gestion de la colonie de Lycanthropes...");
        for (Place place : model.getPlaces()) {
            if (place instanceof model.place.Enclosure) {

                ((model.place.Enclosure) place).updateLycanthropes();
            }
        }

    }

    /**
     * Executes the clan chief's turn, displays it's action amount before the end of his turn.
     * Also displays the possible actions for his next turn.
     *
     * @param model    	   InvasionTheatreController to control.
     * @return             void
     */
    private void executeClanChiefTurn(ClanChiefModel chief, int turnNumber) {
        // Displays the turn.
        view.showTurnEvents(turnNumber, chief.getName());

        // Clan chief clan.
        ClanChiefView chiefView = new ClanChiefView();
        ClanChiefController chiefController = new ClanChiefController(chief, chiefView);
  
        // Automated events
        executeAutomaticEvents();
        
        // Chief's action roaster
        int maxActions = 3;
        for (int i = 0; i < maxActions; i++) {
            view.showMessage("\n┌─ ACTIONS DISPONIBLES (" + (maxActions - i) + " restante(s)) ─┐");
            view.showClanChiefMenu();

            int choice = Input.getIntInput();

            switch (choice) {
                case 1:
                    view.showMessage("\n➤ Examen du lieu");
                    chiefController.examinePlace();
                    break;
                case 2:
                    view.showMessage("\n➤ Création d'un nouveau personnage");
                    chiefController.createCharacter();
                    break;
                case 3:
                    view.showMessage("\n➤ Soin des personnages");
                    chiefController.healAllCharacters();
                    break;
                case 4:
                    view.showMessage("\n➤ Rationnement des personnages");
                    chiefController.charactersEat();
                    break;
                case 5:
                    view.showMessage("\n➤ Demande de potion magique à un druide");
                    //Success or failure of the potion's creation or absence of the druid
                    if (!chiefController.askMagicPotion()) {
                    	--i;
                    }
                    break;
                case 6:
                    view.showMessage("\n➤ Faire boire de la potion magique");
                    //Success or failure in using the potion, or absence of a druid
                    if(!chiefController.drinkMagicPotion()) {
                    	--i;
                    }
                    break;
                case 7:
                    view.showMessage("\n➤ Transférer un personnage");
                    if (chiefController.isNotEmptyPlace()) {
                        if (model.isBattlefieldPresent()) {
                            ArrayList<Place> destinations = model.getTransferDestinations();
                        	chiefController.moveCharac(destinations);
                        }else {
                        	view.showMessage("Pas de champ de bataille présent dans le théatre d'envahissement.");
                        }
                    } else {
                    	view.showMessage("Aucun personnage présent dans le lieu \nVeuillez sélectionner une autre option");
                    	--i;
                    }
                    break;
                default:
                    view.showMessage("Choix invalide");
                    --i;
            }
        }
    }

    /**
     * Ultron, start the simulation.
     * Starts the simulation. initiates the turn properties and boots the game.
     *
     * @return             void
     */
    public void startSimulation() {
        view.showMessage("Démarrage de la simulation du théâtre : " + model.getName());

        if (model.getClanChiefs().isEmpty()) {
            view.showMessage("Aucun chef de clan dans le théâtre !");
            return;
        }

        int turnNumber = 1;
        int currentChiefIndex = 0;

        while (true) {
            ClanChiefModel currentChief = model.getClanChief(currentChiefIndex);
            executeClanChiefTurn(currentChief, turnNumber);

            currentChiefIndex = (currentChiefIndex + 1) % model.getNumberClanChiefs();

            if (currentChiefIndex == 0) {
                turnNumber++;
            }

        }
    }

    // ==================== Main Menu ====================

    /**
     * Manages the main menu.
     *
     * @return             void
     */
    public void showMainMenu() {
        boolean running = true;

        while (running) {
            view.showMainMenu();
            int choice = Input.getIntInput();

            switch (choice) {
                case 1:
                    displayPlaces();
                    break;
                case 2:
                    displayTotalCharacters();
                    break;
                case 3:
                    displayAllCharacters();
                    break;
                case 4:
                    startSimulation();
                    break;
                case 5:
                    view.showMessage("Au revoir !");
                    running = false;
                    break;
                default:
                    view.showMessage("Choix invalide");
            }
        }
    }


}
