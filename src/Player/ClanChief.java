package Player;

import Character.*;
import Place.*;
import model.character.Character;
import model.character.Druid;
import model.character.FantasticCreaturesLycanthropes;
import model.character.GallicMerchant;
import model.character.General;
import model.character.Innkeeper;
import model.character.Legionnaire;
import model.character.Prefect;
import model.place.Place;

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
		System.out.println(place.getPeople().size() + '\n');
		System.out.println(place.getListFood().toString() + '\n');
	}
	
	public Character createACharacter() {
		int type = 0;
		scanner = new Scanner(System.in);
		System.out.println("Le nom de votre nouveau personnage : " + "\n");
		String name = scanner.nextLine();
		System.out.println("Le sexe de votre nouveau personnage : "+ "\n");
		String sex = scanner.nextLine();
		System.out.println("La taille de votre nouveau personnage : "+ "\n");
	    double height = scanner.nextDouble();
		System.out.println("L'Age de votre nouveau personnage : "+ "\n");
		int age = scanner.nextInt();
		System.out.println("Votre type de personnage : ");
		System.out.println("- 1 : druide" + "\n"
				+ "- 2 : forgerons"+ "\n" + "- 3 : aubergistes"+ "\n" + "- 4 : marchands"
				+ "\n" + "- 5 : légionnaires"+ "\n" + "- 6 : préfets"+ "\n" + "- 7: généraux"
				+ "\n" + "- 8 : lycantrophe");
		type = scanner.nextInt();
		switch(type) {
			case 1:
				Druid druid = new Druid(name,sex,height,age,10,40,30,0,0,0);
				return druid;
			case 3:
				Innkeeper innkeeper = new Innkeeper(name,sex,height,age,10,40,20,0,0,0);
				return innkeeper;
			case 4:
				GallicMerchant merchant = new GallicMerchant(name,sex,height,age,15,20,25,0,0,0);
				return merchant;
			case 5:
				Legionnaire legionnaire = new Legionnaire(name,sex,height,age,20,30,25,0,0,0);
				return legionnaire;
			case 6:
				Prefect prefect = new Prefect(name,sex,height,age,22,12,35,0,0,0);
				return prefect;
			case 7:
				General general = new General(name,sex,height,age,26,18,30,0,0,0);
				return general;
			case 8:
				FantasticCreaturesLycanthropes lycanthrope = new FantasticCreaturesLycanthropes(name,sex,height,age,34,50,40,0,0,0);
				return lycanthrope;
			default:
				System.out.println("C'est pas un nombre valide(idiot)"+ "\n");
				return null;
		}
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
	
	
}
