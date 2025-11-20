package Menu;

import Character.Druid;
import Food.Food;

public class Main {
	public static void main(String[] args) {
		Food boar = Food.BOAR;
		
		System.out.println(boar.getName());
		System.out.println(boar.getCategory());
		System.out.println(boar.getNutritionalValue());
		
		Druid test = new Druid(null, null, null, null, null, null, null, null, null, null); 
		System.out.print(test.getName());
	}
}
