package controller.lycanthrope;

import model.lycanthrope.Colony;
import model.character.*;
import model.lycanthrope.Pack;
import view.lycanthrope.lycanthropeView;

public class lycanthropeController {
    private Colony colony;
    private lycanthropeView view;
    private boolean isSeasonLove = false;

    public lycanthropeController() {
        this.colony = new Colony();
        this.view = new lycanthropeView();
        initializeDemoData();
    }
    
    private void initializeDemoData() {
        // Create a pack and some wolves
        Pack pack1 = new Pack();
        pack1.addMember(new FantasticCreaturesLycanthropes("WOUF1", Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Alpha", 40, false, Rank.ALPHA, false, true));// Strong male
        pack1.addMember(new FantasticCreaturesLycanthropes("WOUF2", Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Alpha", 40, false, Rank.ALPHA, false, false));  // Strong female
        pack1.addMember(new FantasticCreaturesLycanthropes("CHOSE", Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Beta", 40, false, Rank.ALPHA, false, true));   // Weaker
        colony.addPack(pack1);
    }

    // Si j'ai la force, je vais faire une simulation de test 
    // qu'on pourra reprendre pour plus tard
    public void startSimulation(int turns) {
        for (int i = 0; i < turns; i++) {
            System.out.println("\n[Turn " + i + "]");

            if (i % 10 == 0) isSeasonLove = !isSeasonLove;

            for (Pack p : colony.getPacks()) {
                p.recalculateHierarchy();

                if (isSeasonLove) {
                    p.reproduce();
                }

                if (Math.random() < 0.1) {
                    if (!p.getMembers().isEmpty()) {
                        p.getMembers().get(0).howl("Awoooo (Dominance)");
                    }
                }
            }

            view.displayColony(colony);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}