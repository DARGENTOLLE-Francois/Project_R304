package model.lycanthrope;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import model.character.*;
import java.util.Random;
/**
 * Class of the pack of Lycanthrope objects
 * 
 * <p> This class is used to initialize the methods used in the pack of lycanthrope</p>
 * @author Benhafessa Alexandre
 * @author Dargentolle François
 * @author Edelstein William
 * @author Griguer Nathan
 */
public class Pack {
	private List<FantasticCreaturesLycanthropes> members;
	private FantasticCreaturesLycanthropes alphaMale;
	private FantasticCreaturesLycanthropes alphaFemale;

	
	public Pack() {
		this.members = new ArrayList<FantasticCreaturesLycanthropes>();
	}
	
	/**
	 * Method that add an object lycanthrope to the list of members of a pack
	 * @param wolf
	 * @return void
	 */
	public void addMember (FantasticCreaturesLycanthropes wolf) {
		members.add(wolf);
		wolf.setPack(this);
		recalculateHierarchy();
	}
	
	/**
	 * Method that remove an object lycanthrope to the list of members of a pack and recalculate the hierarchy
	 * @param wolf
	 * @return void
	 */
	public void removeMember (FantasticCreaturesLycanthropes wolf) {
		members.remove(wolf);
		wolf.setPack(null);
		if (wolf == alphaMale) alphaMale = null;
        if (wolf == alphaFemale) alphaFemale = null;
		recalculateHierarchy();
	}
	
	/**
	 * Method that re-arrange the hierarchy of the pack (mostly the alpha couple)
	 * <p> This methode will verify if a male and female are worthy of becoming alpha and if they do, then their rank will change in consequence
	 *  only if there isn't another alpha from the same gender as them </p>
	 * @return void
	 */
	public void recalculateHierarchy() {
		
		FantasticCreaturesLycanthropes bestMale = null;
        FantasticCreaturesLycanthropes bestFemale = null;
        
        // ON COMMENCE PAR LA PIERRE (le male, ref a gon tu connais)
        
		for (FantasticCreaturesLycanthropes member : members) {
			if(member.isMale()) {
				if (bestMale == null || member.getLevel() > bestMale.getLevel()) { // je change ma logique, ca me parait plus simple
					bestMale = member;
				}
			}
			else {
				if (bestFemale == null || member.getLevel() > bestFemale.getLevel()) {
                    bestFemale = member;
                }
			}
		}
		// après la boucle qui check qui est le best, on setup les potentiels nouveaux alpha çipjfeziç
		
        if (bestMale != null) {
            if (this.alphaMale != null && this.alphaMale != bestMale) {
                this.alphaMale.setRank(Rank.BETA); // bouh le gros nul a perdu sa place, cheh
            }
            this.alphaMale = bestMale;
            this.alphaMale.setRank(Rank.ALPHA);
        }

        if (bestFemale != null) {
            if (this.alphaFemale != null && this.alphaFemale != bestFemale) {
                this.alphaFemale.setRank(Rank.BETA); // bouh la grosse nulle a perdu sa place, cheh
            }
            this.alphaFemale = bestFemale;
            this.alphaFemale.setRank(Rank.ALPHA);
        }
    }
	
	/**
	 * Method that will make baby out of the alpha couple
	 * <p> This method will make the couple reproduce a random number of cub between 1 and 7. The method also assign the attribute of the cub while 
     * the rank of everyone in the pack</p>
     * @return void
	 */
	public void reproduce() {
        if (alphaMale != null && alphaFemale != null) {
            
            Random rand = new Random();
            int litterSize = 1 + rand.nextInt(7); // 1 à 7 petits
            
            System.out.println("Reproduction : " + litterSize + " pôti loup tout mignon et sanguinaire sont nés !");
            
            boolean hasBeta = members.stream().anyMatch(w -> w.getRank() == Rank.BETA); // j'ai mis 20 min a écrire cette ligne putain de merde
            Rank childRank = hasBeta ? Rank.GAMMA : Rank.BETA;

            for (int i = 0; i < litterSize; i++) {
                boolean isMale = rand.nextBoolean();
                Sex sex = isMale ? Sex.MALE : Sex.FEMALE;
                
                FantasticCreaturesLycanthropes child = new FantasticCreaturesLycanthropes("Child_" + System.currentTimeMillis() + "_" + i, 
                		sex, 1.95, CategoryAge.YOUNG, 45, 100, 100, 0, 0, 0, 0, 40, false, childRank, isMale);
                
                members.add(child);
                child.setPack(this);
            }
        } else 
        {
            System.out.println("Pas de couple Alpha complet, pas de reproduction.");
        }
    }
	//faire doc ^^
	public void decreaseRanksNaturally() {
		for (FantasticCreaturesLycanthropes member : members) {
			member.naturalHierachydown();
		}
	}
	
	/**
	 * Method that will sort the lycanthrope thanks to their rank
	 * @return result the list of lycanthrope sorted by rank
	 */
	public List<FantasticCreaturesLycanthropes> getMembersSortedByRank(){
		List<FantasticCreaturesLycanthropes> result = new ArrayList<>();
		result.addAll(getMembers());
		result.sort(Comparator.comparingInt((FantasticCreaturesLycanthropes e) -> e.getRank().getValue()).reversed());		
		return result;
	}
	
	/**
	 * Getter of the list of lycanthrope
	 * @return members
	 */
	public List<FantasticCreaturesLycanthropes> getMembers(){
		return members;
	}
	
	/**
	 * Setter of the alpha male
	 * @param male
	 * @return void
	 */
	public void setAlphaMale(FantasticCreaturesLycanthropes male) {
		this.alphaMale = male;
	}
	
	/**
	 * Setter of the alpha female
	 * @param female
	 * @return void
	 */
	public void setAlphaFemale(FantasticCreaturesLycanthropes female) {
		this.alphaFemale = female;
	}
	
	/**
	 * Getter of the alpha male
	 * @return alphaMale
	 */
	public FantasticCreaturesLycanthropes getAlphaMale() {
		return this.alphaMale;
	}
	
	/**
	 * Getter of the alpha female
	 * @return alphaFemale
	 */
	public FantasticCreaturesLycanthropes getAlphaFemale() {
		return this.alphaFemale;
	}
	
	public String coupleAlphaString() {
		return alphaMale.toString() + alphaFemale.toString();
	}
	
}
