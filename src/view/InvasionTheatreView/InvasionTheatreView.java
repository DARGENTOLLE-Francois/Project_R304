package view.InvasionTheatreView;

import java.util.ArrayList;


/**
* The view class for the InvasionTheatre object .
* Will be created in game and only one instance of this class should exist.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class InvasionTheatreView {	
	
	/**
	 * Prints the message given in parameter as a string
	 * 
	 * @param message String the message to display
	 */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
	 * Shows a formated title.
	 * 
	 * @param title String the message to display
	 */
    public void showSectionTitle(String title) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + title);
        System.out.println("=".repeat(60));
    }

    /**
     * Shows the theatre name and all th places amongst it a formated way.
     * 
     * @param theatreName String
     * @param placeNames ArrayList<String>
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
     * Shows the total number of character a formated way
     * 
     * @param total int
     */
    public void showTotalCharacters(int total) {
        showSectionTitle("POPULATION DU THÉÂTRE");
        System.out.println("  Nombre total de personnages : " + total);
        System.out.println();
    }

    /**
     * Shows the characters info a formated way.
     * 
     * @param charactersInfo ArrayList<String>
     */
    public void showAllCharacters(ArrayList<String> charactersInfo) {
        showSectionTitle("TOUS LES PERSONNAGES DU THÉÂTRE");
        
        for (String info : charactersInfo) {
            System.out.println(info);
        }
    }
    
    /**
     * At the end of a combat, uses this formating to display the result.
     * 
     * @param messages
     */
    public void showCombatResults(ArrayList<String> messages) {
        System.out.println("\n═══ RÉSULTATS DES COMBATS ═══");
        for (String message : messages) {
            System.out.println(message);
        }
        System.out.println("═════════════════════════════\n");
    }
    

    /**
     * Shows the turn event.
     * 
     * @param turnNumber int
     * @param chiefName String
     */
    public void showTurnEvents(int turnNumber, String chiefName) {
        System.out.println("\n");
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║  TOUR " + turnNumber + " - Chef : " + chiefName + 
                         " ".repeat(Math.max(1, 58 - 17 - turnNumber/10 - chiefName.length())) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");
        System.out.println();
    }

    
    /**
     * Clears the terminal.
     * 
     */
    public void clearScreen() {  
        System.out.print("\033[H\033[2J");
    }  
    
    /**
     * Shows the clan chief menu
     * 
     */
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
    
    /**
     * Shows the main menu
     * 
     */
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