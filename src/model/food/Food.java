package model.food;

/**
* The Food enumeration. Lists all the foods that exists.
* Uses the category emun for the kind of food, the NutritionalValue for the nutritional value and the Freshnesslevel for the freshness level of the food.
* Also has a some methods besides that, getters and setters.
* 
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public enum Food {
	// Name, Freshness Level, Category, Nutritional Value, is in magic potion
	BOAR("Sanglier", FreshnessLevel.FRESH, Category.MEAT, NutritionalValue.GOOD),
	FAIRLY_FRESH_FISH("Poisson passablemment frais", FreshnessLevel.FAIRLY_FRESH, Category.FISH, NutritionalValue.MID),
	MISTLETOE("Gui", FreshnessLevel.FRESH, Category.VEGETABLE, NutritionalValue.MID),
	LOBSTER("Homard", FreshnessLevel.FRESH, Category.FISH, NutritionalValue.GOOD),
	STRAWBERRY("Fraise", FreshnessLevel.FRESH, Category.VEGETABLE, NutritionalValue.MID),
	CARROTS("Carottes", FreshnessLevel.FRESH, Category.VEGETABLE, NutritionalValue.GOOD),
	SALT("Sel", FreshnessLevel.NONE, Category.INGREDIENT_OF_MAGIC_POTION, NutritionalValue.BAD),
	FOURLEAF_CLOVER("Trèfle à quatre feuilles", FreshnessLevel.FRESH, Category.VEGETABLE, NutritionalValue.BAD),
	TREELEAF_CLOVER("Trèfle à trois feuilles", FreshnessLevel.FRESH, Category.VEGETABLE, NutritionalValue.BAD),
	ROCK_OIL("Huile de roche", FreshnessLevel.NONE, Category.INGREDIENT_OF_MAGIC_POTION, NutritionalValue.BAD),
	BEETROOT_JUICE("Jus de betterave", FreshnessLevel.FAIRLY_FRESH, Category.DRINK, NutritionalValue.MID),
	HONEY("Miel", FreshnessLevel.NONE, Category.DRINK, NutritionalValue.GOOD),
	WINE("Vin", FreshnessLevel.NONE, Category.DRINK, NutritionalValue.BAD),
	MEAD("Hydromel", FreshnessLevel.NONE, Category.DRINK, NutritionalValue.MID),
	MILK_FROM_A_TWOHEADED_UNICORN("Lait de licorne bicéphale", FreshnessLevel.FRESH, Category.INGREDIENT_OF_MAGIC_POTION, NutritionalValue.GOOD),
	IDEFIX_HAIR("Poil d'Idéfix", FreshnessLevel.NONE, Category.INGREDIENT_OF_MAGIC_POTION, NutritionalValue.NONE),
	SECRET_INGREDIENT("Ingrédient secret", FreshnessLevel.NONE, Category.INGREDIENT_OF_MAGIC_POTION, NutritionalValue.NONE);

	private String name;
	private FreshnessLevel freshnessLevel;
	private Category category;
	private NutritionalValue nutritionalValue;

	Food(String name, FreshnessLevel freshnessLevel, Category category, NutritionalValue nutritionalValue) {
		this.name = name;
		this.freshnessLevel = freshnessLevel;
		this.category = category;
		this.nutritionalValue = nutritionalValue;
	}

	public String getName() {
		return name;
	}

	public FreshnessLevel getFreshnessLevel() {
		return freshnessLevel;
	}
	
	public void setFreshnessLevel(FreshnessLevel freshnessLevel) {
		this.freshnessLevel= freshnessLevel;
	}

	public Category getCategory() {
		return category;
	}

	public NutritionalValue getNutritionalValue() {
		return nutritionalValue;
	}
	
}