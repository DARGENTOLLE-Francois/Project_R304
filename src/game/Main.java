package game;
import controller.lycanthrope.lycanthropeController;
/**
 * Class Main of the lycanthrope simulation
 * 
 * <p> This class is used to initialize the controller and start the simulation</p>
 * @author Benhafessa Alexandre
 * @author Dargentolle François
 * @author Edelstein William
 * @author Griguer Nathan
 */
public class Main {

    public static void main(String[] args) {
    	
        lycanthropeController lycanController = new lycanthropeController();
        lycanController.startSimulation(10);
        
        Game game = new Game();
        game.start();          
    }
}