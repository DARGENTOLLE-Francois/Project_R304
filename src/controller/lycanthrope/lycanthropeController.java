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
        
        FantasticCreaturesLycanthropes alphaM = new FantasticCreaturesLycanthropes(
                "AlphaWolf_M", Sex.MALE, 2.1, CategoryAge.ADULT, 
                90, 100, 100, 0, 0, 0, 50, 80, false, Rank.ALPHA, true
            );
            
        FantasticCreaturesLycanthropes alphaF = new FantasticCreaturesLycanthropes(
                "AlphaWolf_F", Sex.FEMALE, 1.9, CategoryAge.ADULT, 
                85, 100, 100, 0, 0, 0, 50, 80, false, Rank.ALPHA, false
            );

        FantasticCreaturesLycanthropes beta = new FantasticCreaturesLycanthropes(
                "BetaWolf", Sex.MALE, 2.0, CategoryAge.ADULT, 
                70, 100, 100, 0, 0, 0, 20, 60, false, Rank.BETA, true
            );
            
        FantasticCreaturesLycanthropes omega = new FantasticCreaturesLycanthropes(
                "OmegaWolf", Sex.FEMALE, 1.8, CategoryAge.ADULT, 
                30, 100, 100, 0, 0, 0, 0, 20, false, Rank.OMEGA, true
            );
        FantasticCreaturesLycanthropes truc1 = new FantasticCreaturesLycanthropes(
                "BetaWolf", Sex.MALE, 2.0, CategoryAge.ADULT, 
                70, 100, 100, 0, 0, 0, 20, 60, false, Rank.KAPPA, true
            );
            
        FantasticCreaturesLycanthropes truc2 = new FantasticCreaturesLycanthropes(
                "OmegaWolf", Sex.FEMALE, 1.8, CategoryAge.ADULT, 
                30, 100, 100, 0, 0, 0, 0, 20, false, Rank.DELTA, true
            );
        pack1.addMember(alphaM);
        pack1.addMember(alphaF);
        pack1.addMember(beta);
        pack1.addMember(omega);
        pack1.addMember(truc1);
        pack1.addMember(truc2);
            
        alphaM.setHowl(TypeHowling.DOMINATION); // simple test ,surement à changer
        omega.setHowl(TypeHowling.SUBMISSION);
            
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