package Player;

import Character.*;
import Character.Character;
import Place.*;

import java.util.Scanner;
import java.util.Iterator;

public class ClanChief {
	
	private String name;
	private String sex;
	private Integer age;
	private Scanner scanner;
	private Place place;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public ClanChief(String name, String sex, Integer age, Place place) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.place = place;
	}

	public void examinatePlace() {
		place.displaySpecifications();
		System.out.println("People " + place.getPeople().size() + "\n");
		System.out.println("Food" + place.getListFood().toString() + "\n");
	}
	
	public Character createACharacter() {
		int type = 0;
		scanner = new Scanner(System.in);
		System.out.println("Le nom de votre nouveau personnage : " + "\n");
		String name = scanner.nextLine();
		System.out.println("Le sexe de votre nouveau personnage : "+ "\n");
		String sex = scanner.nextLine();
		System.out.println("La taille de votre nouveau personnage : "+ "\n");
		double height = scanner.nextDouble(); // J'ai nettoyé les caractères invisibles ici
		System.out.println("L'Age de votre nouveau personnage : "+ "\n");
		int age = scanner.nextInt();
		System.out.println("Votre type de personnage : ");
		System.out.println("- 1 : druide" + "\n"
				+ "- 2 : forgerons"+ "\n" + "- 3 : aubergistes"+ "\n" + "- 4 : marchands"
				+ "\n" + "- 5 : légionnaires"+ "\n" + "- 6 : préfets"+ "\n" + "- 7: généraux"
				+ "\n" + "- 8 : lycantrophe");
		type = scanner.nextInt();
		
		Character newChar = null; // Variable temporaire pour stocker le perso
		
		switch(type) {
			case 1:
				newChar = new Druid(name,sex,height,age,10,40,30,0,0,0);
				break;
			case 3:
				newChar = new Innkeeper(name,sex,height,age,10,40,20,0,0,0);
				break;
			case 4:
				newChar = new GallicMerchant(name,sex,height,age,15,20,25,0,0,0);
				break;
			case 5:
				newChar = new Legionnaire(name,sex,height,age,20,30,25,0,0,0);
				break;
			case 6:
				newChar = new Prefect(name,sex,height,age,22,12,35,0,0,0);
				break;
			case 7:
				newChar = new General(name,sex,height,age,26,18,30,0,0,0);
				break;
			case 8:
				newChar = new FantasticCreaturesLycanthropes(name,sex,height,age,34,50,40,0,0,0);
				break;
			default:
				System.out.println("C'est pas un nombre valide(idiot)"+ "\n");
				return null;
		}
		
		// Putain ct long cette merde
		if (newChar != null) {
			this.place.getPeople().add(newChar);
			newChar.setOriginPlace(this.place); 
		}
		return newChar;
	}
	
	public void HealTheirCharacter() {
		Iterator<Character> charc = place.getPeople().iterator();
		while(charc.hasNext()) {
			charc.next().heal();
		}
	}
	
	public void CharacterWillEat() {
		Iterator<Character> charc = place.getPeople().iterator();
		while(charc.hasNext()) {
			if(place.getListFood().size() == 0) {
				System.out.println("Plus de nourriture disponible");
				break;
			}
			else{
				Character character = charc.next();
				character.eat(place.getListFood().get(0));
				place.getListFood().remove(0);
			}
			
		}
	}

	public void transferCharacter(Place destination) {
		if (this.place.getPeople().isEmpty()) {
			System.out.println("Aucun personnage à transférer.");
			return;
		}

		if(scanner == null) scanner = new Scanner(System.in);

		System.out.println("Quel personnage envoyer vers " + destination.getName() + " ? (Entrez l'index)");

		for (int i = 0; i < this.place.getPeople().size(); i++) {
			System.out.println(i + " : " + this.place.getPeople().get(i).getName());
		}
		
		System.out.print("Choix : ");
		if (scanner.hasNextInt()) {
			int index = scanner.nextInt();
			if (index >= 0 && index < this.place.getPeople().size()) {
				Character c = this.place.getPeople().get(index);
				
				this.place.getPeople().remove(index);
				destination.getPeople().add(c);
				
				System.out.println(c.getName() + " transféré vers " + destination.getName());
			} else {
				System.out.println("Index invalide.");
			}
		} else {
			scanner.next();
			System.out.println("Entrée invalide.");
		}
	}
}