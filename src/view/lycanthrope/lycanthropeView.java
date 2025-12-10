package view.lycanthrope;

import model.lycanthrope.Colony;
import model.lycanthrope.Pack;
import model.character.FantasticCreaturesLycanthropes;

public class lycanthropeView {

    public void displayColony(Colony colony) {
        System.out.println("================ ETAT DE LA COLONIE ================");
        
        int packIndex = 1;
        for (Pack pack : colony.getPacks()) {
            System.out.println("\n--- MEUTE #" + packIndex + " ---");
            displayPack(pack);
            packIndex++;
        }

        // solitaires
        if (!colony.getSolitaries().isEmpty()) {
            System.out.println("\n--- SOLITAIRES ---");
            for (FantasticCreaturesLycanthropes loup : colony.getSolitaries()) {
                System.out.println("  * [Solitaire] " + loup.toString() + "Sexe : " + loup.getSex());
            }
        } else {
            System.out.println("\n(Aucun loup solitaire)");
        }
        
        System.out.println("====================================================\n");
    }

    private void displayPack(Pack pack) {
        // print couple Alpha
        FantasticCreaturesLycanthropes alphaM = pack.getAlphaMale();
        FantasticCreaturesLycanthropes alphaF = pack.getAlphaFemale();

        System.out.println("Couple Alpha :");
        System.out.println("  Mâle : " + (alphaM != null ? alphaM.toString() : "Aucun"));
        System.out.println("  Female : " + (alphaF != null ? alphaF.toString() : "Aucune"));
        
        System.out.println("Membres de la meute (" + pack.getMembers().size() + ") :");
        
        for (FantasticCreaturesLycanthropes loup : pack.getMembersSortedByRank()) {
            String role = "";
            
            if (loup == alphaM || loup == alphaF) role = " [CHEF]";
            
            System.out.println("    - " + loup.toString() + role + " | Sexe: " + loup.getSex() + " | Age: " + loup.getCage());
        }
    }
}