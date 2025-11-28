//Réalisé par IA

package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Character.Gallic;
import Character.Roman;
import InvasionTheatre.InvasionTheatre;
import Character.Character;
import Place.Place;
import Place.GallicVillage;
import Place.RomanCity;
import Place.Battlefield;
import Player.ClanChief;

public class TestSimulation {

    public static void main(String[] args) {
        System.out.println("=== INITIALISATION DE L'ARMORIQUE (-50 av. J.C.) ===");

        // --- 1. CRÉATION DES LIEUX [cite: 5, 59] ---
        ArrayList<Place> places = new ArrayList<>();
        
        // Création d'un village et d'un camp
        GallicVillage village = new GallicVillage("Village des Irréductibles", 100);
        RomanCity camp = new RomanCity("Babaorum", 500);
        Battlefield champBataille = new Battlefield("Plaines d'Armorique", 2000); // [cite: 78]

        places.add(village);
        places.add(camp);
        places.add(champBataille);

        // --- 2. CRÉATION DES PERSONNAGES [cite: 16] ---
        // Astérix (Gallic)
        Gallic asterix = new Gallic("Astérix", "M", 1.10, 35, 10, 10, 100, 0, 0, 0);
        asterix.setOriginPlace(village); // Important pour le retour après combat [cite: 110]
        village.getPeople().add(asterix);

        // Obélix (Gallic)
        Gallic obelix = new Gallic("Obélix", "M", 2.10, 35, 80, 20, 150, 20, 0, 1000); // Tombé dedans petit
        obelix.setOriginPlace(village);
        village.getPeople().add(obelix);

        // Caius Bonus (Roman)
        Roman caius = new Roman("Caius Bonus", "M", 1.70, 40, 15, 12, 100, 5, 10, 0);
        caius.setOriginPlace(camp);
        camp.getPeople().add(caius);

        // Légionnaire lambda (Roman)
        Roman legionnaire = new Roman("Légionnaire Minus", "M", 1.65, 25, 12, 10, 80, 10, 5, 0);
        legionnaire.setOriginPlace(camp);
        camp.getPeople().add(legionnaire);

        // --- 3. CRÉATION DES CHEFS DE CLAN [cite: 80] ---
        ArrayList<ClanChief> chiefs = new ArrayList<>();
        
        ClanChief abraracourcix = new ClanChief("Abraracourcix", "M", 50, village); // Chef du village
        ClanChief julesCesar = new ClanChief("Jules César", "M", 55, camp); // Chef du camp
        
        chiefs.add(abraracourcix);
        chiefs.add(julesCesar);

        // --- 4. INITIALISATION DU THÉÂTRE [cite: 100] ---
        InvasionTheatre theatre = new InvasionTheatre("Guerre des Gaules", places, chiefs);

        System.out.println("Lieux créés : " + theatre.displayPlaces());
        theatre.displayNumberCharacter();

        // --- 5. BOUCLE DE SIMULATION  ---
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int tours = 1;

        System.out.println("\n=== DÉBUT DE LA SIMULATION ===");

        while (running) {
            System.out.println("\n-----------------------------------------");
            System.out.println("            TOUR " + tours);
            System.out.println("-----------------------------------------");

            // A. SCÉNARIO DE TEST : DÉPLACEMENT MANUEL POUR PROVOQUER UN COMBAT
            // Pour tester fightBelligerents, il faut des gens sur le champ de bataille.
            // Normalement, c'est le chef qui les déplace, mais on le simule ici pour le test.
            if (tours == 1) {
                System.out.println("[SCENARIO] Envoi des troupes sur le champ de bataille...");
                
                // Déplacement d'Astérix
                village.getPeople().remove(asterix);
                champBataille.getPeople().add(asterix);
                
                // Déplacement du Légionnaire
                camp.getPeople().remove(legionnaire);
                champBataille.getPeople().add(legionnaire);
            }

            // B. COMBATS [cite: 110]
            // Astérix et le Légionnaire devraient se battre ici au Tour 1
            // S'ils survivent, ils rentrent automatiquement chez eux grâce à character.returnToCamp()
            theatre.fightBelligerents();

            // C. ÉVÈNEMENTS ALÉATOIRES (Faim, Potion...) [cite: 111]
            theatre.alterCharacRandomly();

            // D. GESTION DE LA NOURRITURE [cite: 112, 113]
            theatre.spawnFood();       // Apparition (Sangliers, poissons...)
            theatre.decreaseFreshness(); // Péremption (Frais -> Pas frais)

            // E. ACTIONS DES CHEFS (INTERACTIF) [cite: 114]
            // On alterne quel chef joue à chaque tour
            int chiefIndex = (tours - 1) % chiefs.size();
            System.out.println("\n>>> C'est au tour du chef " + chiefs.get(chiefIndex).getName() + " de jouer.");
            theatre.execClanChief(chiefIndex);

            // F. ÉTAT FIN DE TOUR
            theatre.displayAllCharacters(); // Affiche où sont les persos et leur santé

            // G. CONTINUER OU ARRÊTER
            System.out.println("\nPasser au tour suivant ? (Entrée = OUI, 'n' = NON)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("n")) {
                running = false;
            }
            
            tours++;
        }

        System.out.println("=== FIN DE LA SIMULATION ===");
        scanner.close();
    }
}