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
 * @author Dargentolle FranÃ§ois
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
    }
    
    /**
     * This Method initialize how does the simulation will start
     * <p> This Method initialize the season of love, when for lycanthrope to reproduce, recalculate the hierarchy of the pack
     * and display the colony in the view</p>
     * @param turns represents the number of turn the lycanthrope will do their actions
     * @return void
     */
    public void startSimulation(int turns) {

        for (int i = 0; i < turns; i++) {
        	this.view.displayMessage("\n[Turn " + i + "]");

            for (Pack p : colony.getPacks()) {
                p.recalculateHierarchy();
                this.view.displayMessage("couple" + p.coupleAlphaString());

                if (i != 0 && i % 3 == 0) { 
                	this.view.displayMessage("--- C'est la saison des amours ! ---");
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