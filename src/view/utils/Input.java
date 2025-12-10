package view.utils;

import java.util.Scanner;

/**
* The input class .
* Is used to ease the prompt the operator.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class Input {
	private static Scanner scanner = new Scanner(System.in);
	
    
    public static int getIntInput() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Veuillez entrer un nombre valide");
            System.out.print("Votre choix : ");
        }
        int input = scanner.nextInt();
        return input;
    }
    
    public static double getDoubleInput() {
    	while(!scanner.hasNextDouble()) {
    		scanner.next();
    		System.out.println("Veuillez entrer un nombre valide");
            System.out.print("Votre choix : ");
    	}
    	double input = scanner.nextDouble();
    	return input;
    }
    
    
    
    public static String getStringInput() {
    	String input;
    	while(true) {
    		input = scanner.nextLine();
    		if (!input.isEmpty()) {
    			return input;
    		}
            System.out.println("Veuillez choisir une chaine de caractère non vide :");
            System.out.print("Votre choix : ");
    	}
    }
}
