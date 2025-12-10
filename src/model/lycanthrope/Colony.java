package model.lycanthrope;

import model.character.*;

import java.util.ArrayList;
import java.util.List;

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
		//TODO
		//Il s'agit du maitre de zoo fantastique qui peut bouger les solitaires (chef de clan)
    }
	
	/**
	 * Getter for the list of pack
	 * @return packs
	 */
	public List<Pack> getPacks() {
        return packs;
    }

	/**
	 * Method that age the members of a pack
	 * @param years
	 * @return void 
	 */
    public void fastForwardTime(int years) {
        // ToDo : avancer le temps dans la colinie pour faire vieillir les lycanthropes , à voir avec la simulation du controleur
    }
}
