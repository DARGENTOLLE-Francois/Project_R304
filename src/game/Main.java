package game;
import controller.lycanthrope.lycanthropeController;
/**
 * Main class of the program. Starts the game.
 * 
 * @author      Alexandre Benhafessa
 * @author      François Dargentolle
 * @author      William Edelstein 
 * @author      Nathan Griguer
 */
public class Main {
	/** 
	 * The Main function.
	 * Creates a game and starts it.
	 *
	 * @return             void
	 */
    public static void main(String[] args) {
    	
        lycanthropeController lycanController = new lycanthropeController();
        lycanController.startSimulation(20);
        
        Game game = new Game();
        game.start();          
    }
}