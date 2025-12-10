package controller.lycanthrope;

import model.lycanthrope.Colony;
import model.character.*;
import model.lycanthrope.Pack;
import view.lycanthrope.lycanthropeView;
/**
 * Controller of the Lycanthrope objects
 * 
 * <p> This class is used to initialize the first pack and colony + 
 * a controller for the simulation of the lycanthrope</p>
 * @author Benhafessa Alexandre
 * @author Dargentolle François
 * @author Edelstein William
 * @author Griguer Nathan
 */
public class lycanthropeController {
    private Colony colony;
    private lycanthropeView view;
    private boolean isSeasonLove = false;

    public lycanthropeController() {
        this.colony = new Colony();
        this.view = new lycanthropeView();
        initializeDemoData();
    }
    
    /**
     * This Method initialize the first wolves into a pack which is add into one colony
     * <p> It has been decide for the start of the simulation to only add manually the wolves in the wait of a generator of wolves </p>
     * @return void
     */
    private void initializeDemoData() {
        // Create a pack and some wolves
        Pack pack1 = new Pack();
        //set le couple alpha
        pack1.setAlphaMale(new FantasticCreaturesLycanthropes("WOUF1", Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Alpha", 40, false, Rank.ALPHA, false, true));
        pack1.setAlphaFemale(new FantasticCreaturesLycanthropes("WOUF2", Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Alpha", 40, false, Rank.ALPHA, false, false));
        
        pack1.addMember(new FantasticCreaturesLycanthropes("WOUF1", Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Alpha", 40, false, Rank.ALPHA, false, true));// Strong male
        pack1.addMember(new FantasticCreaturesLycanthropes("WOUF2", Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Alpha", 40, false, Rank.ALPHA, false, false));  // Strong female
        pack1.addMember(new FantasticCreaturesLycanthropes("CHOSE", Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Beta", 40, false, Rank.OMEGA, false, true));   // Weaker
        colony.addPack(pack1);
        
        
        
    }

    // Si j'ai la force, je vais faire une simulation de test 
    // qu'on pourra reprendre pour plus tard
    /**
     * This Method initialize how does the simulation will start
     * <p> This Method initialize the season of love, when for lycanthrope to reproduce, recalculate the hierarchy of the pack
     * and display the colony in the view</p>
     * @param turns represents the number of turn the lycanthrope will do their actions
     * @return void
     */
    public void startSimulation(int turns) {

        for (int i = 0; i < turns; i++) {
            System.out.println("\n[Turn " + i + "]");

            for (Pack p : colony.getPacks()) {
                p.recalculateHierarchy();
                System.out.print("couple" + p.coupleAlphaString());

                if (i != 0 && i % 3 == 0) { 
                    System.out.println("--- C'est la saison des amours ! ---");
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