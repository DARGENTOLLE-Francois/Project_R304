package view.InvasionTheatreView;

import java.util.ArrayList;

public class InvasionTheatreView {	
	
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Affiche un titre de section
     */
    public void showSectionTitle(String title) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + title);
        System.out.println("=".repeat(60));
    }

    /**
     * Affiche la liste des lieux
     */
    public void showPlaces(String theatreName, ArrayList<String> placeNames) {
        showSectionTitle("LIEUX DU THÉÂTRE : " + theatreName);
        
        if (placeNames.isEmpty()) {
            System.out.println("  (Aucun lieu dans le théâtre)");
        } else {
            for (int i = 0; i < placeNames.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + placeNames.get(i));
            }
        }
        System.out.println();
    }

    /**
     * Affiche le nombre total de personnages
     */
    public void showTotalCharacters(int total) {
        showSectionTitle("POPULATION DU THÉÂTRE");
        System.out.println("  Nombre total de personnages : " + total);
        System.out.println();
    }

    /**
     * Affiche tous les personnages de tous les lieux
     */
    public void showAllCharacters(ArrayList<String> charactersInfo) {
        showSectionTitle("TOUS LES PERSONNAGES DU THÉÂTRE");
        
        for (String info : charactersInfo) {
            System.out.println(info);
        }
    }

    /**
     * Affiche les événements automatiques d'un tour
     */
    public void showTurnEvents(int turnNumber, String chiefName) {
        System.out.println("\n");
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║  TOUR " + turnNumber + " - Chef : " + chiefName + 
                         " ".repeat(Math.max(1, 58 - 17 - turnNumber/10 - chiefName.length())) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        System.out.println();
    }

    
    
    public void clearScreen() {  
        System.out.print("\033[H\033[2J");
    }  
    
    

    public void showClanChiefMenu() {
        System.out.println("│ 1. Examiner son lieu");
        System.out.println("│ 2. Créer un nouveau personnage");
        System.out.println("│ 3. Soigner les personnages");
        System.out.println("│ 4. Nourrir les personnages");
        System.out.println("│ 5. Demander une potion magique à un druide");
        System.out.println("│ 6. Faire boire de la potion magique");
        System.out.println("│ 7. Transférer un personnage vers champ de bataille/enclos");
        System.out.println("└────────────────────────────────────────────────────┘");
        System.out.print("Votre choix : ");
    }
    
    
    public void showMainMenu() {
        System.out.println("\n" + "─".repeat(60));
        System.out.println("  MENU PRINCIPAL DU THÉÂTRE");
        System.out.println("─".repeat(60));
        System.out.println("  1. Afficher les lieux");
        System.out.println("  2. Afficher le nombre de personnages");
        System.out.println("  3. Afficher tous les personnages");
        System.out.println("  4. Démarrer la simulation");
        System.out.println("  5. Quitter");
        System.out.println("─".repeat(60));
        System.out.print("  Votre choix : ");
    }

}