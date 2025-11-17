package Potion;

import Food.*;
import java.util.*;

public class MagicPotionCauldron {
	
	private int dose = 15; // une marmite => 15 doses
	private List<Food> list_ingredient = new ArrayList<>();
	private boolean is_dedoublement = false;
	private boolean is_metamorphosis = false;
	
	public MagicPotionCauldron(int dose, List<Food> list_ingredient, boolean is_dedoublement,
			boolean is_metamorphosis) {
		super();
		this.dose = dose;
		this.list_ingredient = list_ingredient;
		this.is_dedoublement = is_dedoublement;
		this.is_metamorphosis = is_metamorphosis;
	}
	
	
	
	
	//GETTER ET SETTER
	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	public List<Food> getList_ingredient() {
		return list_ingredient;
	}

	public void setList_ingredient(List<Food> list_ingredient) {
		this.list_ingredient = list_ingredient;
	}

	public boolean isIs_dedoublement() {
		return is_dedoublement;
	}

	public void setIs_dedoublement(boolean is_dedoublement) {
		this.is_dedoublement = is_dedoublement;
	}

	public boolean isIs_metamorphosis() {
		return is_metamorphosis;
	}

	public void setIs_metamorphosis(boolean is_metamorphosis) {
		this.is_metamorphosis = is_metamorphosis;
	}
	
	

}
