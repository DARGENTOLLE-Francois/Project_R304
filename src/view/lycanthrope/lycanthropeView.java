package view.lycanthrope;

import model.lycanthrope.Colony;
import model.character.*;
import model.lycanthrope.Pack;

public class lycanthropeView {

    public void displayLycanthrope(FantasticCreaturesLycanthropes wolf) {
        System.out.println("   -> " + wolf.toString());
    }

    public void displayPack(Pack p) {
        System.out.println("--- PACK INFO ---");
        for (FantasticCreaturesLycanthropes l : p.getMembersSortedByRank()) {
            displayLycanthrope(l);
        }
    }

    public void displayColony(Colony c) {
        System.out.println("COLONY STATUS");
        int i = 1;
        for (Pack p : c.getPacks()) {
            System.out.println("Pack #" + i++);
            displayPack(p);
        }
    }
}