package model.lycanthrope;

import model.character.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class of the colony of Lycanthrope objects
 * 
 * <p> This class is used to initialize the methods used in the colony of lycanthrope</p>
 * @author Benhafessa Alexandre
 * @author Dargentolle François
 * @author Edelstein William
 * @author Griguer Nathan
 */
public class Colony {
	private List<Pack> packs;
	private List<FantasticCreaturesLycanthropes> solitaries; // j'ai un doute sur celle la

	public Colony() {
        this.packs = new ArrayList<>();
        this.solitaries = new ArrayList<>();
    }
	
	/**
	 * Method that add a pack to the list of pack
	 * @param p the pack of lycanthrope
	 * @return void
	 */
	public void addPack(Pack p) {
        this.packs.add(p);
    }
	
	/**
	 * Method that manage the lycanthrope in solitary state
	 * @return void
	 */
	public void manageSolitaries() {
        System.out.println("Il y a " + solitaries.size() + " loups solitaires.");
    }
	
	/**
	 * Getter for the list of pack
	 * @return packs
	 */
	public List<Pack> getPacks() {
        return packs;
    }
	// faire doc
	public List<FantasticCreaturesLycanthropes> getSolitaries() {
        return solitaries;
    }

	/**
	 * Method that age the members of a pack
	 * @param years
	 * @return void 
	 */
    public void fastForwardTime(int years) {

    	Random rand = new Random();
    	
    	attemptCreatePackFromSolitaries();
    	List<Pack> packsToRemove = new ArrayList<>();
    	
    	for (Pack packs : getPacks()) {
            if (rand.nextInt(100) < 35) {
                packs.reproduce();
            }
            
            packs.decreaseRanksNaturally();
            handleDominanceConflicts(packs, rand);

            
            List<FantasticCreaturesLycanthropes> toRemove = new ArrayList<>();
            
            for (FantasticCreaturesLycanthropes member : packs.getMembers()){
                if(rand.nextInt(100) <35) {

                    if (member.getCage() == CategoryAge.YOUNG) {
                        member.setCage(CategoryAge.ADULT);
                        System.out.println(member.getName() + " est devenu ADULTE.");
                    } else if (member.getCage() == CategoryAge.ADULT) {
                        member.setCage(CategoryAge.OLD);
                        System.out.println(member.getName() + " est devenu VIEUX.");
                    }
                    else if (member.getCage() == CategoryAge.OLD) {
                        if (rand.nextInt(100) < 25) {
                            System.out.println(member.getName() + " est mort de vieillesse.");
                            toRemove.add(member);
                        }
                    }
                }
                if(rand.nextInt(100) < 20) {
                    member.setHowl(TypeHowling.BELONGE_TO);
                    member.howl("Wouf (pif)");
                }
                if(rand.nextInt(100) < 5) {
                    member.transformationHuman();
                    System.out.println(member.getName() + " devient humain et quitte la meute.");
                    toRemove.add(member);
                }
                if (member.getRank() == Rank.OMEGA && rand.nextInt(100) < 15) {
                    System.out.println(member.getName() + " en a marre d'être une merde et devient auto-entrepreneur");
                    toRemove.add(member);
                    this.solitaries.add(member);
                }
            }
            
            for (FantasticCreaturesLycanthropes wolf : toRemove) {
                packs.removeMember(wolf);
            }
            
            packs.recalculateHierarchy();
            
            if (packs.getMembers().isEmpty()) {
                System.out.println("--- UNE MEUTE A DISPARU (Plus de membres) ---");
                packsToRemove.add(packs);
            }
        }
    }
    
    private void attemptCreatePackFromSolitaries() {
        FantasticCreaturesLycanthropes maleFound = null;
        FantasticCreaturesLycanthropes femaleFound = null;

        for (FantasticCreaturesLycanthropes loup : solitaries) {
            if (maleFound == null && loup.isMale()) {
                maleFound = loup;
            } else if (femaleFound == null && !loup.isMale()) {
                femaleFound = loup;
            }
            if (maleFound != null && femaleFound != null) break;
        }

        if (maleFound != null && femaleFound != null) {
            System.out.println("nouvelle meute des loosers");
            
            Pack newPack = new Pack();
            newPack.addMember(maleFound);
            newPack.addMember(femaleFound);
            
            this.packs.add(newPack);
            
            solitaries.remove(maleFound);
            solitaries.remove(femaleFound);
            
            newPack.recalculateHierarchy();
        }
    }
    private void handleDominanceConflicts(Pack pack, Random rand) {
        if (pack.getMembers().size() > 1) {
            
            int conflicts = rand.nextInt(pack.getMembers().size());
            
            for (int i = 0; i < conflicts; i++) {
                List<FantasticCreaturesLycanthropes> wolves = pack.getMembers();
                
                FantasticCreaturesLycanthropes loup1 = wolves.get(rand.nextInt(wolves.size()));
                FantasticCreaturesLycanthropes loup2 = wolves.get(rand.nextInt(wolves.size()));

                if (loup1 != loup2) {
                    
                    loup1.setHowl(TypeHowling.DOMINATION);
                    
                    if (rand.nextBoolean()) {
                        loup2.setHowl(TypeHowling.SUBMISSION);
                    } else {
                        loup2.setHowl(TypeHowling.DOMINATION);
                    }
                    
                    loup1.attemptDomination(loup2);
                    
                    loup1.setHowl(TypeHowling.BELONGE_TO);
                    loup2.setHowl(TypeHowling.BELONGE_TO);
                }
            }
        }
    }
}