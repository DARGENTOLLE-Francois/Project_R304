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

    public lycanthropeController() {
        this.colony = new Colony();
        this.view = new lycanthropeView();
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
            
            colony.fastForwardTime(1);
            view.displayColony(colony);
            try {
                Thread.sleep(2000); // pour avoir testé, faut un temps de pause
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}