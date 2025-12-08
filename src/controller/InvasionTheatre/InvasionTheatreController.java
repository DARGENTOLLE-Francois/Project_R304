package controller.InvasionTheatre;

import controller.player.ClanChiefController;
import model.player.ClanChiefModel;
import model.InvasionTheatre.*;
import model.place.Place;
import view.player.ClanChiefView;
import view.utils.Input;
import view.InvasionTheatreView.InvasionTheatreView;

import java.util.ArrayList;

/**
 * CONTROLLER - InvasionTheatre
 * Gère les interactions entre le modèle et la vue du théâtre
 */
public class InvasionTheatreController {
    private InvasionTheatreModel model;
    private InvasionTheatreView view;

    public InvasionTheatreController(InvasionTheatreModel model, InvasionTheatreView view) {
        this.model = model;
        this.view = view;
    }

    public void displayPlaces() {
        view.showPlaces(model.getName(), model.getPlaceNames());
    }

    public void displayTotalCharacters() {
        int total = model.getTotalNumberOfCharacters();
        view.showTotalCharacters(total);
    }

    public void displayAllCharacters() {
        view.showAllCharacters(model.getAllCharactersInfo());
    }


    private void executeAutomaticEvents() {

        // 1. Modification aléatoire des personnages
        view.showMessage("Modifications aléatoires des personnages...");
        model.alterCharacRandomly();

        // 2. Apparition de nourriture
        view.showMessage("Apparition de nourriture dans les lieux...");
        model.spawnFood();

        // 3. Diminution de fraîcheur
        view.showMessage("Vieillissement de la nourriture...");
        model.decreaseFoodFreshness();

        // 4. Combats (à implémenté)

        if (!model.isBattlefieldPresent()) {
        	view.showMessage("Il doit y avoir un champ de bataille dans le théatre d'envahissement");
        //}else if (!model.hasBattlefieldAtLeastTwoCharac()) {
        	//view.showMessage("Il doit y avoir au moins 2 caractères présents sur le champ de bataille");
        } else {
            view.showMessage("Résolution des combats sur les champs de bataille...");
            ArrayList<String> combatResults = model.fightBelligerents();
            view.showCombatResults(combatResults);
        }

    }


    private void executeClanChiefTurn(ClanChiefModel chief, int turnNumber) {
    	view.clearScreen();
    	
        // Affichage du tour
        view.showTurnEvents(turnNumber, chief.getName());

        // Tour du chef de clan
        ClanChiefView chiefView = new ClanChiefView();
        ClanChiefController chiefController = new ClanChiefController(chief, chiefView);
  
        // Événements automatiques
        executeAutomaticEvents();
        
        // Menu d'actions pour le chef
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
                    // TODO: À implémenter avec le système de potion
                    view.showMessage("Fonctionnalité à implémenter");
                    break;
                case 6:
                    view.showMessage("\n➤ Faire boire de la potion magique");
                    // TODO: À implémenter
                    view.showMessage("Fonctionnalité à implémenter");
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

    // ==================== MENU PRINCIPAL ====================

    /**
     * Gère le menu principal du théâtre
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
