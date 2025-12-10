package model.character;

/**
 * Model of the Lycanthrope objects
 * 
 * <p> This class is used to initialize all the attributes and method of a lycanthrope </p>
 * @author Benhafessa Alexandre
 * @author Dargentolle François
 * @author Edelstein William
 * @author Griguer Nathan
 */
public class FantasticCreaturesLycanthropes  extends Character implements Fight{

	public FantasticCreaturesLycanthropes(String name, Sex sexe, double height, CategoryAge age, Integer strength,
			Integer stamina, Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion);
	}
	
	private Integer domination_factor;
	private double level;
	private String domination_rank;
	private Integer Impentuosity_factor;
	private boolean sickness;
	private Rank rank;
	private boolean human;
	private CategoryAge cage;
	private boolean isMale;
	//private Pack pack
	
	public FantasticCreaturesLycanthropes(String name, Sex sexe, double height, CategoryAge age, Integer strength,
			Integer stamina, Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion,
			Integer domination_factor, double level, String domination_rank, Integer impentuosity_factor,
			boolean sickness, Rank rank, boolean human, boolean isMale) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion);
		this.domination_factor = domination_factor;
		this.level = level;
		this.domination_rank = domination_rank;
		Impentuosity_factor = impentuosity_factor;
		this.sickness = sickness;
		this.rank = rank;
		this.human = human;
		this.isMale = isMale;
	}

	/**
	 * Getter for the enumerator age
	 * @return cage Category of age 
	 */
	public CategoryAge getCage() {
		return cage;
	}
	/**
	 * Setter for the enumerator age
	 * @param cage Category of age of the lycanthrope
	 * @return cage Category of age 
	 */
	public void setCage(CategoryAge cage) {
		this.cage = cage;
	}

	/**
	 * Getter for the factor of domination
	 * @return domination_factor
	 */
	public Integer getDomination_factor() {
		return domination_factor;
	}
	
	/**
	 * Setter for the factor of domination
	 * @param domination_factor
	 * @return domination_factor
	 */
	public void setDomination_factor(Integer domination_factor) {
		this.domination_factor = domination_factor;
	}

	/**
	 * Getter for the level of the lycanthrope
	 * @return level
	 */
	public double getLevel() {
		return level;
	}
	
	/**
	 * Setter for the level of the lycanthrope
	 * @param level
	 * @return level
	 */
	public void setLevel(double level) {
		this.level = level;
	}

	/**
	 * Getter for the rank of domination
	 * @return domination_rank
	 */
	public String getDomination_rank() {
		return domination_rank;
	}

	/**
	 * Setter for the rank of domination
	 * @param domination_rank
	 * @return domination_rank
	 */
	public void setDomination_rank(String domination_rank) {
		this.domination_rank = domination_rank;
	}

	/**
	 * Getter for the factor of impetuosity
	 * @return Impentuosity_factor
	 */
	public Integer getImpentuosity_factor() {
		return Impentuosity_factor;
	}

	/**
	 * Setter for the factor of impetuosity
	 * @param Impentuosity_factor
	 * @return Impentuosity_factor
	 */
	public void setImpentuosity_factor(Integer impentuosity_factor) {
		this.Impentuosity_factor = impentuosity_factor;
	}

	/**
	 * Boolean for the weel-being of the lycanthrope
	 * @return sickness
	 */
	public boolean isSickness() {
		return sickness;
	}

	/**
	 * Setter for the state sickness of the lycanthrope 
	 * @param sickness
	 * @return sickness
	 */
	public void setSickness(boolean sickness) {
		this.sickness = sickness;
	}

	/**
	 * Getter for the rank of the lycanthrope
	 * @return domination_factor
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * Setter for the rank of the lycanthrope
	 * @param rank
	 * @return rank
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	/**
	 * Boolean to see if the lycanthrope has become human
	 * @return human
	 */
	public boolean isHuman() {
		return human;
	}

	/**
	 * Setter for the state of humanism of the lycanthrope
	 * @param human
	 * @return human
	 */
	public void setHuman(boolean human) {
		this.human = human;
	}
	public boolean isMale() {
		return this.isMale;
	}
	
	/**
	 * Method that calculate the level of the lycanthrope
	 * @return Integer made by rank value, the impentuosity factor, the domination factor and the Category of age
	 */
	public double CalculateLevel() {
		return (rank.getValue()+ domination_factor * Impentuosity_factor) * cage.getValue(); 
	}
	
	/**
	 * Method that transform the lycanthrope in human
	 * @return void
	 */
	public void transformationHuman() {
		this.human = true;
		
	}
	
	public void attemptDomination(FantasticCreaturesLycanthropes target) {
		//TODO
		
	}
	public void howl(String message) {
		System.out.println("Je suis le loup" + this.getName()+ "et je crie jsp pk");
		
	}
	/**
	 * Method to display the important information of the lycanthrope
	 * @return String
	 */
	@Override
    public String toString() {
        return getName() + " [" + rank + "] (Lvl: " + getLevel() + ")";
    }
	
	/**
	 * Method that decreasing the rank of the lycanthrope depending of his rank 
	 * @return void
	 */
	public void naturalHierachydown() {
		if (this.rank != Rank.OMEGA) {
			if(this.rank.getValue() < 3) {
				this.rank.setValue(this.rank.getValue() - 1);
				System.out.println(this.getName() + " descend dans la hiérarchie au rang de " + this.rank);
			}
		}

	}

}
