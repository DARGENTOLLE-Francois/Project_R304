package model.character;

import model.lycanthrope.Pack;

import model.place.Place;

/**
* The FantasticCreaturesLycanthropes class, extends the Character class and implements the Fight interface.s.
* 
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/

public class FantasticCreaturesLycanthropes  extends Character implements Fight{

	/** 
     * Creates an instance with the given parameters
     *
     *
     * @param name		    The name of the character
     * @param sexe		    The gender of the character
     * @param height	    The height of the character
     * @param age		    The age of the character
     * @param strength	    The strength stat of the character
     * @param stamina	    The stamina stat of the character
     * @param health	    The health stat of the character
     * @param hunger	    The hunger of the character
     * @param belligerence  The belligerence of the character
     * @param levelOfPotion The levelOfPotion of the character
     * @return             The newly created object
     */
	public FantasticCreaturesLycanthropes(String name, Sex sexe, double height, CategoryAge age, Integer strength,
			Integer stamina, Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion);
	}
	
	private Integer domination_factor;
	private Integer Impentuosity_factor;
	private boolean sickness;
	private Rank rank;
	private boolean human;
	private CategoryAge cage;
	private boolean isMale;
	private TypeHowling howl;
	private Pack pack;
	
	public FantasticCreaturesLycanthropes(String name, Sex sexe, double height, CategoryAge cage, Integer strength,
			Integer stamina, Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion,
			Integer domination_factor, Integer impentuosity_factor,
			boolean sickness, Rank rank, boolean isMale) {
		super(name, sexe, height, null, strength, stamina, health, hunger, belligerence, levelOfPotion);
		
		this.domination_factor = domination_factor;
		this.Impentuosity_factor = impentuosity_factor;
		this.sickness = sickness;
		this.rank = rank;
		this.human = false;
		this.isMale = isMale;
		this.cage = cage;
		this.howl = TypeHowling.BELONGE_TO; //éviter le null (pas sur honnetement)
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
		return calculateLevel();
	}
	
	/**
	 * Setter for the level of the lycanthrope
	 * @param level
	 * @return level
	 */
	public double calculateLevel() {
		double ageVal = (this.cage != null) ? this.cage.getValue() : 1.0;

		int rankScore = rank.getValue();

		return (getStrength() + domination_factor + rankScore) * ageVal;
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
	
	/**
	 * Method that transform the lycanthrope in human
	 * @return void
	 */
	public void transformationHuman() {
		this.human = true;
		
	}
	
	/**
	 * Method that attempt to make a lycanthrope dominate another lycanthrope
	 * @param target the lycanthrope to dominate
	 * @return void
	 */
	public void attemptDomination(FantasticCreaturesLycanthropes target) {
		int myPower = this.getStrength() * this.getImpentuosity_factor();

		// Si soumission par hurlement
		if(this.howl == TypeHowling.DOMINATION && target.howl == TypeHowling.SUBMISSION) {
			this.domination_factor += 1;
			target.domination_factor -= 1;
			System.out.println(this.getName() + " domine (soumission) " + target.getName());
		}
		
		// Si conflit
		else if(this.howl == TypeHowling.DOMINATION && target.howl != TypeHowling.SUBMISSION) {
			
			if(myPower >= target.getStrength()) {
				
				if (this.calculateLevel() > target.calculateLevel() || target.getRank() == Rank.OMEGA) {
					
					System.out.println(this.getName() + " a dominé par la force " + target.getName());
				
					this.domination_factor += 1;
					target.domination_factor -= 1;
					
					Rank temp = this.rank;
					this.rank = target.rank;
					target.rank = temp;
					
					System.out.println("Échange de rangs effectué ! " + this.getName() + " est maintenant " + this.rank);
				} else {
					// pas de chance
					System.out.println(this.getName() + " a échoué (niveau insuffisant).");
					this.domination_factor -= 1; 
				}
			} else {
				System.out.println(this.getName() + " n'est pas assez impétueux pour attaquer.");
			}
		}	
	}

	// The howls must be "heard" by other lycanthropes nearby
	public void howl(String message) {
		this.howl = TypeHowling.BELONGE_TO; //placeholder
		System.out.println("Je suis le loup" + this.getName()+ " [" + this.rank + "] et je hurle : " + message);
		
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
		if (this.rank != Rank.OMEGA && this.rank != Rank.ALPHA) {
			if(this.domination_factor < 3) {
				this.rank = this.rank.previous();
				System.out.println(this.getName() + " descend dans la hiérarchie au rang de " + this.rank);
			}
		}
	}
	
	public Pack getPack() { 
		return pack; 
	}
    public void setPack(Pack pack) { 
    	this.pack = pack; 
    }

    public TypeHowling getHowl() {
        return howl;
    }

    public void setHowl(TypeHowling howl) {
        this.howl = howl;
    }
    public Sex getSex() {
        if (this.isMale) {
            return Sex.MALE;
        } else {
            return Sex.FEMALE;
        }
    }
}
